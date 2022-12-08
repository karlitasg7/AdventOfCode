package Year2022.day8;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day8 {

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

            int countOfVisibleInteriorTrees = 0;
            for (int row = 1; row < treeMap.length - 1; row++) {
                for (int col = 1; col < treeMap[row].length - 1; col++) {

                    if (checkIfTreeIsVisibleInTop(treeMap, row, col) ||
                            checkIfTreeIsVisibleInBottom(treeMap, row, col) ||
                            checkIfTreeIsVisibleInLeft(treeMap, row, col) ||
                            checkIfTreeIsVisibleInRight(treeMap, row, col)
                    ) {
                        countOfVisibleInteriorTrees += 1;
                    }

                }
            }

            System.out.println("Visible in edges: " + ((countOfRows * 2 + ((countOfRows - 2) + (countOfRows - 2))) + countOfVisibleInteriorTrees));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean checkIfTreeIsVisibleInTop(int[][] treeMap, int currentRow, int currentCol) {
        int currentTree = treeMap[currentRow][currentCol];
        for (int row = (currentRow - 1); row > -1; row--) {
            if (treeMap[row][currentCol] >= currentTree) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfTreeIsVisibleInBottom(int[][] treeMap, int currentRow, int currentCol) {
        int currentTree = treeMap[currentRow][currentCol];
        for (int row = (treeMap.length - 1); row > currentRow; row--) {
            if (treeMap[row][currentCol] >= currentTree) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfTreeIsVisibleInLeft(int[][] treeMap, int currentRow, int currentCol) {
        int currentTree = treeMap[currentRow][currentCol];
        for (int col = 0; col < currentCol; col++) {
            if (treeMap[currentRow][col] >= currentTree) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfTreeIsVisibleInRight(int[][] treeMap, int currentRow, int currentCol) {
        int currentTree = treeMap[currentRow][currentCol];
        for (int col = (treeMap.length - 1); col > currentCol; col--) {
            if (treeMap[currentRow][col] >= currentTree) {
                return false;
            }
        }
        return true;
    }

}
