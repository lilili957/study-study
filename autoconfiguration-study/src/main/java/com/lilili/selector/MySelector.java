package com.lilili.selector;

import com.lilili.model.Fruit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
public class MySelector implements ImportSelector, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("beanFactory: " + beanFactory);
        System.out.println("annotationMetadata: " + annotationMetadata);
        return new String[]{Fruit.class.getName()};
    }
}
