package com.muguang.ebusiness.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author muguang
 * @date 2017/3/6 14:21.
 */
public class SignatureUtil {
    
    
    public static String md5(String password){
        if (StringUtils.isBlank(password)){
            throw new RuntimeException("the password should be not null");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("System Error!");
        }
    }
}
