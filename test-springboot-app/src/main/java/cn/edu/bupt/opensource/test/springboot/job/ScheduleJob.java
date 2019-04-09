package cn.edu.bupt.opensource.test.springboot.job;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 使用Spring Schedule实现定时任务
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class ScheduleJob {

    private static final Logger log = LoggerFactory.getLogger(ScheduleJob.class);

    private static final long ONE_SECOND =  1000;

    private final FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = ONE_SECOND * 2)
    public void fixedDelayJob() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        log.info("[FixedDelayJob 执行]：" + sdf.format(new Date()));
    }

    @Scheduled(fixedRate = ONE_SECOND * 4)
    public void fixedRateJob() {
        log.info("[FixedRateJob 执行]：" + sdf.format(new Date()));
    }

    @Scheduled(cron = "0/4 * * * * ?")
    public void cronJob() {
        log.info("[CronJob 执行]：" + sdf.format(new Date()));
    }

}
