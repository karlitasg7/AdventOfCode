package com.karlasequen.Year2024.Day2;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;

public class Part2 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day2/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int countSafe = 0;
        for (String line : input) {
            if (!Objects.equals(line, "")) {

                int isSafe  = isLineSafe(line, -1);
                int isSafe2 = -1;

                if (isSafe == -1) {
                    countSafe++;
                } else {
                    String[] parts = line.split(" ");
                    for (int i = 0; i < parts.length; i++) {
                        isSafe2 = isLineSafe(line, i);
                        if (isSafe2 == -1) {
                            countSafe++;
                            break;
                        }

                    }
                }

                System.out.println(line + " is Safe. " + isSafe + " . " + isSafe2);
            }
        }

        System.out.println("Total safe =  " + countSafe);

    }

    private static int isLineSafe(String line, int partToExclude) {

        String[] parts = line.split(" ");

        int previous = Integer.parseInt(parts[0]);
        int second   = Integer.parseInt(parts[1]);
        int initOn   = 1;

        if (partToExclude == 0) {
            previous = Integer.parseInt(parts[1]);
            second   = Integer.parseInt(parts[2]);
            initOn   = 2;
        }

        if (partToExclude == 1) {
            second = Integer.parseInt(parts[2]);
        }

        boolean isIncreasing = !(previous > second);

        for (int i = initOn; i < parts.length; i++) {

            if (partToExclude == i) {
                continue;
            }

            int current = Integer.parseInt(parts[i]);
            if (isIncreasing) {
                if (current < previous) {
                    return i;
                }
            } else {
                if (current > previous) {
                    return i;
                }
            }

            int difference = Math.abs(previous - current);

            if (difference > 3) {
                return i;
            }

            if (previous == current) return i;

            previous = current;

        }


        return -1;
    }

}
