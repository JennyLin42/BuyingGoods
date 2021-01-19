package com.pp.buying.service.impl;

import com.pp.buying.dao.ProductDao;
import com.pp.buying.dao.PurchaseRecordDao;
import com.pp.buying.entity.Product;
import com.pp.buying.entity.PurchaseRecord;
import com.pp.buying.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Date;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    private PurchaseRecordDao purchaseRecordDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public PurchaseRecord getPurchaseRecordById(Long id) {
        return purchaseRecordDao.getPurchaseRecordById(id);
    }

    @Override
    public int addPurchaseRecord(PurchaseRecord purchaseRecord) {
        return purchaseRecordDao.addPurchaseRecord(purchaseRecord);
    }

    @Override
    public int deletePurchaseRecord(long id){
        return purchaseRecordDao.deletePurchaseRecord(id);

    }

    /**
     * 乐观锁是一种不使用数据库的锁，不会造成阻塞，只是采用乐观锁会导致过多的SQL执行失败的问题。
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    @Override
    @Transactional
    public boolean purchse(Long userId,Long productId,int quantity){
        for(int i = 0; i < 3 ;i++){
            //获取商品
            Product product = productDao.getProductById(productId);
            //比较库存和购买数量
            if(product.getStock() < quantity){
                //库存不足
                return false;
            }
            //扣减库存
            int result = productDao.decreaseProduct(productId,quantity,product.getVersion());
            if(result == 0){
                continue;
            }
            //初始化购买信息
            PurchaseRecord pr = this.initPurchaseRecord(userId,product,quantity);
            //插入购买记录
            purchaseRecordDao.addPurchaseRecord(pr);
            return true;
        }
        return false;
    }
    public PurchaseRecord initPurchaseRecord(Long userId,Product product,int quantity){
        PurchaseRecord pr = new PurchaseRecord();
        pr.setNote("抢购商品");
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        pr.setPurchaseDate(new Date());
        return pr;
    }

}
