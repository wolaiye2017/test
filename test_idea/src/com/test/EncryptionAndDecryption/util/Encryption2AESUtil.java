package com.test.EncryptionAndDecryption.util;/**
 * @PACKAGE com.test.EncryptionAndDecryption.util
 * @Author Administrator
 * @Date created in 2018/6/8 09:19
 * @Description:
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.SecureRandom;
import java.util.Base64;


/**
 * 加密
 *
 * @author Administrator
 * @create 2018-06-08 9:19
 **/
public class Encryption2AESUtil {

    private static final String ALGORITHM = "AES";

    private static final String PASSWORD="CHENGGUAN";

    private static final String CHARSET="UTF-8";

    /**
     * 生成密钥
     * @return
     * @throws Exception
     */
    public static String getKey()throws Exception{
        SecretKey secretKey = geneKey();
        byte[] encodeds = secretKey.getEncoded();
        String key = Encryption2AESUtil.byteToHexString(encodeds);
        return key;
    }

    private static SecretKey geneKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = new SecureRandom();
        random.setSeed(PASSWORD.getBytes(CHARSET));//设置加密用的种子，密钥
        keyGenerator.init(random);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }

    /**
     * AES 加密
     * @param content
     * @return
     * @throws Exception
     */
    public static String Encrypt(String content) throws Exception{
        //1、指定算法、获取Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHM);//算法是AES
        //2、生成/读取用于加解密的密钥
        SecretKey secretKey = geneKey();
        //3、用指定的密钥初始化Cipher对象，指定是加密模式，还是解密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //4、更新需要加密的内容
        cipher.update(content.getBytes(CHARSET));
        //5、进行最终的加解密操作
        byte[] result = cipher.doFinal();//加密后的字节数组
        String res = Base64.getEncoder().encodeToString(result);
//        String res = byteToHexString(result);
        return res;
    }

    /**
     * AES 解密
     * @param content
     * @return
     * @throws Exception
     */
    public static String Decrpyt(String content) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = geneKey();
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encodedBytes = Base64.getDecoder().decode(content.getBytes());
        byte[] result = cipher.doFinal(encodedBytes);//对加密后的字节数组进行解密
        return new String(result,CHARSET);
    }

    /**
     *   * byte数组转化为16进制字符串
     *   * @param bytes
     *   * @return
     *   
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex = Integer.toHexString(bytes[i]);
            if (strHex.length() > 3) {
                sb.append(strHex.substring(6));
            } else {
                if (strHex.length() < 2) {
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return sb.toString();
    }
}
