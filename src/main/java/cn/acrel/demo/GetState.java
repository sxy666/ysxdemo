package cn.acrel.demo;

public class GetState implements CallBack {

    public String get(String productId,String devicesId){
    TestGetState testGetState=new TestGetState();
    String result=null;
    result= testGetState.get(productId,devicesId,this);
    return result;
}
    @Override
    public String getState(String productId,String devicesId) {
        String result=null;
        try {
            result= ApiExample.queryDeviceStatusList(productId, devicesId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
