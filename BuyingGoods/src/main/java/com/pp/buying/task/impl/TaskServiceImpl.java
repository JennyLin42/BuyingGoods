package com.pp.buying.task.impl;

import com.pp.buying.task.TaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Scheduled(cron = "0 0 1 * * ?")
    public void sayHello(){
        System.out.println("定时任务");
    }

}
