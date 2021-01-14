package com.pp.buying.service;

import com.pp.buying.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductService {
    public Product getProduct(Long id);

    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProduct(Long id);

    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

}
