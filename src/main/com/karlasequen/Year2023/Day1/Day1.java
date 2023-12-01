package com.karlasequen.Year2023.Day1;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day1/sample.txt";
    //    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day1/sample2.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day1/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int totalSum = 0;

        for (String line : input) {
            if (!Objects.equals(line, "")) {

                char first = getFirstDigit(line);
                char last  = getLastDigit(line);

                String combined = (first + String.valueOf(last)).trim();

                if (!combined.isEmpty()) {
                    totalSum += Integer.parseInt((first + String.valueOf(last)));
                }

            }

        }

        System.out.println("First Part = " + totalSum);


        totalSum = 0;
        for (String line : input) {
            if (!Objects.equals(line, "")) {
                List<Integer> arrayOfDigits = new ArrayList<>();

                int index = 0;
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        arrayOfDigits.add(Integer.parseInt(String.valueOf(c)));
                    }

                    String temp = line.substring(index);

                    if (temp.startsWith("one")) {
                        arrayOfDigits.add(1);
                    } else if (temp.startsWith("two")) {
                        arrayOfDigits.add(2);
                    } else if (temp.startsWith("three")) {
                        arrayOfDigits.add(3);
                    } else if (temp.startsWith("four")) {
                        arrayOfDigits.add(4);
                    } else if (temp.startsWith("five")) {
                        arrayOfDigits.add(5);
                    } else if (temp.startsWith("six")) {
                        arrayOfDigits.add(6);
                    } else if (temp.startsWith("seven")) {
                        arrayOfDigits.add(7);
                    } else if (temp.startsWith("eight")) {
                        arrayOfDigits.add(8);
                    } else if (temp.startsWith("nine")) {
                        arrayOfDigits.add(9);
                    }

                    index++;
                }

                totalSum += Integer.parseInt((arrayOfDigits.get(0) + "" + arrayOfDigits.get(arrayOfDigits.size() - 1)));

            }

        }
        System.out.println("Second Part = " + totalSum);

    }

    private static char getFirstDigit(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }

        return ' ';
    }

    private static char getLastDigit(String text) {
        char lastDigit = ' ';

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                lastDigit = c;
            }
        }

        return lastDigit;
    }

}
