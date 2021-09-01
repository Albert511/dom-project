package com.dom.commonutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 密码工具类
 * @author: Dom Frank
 * @create: 2021/09/01 10:52
 */
public class PasswordUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(PasswordUtil.class);

    public static final String PWD_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz23456789!@%+_";

    public static final String PWD_STR1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String PWD_STR2 = "abcdefghijklmnopqrstuvwxyz";

    public static final String PWD_STR3 = "23456789";

    public static final String PWD_STR4 = "!@%+_";

    public static final char[] PWD_STR_CHARS = PWD_STR.toCharArray();

    public static final char[] PWD_STR_CHARS1 = PWD_STR1.toCharArray();

    public static final char[] PWD_STR_CHARS2 = PWD_STR2.toCharArray();

    public static final char[] PWD_STR_CHARS3 = PWD_STR3.toCharArray();

    public static final char[] PWD_STR_CHARS4 = PWD_STR4.toCharArray();

    public static String createSecurePassword() {
        try {
            List<Character> charList = new ArrayList<Character>();
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            final int pwdLength = 6;
            final int totalPwdLength = 10;
            byte[] keyBytes = new byte[pwdLength];
            sr.nextBytes(keyBytes);
            final int j = 0xFF;//255
            charList.add(PWD_STR_CHARS3[sr.nextInt(PWD_STR_CHARS3.length)]);
            for (int i = 0; i < keyBytes.length; i++) {
                charList.add(PWD_STR_CHARS[(keyBytes[i] & j) % PWD_STR_CHARS.length]);
            }
            charList.add(PWD_STR_CHARS2[sr.nextInt(PWD_STR_CHARS2.length)]);
            charList.add(PWD_STR_CHARS4[sr.nextInt(PWD_STR_CHARS4.length)]);
            charList.add(PWD_STR_CHARS1[sr.nextInt(PWD_STR_CHARS1.length)]);

            char[] newPdArr = new char[totalPwdLength];
            for (int i = 0; i < totalPwdLength; i++) {
                newPdArr[i] = charList.remove(sr.nextInt(charList.size()));
            }
            return String.valueOf(newPdArr);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Get key chars failed.{}", e.getMessage());
        }
        return null;
    }
}
