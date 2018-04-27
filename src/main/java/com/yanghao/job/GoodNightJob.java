package com.yanghao.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义晚安任务类
 */
public class GoodNightJob {

    public void goodNight(){

        System.out.println("夜晚，月光和星星都是那么耀眼！");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:SS");
        String formatDate = simpleDateFormat.format(date);
        System.out.println("当前的时间是："+formatDate);
        System.out.println("这个时间正好是酣睡的好时机，看看大树和泥土都已经拥抱在一起了，渐渐。。渐渐 。。入梦");
    }
}
