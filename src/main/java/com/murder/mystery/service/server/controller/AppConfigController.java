package com.murder.mystery.service.server.controller;

import com.murder.mystery.service.server.domain.AppConfig;
import com.murder.mystery.service.server.netty.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yuehui on 2018/6/10
 */
@Controller
@RequestMapping("/config")
public class AppConfigController {

    @Value("${start.hour}")
    private Integer startHour;
    @Value("${end.hour}")
    private Integer endHour;

    @RequestMapping("/get_time")
    @ResponseBody
    public AppConfig getLeftTime(){
        AppConfig config = new AppConfig();
        config.setStartDt(CommonUtils.getTodayLeftTime(startHour));
        config.setEndDt(CommonUtils.getTodayBeginTime(endHour));
        return config;
    }

}
