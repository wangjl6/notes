package com.study.gupao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/6/26
 **/
@Configuration
@EnableAsync
public class ApplicationConfig {

    @Bean
    public Executor taskExecutor(){
        Executor taskExecutor = new SimpleAsyncTaskExecutor();
        return taskExecutor;
    }

}
