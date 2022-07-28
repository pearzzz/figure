package com.red.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:39 2022-07-27
 */
public class YearTagUtils {
    public static String getYearTag(int age){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-age);
        Date dateTime = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String dateYear = dateFormat.format(dateTime);
        long yearlong = Long.valueOf(dateYear);
        String flag = "未知";
        if(yearlong> 1940 && yearlong <= 1950){
            flag = "40后";
        }else if(yearlong> 1950 && yearlong <= 1960){
            flag = "50后";
        }else if(yearlong> 1960 && yearlong <= 1970){
            flag = "60后";
        }else if(yearlong> 1970 && yearlong <= 1980){
            flag = "70后";
        }else if(yearlong> 1980 && yearlong <= 1990){
            flag = "80后";
        }else if(yearlong> 1990 && yearlong <= 2000){
            flag = "90后";
        }else if(yearlong> 2000 && yearlong <= 2010){
            flag = "00后";
        }else if(yearlong> 2010 && yearlong <= 2020){
            flag = "10后";
        }
        return flag;
    }
}
