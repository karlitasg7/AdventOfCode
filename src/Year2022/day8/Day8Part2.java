package Year2022.day8;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day8Part2 {

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day8\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            int countOfRows = 0;

            int[][] treeMap = new int[99][99];

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                treeMap[countOfRows] = Arrays.stream(data.split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                countOfRows += 1;

            }
            myReader.close();

            List<Integer> scoreList = new ArrayList<>();

            for (int row = 1; row < treeMap.length - 1; row++) {
                for (int col = 1; col < treeMap[row].length - 1; col++) {

                    scoreList.add(
                            checkIfTreeIsVisibleInTop(treeMap, row, col) *
                                    checkIfTreeIsVisibleInBottom(treeMap, row, col) *
                                    checkIfTreeIsVisibleInLeft(treeMap, row, col) *
                                    checkIfTreeIsVisibleInRight(treeMap, row, col)
                    );

                }
            }

            scoreList.sort(Collections.reverseOrder());

            System.out.println(scoreList.get(0));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static int checkIfTreeIsVisibleInTop(int[][] treeMap, int currentRow, int currentCol) {
        int count       = 0;
        int currentTree = treeMap[currentRow][currentCol];
        for (int row = (currentRow - 1); row > -1; row--) {
            if (treeMap[row][currentCol] < currentTree) {
                count += 1;
            } else {
                count += 1;
                return count;
            }
        }
        return count;
    }

    private static int checkIfTreeIsVisibleInBottom(int[][] treeMap, int currentRow, int currentCol) {
        int count       = 0;
        int currentTree = treeMap[currentRow][currentCol];
        for (int row = (currentRow + 1); row < treeMap.length; row++) {
            if (treeMap[row][currentCol] < currentTree) {
                count += 1;
            } else {
                count += 1;
                return count;
            }
        }
        return count;
    }

    private static int checkIfTreeIsVisibleInLeft(int[][] treeMap, int currentRow, int currentCol) {
        int count       = 0;
        int currentTree = treeMap[currentRow][currentCol];
        for (int col = (currentCol - 1); col > -1; col--) {
            if (treeMap[currentRow][col] < currentTree) {
                count += 1;
            } else {
                count += 1;
                return count;
            }
        }
        return count;
    }

    private static int checkIfTreeIsVisibleInRight(int[][] treeMap, int currentRow, int currentCol) {
        int count       = 0;
        int currentTree = treeMap[currentRow][currentCol];
        for (int col = (currentCol + 1); col < treeMap.length; col++) {
            if (treeMap[currentRow][col] < currentTree) {
                count += 1;
            } else {
                count += 1;
                return count;
            }
        }
        return count;
    }

}
