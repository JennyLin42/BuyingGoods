package com.pp.buying.dao;

import com.pp.buying.entity.PurchaseRecord;

public interface PurchaseRecordDao {
    // 获取购买记录
    public PurchaseRecord getPurchaseRecordById(Long id);
    //添加购买记录
    public int addPurchaseRecord(PurchaseRecord purchaseRecord);

    public int deletePurchaseRecord(long id);
}
