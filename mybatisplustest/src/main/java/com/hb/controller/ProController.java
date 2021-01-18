package com.hb.controller;

import com.hb.pojo.Products;
import com.hb.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ProController {
    @Resource
    private ProductsService productsService;

    @RequestMapping("/byId")
    public Products show(){
        //根据id查询
        Products byId = productsService.getById(2);
        //如果传参时map
        /*
        listMaps()//返回值是List<Map<String, Object>>
         */
        return byId;
    }
    //查询全部list()
    @RequestMapping("/show")
    public List<Products> show1(){
        //list()查询全部
        //List<Products> list = productsService.list();




        System.err.println("批量查询----");
        List<Integer> ids = Arrays.asList(2,3);
        List<Products> list1 = productsService.listByIds(ids);



        System.out.println(list1);
        return list1;
    }

    //根据条件查询
    @RequestMapping("/show2")
    public List<Products> show2(){
        
        return null;
    }

}
