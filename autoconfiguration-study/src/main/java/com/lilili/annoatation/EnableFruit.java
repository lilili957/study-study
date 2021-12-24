package com.lilili.annoatation;

import com.lilili.selector.MySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Import({MySelector.class})
public @interface EnableFruit {
}
