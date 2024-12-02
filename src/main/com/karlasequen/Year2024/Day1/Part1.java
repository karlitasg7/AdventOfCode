package com.karlasequen.Year2024.Day1;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Part1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day1/sample.txt";
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

        listRight.sort(Integer::compareTo);
        listLeft.sort(Integer::compareTo);

        int totalSum = 0;

        for (int i = 0; i < listLeft.size(); i++) {
            totalSum += Math.abs(listLeft.get(i) - listRight.get(i));
        }

        System.out.println("total is " + totalSum);

    }

}
