package cn.acrel.demo.controller;

import cn.acrel.demo.Test;
import cn.acrel.demo.entity.ResponseState;
import cn.acrel.demo.imp.QueryStateServiceImpl;
import cn.acrel.demo.service.QueryStateService;
import cn.acrel.demo.entity.DeviceStateInfo;
import com.ctiot.aep.mqmsgpush.sdk.IMsgConsumer;
import com.ctiot.aep.mqmsgpush.sdk.IMsgListener;
import com.ctiot.aep.mqmsgpush.sdk.MqMsgConsumer;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static cn.acrel.demo.example.ApiExample.*;

@RestController
public class TController {
    @Resource
    QueryStateService stateService;
    @Resource
    HttpServletRequest request;

    @GetMapping("/ttt")
    public String a(){
        return "sadawdwa";
    }


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
    public Map<Boolean, String> post(@RequestBody DeviceStateInfo deviceStateInfo) {
        return stateService.getState(deviceStateInfo);
    }

    @GetMapping("/getDeviceState")
    public List<DeviceStateInfo> getState(@RequestParam String produceID,@RequestParam String deviceID) {
        return stateService.getDevice(produceID, deviceID);
    }

    @PostMapping("/Update")
    public DeviceStateInfo update(@RequestBody ResponseState responseState) throws Exception {
        DeviceStateInfo deviceStateInfo = new DeviceStateInfo();
        String result = queryDeviceStatusList(responseState.getProductId(), responseState.getDeviceId());
        int begin = result.indexOf("dataVal1");
        result = result.substring(begin + 13, begin + 17);
        String re = Test.hexStr2BinStr(result);
        re = re.substring(12);
        deviceStateInfo.setState(re.equals("0000"));
        deviceStateInfo.setDeviceID(responseState.getDeviceId());
        deviceStateInfo.setProduceID(responseState.getProductId());
        stateService.update(deviceStateInfo);
        return deviceStateInfo;
    }
}
