package com.karlasequen.Year2016.Day7;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day7 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day7/sample.txt";
    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day7/sample2.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day7/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        List<String> ipAddresses = new ArrayList<>();
        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }
            ipAddresses.add(line);

        }

        List<String> tlsSupportingIPs = new ArrayList<>();
        List<String> sslSupportingIPs = new ArrayList<>();
        for (String ip : ipAddresses) {
            if (supportsTLS(ip)) {
                tlsSupportingIPs.add(ip);
            }

            if (supportsSSL(ip)) {
                sslSupportingIPs.add(ip);
            }
        }

        System.out.println("Part 1. " + tlsSupportingIPs.size());
        System.out.println("Part 2. " + sslSupportingIPs.size());

    }

    private static boolean isABBA(String s) {
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                s.substring(i, i + 2).equals(new StringBuilder(s.substring(i + 2, i + 4)).reverse().toString())
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isABA(String text) {

        if (text.length() < 3) {
            return false;
        }

        String[] splitText = text.split("");

        return !Objects.equals(splitText[0], splitText[1]) &&
            Objects.equals(splitText[0], splitText[2]);
    }

    private static boolean supportsTLS(String ip) {
        String[]     parts        = ip.split("\\[");
        String       firstPart    = parts[0];
        List<String> hypernetList = new ArrayList<>();
        List<String> lastPart     = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            hypernetList.add(parts[i].split("]")[0]);
            lastPart.add(parts[i].split("]")[1]);
        }

        for (String hypernet : hypernetList) {
            if (isABBA(hypernet)) {
                return false;
            }
        }

        for (int i = 0; i < firstPart.length() - 3; i++) {
            if (isABBA(firstPart.substring(i, i + 4))) {
                return true;
            }
        }

        for (String p : lastPart) {
            for (int i = 0; i < p.length() - 3; i++) {
                if (isABBA(p.substring(i, i + 4))) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean supportsSSL(String ip) {
        String[]     parts        = ip.split("\\[");
        String       firstPart    = parts[0];
        List<String> hypernetList = new ArrayList<>();
        List<String> lastPart     = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            hypernetList.add(parts[i].split("]")[0]);
            lastPart.add(parts[i].split("]")[1]);
        }

        for (int i = 0; i < firstPart.length() - 2; i++) {
            String text = firstPart.substring(i, i + 3);
            if (isABA(text) && hasBAB(hypernetList, text)) {
                return true;
            }
        }

        for (String p : lastPart) {
            for (int i = 0; i < p.length() - 2; i++) {
                String text = p.substring(i, i + 3);
                if (isABA(text) && hasBAB(hypernetList, text)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasBAB(List<String> hypernetList, String abaText) {

        String[] splitText   = abaText.split("");
        String   babToSearch = splitText[1] + splitText[0] + splitText[1];

        for (String p : hypernetList) {

            for (int i = 0; i < p.length() - 2; i++) {
                String text = p.substring(i, i + 3);
                if (text.equals(babToSearch)) {
                    return true;
                }
            }

        }

        return false;
    }

}
