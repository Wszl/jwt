package org.xdove.jwt.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

    public static String parseJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static <T> T parseObject(String str, Class<T> clazz) {
        return JSONObject.parseObject(str, clazz);
    }
}
