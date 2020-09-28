package cn.acrel.demo.entity;

import lombok.Data;

@Data
public class DeviceStateInfo {
    private String deviceID;
    private String produceID;
    private Boolean state;
}
