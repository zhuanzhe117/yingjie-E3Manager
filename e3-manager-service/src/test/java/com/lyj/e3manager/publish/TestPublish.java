package com.lyj.e3manager.publish;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPublish {
    @Test
    public void publishService()throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpaht:spring/applicationContext-*.xml");
        while (true){
            Thread.sleep(1000);
        }
//        System.in.read();
    }
}
