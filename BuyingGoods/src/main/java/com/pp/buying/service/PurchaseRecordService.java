package com.pp.buying.service;

import com.pp.buying.entity.PurchaseRecord;

public interface PurchaseRecordService {
    // 获取购买记录
    public PurchaseRecord getPurchaseRecordById(Long id);
    //添加购买记录
    public int addPurchaseRecord(PurchaseRecord purchaseRecord);

    public int deletePurchaseRecord(long id);

    public boolean purchse(Long userId,Long productId,int quantity);

}
