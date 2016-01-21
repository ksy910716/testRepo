package com.example.ksy.t_20160120.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ksy on 2016-01-08.
 */
public class LockScreenDateUtil {
    private long now;
    private Date date;
    private SimpleDateFormat sdfnowTime = new SimpleDateFormat("hh:mm a", Locale.US);
    private SimpleDateFormat sdfNowDate = new SimpleDateFormat("MM.dd E요일");
    private String nowDate;
    private String nowTime;

    public void DateUtil(){
        init();
    }

    private void init() {
        now = System.currentTimeMillis();
        date = new Date(now);
        nowDate = sdfNowDate.format(date);
        nowTime = sdfnowTime.format(date);
    }

    public String getNowTime(){
        return nowTime;
    }

    public String getNowDate(){
        return nowDate;
    }

}
