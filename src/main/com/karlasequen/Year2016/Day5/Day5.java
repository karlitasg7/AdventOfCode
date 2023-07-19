package com.karlasequen.Year2016.Day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day5 {

    //    private static final String doorId = "abc";
    private static final String doorId = "cxdnnyjw";

    public static void main(String[] args) {

        int index = 0;
        String pass = "";

        while (pass.length() != 8) {
            String newDoorId = doorId + index;

            String hash = generateMD5(newDoorId);

            if (hash.startsWith("00000")) {
                pass += hash.substring(5, 6);
            }

            index++;
        }

        System.out.println("Part 1. " + pass);

        // part 2
        index = 0;
        String[] passArr = new String[8];
        pass = Arrays.stream(passArr)
            .filter(Objects::nonNull)
            .collect(Collectors.joining());

        while (pass.length() != 8) {
            String newDoorId = doorId + index;

            String hash = generateMD5(newDoorId);

            if (hash.startsWith("00000")) {
                String letter = hash.substring(6, 7);

                int position = -1;
                try {
                    position = Integer.parseInt(hash.substring(5, 6));
                } catch (NumberFormatException e) {

                }

                if (position > -1 && position < 8 && passArr[position] == null) {
                    passArr[position] = letter;
                }

            }

            pass = Arrays.stream(passArr)
                .filter(Objects::nonNull)
                .collect(Collectors.joining());

            index++;
        }

        System.out.println("Part 2. " + pass);

    }

    public static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] byteData = input.getBytes();
            md.update(byteData);
            byte[] mdBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte mdByte : mdBytes) {
                sb.append(Integer.toString((mdByte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

}
