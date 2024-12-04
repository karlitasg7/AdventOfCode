package com.karlasequen.Year2024.Day4;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2024 + "Day4/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        String[][] words = new String[input.size()][];
        int        row   = 0;

        int totalInRows         = 0;
        int totalInColumns      = 0;
        int totalDiagonalsRight = 0;
        int totalDiagonalsLeft  = 0;

        for (String line : input) {
            if (!Objects.equals(line, "")) {

                words[row] = line.split("");
                row++;

                int totalXLine = getTotalByLine(line);
                System.out.println("Row = " + line + " (" + totalXLine + ")");

                totalInRows += totalXLine;
            }
        }

        // process columns
        System.out.println("********** COLUMNS **********");
        for (int i = 0; i < words[0].length; i++) {
            String line       = getColumn(words, i);
            int    totalXLine = getTotalByLine(line);

            System.out.println("Col = " + line + " (" + totalXLine + ")");

            totalInColumns += totalXLine;
        }

        // process diagonal right
        System.out.println("********** DIAGONAL RIGHT **********");
        for (int i = 0; i < words.length; i++) {
            String line       = getDiagonalRight(words, i, 0);
            int    totalXLine = getTotalByLine(line);

            System.out.println("diagonal R = " + line + " (" + totalXLine + ")");

            totalDiagonalsRight += totalXLine;

        }

        for (int j = 1; j < words[0].length; j++) {
            String line       = getDiagonalRight(words, 0, j);
            int    totalXLine = getTotalByLine(line);

            System.out.println("diagonal R = " + line + " (" + totalXLine + ")");

            totalDiagonalsRight += totalXLine;
        }

        // process diagonal left
        System.out.println("********** DIAGONAL LEFT **********");
        for (int i = 0; i < words.length; i++) {
            String line       = getDiagonalLeft(words, i, words.length - 1);
            int    totalXLine = getTotalByLine(line);

            System.out.println("diagonal L = " + line + " (" + totalXLine + ")");

            totalDiagonalsLeft += totalXLine;

        }

        for (int j = words[0].length - 2; j > -1; j--) {
            String line       = getDiagonalLeft(words, 0, j);
            int    totalXLine = getTotalByLine(line);

            System.out.println("diagonal L = " + line + " (" + totalXLine + ")");

            totalDiagonalsLeft += totalXLine;
        }

        System.out.println("Total = " + (totalInRows + totalInColumns + totalDiagonalsRight + totalDiagonalsLeft));

    }

    private static int getTotalByLine(String line) {
        String regex = "XMAS";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        int total = 0;

        while (matcher.find()) {
            total++;
        }

        regex   = "SAMX";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(line);
        while (matcher.find()) {
            total++;
        }

        return total;
    }

    private static String getColumn(String[][] words, int col) {
        StringBuilder result = new StringBuilder();

        for (String[] word : words) {
            result.append(word[col]);
        }

        return result.toString();
    }

    private static String getDiagonalRight(String[][] words, int row, int col) {
        StringBuilder result = new StringBuilder();

        int newCol = col;
        for (int i = row; i < words.length; i++) {
            if (newCol < words[i].length) {
                result.append(words[i][newCol]);
                newCol++;
            }
        }

        return result.toString();
    }

    private static String getDiagonalLeft(String[][] words, int row, int col) {
        StringBuilder result = new StringBuilder();

        int newCol = col;
        for (int i = row; i < words.length; i++) {
            if (newCol >= 0 && newCol < words[i].length) {
                result.append(words[i][newCol]);
                newCol--;
            }
        }

        return result.toString();
    }

}
