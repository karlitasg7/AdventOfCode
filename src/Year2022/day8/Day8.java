package Year2022.day8;

import shared.Constant;
import shared.InputData;

import java.util.Arrays;
import java.util.List;

public class Day8 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day8\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day8\\input.txt";

    public static void main(String[] args) {

        int sizeTreeMap = 5;

        if (FILE_NAME.endsWith("input.txt")) {
            sizeTreeMap = 99;
        }

        int countOfRows = 0;

        int[][] treeMap = new int[sizeTreeMap][sizeTreeMap];

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            treeMap[countOfRows] = Arrays.stream(line.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            countOfRows += 1;

        }

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

        System.out.println("(Part 1). Visible in edges: " +
                                   ((countOfRows * 2 + ((countOfRows - 2) + (countOfRows - 2))) + countOfVisibleInteriorTrees)
        );

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
