import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lilili.MybatisStudyApplication;
import com.lilili.dao.StudentMapper;

import com.lilili.model.Student;
import com.lilili.service.StudentService;
import com.lilili.service.StudentServiceImpl;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@SpringBootTest(classes = MybatisStudyApplication.class)
@RunWith(SpringRunner.class)
public class MybatisStudyApplicationTest {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    @Qualifier("studentServiceImpl")
    StudentService studentService;

    /**
     * mybatis-plus的Model实体类测试
     */
    @Test
    public void test01() {
//        System.out.println(studentMapper.selectList(new QueryWrapper<>()));
        Student student = new Student();
        student.setName("陈大");
        student.setGender(1);
        System.out.println("添加之前: " + student);
        student.insert();
        System.out.println("添加之后: " + student);
    }

    @Test
    public void test02() {
        Student student = new Student();
        student.setName("陈大");
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.setEntity(student);
        QueryWrapper<Student> select = qw.select();
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }

    public void test03(Student s, Student s2) {
        s.setName("李梨离");
        s.setGender(1);
        s.insert();
        System.out.println(s);
        s2.setId(s.getId());
    }

    @Test
    public void test04() {
        Student student = new Student();
        Student s2 = new Student();
        s2.setId(0L);
        test03(student, s2);
        System.out.println(s2);
    }

    @Test
    public void test05() {
        Student student = new Student();
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("nick_name", "霸王龙");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }

    @Test
    public void test06() {
//        UpdateWrapper<Student> uw = new UpdateWrapper<>();
//        uw.eq("name", "张三");
        HashMap<String, Object> map = new HashMap<>();
        map.put("nick_name", "霸王龙");
        int delete = studentMapper.deleteByMap(map);
        System.out.println(delete);
    }

    @Test
    public void test07() {
        UpdateWrapper<Student> uw = new UpdateWrapper<>();
        uw.eq("id", 11);
        Student s = new Student();
        s.setNickName("null");
        studentMapper.update(s, uw);
    }

    @Test
    public void test08() {
        Student s = new Student();
        s.setId(11L);
        s.setNickName("菠萝吹雪");
        s.updateById();
        System.out.println("更新后的对象: " + s);
    }

    @Test
    public void testInsertData() {
        int maxCount = 100000;
        long start = System.currentTimeMillis();
        Student student = new Student();
        for (int i = 0; i < maxCount; i++) {
            student.setName("测试:" + i);
            student.setGender(1);
            student.setNickName("测试昵称:" + i);
            studentMapper.insert(student);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间为:" + (end - start));
    }


    @Test
    public void testSaveBatch() {
        int maxCount = 100000;
        long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            Student student = new Student();
            student.setName("测试:" + i);
            student.setGender(1);
            student.setNickName("测试昵称:" + i);
            list.add(student);
        }
        //一千条一次
        studentService.saveBatch(list);
        long end = System.currentTimeMillis();
        System.out.println("执行时间为:" + (end - start));
    }

    @Test
    public void testWrapper() {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("id", 11);
        System.out.println(studentMapper.selectOne(qw));
        qw.eq("nick_name", "菠萝吹雪");
        System.out.println(studentMapper.selectOne(qw));
    }

    /**
     * 测试插入异常后是否有返回值
     * result: 直接打印异常， 没有返回值
     */
    @Test
    public void insertException() {
        Student student = new Student();
        student.setNickName("满舒克");
        student.setName("MDSK");
        student.setGender(10000);
        System.out.println(studentMapper.insert(student));
    }

    /**
     * selecOne查询不到记录会返回null
     * selectList是空数组
     */
    @Test
    public void test11() {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name", "KSDM");
        System.out.println(studentMapper.selectOne(qw));
        List<Student> list = studentMapper.selectList(qw);
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void test12() {
        Student student = new Student();
        student.setName("更新后");
        student.setNickName("更新后");
        studentService.saveOrUpdate(student);
    }

    /**
     * 2021-11-30
     */
    @Test
    public void test13() {
        Student student = new Student();
        student.setNickName("满舒克");
        student.setName("MDSK");
        student.setGender(1);
        studentMapper.insert(student);
        System.out.println(student);
    }

    /**
     * 测试RowBounds分页
     */
    @Test
    public void test14() {
        RowBounds rowBounds = new RowBounds(0, 2);
        List<Student> students = studentMapper.testRowBounds(rowBounds);
        System.out.println(students);
    }

}

