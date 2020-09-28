package cn.acrel.demo.callback;

import cn.acrel.demo.entity.DeviceStateInfo;

/**
 * @author
 * @version 调用者，预留回调接口
 */
public class Caller {
    private CallBack callBack;
    public void doCall(DeviceStateInfo deviceStateInfo){
        callBack.updateSate(deviceStateInfo);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
