package com.red.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:48 2022-07-27
 */
public class DateUtils {
    public static String getDateStringBy(Date time, String formatString) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat(formatString);
        String result = dateFormat.format(time);
        return result;
    }

    public static int compareDate(String o1, String o2,String dateFormatpara) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatpara);
        int result = (dateFormat.parse(o1)).compareTo(dateFormat.parse(o2));
        return result;

    }
}
