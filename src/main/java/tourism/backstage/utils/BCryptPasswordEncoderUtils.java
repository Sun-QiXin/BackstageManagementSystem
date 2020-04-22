package tourism.backstage.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *  自定义的密码加密工具类
 * @author 孙启新
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        //将加密后的密码返回
        return bCryptPasswordEncoder.encode(password);

    }


    /**
     * 测试加密
     */
    public static void main(String[] args) {
        String password = "123";
        String encodePassword = encodePassword(password);
        System.out.println(encodePassword);
    }
}
