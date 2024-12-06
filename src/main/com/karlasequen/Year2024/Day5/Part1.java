package com.karlasequen.Year2024.Day5;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Part1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day5/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day5/input.txt";

    private static final Map<Integer, List<Integer>> mapRules = new HashMap<>();

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        List<String> listOfUpdates = new ArrayList<>();

        for (String line : input) {
            if (!Objects.equals(line, "")) {

                if (line.contains("|")) {
                    String[] split   = line.split("\\|");
                    int      numberX = Integer.parseInt(split[0]);
                    int      numberY = Integer.parseInt(split[1]);

                    if (mapRules.containsKey(numberY)) {
                        mapRules.get(numberY).add(numberX);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(numberX);
                        mapRules.put(numberY, list);
                    }
                } else {
                    listOfUpdates.add(line);
                }
            }
        }

        List<String> correctLines   = new ArrayList<>();
        List<String> incorrectLines = new ArrayList<>();

        for (String line : listOfUpdates) {
            if (isLineValid(line)) {
                correctLines.add(line);
            } else {
                incorrectLines.add(line);
            }
        }

        System.out.println("Total = " + getTotal(correctLines));

        // ***** part 2
        List<String> fixedIncorrectLines = new ArrayList<>();
        for (String line : incorrectLines) {
            fixedIncorrectLines.add(getFixedLine(line));
        }

        System.out.println("Total part 2 = " + getTotal(fixedIncorrectLines));

    }

    private static boolean isLineValid(String line) {
        String[] parts = line.split(",");

        for (int i = parts.length - 1; i > 0; i--) {
            int number = Integer.parseInt(parts[i]);

            for (int j = 0; j < i; j++) {
                int numberToCheck = Integer.parseInt(parts[j]);
                if (!mapRules.containsKey(number) || !mapRules.get(number).contains(numberToCheck)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getTotal(List<String> lines) {
        int total = 0;
        for (String line : lines) {
            String[] parts = line.split(",");

            int middlePosition = parts.length / 2;

            total += Integer.parseInt(parts[middlePosition]);
        }

        return total;
    }

    private static String getFixedLine(String line) {
        String[] parts = line.split(",");

        int position = parts.length - 1;
        int number   = Integer.parseInt(parts[position]);

        int positionToCheck = position - 1;

        while (position > 0) {
            int numberToCheck = Integer.parseInt(parts[positionToCheck]);

            if (!mapRules.containsKey(number) || !mapRules.get(number).contains(numberToCheck)) {
                parts[position]        = parts[positionToCheck];
                parts[positionToCheck] = String.valueOf(number);

                number          = Integer.parseInt(parts[position]);
                positionToCheck = position - 1;
            } else {
                if (positionToCheck == 0) {
                    position--;
                    positionToCheck = position - 1;
                    number          = Integer.parseInt(parts[position]);
                } else {
                    positionToCheck--;
                }
            }
        }

        return String.join(",", parts);
    }

}
