import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: SpringBoot-Labs
 * @description:
 * @author: pcoy
 * @create: 2021-01-15 17:46
 **/
@Slf4j
public class testBCrypt {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info(bCryptPasswordEncoder.encode("123456"));
    }
}
