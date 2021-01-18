package com.pp.buying.dao;

import com.pp.buying.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface ProductDao {
    // 获取产品
    public Product getProductById(Long id);
    //添加产品
    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProductById(Long id);

    //减库存，而@Param标明MyBatis参数传递给后台 版本1
//    public int decreaseProoduct(@Param("id") Long id, @Param("quantity") int quantity);

    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity,int version);

}
