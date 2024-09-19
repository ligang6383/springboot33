package com.example.service;

import com.example.springEvent.CustomSpringEvent;
import com.example.springEvent.CustomSpringEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    CustomSpringEventListener customSpringEventListener;


    // 示例方法
    public String getData() {

        System.out.println("Publishing custom event. ");
        System.out.println("Message: " + "这是获取到的数据");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, "message");

        customSpringEventListener.onApplicationEvent(customSpringEvent);

        return "这是获取到的数据";
    }


}
