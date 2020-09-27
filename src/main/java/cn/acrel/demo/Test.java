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
        System.out.println( hexStringToBytes("01 FC 3B 00 06 00 D2 05  CF 4A 54 00 21 03 08 67 88 40 40 05 43 70 04 60  11 31 19 59 86 62 00 00 0F FF 75 04 01 00 05 00  00 01 00 24 B0 BE 61 2A FF 01 FC 3B 00 06 00 D2 " +
                " 05 CF 4A 54 00 21 03 08 67 88 40 40 05 43 70 04  60 11 31 19 59 86 62 00 00 0F FF 75 04 01 00 05  00 00 01 00 24 B0 BE"));
        hexToByte("01 FC 3B 00 06 00 D2 05  CF 4A 54 00 21 03 08 67 88 40 40 05 43 70 04 60  11 31 19 59 86 62 00 00 0F FF 75 04 01 00 05 00  00 01 00 24 B0 BE 61 2A FF 01 FC 3B 00 06 00 D2 " +
                " 05 CF 4A 54 00 21 03 08 67 88 40 40 05 43 70 04  60 11 31 19 59 86 62 00 00 0F FF 75 04 01 00 05  00 00 01 00 24 B0 BE");
    }
}
