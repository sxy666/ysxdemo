package cn.acrel.demo.mapper;

import cn.acrel.demo.entity.DeviceStateInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceStateMapper {
    Boolean update(DeviceStateInfo deviceStateInfo);
    List<DeviceStateInfo> select(String produceID, String deviceID);
}
