package com.karlasequen.Year2016.Day10;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 {

//    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day10/sample.txt";
//    private static final Integer searchValue1 = 5;
//    private static final Integer searchValue2 = 2;

    private static final String  FILE_NAME    = Constant.BASE_PATH_2016 + "Day10/input.txt";
    private static final Integer searchValue1 = 61;
    private static final Integer searchValue2 = 17;

    private static final Map<String, List<Integer>> mapBots = new HashMap<>();

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        List<String> linesToProcess = new ArrayList<>();

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("value")) {
                processValue(line);
            } else {
                linesToProcess.add(line);
            }
        }

        /*String botWithValues = checkValues();

        while (botWithValues.isEmpty()) {
            for (String line : linesToProcess) {
                processLine(line);

                botWithValues = checkValues();

            }
        }

        System.out.println("Part 1. " + botWithValues);*/

        String botWithValues = checkOutputsPart2();

        while (botWithValues.isEmpty()) {
            for (String line : linesToProcess) {
                processLine(line);

                botWithValues = checkOutputsPart2();

            }
        }

        System.out.println("Part 2. " + botWithValues);

    }

    private static void processLine(String line) {
        String[] splitLine = line.split(" ");

        String source     = splitLine[0] + splitLine[1];
        String targetLow  = splitLine[5] + splitLine[6];
        String targetHigh = splitLine[10] + splitLine[11];

        checkIfExistOrInitArray(source);
        checkIfExistOrInitArray(targetLow);
        checkIfExistOrInitArray(targetHigh);

        if (mapBots.get(source).size() != 2) {
            return;
        }

        int low  = Collections.min(mapBots.get(source));
        int high = Collections.max(mapBots.get(source));

        mapBots.put(source, new ArrayList<>());

        mapBots.get(targetLow).add(low);
        mapBots.get(targetHigh).add(high);

    }

    private static void checkIfExistOrInitArray(String key) {
        if (!mapBots.containsKey(key)) {
            mapBots.put(key, new ArrayList<>());
        }
    }

    private static void processValue(String line) {

        String[] splitLine = line.split(" ");

        Integer value = Integer.parseInt(splitLine[1]);
        String  type  = splitLine[4] + splitLine[5];

        checkIfExistOrInitArray(type);
        mapBots.get(type).add(value);

    }

    private static String checkValues() {

        for (String row : mapBots.keySet()) {

            List<Integer> listOfValues = mapBots.get(row);

            if (listContainsValues(listOfValues, searchValue1) && listContainsValues(listOfValues, searchValue2)) {
                return row;
            }

        }

        return "";

    }

    private static boolean listContainsValues(List<Integer> listOfValues, int value) {
        for (Integer val : listOfValues) {
            if (val == value) {
                return true;
            }
        }

        return false;
    }

    private static String checkOutputsPart2() {

        checkIfExistOrInitArray("output0");
        checkIfExistOrInitArray("output1");
        checkIfExistOrInitArray("output2");

        if (mapBots.get("output0").size() == 1 &&
            mapBots.get("output1").size() == 1 &&
            mapBots.get("output2").size() == 1
        ) {

            int response = mapBots.get("output0").get(0) *
                mapBots.get("output1").get(0) *
                mapBots.get("output2").get(0);

            return Integer.toString(response);

        }

        return "";
    }

}
