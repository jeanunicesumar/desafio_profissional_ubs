package com.saude.agenda.api.helper;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.DoctorRepository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public static String generateHash(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, messageDigest.digest(password.getBytes()));
        return hash.toString(16);
    }

    public static Boolean verifyPassword(String password, String criptPassword) {
         String userPassword = generateHash(password);
         return userPassword.equals(criptPassword);
    }
}
