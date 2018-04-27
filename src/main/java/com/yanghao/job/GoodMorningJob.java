package com.yanghao.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 早晨叮咛
 * 具体要实现的任务类
 */
public class GoodMorningJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("清晨，一缕阳光溜进了那洁白的窗台");

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String time = (String) jobDataMap.get("时间");
        String place = (String) jobDataMap.get("地点");
        System.out.println("时间："+time);
        System.out.println("地点："+place);
    }
}