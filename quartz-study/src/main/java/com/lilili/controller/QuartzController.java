//package com.lilili.controller;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.lilili.model.UpdateJobBean;
//import com.lilili.service.QuartzService;
//import org.quartz.JobDataMap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
////@Api(value = "quartz增删改查相关API")
//@RequestMapping(value = "/quartz")
//public class QuartzController {
//
//    @Autowired
//    QuartzService quartzService;
//
////    @ApiOperation(value = "使用quartz添加job")
//    @RequestMapping(value = "/addJob/{jobUUID}", method = RequestMethod.POST)
//    public void addQuartzJob(
//            @PathVariable("jobUUID") String jobUUID,
//           @RequestBody JobXXXBean jobXXXBean) {
//
//        if (jobXXXBean.getOpenBean() != null) {
//            JobDataMap jobDataMap = new JobDataMap();
//            jobDataMap.put("key01", jobXXXBean.getKey01());
//            jobDataMap.put("key02", jobXXXBean.getKey02());
//            jobDataMap.put("key03", jobXXXBean.getKey03());
//            jobDataMap.put("jobTimeCron", jobXXXBean.getJobTimeCron());
//            jobDataMap.put("key04", jobXXXBean.getKey04());
//            quartzService.addJob(Job1.class,
//                    jobUUID,
//                    jobUUID,
//                    jobXXXBean.getJobTimeCron(),
//                    jobDataMap);
//        } else {
//            throw new BadRequestException("参数错误");
//        }
//    }
//
//
//    @ApiOperation(value = "使用quartz查询所有job")
//    @RequestMapping(value = "/queryAllJob", method = RequestMethod.GET)
//    public List<Map<String, Object>> queryAllQuartzJob() {
//
//        List<Map<String, Object>> list = quartzService.queryAllJob();
//        return list;
//    }
//
//
//    @ApiOperation(value = "使用quartz查询所有运行job")
//    @RequestMapping(value = "/queryRunJob", method = RequestMethod.GET)
//    public List<Map<String, Object>> queryRunQuartzJob() {
//
//        List<Map<String, Object>> list = quartzService.queryRunJob();
//        return list;
//    }
//
//    @ApiOperation(value = "使用quartz删除job")
//    @RequestMapping(value = "/deleteJob/{jobUUID}", method = RequestMethod.DELETE)
//    public void deleteJob(
//            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID) {
//
//        quartzService.deleteJob(jobUUID, jobUUID);
//    }
//
//
//    @ApiOperation(value = "使用quartz修改job的cron时间")
//    @RequestMapping(value = "/updateJob/{jobUUID}", method = RequestMethod.PUT)
//    public void deleteJob(
//            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID,
//            @ApiParam(name = "jobCronTime") @RequestBody UpdateJobBean updateJobBean) {
//
//        quartzService.updateJob(jobUUID, jobUUID, updateJobBean.getJobCronTime());
//
//    }
//}
//
//
//
