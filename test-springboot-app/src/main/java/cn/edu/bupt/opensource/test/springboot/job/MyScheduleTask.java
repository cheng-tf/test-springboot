package cn.edu.bupt.opensource.test.springboot.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chengtf
 * @date 2019/4/9
 */
@Configuration
@Component
@EnableScheduling
public class MyScheduleTask {

    private static final Logger log = LoggerFactory.getLogger(MyScheduleTask.class);

    public void myScheduleMethod() {
        // 实际业务
        log.info("开始定时执行：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
