package cn.acrel.demo;


import cn.acrel.demo.entity.DeviceStateInfo;
import cn.acrel.demo.service.QueryStateService;
import cn.acrel.demo.va.PBKDF2Util;
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


        String password = "123456";

        for (int i = 0; i < 5; i++) {
            String salt = PBKDF2Util.generateSalt();
            String pbkdf2 = PBKDF2Util.getEncryptedPassword(password,salt);

            System.out.println("原始密码:"+password);
            System.out.println("盐值:"+salt);
            System.out.println("PBKDF2加盐后的密码:"+pbkdf2);
            boolean authenticate = PBKDF2Util.authenticate("12346", pbkdf2, salt);
            System.out.println(authenticate);
            System.out.println("----------------------------");


        }


    }

}
