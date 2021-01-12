package com.adweak.reference.quartz.scheduler;

import com.adweak.reference.quartz.utils.QuartzUtils;
import groovy.lang.Singleton;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
@Singleton
public class BookRecordScheduleMgr {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 创建定时执行Job
     * @param bookRecordId
     * @param exeTime
     */
    public void scheduleBookRecordJob(Long bookRecordId, long exeTime) {
        unScheduleBookRecordJob(bookRecordId);
        Scheduler sched = schedulerFactoryBean.getScheduler();
        // Trigger the job to run now, and then every 40 seconds
        JobDetail job = QuartzUtils.getBookRecordJobDetail(bookRecordId);
        Trigger trigger = QuartzUtils.getOneTimeBookRecordTrigger(bookRecordId, exeTime);
        // Tell quartz to scheduler the job using our trigger
        try {
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建带有时区的定时执行Job
     * @param bookRecordId
     * @param exeTime
     * @param timezone
     */
    public void scheduleBookRecordJob(Long bookRecordId, long exeTime, String timezone) {
        unScheduleBookRecordJob(bookRecordId);
        Scheduler sched = schedulerFactoryBean.getScheduler();
        // Trigger the job to run now, and then every 40 seconds
        JobDetail job = QuartzUtils.getBookRecordJobDetail(bookRecordId);
        Trigger trigger = QuartzUtils.getOneTimeBookRecordTrigger(bookRecordId, exeTime, timezone);
        // Tell quartz to scheduler the job using our trigger
        try {
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除定时执行Job
     * @param bookRecordId
     */
    public void unScheduleBookRecordJob(Long bookRecordId) {
        JobKey jobKey = QuartzUtils.getJobKey(bookRecordId);
        Scheduler sched = schedulerFactoryBean.getScheduler();
        try {
            if (sched.checkExists(jobKey)) {
                sched.deleteJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
