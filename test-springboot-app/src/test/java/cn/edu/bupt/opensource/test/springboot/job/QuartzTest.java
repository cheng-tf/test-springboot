package cn.edu.bupt.opensource.test.springboot.job;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author chengtf
 * @date 2019/4/10
 */
public class QuartzTest {

    @Test
    public void main() {
        try {
            // #1 Quartz调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // #2 触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    // SimpleTrigger
                    /*.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())*/
                    // CalendarIntervalTrigger
                    /*.withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                            .withIntervalInSeconds(1))*/
                    // DailyTimeIntervalTrigger
                    /*.withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                            .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0))
                            .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(16, 0))
                            .onDaysOfTheWeek(DateBuilder.MONDAY,DateBuilder.TUESDAY,DateBuilder.WEDNESDAY,DateBuilder.THURSDAY,DateBuilder.FRIDAY)
                            .withIntervalInHours(1)
                            .withRepeatCount(100)
                            )*/
                    // CronTrigger
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?"))
                    .build();

            // #3 定时任务
            JobDetail job = JobBuilder.newJob(HelloQuartz.class)
                    .withIdentity("job1", "group1")
                    .withDescription("This is a test job!")
                    .usingJobData("name", "quartz")
                    .build();
            job.getJobDataMap().put("age", 18);

            // #4 加入调度器，并启动
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
            Thread.sleep(10000);

            // #5 关闭调度器
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}