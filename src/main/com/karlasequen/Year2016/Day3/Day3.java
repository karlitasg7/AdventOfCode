package com.karlasequen.Year2016.Day3;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;
import org.jgrapht.alg.util.Triple;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day3/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day3/input.txt";

    private static int countValidTriangles = 0;
    private static final List<Triple<Integer, Integer, Integer>> trianglesSides = new ArrayList<>();

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            line = line.trim();

            checkLine(line);

        }

        System.out.println("Part 1. " + countValidTriangles);

        countValidTriangles = 0;
        part2();
        System.out.println("Part 2. " + countValidTriangles);

    }

    private static boolean isValidTriangle(int side1, int side2, int side3) {
        return ((side1 + side2) > side3) && ((side2 + side3) > side1) && ((side1 + side3) > side2);
    }

    private static void checkLine(String line) {
        String[] splitLine = line.split("\\s+");

        int side1 = Integer.parseInt(splitLine[0]);
        int side2 = Integer.parseInt(splitLine[1]);
        int side3 = Integer.parseInt(splitLine[2]);

        trianglesSides.add(new Triple<>(side1, side2, side3));

        if (isValidTriangle(side1, side2, side3)) {
            countValidTriangles += 1;
        }
    }

    private static void part2() {
        for (int i = 0; i < trianglesSides.size() - 2; i += 3) {
            Triple<Integer, Integer, Integer> first = trianglesSides.get(i);
            Triple<Integer, Integer, Integer> second = trianglesSides.get(i + 1);
            Triple<Integer, Integer, Integer> third = trianglesSides.get(i + 2);

            if (isValidTriangle(first.getFirst(), second.getFirst(), third.getFirst()))
                countValidTriangles++;
            if (isValidTriangle(first.getSecond(), second.getSecond(), third.getSecond()))
                countValidTriangles++;
            if (isValidTriangle(first.getThird(), second.getThird(), third.getThird()))
                countValidTriangles++;
        }
    }

}
