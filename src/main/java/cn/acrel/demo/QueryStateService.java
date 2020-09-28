package cn.acrel.demo;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface QueryStateService {
    Map<String,String> getState(String produceId, String deviceId);
}
