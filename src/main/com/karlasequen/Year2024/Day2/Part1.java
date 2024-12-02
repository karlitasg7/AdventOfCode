package com.karlasequen.Year2024.Day2;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;

public class Part1 {

    //        private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day2/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int countSafe = 0;
        for (String line : input) {
            if (!Objects.equals(line, "")) {

                boolean isSafe = isLineSafe(line);

                System.out.println(line + " is Safe = " + isSafe);

                if (isSafe) {
                    countSafe++;
                }
            }
        }

        System.out.println("Total safe =  " + countSafe);

    }

    private static boolean isLineSafe(String line) {

        String[] parts = line.split(" ");

        int     previous     = Integer.parseInt(parts[0]);
        int     second       = Integer.parseInt(parts[1]);
        boolean isIncreasing = !(previous > second);

        for (int i = 1; i < parts.length; i++) {

            int current = Integer.parseInt(parts[i]);
            if (isIncreasing) {
                if (current < previous) {
                    return false;
                }
            } else {
                if (current > previous) {
                    return false;
                }
            }

            int difference = Math.abs(previous - current);

            if (difference > 3) {
                return false;
            }

            if (previous == current) return false;

            previous = current;

        }


        return true;
    }

}
