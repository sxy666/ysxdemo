package cn.acrel.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static cn.acrel.demo.ApiExample.queryDeviceStatusList;

public class QueryStateServiceImpl implements QueryStateService {
    @Override
    public Map<String, String> getState(String produceId, String deviceId) {
        produceId = "15000601";
        deviceId = "6b27bdb569094a6aa1849310be648149";
        Map<String, String> map = new HashMap<>();
        try {
            String result = queryDeviceStatusList(produceId, deviceId);
            int begin = result.indexOf("dataVal1");
            result = result.substring(begin + 13, begin + 17);
            String re = Test.hexStr2BinStr(result);
            re = re.substring(11, 15);
            if (re.equals("0000"))
                map.put("正常", "没有报警");
            if (re.equals("0001"))
                map.put("报警", "水浸报警");
            if (re.equals("0100"))
                map.put("报警", "防拆报警");
            if (re.equals("0101"))
                map.put("报警", "全部报警");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
