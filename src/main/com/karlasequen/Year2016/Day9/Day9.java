package com.karlasequen.Year2016.Day9;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;

public class Day9 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day9/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day9/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            System.out.println(line);
            System.out.println("Part 1. " + processLine(line));
            System.out.println("Part 2. " + part2(line));
        }
    }

    private static int processLine(String line) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                int    indexOfX          = line.indexOf('x', i);
                int    indexClosingParen = line.indexOf(')', i);
                int    lenCharRepeat     = Integer.parseInt(line.substring(i + 1, indexOfX));
                int    amountRepetition  = Integer.parseInt(line.substring(indexOfX + 1, indexClosingParen));
                String textToRepeat      = line.substring(indexClosingParen + 1, indexClosingParen + lenCharRepeat + 1);

                sb.append(repeatStr(textToRepeat, amountRepetition));

                i += lenCharRepeat + (indexClosingParen - i);
            } else {
                sb.append(line.charAt(i));
            }
        }

        return sb.length();
    }

    private static String repeatStr(String str, int amount) {
        return str.repeat(amount);
    }

    private static long part2(String line) {
        return expand(line, 1);
    }

    private static long expand(String input, int multiplyBy) {
        if (!input.contains("(") && !input.contains(")")) {
            return multiplyBy * input.length();
        }

        long counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                int indexOfX          = input.indexOf('x', i);
                int indexClosingParen = input.indexOf(')', i);
                int lenCharRepeat     = Integer.parseInt(input.substring(i + 1, indexOfX));
                int amountRepetition  = Integer.parseInt(input.substring(indexOfX + 1, indexClosingParen));

                counter += expand(input.substring(indexClosingParen + 1, lenCharRepeat + indexClosingParen + 1),
                    amountRepetition * multiplyBy);

                i += lenCharRepeat + (indexClosingParen - i);
            } else {
                counter++;
            }

        }

        return counter;

    }

}
