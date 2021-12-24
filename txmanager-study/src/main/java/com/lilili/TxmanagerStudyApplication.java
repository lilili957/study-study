package com.lilili;

import com.lilili.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.Resource;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
@EnableTransactionManagement
@SpringBootApplication
public class TxmanagerStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxmanagerStudyApplication.class, args);
    }
    //事务管理器, jdbc中给我们提供了事务管理器， 那么框架会自动使用这个事务管理器。
    //当有多个事务管理器的时候我们需要去手动指定默认的使用哪个， 在使用@Transactional注解的时候也可以指定需要使用的管理器
    //TxManagerConfig配置了默认的事务管理器
//    @Autowired
//    PlatformTransactionManager platformTransactionManager;

//    @Resource(name = "txmanager1")
//    TransactionManager transactionManager;


    @Autowired
    TxService txService;

    @Bean
    public ApplicationRunner applicationRunner() {
        return (args) -> {
//            System.out.println(platformTransactionManager);
//            System.out.println(transactionManager);
            txService.testDefaultTxmanager();
            txService.testByNameTxmanager();
            System.out.println(Propagation.MANDATORY.value());
        };
    }


}
