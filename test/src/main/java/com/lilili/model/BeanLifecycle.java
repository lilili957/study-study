package com.lilili.model;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @Author LiYuan
 * @Date 2021/12/23
 **/
@Component
public class BeanLifecycle implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("name-------" + name);
    }
}
