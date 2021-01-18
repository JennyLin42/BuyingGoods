package com.pp.buying.service;

import com.pp.buying.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductService {
    public Product getProductById(Long id);

    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProductById(Long id);

}
