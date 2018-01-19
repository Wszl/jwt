package org.xdove.jwt.utils;

import java.util.Base64;

public class AlgorithmUtils {

    public static byte[] parseBase64Url(byte[] data) {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        return encoder.encode(data);
    }

    public static byte[] decodeBase64Url(byte[] data) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        return decoder.decode(data);
    }

    public static String decodeBase64Url(String data) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        return new String(decoder.decode(data));
    }

    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
}
