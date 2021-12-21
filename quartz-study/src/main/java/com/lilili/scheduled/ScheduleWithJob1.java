package com.lilili.scheduled;

import com.lilili.service.ScheduleJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @Author LiYuan
 * @Date 2021/12/14
 **/
@Slf4j
public class ScheduleWithJob1 extends QuartzJobBean {

    @Autowired
    ScheduleJobService scheduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("start schedule job1: " + LocalDateTime.now());
        try {
            scheduleJobService.scheduleJob1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

