package com.lilili.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.lilili.dao.DemoMapper;
import com.lilili.model.DemoData;
import com.lilili.service.DemoService;
import com.lilili.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    private static final int BATCH_COUNT = 3000;

    /**
     * 缓存的数据
     */
    private List<DemoData> list = new ArrayList<>(BATCH_COUNT);

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DemoService demoService;

    public DemoDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        demoService = new DemoServiceImpl();
    }


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public DemoDataListener(DemoService demoService) {
        this.demoService = demoService;
    }



    /**
     * 这个每一条数据解析都会来调用
     *
     * @param demoData row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(DemoData demoData, AnalysisContext context) {
        log.info("解析到一条数据: {}", JSONObject.toJSONString(demoData));
        list.add(demoData);
        if (list.size() >= BATCH_COUNT) {
            saveData();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成");
    }

    private void saveData() {
        log.info("开始存储数据库, 记录为{}条", list.size());
        long start = System.currentTimeMillis();
        demoService.saveBatch(list);
        long end = System.currentTimeMillis();
        log.info("存储成功, 用时{}s", (end - start) / 1000);
    }
}
