package com.ws.springbootStudy.server.controller;

import com.google.common.collect.Maps;
import com.ws.springbootStudy.server.enums.StatusCode;
import com.ws.springbootStudy.server.response.BaseResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 读取通用他配置信息
 * 1、通过environment的getProperty（）方法获取
 * 2、通过@Value注解获取
 * Created by UPC on 2019/1/20.
 */
@RestController
public class EnvironmentController {

    private final Logger logger = Logger.getLogger(EnvironmentController.class);

    private static final String prefix = "/enviroment";

    @Autowired
    private Environment environment;

    @Value("${com.ws.persionInfo.name}")
    private String name;
    @Value("${com.ws.persionInfo.age}")
    private String age;
    @Value("${com.ws.persionInfo.phone}")
    private String phone;

    @RequestMapping(name = "/detail")
    public BaseResponse envirDetail() {

        BaseResponse baseResponse = new BaseResponse(StatusCode.SUCCESS);

        try {
            Map<String, Object> resultMap = Maps.newHashMap();

//            resultMap.put("name", environment.getProperty("com.ws.persionInfo.name"));
//            resultMap.put("age", environment.getProperty("com.ws.persionInfo.age"));
//            resultMap.put("phone", environment.getProperty("com.ws.persionInfo.phone"));
            resultMap.put("name", name);
            resultMap.put("age", age);
            resultMap.put("phone", phone);
            baseResponse.setData(resultMap);

        } catch (Exception e) {
            logger.error("异常：",e);
            baseResponse.setCode(50);
            return baseResponse;
        }

        return baseResponse;
    }
}
