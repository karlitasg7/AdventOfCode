package com.karlasequen.Year2015.Day18;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.Arrays;
import java.util.List;

public class Day18 {

//    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day18/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day18/input.txt";

    private static boolean isPart2 = true;

    public static void main(String[] args) {

        int sizeGrid = 6;
        if (FILE_NAME.contains("input")) {
            sizeGrid = 100;
        }

        Boolean[][] lightGrid = new Boolean[sizeGrid][sizeGrid];

        int row = 0;

        List<String> input = InputData.get(FILE_NAME);
        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            lightGrid[row] = Arrays.stream(line.split(""))
                    .map(x -> {
                        if (x.equals("#")) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .toList()
                    .toArray(Boolean[]::new);

            row++;
        }

        if (isPart2) {
            lightGrid[0][0]                                       = true;
            lightGrid[0][lightGrid.length - 1]                    = true;
            lightGrid[lightGrid.length - 1][0]                    = true;
            lightGrid[lightGrid.length - 1][lightGrid.length - 1] = true;
        }

        for (int i = 0; i < 100; i++) {
            lightGrid = makeStep(lightGrid);
        }

        System.out.println("(Part 1). " + countLightsOn(lightGrid));

    }

    private static Boolean[][] makeStep(Boolean[][] lightGrid) {

        Boolean[][] newLightGrid = new Boolean[lightGrid.length][lightGrid.length];

        for (int row = 0; row < lightGrid.length; row++) {
            for (int col = 0; col < lightGrid[row].length; col++) {

                int countNeighborsOn = getCountNeighbors(lightGrid, row, col, true);

                newLightGrid[row][col] = lightGrid[row][col];

                if (lightGrid[row][col]) {

                    if (countNeighborsOn != 2 && countNeighborsOn != 3) {
                        newLightGrid[row][col] = false;
                    }

                } else {
                    if (countNeighborsOn == 3) {
                        newLightGrid[row][col] = true;
                    }
                }
            }
        }

        if (isPart2) {
            newLightGrid[0][0]                                       = true;
            newLightGrid[0][lightGrid.length - 1]                    = true;
            newLightGrid[lightGrid.length - 1][0]                    = true;
            newLightGrid[lightGrid.length - 1][lightGrid.length - 1] = true;
        }

        return newLightGrid;

    }

    private static int getCountNeighbors(Boolean[][] lightGrid, int row, int col, boolean val) {
        int count = 0;

        if (row > 0) {

            // check same column in row before
            count += lightGrid[row - 1][col] == val ? 1 : 0;

            // check row before, column before
            if (col > 0) {
                count += lightGrid[row - 1][col - 1] == val ? 1 : 0;
            }

            // check row before, column after
            if (col < lightGrid.length - 1) {
                count += lightGrid[row - 1][col + 1] == val ? 1 : 0;
            }

        }

        if (row < lightGrid.length - 1) {

            // check same column in row after
            count += lightGrid[row + 1][col] == val ? 1 : 0;

            // check row after, column before
            if (col > 0) {
                count += lightGrid[row + 1][col - 1] == val ? 1 : 0;
            }

            // check row after, column after
            if (col < lightGrid.length - 1) {
                count += lightGrid[row + 1][col + 1] == val ? 1 : 0;
            }
        }

        // check same row, column before
        if (col > 0) {
            count += lightGrid[row][col - 1] == val ? 1 : 0;
        }

        // check same row, column after
        if (col < lightGrid.length - 1) {
            count += lightGrid[row][col + 1] == val ? 1 : 0;
        }

        return count;
    }

    private static int countLightsOn(Boolean[][] lightGrid) {
        int count = 0;

        for (int row = 0; row < lightGrid.length; row++) {
            for (int col = 0; col < lightGrid[row].length; col++) {
                if (lightGrid[row][col]) {
                    count++;
                }
            }
        }
        return count;
    }

}
