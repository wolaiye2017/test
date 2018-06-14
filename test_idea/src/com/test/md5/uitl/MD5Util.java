/**
 *
 */
package com.test.md5.uitl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private final static String encode = "UTF-8";

    /**
     * MD5转换
     *
     * @param plainText
     * @return MD5字符串
     */
    public static String getMD5(String plainText) throws UnsupportedEncodingException {

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException("MD5 error:", e);
        }
        messageDigest.update(plainText.getBytes(encode));
        byte by[] = messageDigest.digest();

        StringBuffer buf = new StringBuffer();
        int val;
        for (int i = 0; i < by.length; i++) {
            val = by[i];
            if (val < 0) {
                val += 256;
            } else if (val < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(val));
        }
        return buf.toString().toUpperCase();
    }

}
