package com.lilili.scheduled;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lilili957
 * @date 2021/12/13 22:23
 **/
public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        String startTime = new SimpleDateFormat("HH:mm:ss").format(date);
        System.out.println(startTime + "  HelloWorld");
    }
}
