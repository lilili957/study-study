import com.lilili.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author LiYuan
 * @Date 2021/11/2
 **/
@SpringBootTest(classes = TestApplicationTest.class)
@RunWith(SpringRunner.class)
public class TestApplicationTest {

    @Autowired
    Student student;

    @Test
    public void test01() {
        System.out.println(student);
    }
}
