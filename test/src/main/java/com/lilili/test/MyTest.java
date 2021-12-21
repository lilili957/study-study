package com.lilili.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lilili.model.Clzss;
import com.lilili.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYuan
 * @Date 2021/10/27
 **/
@Slf4j
public class MyTest {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        log.info("Map to JSON start...");
//        map.put("1", "first");
//        map.put("2", "two");
//        map.put("3", "three");
//        map.put("4", "four");
//        map.put("5", "five");
//        map.put("6", "six");
//        map.put("7", "seven");
//        map.put("8", "eight");
//        map.put("9", "nine");
//        map.put("10", "ten");
//        //Map to JSON
//        String jsonString = JSONObject.toJSONString(map);
////        JSONObject.parse(jsonString, Fe)
//        System.out.println(jsonString);
//        System.out.println(JSON.toJSONString(map));
//        //JSON to Map
//        Map mapp = (Map) JSON.parse(jsonString);
//        System.out.println(mapp);
//        System.out.println(mapp.get(1));
//
//        Map mappp = JSON.parseObject(jsonString, Map.class);
//        System.out.println(mappp);
//        System.out.println(mappp.get("2"));

        //----测试BeanUtils.copyProperties是否是深拷贝
        Student s1 = new Student("zhangsan", "123");
        Clzss c1 = new Clzss();
        c1.setName("高一");
        s1.setClzss(c1);
        Student s2 = new Student();

        BeanUtils.copyProperties(s1, s2);

        System.out.println(s2);
        s2.getClzss().setName("高二");
        System.out.println(s1);
        System.out.println(s2);
    }


}
