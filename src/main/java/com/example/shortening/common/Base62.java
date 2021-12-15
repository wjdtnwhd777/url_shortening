package com.example.shortening.common;

import org.springframework.stereotype.Component;

@Component
public class Base62 {

    static final char[] CODEC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    static final int SALT = 920115;


    public static String encoding(int orgValue) {
        final StringBuilder sb = new StringBuilder();
        orgValue = orgValue + SALT;
        while (orgValue > 0) {
            int i = orgValue % 62;
            sb.append(CODEC[i]);
            orgValue /= 62;
        };
        return sb.toString();
    }

    public static Long decoding(String hashValue) {
        Long result = 0L;
        int power = 1;
        for (int i=0; i<hashValue.length(); i++) {
            int digit = new String(CODEC).indexOf(hashValue.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result - SALT;
    }
}
