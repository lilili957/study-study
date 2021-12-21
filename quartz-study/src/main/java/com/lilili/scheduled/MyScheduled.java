package com.lilili.scheduled;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lilili957
 * @date 2021/12/13 22:25
 **/
public class MyScheduled {
    public static void main(String[] args) throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        //创建Job实例
        JobDetail job = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "jobGroup1")
                .build();
        //创建触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();


    }
}
