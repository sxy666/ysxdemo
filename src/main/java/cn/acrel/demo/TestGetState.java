package cn.acrel.demo;

public class TestGetState {
    public String get(String productId, String deviceId, CallBack callBack) {
        System.out.println("ygx");
        return  callBack.getState(productId,deviceId);
    }
}
