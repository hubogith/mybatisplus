package com.hb.controller;

import com.hb.pojo.Option;
import com.hb.pojo.Sub;
import com.hb.service.OptionService;
import com.hb.service.SubService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SubController {
    @Resource
    private SubService subService;
    @Resource
    private OptionService optionService;


    //新增主题
    @Transactional
    @RequestMapping("/add")
    public String subAdd(@RequestParam List<String> options, Sub sub,Model model) {
        System.out.println("进来了subAdd....................");
        System.out.println("================" + sub);
        Sub sub1 = subService.bySubTitle(sub.getSubTitle());
        String mess="";
        if (sub1==null){
            //新增主题
            int num = subService.addSub(sub);
            List<Option> list = new ArrayList<>();

            if (num > 0) {
                int subId = subService.bySubId();

                for (int i = 0; i < options.size(); i++) {
                    list.add(new Option(subId, options.get(i), (i + 1)));
                }

                int nums = optionService.optionAdd(list);
                mess = nums > 0 ? "redirect:/subAdd.html" : "redirect:/xiugai.html";
            } else {
                return "redirect:/xiugai.html";
            }
        }else {
            model.addAttribute("quanxiang","主题已存在");
            return "chongfu";
        }

        return mess;
    }

}
