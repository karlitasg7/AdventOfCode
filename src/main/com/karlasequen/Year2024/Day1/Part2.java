package com.karlasequen.Year2024.Day1;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Part2 {

    //        private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day1/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day1/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        List<Integer> listRight = new ArrayList<>();
        List<Integer> listLeft  = new ArrayList<>();

        for (String line : input) {
            if (!Objects.equals(line, "")) {

                String[] parts = line.trim().split(" ");

                listLeft.add(Integer.parseInt(parts[0]));
                listRight.add(Integer.parseInt(parts[parts.length - 1]));
            }
        }

        int totalSum = 0;

        for (Integer numberLeft : listLeft) {
            long countOnRight = listRight.stream().filter(n -> Objects.equals(n, numberLeft)).count();
            totalSum += numberLeft * (int) countOnRight;
        }

        System.out.println("total is " + totalSum);

    }

}
