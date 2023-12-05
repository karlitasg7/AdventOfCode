package com.karlasequen.shared;

import java.util.List;

public class ListToCharArray {

    public static char[][] convertListToCharArray(List<String> linesFile) {
        char[][] charArray;

        int numRows      = linesFile.size() + 2;
        int maxRowLength = linesFile.stream().mapToInt(String::length).max().orElse(0);
        int numCols      = maxRowLength + 2;

        charArray = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                charArray[i][j] = '.';
            }
        }

        for (int i = 0; i < linesFile.size(); i++) {
            String line = linesFile.get(i);
            line.getChars(0, line.length(), charArray[i + 1], 1);
        }

        return charArray;

    }

}
