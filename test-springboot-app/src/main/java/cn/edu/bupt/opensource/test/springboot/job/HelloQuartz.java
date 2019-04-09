package cn.edu.bupt.opensource.test.springboot.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author chengtf
 * @date 2019/4/10
 */
public class HelloQuartz implements Job {

    private static final Logger log = LoggerFactory.getLogger(HelloQuartz.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        log.info("Say Hello to " + detail.getJobDataMap().getString("name") + " at " + new Date());
    }

}
