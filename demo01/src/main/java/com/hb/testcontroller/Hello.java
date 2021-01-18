package com.hb.testcontroller;

import com.hb.pojo.Stu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String test1(Model model, HttpSession session){

        model.addAttribute("mess","测试数据");
        //模拟session传值
        session.setAttribute("stu",new Stu(1,"张三",new Date()));

        //模拟投票并显示颜色, 测试样式控制百分比
        model.addAttribute("count",50);
        model.addAttribute("count1",100);

        //测试集合
        List<Stu> list=new ArrayList<>();
        list.add(new Stu(1,"张三",new Date()));
        list.add(new Stu(2,"李四",new Date()));
        list.add(new Stu(3,"王五",new Date()));
        list.add(new Stu(4,"赵六",new Date()));
        list.add(new Stu(5,"老七",new Date()));
        list.add(new Stu(6,"老八",new Date()));
        model.addAttribute("list",list);
        model.addAttribute("url","<a href='http://www.baidu.com'>删除</a>");
        model.addAttribute("url1","<a href='http://www.baidu.com'>修改</a>");

        model.addAttribute("uri","h");

        //传图片名称
        model.addAttribute("img","img/1.jpg");

        model.addAttribute("obj",new Stu(1,"战三",new Date()));

        return "hello";
    }

    @RequestMapping("/h")
    public String test2(Integer sid){
        System.out.println(sid);
        System.out.println("sadasd");
        return "";
    }

    @RequestMapping("/hee")
    public String test3(@RequestBody List<String> names){
        System.out.println("进来了");
        for (String s : names) {
            System.out.println(s);
        }


        return "";
    }

    @RequestMapping("/login6.action")
    public String login6(@RequestParam Map<String,String> cid) {

        for (String s : cid.keySet()) {
            System.out.println(cid.get(s));
        }

        System.out.println(cid.keySet());
        System.out.println(cid.values());

        return "forward:/success.jsp";
    }
}
