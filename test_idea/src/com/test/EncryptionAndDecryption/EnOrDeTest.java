package com.test.EncryptionAndDecryption;
/**
 * @PACKAGE com.test.EncryptionAndDecryption.util
 * @Author Administrator
 * @Date created in 2018/6/8 09:18
 * @Description:
 */

import com.test.EncryptionAndDecryption.util.RSA2Coder;
import com.test.EncryptionAndDecryption.util.RSACoder;

import java.util.Map;

/**
 * 加解密测试
 * @author Administrator
 * @create 2018-06-08 9:18
 **/
public class EnOrDeTest {

    public static void main(String[] args) throws Exception{
       /* System.out.println(Encryption2AESUtil.Encrypt("123456"));
        System.out.println(Encryption2AESUtil.Encrypt("123456").length());
        System.out.println(Encryption2AESUtil.Decrpyt("iq7B/xRNuDcnXCKbye03Tw=="));*/
       /* Map<String, Object> keyMap = RSA2Coder.initKey();
        System.out.println(RSA2Coder.getPrivateKey4String(keyMap));
        System.out.println(RSA2Coder.getPublicKey4String(keyMap));*/
        Map<String, Object> keyMap2 =RSACoder.initKey();
        System.out.println(RSACoder.getPrivateKey(keyMap2));
        System.out.println(RSACoder.getPublicKey(keyMap2));

        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKV3JztsDEagYnALHP5pH5ZurhpSgbyMlaRcAh1MjcMaA0lVFzxd7KTpOe3NjmcTEJeSJXt+eqx8ULWaW0OrV5jwOfeyU736bEUpuP90eRvL3DJsRBZ8ICsRFeo5YuVqyWbq64xS6BkmWrNjUNxvjEscP18YacEgUbNtdJfnqHhPAgMBAAECgYBnoFv9pwl5IfEEYrFh08xoliCLc6i0wQbmzIi2eL8/tQbh4lyO/fO6xCX3fIj2nMYDZw/6a5fAdorFcUo+8wwERiePP9CN71m7Er3SnBAnHNEKej3Ohn/mHKcOklN2/1fZHKJHabtB99umLUai5wbSkI3SguYhIW/g68DBvvmvAQJBANj2nnUMHvUEfYA/Y/xaoDts8lZjdJDK7RT2kLyiMsA/CK1wZmRRC+Zp1UB7Dy54Ecr8Vg5ntvpAVzOIAH4k9KECQQDDPIdfqRXaXuhxHCpdSCcBrScdvA1/KibUMnC0wAp+Vp8URPWBmMzP/EGze8Kj/YkVLsH69bb41Eu2Yip8ulbvAkBKXxdoJfSCprxidthOS757QFg9tq/hZj4onnB0yOC+t5zA3zOqFYIPxJ1+EfDdS/lFbIQPQgwd8mox1t/cXcyhAkEAwfz8jaJWIlo3H1xbA8DTcSj5OuRFjNr3JdTQg+hlBM9Q1TUHs7N9nhMJvSr1ZThf4vpIp/FJ0sguSpQTn0cPZQJBAMKIjvl4EoKGaDsLCZGI7DGfy7DTP7Sf2M/0cqhCltcMovQBkk85gG42sT1FH9Sf8BMWiMAvR4H1+EQgqPdnooU=";
        String publicKey1= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCldyc7bAxGoGJwCxz+aR+Wbq4aUoG8jJWkXAIdTI3DGgNJVRc8Xeyk6TntzY5nExCXkiV7fnqsfFC1mltDq1eY8Dn3slO9+mxFKbj/dHkby9wybEQWfCArERXqOWLlaslm6uuMUugZJlqzY1Dcb4xLHD9fGGnBIFGzbXSX56h4TwIDAQAB";
//        System.out.println(publicKey1.equals(RSA2Coder.getPublicKey4String(keyMap)));
        byte[] b = RSACoder.encryptByPublicKey(("wolaiye").getBytes("UTF-8"),publicKey1);
//        byte[] b = RSACoder.encryptByPublicKey(RSACoder.decryptBASE64("wolaiye"),publicKey1);
//        System.out.println(new String(b,"UTF-8"));
        System.out.println(RSACoder.encryptBASE64(b));
//        String e = "fBgx6vO+44eXX3fgKirq+ICb1nE23Phn6gq4t1hVyc0T3GAY3YgMG2LcLej8w3+ySxM7eEtoK+JsyGIHyaL34QnzKIdSD52SZ4lBEXaRb8YDZrBl9tZbcpqmrGWCUmRFURMwREAMSFUgAmTFnK4azPAovdx6q7Zcm6SycZ4oeTU=";
        String e = "DTL8Yjh9Uqs+SdEOlVIZOPdMgP4IGl1D2AybI/wsW2lG1i88tDSVKrjApdYrTvKiTFL7dsk/v0DX8T269SQHFZ4VDB2fx+APmOKuFr1aHpcv89tu51Y5wZdsM5PuIiW0rUkq0tVaQNwMZAdGwJgLJN/UxGQ6cboH1z+BkuRxBCs=";
        System.out.println(RSACoder.decryption4Private(e,privateKey));
        System.out.println(RSACoder.encryptBASE64(RSACoder.decryptByPrivateKey1(RSACoder.decryptBASE64(e),privateKey)));
        System.out.println(new String(RSACoder.decryptByPrivateKey1(RSACoder.decryptBASE64(e),privateKey)));

//        test();
//        System.out.println();
//        testSign();
//        System.out.println(RSACoder.sign("CHENGUAN".getBytes(),RSA2Coder.getPrivateKey4String(keyMap)));
    }

