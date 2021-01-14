package com.pp.buying.test;

import com.pp.buying.dao.ProductDao;
import com.pp.buying.entity.Product;
import com.pp.buying.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void testPro(){
        Product product = productService.getProduct(1L);
        System.out.println(product.getId());
    }

    @Test
    public void addPro(){
        Product product = new Product();
        product.setNote("备注");
        product.setPrice(22.22);
        product.setProdectName("做梦");
        product.setStock(100);
        product.setVersion(0);
        productService.addProduct(product);
    }

    @Test
    public void updatePro(){
        Product product = productService.getProduct(2L);
        product.setNote("再次保存2");
        productService.updateProduct(product);
    }

    @Test
    public void deletePro(){
        productService.deleteProduct(1L);
    }

    @Test
    public void decreasePro(){
        productService.decreaseProduct(2L,20);
    }
}


