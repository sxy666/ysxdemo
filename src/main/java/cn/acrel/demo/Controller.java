package cn.acrel.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.acrel.demo.ApiExample.*;

@RestController
public class Controller {

    @GetMapping(value = "/Get", produces = "application/json", consumes = "application/json")
    public String get (){
        try {
            return httpGetExample("product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/Post", produces = "application/json", consumes = "application/json")
    public String post(String produceId,String deviceId){
        produceId="15000601";
        deviceId="6b27bdb569094a6aa1849310be648149";
        try {
            return queryDeviceStatusList(produceId, deviceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
