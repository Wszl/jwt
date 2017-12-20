package org.xdove.jwt.utils.algorithm;

import org.junit.Test;
import org.xdove.jwt.utils.AlgorithmUtils;

import java.util.Base64;

import static org.junit.Assert.*;

public class CommonAlgorithmTest {

    public static final String HMS256 = "HmacSHA256";
    public static final String data = "233";
    public static final String key = "233";

    @Test
    public void signature() {
        CommonAlgorithm ca = new CommonAlgorithm();
        ca.setAlg(HMS256);


        byte[] result = ca.signature(data.getBytes(), key.getBytes());
        System.out.println(AlgorithmUtils.byte2hex(result));
    }
}