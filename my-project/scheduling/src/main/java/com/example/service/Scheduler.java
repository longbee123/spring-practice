//package com.example.scheduling;
//
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//public class Scheduler {
//    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
//    public void fixedDelaySch() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date now = new Date();
//        String strDate = sdf.format(now);
//        System.out.println("Fixed Delay scheduler:: " + strDate);
//    }
//
//}
