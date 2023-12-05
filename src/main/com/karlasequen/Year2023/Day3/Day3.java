package com.karlasequen.Year2023.Day3;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;
import com.karlasequen.shared.ListToCharArray;

import java.util.List;

public class Day3 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day3/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day3/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        char[][] inputChar = ListToCharArray.convertListToCharArray(input);

        boolean keepNumber = false;
        String  number     = "";
        int     sum        = 0;
        for (int i = 1; i < inputChar.length - 1; i++) {
            for (int j = 1; j < inputChar[i].length - 1; j++) {
                if (inputChar[i][j] >= '0' && inputChar[i][j] <= '9') {
                    number += inputChar[i][j];
                    if (checkAdjustments(inputChar, i, j)) {
                        keepNumber = true;
                    }
                } else {
                    if (keepNumber && !number.isEmpty()) {
                        sum += Integer.parseInt(number);
                    }

                    keepNumber = false;
                    number = "";
                }

            }

            if (keepNumber && !number.isEmpty()) {
                sum += Integer.parseInt(number);
            }

            keepNumber = false;
        }

        System.out.println("First Part = " + sum);

        sum = 0;
        for (int i = 1; i < inputChar.length - 1; i++) {
            for (int j = 1; j < inputChar[i].length - 1; j++) {
                if (inputChar[i][j] == '*') {
                    sum += part2(inputChar, i, j);
                }
            }
        }
        System.out.println("Second Part = " + sum);
    }

    private static boolean checkAdjustments(char[][] input, int i, int j) {
        return input[i + 1][j] != '.' ||
            input[i - 1][j] != '.' ||
            input[i + 1][j + 1] != '.' ||
            input[i + 1][j - 1] != '.' ||
            input[i - 1][j + 1] != '.' ||
            input[i - 1][j - 1] != '.' ||
            !isDigitOrDot(input[i][j + 1]) ||
            !isDigitOrDot(input[i][j - 1]);
    }

    private static boolean isDigitOrDot(char c) {
        return isDigit(c) || c == '.';
    }

    private static int part2(char[][] input, int i, int j) {
        int power = 1;
        int count = 0;

        if (isDigit(input[i - 1][j])) {
            count++;
            power *= Integer.parseInt(getMiddleNumber(input, i - 1, j, input[i - 1][j] + ""));
        } else {
            if (isDigit(input[i - 1][j - 1])) {
                count++;
                power *= Integer.parseInt(getLeftNumber(input, i - 1, j - 1, input[i - 1][j - 1] + ""));
            }
            if (isDigit(input[i - 1][j + 1])) {
                count++;
                power *= Integer.parseInt(getRightNumber(input, i - 1, j + 1, input[i - 1][j + 1] + ""));
            }
        }

        if (isDigit(input[i + 1][j])) {
            count++;
            power *= Integer.parseInt(getMiddleNumber(input, i + 1, j, input[i + 1][j] + ""));
        } else {
            if (isDigit(input[i + 1][j - 1])) {
                count++;
                power *= Integer.parseInt(getLeftNumber(input, i + 1, j - 1, input[i + 1][j - 1] + ""));
            }
            if (isDigit(input[i + 1][j + 1])) {
                count++;
                power *= Integer.parseInt(getRightNumber(input, i + 1, j + 1, input[i + 1][j + 1] + ""));
            }
        }
        if (isDigit(input[i][j - 1])) {
            count++;
            power *= Integer.parseInt(getLeftNumber(input, i, j - 1, input[i][j - 1] + ""));
        }
        if (isDigit(input[i][j + 1])) {
            count++;
            power *= Integer.parseInt(getRightNumber(input, i, j + 1, input[i][j + 1] + ""));
        }


        if (count != 2) {
            return 0;
        }
        return power;
    }

    private static String getMiddleNumber(char[][] input, int i, int j, String number) {
        if (!isDigit(input[i][j - 1]) && !isDigit(input[i][j + 1])) {
            return number;
        }
        if (isDigit(input[i][j - 1]) && isDigit(input[i][j + 1])) {

            return getLeftNumber(input, i, j - 1, input[i][j - 1] + "") + number +
                getRightNumber(input, i, j + 1, input[i][j + 1] + "");
        }
        if (isDigit(input[i][j - 1])) {
            return getLeftNumber(input, i, j - 1, input[i][j - 1] + number);
        }
        if (isDigit(input[i][j + 1])) {
            return getRightNumber(input, i, j + 1, number + input[i][j + 1]);
        }
        return number;
    }

    private static String getLeftNumber(char[][] input, int i, int j, String number) {
        if (!isDigit(input[i][j - 1])) {
            return number;
        }
        return getLeftNumber(input, i, j - 1, input[i][j - 1] + number);
    }

    private static String getRightNumber(char[][] input, int i, int j, String number) {
        if (!isDigit(input[i][j + 1])) {
            return number;
        }
        return getRightNumber(input, i, j + 1, number + input[i][j + 1]);
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
