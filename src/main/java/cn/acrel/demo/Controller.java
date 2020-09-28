package cn.acrel.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static cn.acrel.demo.ApiExample.*;

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
    public Map<String, String> post(String produceId, String deviceId) {
        return stateService.getState(produceId, deviceId);
    }
}
