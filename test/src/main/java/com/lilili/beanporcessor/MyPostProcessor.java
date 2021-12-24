package com.lilili.beanporcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author LiYuan
 * @Date 2021/12/23
 **/
//@Component
//public class MyPostProcessor implements BeanPostProcessor {
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//
//        System.out.println("--------------BeanPostProcessor----------beanName" + beanName);
//        System.out.println("--------------BeanPostProcessor----------前置方法");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("--------------BeanPostProcessor----------beanName" + beanName);
//        System.out.println("--------------BeanPostProcessor----------后置方法");
//        return bean;
//    }
//}
