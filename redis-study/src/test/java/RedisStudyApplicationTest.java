import com.lilili.RedisStudyApplication;
import com.lilili.config.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author LiYuan
 * @Date 2021/9/30
 **/
@SpringBootTest(classes = RedisStudyApplication.class)
@RunWith(SpringRunner.class)
public class RedisStudyApplicationTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test01() {
        redisUtil.setRedis("username:01", "lilili957");
        System.out.println("username:01: " + redisUtil.getRedis("username:01"));
    }

    @Test
    public void test02() {
        redisUtil.setRedis("userId", UUID.randomUUID().toString(), 10);
    }
}
