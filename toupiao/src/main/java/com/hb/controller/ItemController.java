package com.hb.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hb.pojo.Item;
import com.hb.pojo.Option;
import com.hb.pojo.Sub;
import com.hb.pojo.User;
import com.hb.service.ItemService;
import com.hb.service.OptionService;
import com.hb.service.SubService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ItemController {

    @Resource
    private ItemService itemService;

    @Resource
    private OptionService optionService;

    @Resource
    private SubService subService;

    @RequestMapping("/show")
    public String show(Model model, Integer pageIndex, String title, @RequestParam(defaultValue = "1") Integer opr) {
        if (pageIndex == null) {
            pageIndex = 0;
        }
        System.out.println("======================opr" + opr);

        Page<Object> page = PageHelper.startPage(pageIndex, 5);

        List<Item> list = itemService.show(title);
        //主页显示
        model.addAttribute("list", list);
        //分页
        model.addAttribute("page", page);
        model.addAttribute("title", title);
        model.addAttribute("opr", opr);
        return "votelist";
    }

    //详细页面
    @RequestMapping("/xiang")
    public String byTitle(Integer subId, Model model, String title, Integer xuan, Integer total) {
        System.out.println("进来了................");
        System.out.println(total);
        List<Map> list = itemService.bySubId(subId);
        model.addAttribute("xuan", xuan);
        model.addAttribute("title", title);
        model.addAttribute("total", total);
        model.addAttribute("list", list);
        return "voteview";
    }

    //投票页面
    @RequestMapping("/voteBySubId")
    public String voteBySubId(Integer subId, Model model, String title, Integer xuan, Integer total) {


        List<Map> maps = itemService.voteBySubId(subId);
        model.addAttribute("xuan", xuan);
        model.addAttribute("title", title);
        model.addAttribute("total", total);
        model.addAttribute("subId", subId);
        model.addAttribute("list", maps);
        return "vote";//跳页面
    }

    //投票后新增
    @RequestMapping("/vote")
    public String vote(@RequestParam List<Integer> options, Model model, Integer subId, Integer userId, String title, Integer xuan, Integer total) {

        //投票新增
        List<Item> list = new ArrayList<>();
        Item item1 = itemService.byUserIdSubId(userId, subId);
        String mess = "";

        if (item1 == null) {

            for (Integer option : options) {
                list.add(new Item(userId, subId, option));
            }
            int num = itemService.addVote(list);

            //根据标题查出投票后的结果
            List<Item> show = itemService.show(title);
            Item item = show.get(0);
            model.addAttribute("item", item);
            model.addAttribute("biao", 1);
            model.addAttribute("xiaoxi", "恭喜：投票成功！");
            mess = num > 0 ? "voteSave" : "redirect:/vote.html";
        } else {
            model.addAttribute("quanxiang", "该用户已经投票，不能重复投票！");
            mess = "chongfu";
        }

        return mess;
    }

    //用来判断新增主题时,权限问题
    @RequestMapping("/tianjia")
    public String addAdd(Model model, HttpSession session, Integer userStatus) {
        System.out.println("userStatus======================" + userStatus);
        String mess = "";
        if (userStatus == 1) {
            mess = "xiugai";
        } else {
            model.addAttribute("quanxiang", "权限不够");
            mess = "chongfu";
        }
        model.addAttribute("session", session);
        return mess;
    }

    @RequestMapping("/weihu")
    public String weihu(Model model, HttpSession session, Integer userStatus, RedirectAttributes attr) {
        String mess = "";
        if (userStatus == 1) {
            attr.addAttribute("opr", 2);
            return "redirect:/show";
        } else {
            model.addAttribute("quanxiang", "权限不够");
            mess = "chongfu";
        }
        return mess;
    }

    //修改
    @RequestMapping("/xiugai")
    public String xiugai(Model model, Integer subId) {
        //根据主题id进行查询
        List<Map> maps = itemService.voteBySubId(subId);
        Integer sType = 0;
        String title = "";

        for (Map map : maps) {
            sType = (Integer) map.get("stype");
            title = (String) map.get("title");
        }
        model.addAttribute("subId", subId);
        model.addAttribute("sType", sType);
        model.addAttribute("title", title);
        model.addAttribute("maps", maps);
        return "add";
    }

    //修改 ,List<String> options,List<Integer> oids
    @Transactional
    @RequestMapping("/update")
    public String update(Model model, Integer subId, Integer stype, @RequestParam List<Integer> oids, @RequestParam List<String> options) {
        System.out.println("=======stype======" + stype);
        System.out.println("=======subId======" + subId);

        List<Map> maps = itemService.voteBySubId(subId);

        List<Integer> oidList = new ArrayList<>();//oid的集合
        List<String> option = new ArrayList<>();//选项内容集合
        for (Map map : maps) {
            Integer oid = (Integer) map.get("oid");
            String ocon = (String) map.get("ocon");
            oidList.add(oid);
            option.add(ocon);
        }

        //修改主题类型
        subService.updateByType(new Sub(subId, stype));

        List<Integer> delOption = new ArrayList<>();//删除id集合

        List<Option> addOption = new ArrayList<>();//新增集合

        List<Option> xiuOption = new ArrayList<>();//修改集合


        int num1 = 0;
        int num2 = 0;
        if (oidList.size() > oids.size()) {

            for (int i = 0; i < oidList.size(); i++) {
                if (!oids.contains(oidList.get(i))) {
                    delOption.add(oidList.get(i));
                    System.out.println("========删除的id=======" + oidList.get(i));
                    num1 = 1;
                }
            }
            for (int i = 0; i < options.size(); i++) {
                if (!option.contains(options.get(i))) {
                    xiuOption.add(new Option(oids.get(i), options.get(i)));
                    System.out.println("========修改的选项内容=======" + options.get(i));
                    System.out.println("========修改的选项内容=======" + oids.get(i));
                    num2 = 1;
                }

            }
            System.out.println("===========================");
            //调方法
            if (num1 == 1) {
                //调option表的删除
                optionService.deleteOid(delOption);
            }
            if (num2 == 1) {
                //调option表的修改方法
                optionService.updateOid(xiuOption);
            }


        }
        System.out.println("==================");
        if (option.size() == options.size()) {
            for (int i = 0; i < options.size(); i++) {
                if (!option.contains(options.get(i))) {
                    xiuOption.add(new Option(oids.get(i), options.get(i)));
                }
            }
            optionService.updateOid(xiuOption);
            System.out.println("修改成功");
        }



        /*
        oidList原有oid集合
        oids从页面上获取的oid集合
        option原有con集合
        options从页面上获取的con集合

         */
        int num = 0;
        int snum = 0;
        if (option.size() < options.size()) {
            int ord = options.size();
            for (int i = 0; i < options.size(); i++) {

                //获得新增选项内容
                if (!option.contains(options.get(i)) && !oidList.contains(oids.get(i))) {
                    addOption.add(new Option(subId, options.get(i), ord++));
                    System.out.println("========新增的选项内容=======" + options.get(i));
                    num = 1;
                }
                //修改选项内容
                if (!option.contains(options.get(i)) && oidList.contains(oids.get(i))) {
                    xiuOption.add(new Option(oids.get(i), options.get(i)));
                    System.out.println("========修改的选项id=======" + oids.get(i));
                    System.out.println("========修改的选项内容2=======" + options.get(i));
                    snum = 1;
                }
            }
            //调方法
            if (num == 1) {
                //调option表的新增方法
                optionService.optionAdd(addOption);
            }
            if (snum == 1) {
                //调option表的修改方法
                optionService.updateOid(xiuOption);
            }
        }
        System.out.println("==================");


        model.addAttribute("biao", 2);
        model.addAttribute("xiaoxi", "恭喜:操作成功!");//voteSave
        return "voteSave";
    }

    @Transactional
    @RequestMapping("/del")
    public String del(Integer subId, RedirectAttributes attr) {
        int num = subService.bySubIdDelete(subId);
        if (num > 0) {
            itemService.bySubIdDelete(subId);
            optionService.bySubIdDelete(subId);
            attr.addAttribute("opr", 2);

        }
        return "redirect:/show";
    }

}
