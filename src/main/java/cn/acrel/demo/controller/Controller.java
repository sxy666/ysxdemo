package cn.acrel.demo.controller;

import cn.acrel.demo.service.QueryStateService;
import cn.acrel.demo.entity.DeviceStateInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

import static cn.acrel.demo.example.ApiExample.*;

@RestController
public class Controller {
    @Resource
    QueryStateService stateService;

    @GetMapping(value = "/Get", produces = "application/json", consumes = "application/json")
    public String get() {
        try {
            return httpGetExample("product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/Post", produces = "application/json", consumes = "application/json")
    public Map<Boolean, String> post(DeviceStateInfo deviceStateInfo) {
        return stateService.getState(deviceStateInfo);
    }
}
