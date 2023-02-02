package com.karlasequen.Year2015.Day4;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;

public class Day4 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day4/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            System.out.println("===================");
            System.out.println(line);
            System.out.println("(Part 1). " + calculateMD5(line, "00000"));
            System.out.println("(Part 2). " + calculateMD5(line, "000000"));
        }

    }

    private static int calculateMD5(String secretKey, String startWith) {

        int i = 1;

        while (true) {
            String newSecretKey = secretKey + i;
            String hash         = getMD5(newSecretKey);

            if (hash.startsWith(startWith)) {
                System.out.println("Hash is = " + hash);
                return i;
            }
            i++;
        }

    }

    private static String getMD5(String secretKey) {
        try {
            java.security.MessageDigest md    = java.security.MessageDigest.getInstance("MD5");
            byte[]                      array = md.digest(secretKey.getBytes());
            StringBuffer                sb    = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return "";
    }

}
