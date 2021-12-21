package com.lilili.scheduled;

import com.lilili.service.ScheduleJobService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @Author LiYuan
 * @Date 2021/12/14
 **/
public class ScheduleWithJob2 extends QuartzJobBean {

    @Autowired
    ScheduleJobService scheduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("start schedule with job2: " + LocalDateTime.now());
            scheduleJobService.scheduleJob2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

