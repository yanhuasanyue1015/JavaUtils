import com.youyou.util.SendMailUtil;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by 张磊 on 2017/5/8.
 */
public class JavaMailTest {
    @Test
    public void sendMail() throws IOException, MessagingException {
        SendMailUtil.sendMail("1015994684@qq.com","你好","我是某某某");
    }
}
