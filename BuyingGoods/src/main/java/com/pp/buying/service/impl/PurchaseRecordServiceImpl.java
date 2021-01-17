package com.pp.buying.service.impl;

import com.pp.buying.dao.PurchaseRecordDao;
import com.pp.buying.entity.PurchaseRecord;
import com.pp.buying.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    private PurchaseRecordDao purchaseRecordDao;

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


}
