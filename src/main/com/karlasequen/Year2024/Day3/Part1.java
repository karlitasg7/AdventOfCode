package com.karlasequen.Year2024.Day3;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day3/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day3/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        long total = 0L;

        for (String line : input) {
            if (!Objects.equals(line, "")) {
                System.out.println(line);
                total += getMulPatterns(line);
            }
        }

        System.out.println("Total = " + total);
    }

    private static long getMulPatterns(String input) {
        String  regex   = "mul\\(\\d+,\\d+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        long total = 0L;

        while (matcher.find()) {
            String[] parts = matcher.group()
                .replace("mul(", "")
                .replace(")", "")
                .split(",");

            long n1 = Long.parseLong(parts[0]);
            long n2 = Long.parseLong(parts[1]);
            long m  = n1 * n2;

            total += m;
        }

        return total;
    }

}
