package com.lilili.tx;

import org.hibernate.engine.spi.EntityEntryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
@Configuration
public class TxManagerConfig implements TransactionManagementConfigurer {

    @Resource(name = "txmanager1")
    PlatformTransactionManager txmanager;
    //注册事务管理器1
    @Bean(name = "txmanager1")
    public PlatformTransactionManager txmanager1(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //注册事务管理器2
    @Bean(name = "txmanager2")
    public PlatformTransactionManager txmanager2(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    //设置默认使用的事务管理器是txmanager1, @Resource注入的是txmanager1
    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return txmanager;
    }
}
