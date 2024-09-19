package com.example.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener {

    @EventListener
    @Async
    //TOTO:怎样不用async生成一个异步的事件监听器AsynchronousSpringEventsConfig工作的不对
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received spring custom event - " + event.getMessage() + " - end");
    }

}