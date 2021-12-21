package com.lilili.service;

/**
 * @Author LiYuan
 * @Date 2021/12/14
 **/
public interface ScheduleJobService {

    /**
     * job1定时任务
     * @throws Exception
     */
    void scheduleJob1() throws Exception;

    /**
     * job2定时任务
     * @throws Exception
     */
    void scheduleJob2() throws Exception;
}