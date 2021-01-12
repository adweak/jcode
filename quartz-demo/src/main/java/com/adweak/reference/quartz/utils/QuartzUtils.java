package com.adweak.reference.quartz.utils;

import com.adweak.reference.quartz.job.BookRecordJob;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Date;

import static com.adweak.reference.quartz.constants.CommonConstants.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzUtils {

    public static JobKey getJobKey(Long bookRecordId) {
        return new JobKey(Long.toString(bookRecordId), GROUP_KEY );
    }

    public static TriggerKey getTriggerKey(Long sceneId) {
        return new TriggerKey(Long.toString(sceneId), GROUP_KEY);
    }

    public static Trigger getOneTimeBookRecordTrigger(Long bookRecordId, long time) {
        Trigger trigger = newTrigger()
                .withIdentity(getTriggerKey(bookRecordId))
                .startNow()
                .startAt(new Date(time))
                .build();
        return trigger;
    }

    public static Trigger getOneTimeBookRecordTrigger(Long bookRecordId, long time, String timezone) {
        LocalDate ld = LocalDate.now(ZoneId.of(timezone));
        LocalTime lt = LocalTime.ofNanoOfDay(time);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.of(timezone));

        Trigger trigger = newTrigger()
                .withIdentity(getTriggerKey(bookRecordId))
                .startNow()
                .startAt(new Date(zonedDateTime.getLong(ChronoField.MILLI_OF_SECOND)))
                .build();
        return trigger;
    }

    public static JobDetail getBookRecordJobDetail(Long bookRecordId) {
        JobDetail job = newJob(BookRecordJob.class)
                .withIdentity(getJobKey(bookRecordId))
                .usingJobData(GROUP_KEY_KEY, bookRecordId)
                .build();
        return job;
    }
}
