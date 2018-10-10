package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* ���ڲ���
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
        Date dateOld = new Date(currentTime); // ����long���͵ĺ�������һ��date���͵�ʱ��
        String sDateTime = dateToString(dateOld); // ��date���͵�ʱ��ת��Ϊstring
        Date date = stringToDate(sDateTime); //  ��String����ת��ΪDate����
        return date;
    }
}
