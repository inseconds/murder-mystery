package com.murder.mystery.service.server.netty.util;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yuehui on 2018/6/10
 */
public class CommonUtils {

    public static Long getTodayLeftTime(Integer hour){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTimeInMillis();
    }

    public static Long getTodayBeginTime(Integer hour){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTimeInMillis();
    }

    public static Date getLastDayBeginDate(){
        Calendar lastDay = Calendar.getInstance();
        lastDay.set(Calendar.DAY_OF_MONTH, lastDay.get(Calendar.DAY_OF_MONTH) - 1);
        lastDay.set(Calendar.HOUR_OF_DAY, 0);
        lastDay.set(Calendar.MINUTE, 0);
        lastDay.set(Calendar.SECOND, 0);
        lastDay.set(Calendar.MILLISECOND, 0);
        return lastDay.getTime();
    }

    public static Date getLastDayEndDate(){
        Calendar lastDay = Calendar.getInstance();
        lastDay.set(Calendar.DAY_OF_MONTH, lastDay.get(Calendar.DAY_OF_MONTH) - 1);
        lastDay.set(Calendar.HOUR_OF_DAY, 23);
        lastDay.set(Calendar.MINUTE, 59);
        lastDay.set(Calendar.SECOND, 59);
        lastDay.set(Calendar.MILLISECOND, 999);
        return lastDay.getTime();
    }

}
