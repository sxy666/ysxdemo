package cn.acrel.demo;

public class Test {
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase().replace(" ", "");
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
        public static byte[] hexToByte(String hex) {
        hex = hex.replace(" ", "");

/**

 　　*字节数组长度为16进制字符串长度的一半

 　　*/

        int byteLength = hex.length() / 2;

        byte[] bytes = new byte[byteLength];

        int m = 0;

        int n = 0;

        for (int i = 0; i < byteLength; i++) {

            m = i * 2 + 1;

            n = m + 1;

            int intHex = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));

            bytes[i] = Byte.valueOf((byte) intHex);
        }
        return bytes;

    }

    public static void main(String[] args) {
        GetState getState=new GetState();
      String result= getState.get("15000601","6b27bdb569094a6aa1849310be648149");
        System.out.println(result);
    }
}
