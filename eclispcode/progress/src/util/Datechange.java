package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 日期操作
* */
public class Datechange {
    public static String formatype ="yyyy-MM-dd HH:mm:ss";
    //date-->String
    public static String dateToString(Date data) {
        return new SimpleDateFormat(formatype).format(data);
    }
    //String-->date
    public static Date stringToDate(String strTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatype);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }
    //long-->date
    public static Date longToDate(long currentTime)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数成一个date类型的时间
        String sDateTime = dateToString(dateOld); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime); //  把String类型转换为Date类型
        return date;
    }
}
