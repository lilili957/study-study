package com.lilili.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
@Service
public class TxService {

    
    @Transactional
    public void testTx() {
        System.out.println("使用了事务注解的方法");
        return;
    }

    @Transactional
    public void testDefaultTxmanager() {
        System.out.println("多个事务管理器的情况下使用默认的事务管理器");
    }


    @Transactional(value = "txmanager2")
    public void testByNameTxmanager() {
        System.out.println("多个事务管理器的情况下使用value指定的事务管理器");
    }
}
