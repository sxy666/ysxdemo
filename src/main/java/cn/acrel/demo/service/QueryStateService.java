package cn.acrel.demo.service;

import cn.acrel.demo.entity.DeviceStateInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
public interface QueryStateService {
    Map<Boolean,String> getState(DeviceStateInfo deviceStateInfo);
    List<DeviceStateInfo> getDevice(String produceID,String deviceID);
    Boolean update(DeviceStateInfo deviceStateInfo);
}
