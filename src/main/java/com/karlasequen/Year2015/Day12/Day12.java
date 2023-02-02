package com.karlasequen.Year2015.Day12;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day12/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day12/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            int     total = 0;
            Pattern p     = Pattern.compile("-?\\d+");
            Matcher m     = p.matcher(line);
            while (m.find()) {
                total += Integer.parseInt(m.group());
            }

            System.out.println("(Part 1). " + total);
        }

    }

}
