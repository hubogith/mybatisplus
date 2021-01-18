package com.hb;

import com.hb.mapper.ProductsMapper;
import com.hb.pojo.Products;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisplustestApplicationTests {
    @Resource
    private ProductsMapper productsMapper;

    @Test
    public void test() {
        Products products = new Products();
        products.setPname("sss皮带");
        products.setPrice(100.20);
        products.setPdesc("号sssss皮带");
        int insert = productsMapper.insert(products);
        System.out.println(insert);
    }

    @Test
    public void  test2(){
        Products products = new Products();
        products.setPname("ssss皮带");
        products.setPrice(1000.20);
        products.setPdesc("号皮带");
        products.setPid(1337367972517138433L);
        int i = productsMapper.updateById(products);
        System.err.println(i);
    }

}
