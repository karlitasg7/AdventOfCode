package com.karlasequen.Year2022.day1;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day1/sample.txt";
//    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day1/input.txt";

    public static void main(String[] args) {

        List<Integer> listOfCaloriesByElf = new ArrayList<>();

        int totalCurrentElf = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if ("".equals(line)) {
                listOfCaloriesByElf.add(totalCurrentElf);
                totalCurrentElf = 0;
            } else {
                totalCurrentElf += Integer.parseInt(line);
            }
        }

        if (totalCurrentElf > 0) {
            listOfCaloriesByElf.add(totalCurrentElf);
        }

        listOfCaloriesByElf.sort(Collections.reverseOrder());
        System.out.println("(Part 1). The most calories are: " + listOfCaloriesByElf.get(0));

        // part 2
        int totalFirstThree = listOfCaloriesByElf.get(0) + listOfCaloriesByElf.get(1) + listOfCaloriesByElf.get(2);

        System.out.println("(Part 2). Sum of first three: " + totalFirstThree);

    }

}
