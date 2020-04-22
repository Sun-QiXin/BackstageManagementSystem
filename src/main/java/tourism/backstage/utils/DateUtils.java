package tourism.backstage.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 *
 * @author 孙启新
 */
public class DateUtils {

    /**
     * 将Date转化成字符串
     * @param date 传入日期格式的值
     * @param pattern 格式化成的格式
     * @return 转换后的字符串
     */
    public static String dateToString(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将字符串转化成Date
     * @param str 传入的字符串
     * @param pattern 格式化成的格式
     * @return 转换后的Date
     * @throws ParseException
     */
    public static Date stringToDate(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(str);
    }
}
