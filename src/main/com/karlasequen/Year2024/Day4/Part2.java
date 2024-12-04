package com.karlasequen.Year2024.Day4;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;

public class Part2 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day4/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        String[][] words = new String[input.size()][];
        int        row   = 0;

        for (String line : input) {
            if (!Objects.equals(line, "")) {

                words[row] = line.split("");
                row++;

                System.out.println(line);
            }
        }

        int total = 0;
        for (int i = 0; i < words.length - 2; i++) {
            for (int j = 0; j < words[i].length - 2; j++) {
                String[][] sliceOfWord = new String[3][3];
                sliceOfWord[0][0] = words[i][j];
                sliceOfWord[0][1] = words[i][j + 1];
                sliceOfWord[0][2] = words[i][j + 2];

                sliceOfWord[1][0] = words[i + 1][j];
                sliceOfWord[1][1] = words[i + 1][j + 1];
                sliceOfWord[1][2] = words[i + 1][j + 2];

                sliceOfWord[2][0] = words[i + 2][j];
                sliceOfWord[2][1] = words[i + 2][j + 1];
                sliceOfWord[2][2] = words[i + 2][j + 2];

                if (isValid(sliceOfWord)) {
                    total++;
                }

            }
        }

        System.out.println("Total = " + total);

    }

    private static boolean isValid(String[][] words) {

        String part1 = words[0][0] + words[1][1] + words[2][2];
        String part2 = words[0][2] + words[1][1] + words[2][0];

        return (part1.equals("MAS") || part1.equals("SAM")) && (part2.equals("MAS") || part2.equals("SAM"));
    }

}
