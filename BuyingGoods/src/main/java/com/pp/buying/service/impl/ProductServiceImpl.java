package com.pp.buying.service.impl;

import com.pp.buying.dao.ProductDao;
import com.pp.buying.entity.Product;
import com.pp.buying.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProduct(Long id){
        return productDao.getProduct(id);
    }

    public int addProduct(Product product){
        return productDao.addProduct(product);
    }

    public int updateProduct(Product product){
        if(product.getId() != null){
            return productDao.updateProduct(product);
        }
        return  0;
    }

    public int deleteProduct(Long id){
        return productDao.deleteProduct(id);
    }

    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity){
        return productDao.decreaseProduct(id,quantity);
    }

}
