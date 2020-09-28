package cn.acrel.demo.callback;

import cn.acrel.demo.entity.DeviceStateInfo;
import cn.acrel.demo.imp.QueryStateServiceImpl;
import cn.acrel.demo.mapper.DeviceStateMapper;

import javax.annotation.Resource;
import java.util.Map;

public class CallBackTest {
    public DeviceStateInfo update(DeviceStateInfo deviceStateInfo) {
        Caller caller = new Caller();
        //实例化具体回调函数，实现回调方法
        caller.setCallBack(new CallBack() {
            @Override
            public DeviceStateInfo updateSate(DeviceStateInfo deviceStateInfo) {
                QueryStateServiceImpl queryStateService = new QueryStateServiceImpl();
                Map<Boolean, String> map = queryStateService.getState(deviceStateInfo);
                for (Map.Entry<Boolean, String> entry : map.entrySet()) {
                    Boolean key = entry.getKey();
                    String value = entry.getValue();
                    deviceStateInfo.setState(key);
                }
                return deviceStateInfo;
            }
        });
        caller.doCall(deviceStateInfo);
       return deviceStateInfo;
    }


}
