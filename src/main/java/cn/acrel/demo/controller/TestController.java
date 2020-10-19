package cn.acrel.demo.controller;

import cn.acrel.demo.config.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/sendMqtt")
    public String sendMqtt(){
        mqttGateway.sendToMqtt("sendData","hello");
        return "OK";
    }

}
