package com.example.andreoliveira.biblio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding {

    public static String encoding(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes(),0,password.length());
        return new BigInteger(1,messageDigest.digest()).toString(16);
    }

}
