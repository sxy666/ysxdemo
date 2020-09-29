package cn.acrel.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseState implements Serializable {

    private String tenantId;
    private String productId;
    private String deviceId;
    private String messageType;
    private String IMEI;
    private String IMSI;
    private String deviceType;
    private String topic;
    private String assocAssetId;
    private long timestamo;
    private int upPacketSN;
    private int upDataSN;
    private String serviceId;
    private String protocol;
    private String payload;
}
