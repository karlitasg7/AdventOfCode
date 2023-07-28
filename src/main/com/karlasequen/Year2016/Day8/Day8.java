package com.karlasequen.Year2016.Day8;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day8/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day8/input.txt";

    private static final Pattern     regex     = Pattern.compile("rotate ([A-Za-z]+) ([a-z])=([\\d-]+) by ([\\d-]+)");
    private static final Integer[][] matrixLed = new Integer[6][50];

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            // print();
            if (line.startsWith("rect")) {
                processLineRect(line);
            } else {
                processLineRotate(line);
            }

        }

        calculate();

        System.out.println("Part 2. ");
        print();

    }

    private static void processLineRect(String line) {
        String[] splitNumbers = line.substring(5).split("x");
        int      number1      = Integer.parseInt(splitNumbers[0]);
        int      number2      = Integer.parseInt(splitNumbers[1]);

        for (int row = 0; row < number2; row++) {
            for (int col = 0; col < number1; col++) {
                matrixLed[row][col] = 1;
            }
        }
    }

    private static void processLineRotate(String line) {
        Matcher matcher = regex.matcher(line);

        if (matcher.find()) {
            String type                = matcher.group(1);
            int    initialPosition     = Integer.parseInt(matcher.group(3));
            int    quantityPixelToMove = Integer.parseInt(matcher.group(4));

            processLineRotateRow(type, initialPosition, quantityPixelToMove);
            processLineRotateColumn(type, initialPosition, quantityPixelToMove);

        }

    }

    private static void processLineRotateColumn(String type, int initialPosition, int quantityPixelToMove) {
        if (!type.equals("column")) {
            return;
        }

        Integer[] currentValues = new Integer[6];

        for (int row = 0; row < 6; row++) {
            currentValues[row] = matrixLed[row][initialPosition];
        }

        int newPos = quantityPixelToMove;
        for (int i = 0; i < 6; i++) {
            matrixLed[newPos][initialPosition] = currentValues[i];

            if (newPos == 5) {
                newPos = -1;
            }

            newPos++;

        }

    }

    private static void processLineRotateRow(String type, int initialPosition, int quantityPixelToMove) {
        if (!type.equals("row")) {
            return;
        }

        Integer[] currentValues = new Integer[50];

        for (int col = 0; col < 50; col++) {
            currentValues[col] = matrixLed[initialPosition][col];
        }

        int newPos = quantityPixelToMove;
        for (int col = 0; col < 50; col++) {
            matrixLed[initialPosition][newPos] = currentValues[col];

            if (newPos == 49) {
                newPos = -1;
            }

            newPos++;

        }

    }

    private static void calculate() {
        int total = 0;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 50; col++) {
                if (matrixLed[row][col] != null) {
                    total += 1;
                }
            }
        }

        System.out.println("Part 1. " + total);
    }

    private static void print() {
        System.out.println("---------- >>>>> ");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 50; col++) {
                if (matrixLed[row][col] != null) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
