package cn.acrel.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static cn.acrel.demo.ApiExample.*;

@RestController
public class Controller {

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
        produceId = "15000601";
        deviceId = "6b27bdb569094a6aa1849310be648149";
        Map<String,String> map=new HashMap<>();
        try {
            String result = queryDeviceStatusList(produceId, deviceId);
            int begin = result.indexOf("dataVal1");
            result = result.substring(begin + 13, begin + 17);
            String re = Test.hexStr2BinStr(result);
            re = re.substring(11,15);
            if (re.equals("0000"))
                map.put("正常","没有报警");
            if (re.equals("0001"))
                map.put("报警","水浸报警");
            if (re.equals("0100"))
                map.put("报警","防拆报警");
            if (re.equals("0101"))
                map.put("报警","全部报警");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