    static void test() throws Exception {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKV3JztsDEagYnALHP5pH5ZurhpSgbyMlaRcAh1MjcMaA0lVFzxd7KTpOe3NjmcTEJeSJXt+eqx8ULWaW0OrV5jwOfeyU736bEUpuP90eRvL3DJsRBZ8ICsRFeo5YuVqyWbq64xS6BkmWrNjUNxvjEscP18YacEgUbNtdJfnqHhPAgMBAAECgYBnoFv9pwl5IfEEYrFh08xoliCLc6i0wQbmzIi2eL8/tQbh4lyO/fO6xCX3fIj2nMYDZw/6a5fAdorFcUo+8wwERiePP9CN71m7Er3SnBAnHNEKej3Ohn/mHKcOklN2/1fZHKJHabtB99umLUai5wbSkI3SguYhIW/g68DBvvmvAQJBANj2nnUMHvUEfYA/Y/xaoDts8lZjdJDK7RT2kLyiMsA/CK1wZmRRC+Zp1UB7Dy54Ecr8Vg5ntvpAVzOIAH4k9KECQQDDPIdfqRXaXuhxHCpdSCcBrScdvA1/KibUMnC0wAp+Vp8URPWBmMzP/EGze8Kj/YkVLsH69bb41Eu2Yip8ulbvAkBKXxdoJfSCprxidthOS757QFg9tq/hZj4onnB0yOC+t5zA3zOqFYIPxJ1+EfDdS/lFbIQPQgwd8mox1t/cXcyhAkEAwfz8jaJWIlo3H1xbA8DTcSj5OuRFjNr3JdTQg+hlBM9Q1TUHs7N9nhMJvSr1ZThf4vpIp/FJ0sguSpQTn0cPZQJBAMKIjvl4EoKGaDsLCZGI7DGfy7DTP7Sf2M/0cqhCltcMovQBkk85gG42sT1FH9Sf8BMWiMAvR4H1+EQgqPdnooU=";
        String publicKey= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCldyc7bAxGoGJwCxz+aR+Wbq4aUoG8jJWkXAIdTI3DGgNJVRc8Xeyk6TntzY5nExCXkiV7fnqsfFC1mltDq1eY8Dn3slO9+mxFKbj/dHkby9wybEQWfCArERXqOWLlaslm6uuMUugZJlqzY1Dcb4xLHD9fGGnBIFGzbXSX56h4TwIDAQAB";
        System.err.println("公钥加密——私钥解密");
        String source = "这是一行没有任何意义的文字，你看完了等于没看，不是吗？";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        System.out.println("加密后文字：\r\n" + new String(encodedData));
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }

    static void testSign() throws Exception {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKV3JztsDEagYnALHP5pH5ZurhpSgbyMlaRcAh1MjcMaA0lVFzxd7KTpOe3NjmcTEJeSJXt+eqx8ULWaW0OrV5jwOfeyU736bEUpuP90eRvL3DJsRBZ8ICsRFeo5YuVqyWbq64xS6BkmWrNjUNxvjEscP18YacEgUbNtdJfnqHhPAgMBAAECgYBnoFv9pwl5IfEEYrFh08xoliCLc6i0wQbmzIi2eL8/tQbh4lyO/fO6xCX3fIj2nMYDZw/6a5fAdorFcUo+8wwERiePP9CN71m7Er3SnBAnHNEKej3Ohn/mHKcOklN2/1fZHKJHabtB99umLUai5wbSkI3SguYhIW/g68DBvvmvAQJBANj2nnUMHvUEfYA/Y/xaoDts8lZjdJDK7RT2kLyiMsA/CK1wZmRRC+Zp1UB7Dy54Ecr8Vg5ntvpAVzOIAH4k9KECQQDDPIdfqRXaXuhxHCpdSCcBrScdvA1/KibUMnC0wAp+Vp8URPWBmMzP/EGze8Kj/YkVLsH69bb41Eu2Yip8ulbvAkBKXxdoJfSCprxidthOS757QFg9tq/hZj4onnB0yOC+t5zA3zOqFYIPxJ1+EfDdS/lFbIQPQgwd8mox1t/cXcyhAkEAwfz8jaJWIlo3H1xbA8DTcSj5OuRFjNr3JdTQg+hlBM9Q1TUHs7N9nhMJvSr1ZThf4vpIp/FJ0sguSpQTn0cPZQJBAMKIjvl4EoKGaDsLCZGI7DGfy7DTP7Sf2M/0cqhCltcMovQBkk85gG42sT1FH9Sf8BMWiMAvR4H1+EQgqPdnooU=";
        String publicKey= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCldyc7bAxGoGJwCxz+aR+Wbq4aUoG8jJWkXAIdTI3DGgNJVRc8Xeyk6TntzY5nExCXkiV7fnqsfFC1mltDq1eY8Dn3slO9+mxFKbj/dHkby9wybEQWfCArERXqOWLlaslm6uuMUugZJlqzY1Dcb4xLHD9fGGnBIFGzbXSX56h4TwIDAQAB";
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }
    
}
