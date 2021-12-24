import com.lilili.TkmybatisStudyApplication;
import com.lilili.dao.StudentMapper;
import com.lilili.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/25
 **/
@SpringBootTest(classes = TkmybatisStudyApplication.class)
@RunWith(SpringRunner.class)
public class TkmybatisStudyApplicationTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void test01() {
        Student student = new Student();
        student.setName("tk-mybatis");
        studentMapper.insert(student);
    }

    @Test
    public void testInsertList() {

        int maxCount = 50000;
        long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            Student student = new Student();
            student.setName("测试:" + i);
            student.setGender(1);
            student.setNickName("测试nickName:" + i);
            list.add(student);
        }
        studentMapper.insertList(list);
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start));
    }

    @Test
    public void testUpdateList() {
        int maxCount = 10000;
        long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            Student student = new Student();
            student.setId((long) (i + 15));
            student.setName(("更新的:" + i));
            student.setGender(0);
            student.setNickName(("更新的nickName:" + i));
            list.add(student);
        }
        int size = studentMapper.updateBatch(list);
        System.out.println("size:" + size);
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start));
    }

    @Test
    public void testTransient() {
        List<Student> list = studentMapper.selectAll();
        System.out.println(list);
    }
}
