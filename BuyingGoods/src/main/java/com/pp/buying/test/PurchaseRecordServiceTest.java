package com.pp.buying.test;

import com.pp.buying.entity.Product;
import com.pp.buying.entity.PurchaseRecord;
import com.pp.buying.service.ProductService;
import com.pp.buying.service.PurchaseRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseRecordServiceTest {

    @Autowired
    PurchaseRecordService purchaseRecordService;

    @Test
    public void testPur(){
        PurchaseRecord pur = purchaseRecordService.getPurchaseRecordById(1L);
        System.out.println(pur.getId());
        assertEquals(1L,pur.getId().longValue());
    }

    @Test
    public void addPur(){
        PurchaseRecord pur = new PurchaseRecord();
        pur.setNote("备注");
        pur.setPrice(22.33);
        pur.setProductId(1L);
        pur.setPurchaseDate(new Date());
        pur.setQuantity(1);
        pur.setSum(1);
        pur.setUserId(1L);
        int i = purchaseRecordService.addPurchaseRecord(pur);
        assertEquals(1,i);

        System.out.println(pur);//配置 keyProperty="id" useGeneratedKeys="true"  就可以把主键赋值到id这一列 即Mybatis会自增ID返回
        //但是如果数据库已经设置了自增ID则可以使用↓
//        但是如果数据库已经设置了自增ID则可以使用，查询最后一个插入的主键，order=after"表示先insert再查询
//        <selectKey resultType="java.lang.Long" order="AFTER" keyProperty="id"> SELECT LAST_INSERT_ID() </selectKey>
    }

    @Test
    public void deletePur(){
        int i = purchaseRecordService.deletePurchaseRecord(5L);
        System.out.println(i);
        assertEquals(1,i);
    }

    @Test
    public void purchase(){
        purchaseRecordService.purchse(1L,2L,1);
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testJedis(){
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.set("key1","aaa");
        System.out.println(jedis.get("key1"));
    }

}


