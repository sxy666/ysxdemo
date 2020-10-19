package cn.acrel.demo;


import cn.acrel.demo.entity.DeviceStateInfo;
import cn.acrel.demo.service.QueryStateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootTest
class DemoApplicationTests {
@Resource
QueryStateService stateService;
    @Test
    void contextLoads() throws NoSuchAlgorithmException, InvalidKeySpecException {
//        DeviceStateInfo deviceStateInfo=new DeviceStateInfo();
//       UpdateState updateState=new UpdateState();
//       deviceStateInfo.setProduceID("1");
//       deviceStateInfo.setDeviceID("1");
//       updateState.updateSate(deviceStateInfo);


    }

}
