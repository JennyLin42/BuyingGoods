package com.pp.buying.test;

import com.pp.buying.entity.Product;
import com.pp.buying.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    ProductService productService;

    @Test
    public void testPro(){
        Product product = productService.getProductById(1L);
        System.out.println(product.getId());
        assertEquals(1L,product.getId().longValue());
    }

    @Test
    public void addPro(){
        Product product = new Product();
        product.setNote("备注");
        product.setPrice(22.22);
        product.setProdectName("做梦");
        product.setStock(100);
        product.setVersion(0);
        int i = productService.addProduct(product);
        assertEquals(1,i);

        //配置 keyProperty="id" useGeneratedKeys="true"  就可以把主键赋值到id这一列 即Mybatis会自增ID返回
        log.info(product.toString());
        //但是如果数据库已经设置了自增ID则可以使用↓
//        但是如果数据库已经设置了自增ID则可以使用，查询最后一个插入的主键，order=after"表示先insert再查询
//        <selectKey resultType="java.lang.Long" order="AFTER" keyProperty="id"> SELECT LAST_INSERT_ID() </selectKey>
    }

    @Test
    public void updatePro(){
        Product product = productService.getProductById(2L);
        product.setNote(null);
        product.setStock(10000);
        int i = productService.updateProduct(product);
        assertEquals(1,i);
    }

    @Test
    public void deletePro(){
        int i = productService.deleteProductById(1L);
        assertEquals(1,i);
    }

//    @Test
//    public void decreasePro(){
//        productService.decreaseProduct(2L,1);
//    }
}


