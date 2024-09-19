package com.example.controller;

import com.example.service.MyService;
import com.example.service.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @Autowired
    private Task task;

    @GetMapping("/data")
    public String getData() {
        return myService.getData();
    }

    @GetMapping("/asyncdata")
    public String getAsyncData() {
        long start = System.currentTimeMillis();
        try {
            Future<String> task1 = task.doTaskOne();
            Future<String> task2 = task.doTaskTwo();
            Future<String> task3 = task.doTaskThree();

            System.out.println("开始判断任务状态");
            while(true) {
                if(task1.isDone() && task2.isDone() && task3.isDone()) {
                    // 三个任务都调用完成，退出循环等待
                    break;
                }
                Thread.sleep(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

        return "这是异步获取到的数据";
    }
}