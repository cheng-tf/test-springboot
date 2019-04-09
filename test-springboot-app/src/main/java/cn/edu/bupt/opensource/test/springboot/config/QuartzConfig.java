package cn.edu.bupt.opensource.test.springboot.config;

import cn.edu.bupt.opensource.test.springboot.job.ScheduleTask;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置类
 * @author chengtf
 * @date 2019/4/9
 */
@Configuration
public class QuartzConfig {

    /**
     * 定时任务
     */
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(true);
        jobDetail.setName("scheduler1");
        jobDetail.setGroup("scheduler_group1");
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("myScheduleMethod");
        return jobDetail;
    }

    /**
     * 定时任务触发器
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(jobDetail.getObject());
        // 每隔6秒钟执行一次
        tigger.setCronExpression("0/6 * * * * ?");
        tigger.setName("myTigger");
        return tigger;

    }

    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 设置是否任意一个已定义的Job会覆盖现在的Job
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(5);
        bean.setTriggers(cronJobTrigger);
        return bean;
    }

}
