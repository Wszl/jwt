package org.xdove.jwt.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Base64;

public class AlgorithmUtils {

    public static String parseJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static byte[] parseBase64Url(byte[] data) {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        return encoder.encode(data);
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
