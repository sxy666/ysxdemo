package cn.acrel.demo.imp;

import cn.acrel.demo.Test;
import cn.acrel.demo.entity.DeviceStateInfo;
import cn.acrel.demo.mapper.DeviceStateMapper;
import cn.acrel.demo.service.QueryStateService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.acrel.demo.example.ApiExample.queryDeviceStatusList;

@Service
public class QueryStateServiceImpl implements QueryStateService{
    @Resource
    DeviceStateMapper mapper;



    @Override
    public Map<Boolean, String> getState(DeviceStateInfo deviceStateInfo) {
      //  deviceStateInfo.setProduceID("15000601");
       // deviceStateInfo.setDeviceID("6b27bdb569094a6aa1849310be648149");
        Map<Boolean, String> map = new HashMap<>();
        try {
            String result = queryDeviceStatusList(deviceStateInfo.getProduceID(), deviceStateInfo.getDeviceID());
            int begin = result.indexOf("dataVal1");
            result = result.substring(begin + 13, begin + 17);
            String re = Test.hexStr2BinStr(result);
            re = re.substring(12);
            if (re.equals("0000")) {
                map.put(true, "没有报警");
                deviceStateInfo.setState(true);
      //          return map;
            }
            if (re.equals("0001")) {
                map.put(false, "报警");
                deviceStateInfo.setState(false);
            }
            if (re.equals("0100")) {
                map.put(false, "防拆报警");
                deviceStateInfo.setState(false);
            }
            if (re.equals("0101")) {
                map.put(false, "全部报警");
                deviceStateInfo.setState(false);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public List<DeviceStateInfo> getDevice(@RequestParam String produceID, @RequestParam String deviceID) {
        return mapper.select(produceID, deviceID);
    }

    @Override
    public Boolean update(DeviceStateInfo deviceStateInfo) {
        return null;
    }


}
