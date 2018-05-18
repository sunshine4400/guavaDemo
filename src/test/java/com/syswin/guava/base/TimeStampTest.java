package com.syswin.guava.base;

import junit.framework.TestCase;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2017-12-04 16:52
 **/
public class TimeStampTest extends TestCase{
    public void test1(){
        //{"empid":"6542","latitude":"32.906043","time":"2017-10-01 00:55:17.266","longitude":"117.338059","timestamp":"1506819317266"}
        Timestamp t = new Timestamp(1515977345000L);
        Timestamp t1 = new Timestamp(1516000454000L);
        Date date = new Date(t.getTime());
        Date date1 = new Date(t1.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String sDate = simpleDateFormat.format(date);
        String sDate1 = simpleDateFormat.format(date1);
        System.out.println(sDate);
        System.out.println(sDate1);
    }

    public void test2(){
        Timestamp ts =  Timestamp.valueOf("2017-06-01 00:00:15");
        System.out.println(ts.getTime());
    }
    public void test3(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -1);
        String lastHour = new SimpleDateFormat("yyyy-MM-dd HH").format(cal.getTime());
        String startLastHour = lastHour + ":00:00";
        String endLastHour = lastHour + ":59:59";
        System.out.println(startLastHour + "   "+endLastHour);
    }
    public void test4(){
        Long differ = Math.abs(13l-18l);
        System.out.println(differ);
    }
    public void test5(){
        display("2008-08-19", "2008-09-05");
    }

    public static void display(String dateFirst, String dateSecond){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date dateOne = dateFormat.parse(dateFirst);
            Date dateTwo = dateFormat.parse(dateSecond);

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(dateOne);

            while(calendar.getTime().before(dateTwo)){
                System.out.println(dateFormat.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

