import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSONObject;
import com.lilili.EasyexcelStudyApplication;
import com.lilili.listener.DemoDataListener;
import com.lilili.model.DemoData;
import com.lilili.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@Slf4j
@SpringBootTest(classes = EasyexcelStudyApplication.class)
@RunWith(SpringRunner.class)
public class EasyexcelStudyApplicationTest {

    @Autowired
    DemoService demoService;

    @Test
    public void simpleRead() {
        String fileName = "D:/Demo/excel/test.xlsx";
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData data : dataList) {
                log.info("读到一条数据{}", JSONObject.toJSONString(data));
            }
        })).sheet().doRead();
    }


    @Test
    public void testInsert() throws IOException {
        String fileName = "D:/Demo/excel/test.xlsx";
        File file = new File(fileName);
        long start = System.currentTimeMillis();
        log.info("读取文件开始");
        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第一次");
            System.out.println(dataList);
        })).sheet(0).doRead();

        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第二次");
            System.out.println(dataList);
        })).sheet(0).doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
    }

    @Test
    public void testInsert2() throws FileNotFoundException {
        String fileName = "D:/Demo/excel/test.xlsx";
        File file = new File(fileName);
        DemoDataListener demoDataListener = new DemoDataListener(demoService);
        long start = System.currentTimeMillis();
        log.info("读取文件开始");
        EasyExcel.read(fileName, DemoData.class, demoDataListener).sheet().doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
    }


    /**
     * 如果是inputStream读取的话，多次读取的情况下要重新创建inputStream， File读取则不用
     */
    @Test
    public void testRepeatedlyRead() throws FileNotFoundException {
        String fileName = "D:/Demo/excel/test.xlsx";
        File file = new File(fileName);
        long start = System.currentTimeMillis();
        FileInputStream inputStream1 = new FileInputStream(file);
        log.info("读取文件开始");
        EasyExcel.read(inputStream1, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第一次");
            System.out.println(dataList);
        })).sheet().doRead();


        FileInputStream inputStream2 = new FileInputStream(file);
        EasyExcel.read(inputStream2, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第二次");
            System.out.println(dataList);
        })).sheet().doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
    }
}
