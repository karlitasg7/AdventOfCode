package com.karlasequen.Year2016.Day2;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;

public class Day2 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day2/input.txt";

    private static final int[][] matrixPart1 = new int[3][3];
    private static final String[][] matrixPart2 = new String[5][5];
    private static int row = 1;
    private static int col = 1;

    private static int rowPart2 = 2;
    private static int colPart2 = 0;

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);
        initMatrix();

        StringBuilder finalResultPart1 = new StringBuilder();
        StringBuilder finalResultPart2 = new StringBuilder();

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            finalResultPart1.append(processLinePart1(line));
            finalResultPart2.append(processLinePart2(line));

        }

        System.out.println("Part 1. " + finalResultPart1);
        System.out.println("Part 2. " + finalResultPart2);

    }

    private static void initMatrix() {

        matrixPart1[0][0] = 1;
        matrixPart1[0][1] = 2;
        matrixPart1[0][2] = 3;

        matrixPart1[1][0] = 4;
        matrixPart1[1][1] = 5;
        matrixPart1[1][2] = 6;

        matrixPart1[2][0] = 7;
        matrixPart1[2][1] = 8;
        matrixPart1[2][2] = 9;

        matrixPart2[0][2] = "1";
        matrixPart2[1][1] = "2";
        matrixPart2[1][2] = "3";
        matrixPart2[1][3] = "4";
        matrixPart2[2][0] = "5";
        matrixPart2[2][1] = "6";
        matrixPart2[2][2] = "7";
        matrixPart2[2][3] = "8";
        matrixPart2[2][4] = "9";
        matrixPart2[3][1] = "A";
        matrixPart2[3][2] = "B";
        matrixPart2[3][3] = "C";
        matrixPart2[4][2] = "D";

    }

    private static int processLinePart1(String line) {

        String[] splitLine = line.split("");

        for (String s : splitLine) {
            switch (s) {
                case "U" -> row = Math.max(0, (row - 1));
                case "L" -> col = Math.max(0, (col - 1));
                case "D" -> row = Math.min(2, (row + 1));
                case "R" -> col = Math.min(2, (col + 1));
            }
        }

        return matrixPart1[row][col];

    }

    private static String processLinePart2(String line) {

        String[] splitLine = line.split("");

        int lastRow = rowPart2;
        int lastCol = colPart2;

        for (String s : splitLine) {
            switch (s) {
                case "U" -> rowPart2 = Math.max(0, (rowPart2 - 1));
                case "D" -> rowPart2 = Math.min(4, (rowPart2 + 1));
                case "L" -> colPart2 = Math.max(0, (colPart2 - 1));
                case "R" -> colPart2 = Math.min(4, (colPart2 + 1));
            }

            if (matrixPart2[rowPart2][colPart2] == null) {
                rowPart2 = lastRow;
                colPart2 = lastCol;
            }
            lastRow = rowPart2;
            lastCol = colPart2;

        }

        return matrixPart2[rowPart2][colPart2];

    }

}
