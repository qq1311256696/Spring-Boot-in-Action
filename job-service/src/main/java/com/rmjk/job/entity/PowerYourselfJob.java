package com.rmjk.job.entity;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * Job: 表示一个任务,要执行的具体内容
 * @author vividzc
 * @date 2018/6/14 23:03
 */
@Slf4j
@Component
public class PowerYourselfJob extends BaseJob {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("11111111111111");
    }
}
