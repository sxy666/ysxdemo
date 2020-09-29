package cn.acrel.demo;

import cn.acrel.demo.callback.CallBackTest;
import cn.acrel.demo.entity.DeviceStateInfo;
import cn.acrel.demo.service.QueryStateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
@Resource
QueryStateService stateService;
    @Test
    void contextLoads() {
//        DeviceStateInfo deviceStateInfo=new DeviceStateInfo();
//       UpdateState updateState=new UpdateState();
//       deviceStateInfo.setProduceID("1");
//       deviceStateInfo.setDeviceID("1");
//       updateState.updateSate(deviceStateInfo);
        DeviceStateInfo deviceStateInfo=new DeviceStateInfo();
        CallBackTest callBackTest=new CallBackTest();
        callBackTest.update(deviceStateInfo);
    }

}
