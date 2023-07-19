package com.karlasequen.Year2016.Day6;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;
import com.karlasequen.shared.UtilsMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day6/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day6/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        List<Map<Character, Integer>> mapList = new ArrayList<>();

        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            char[] splitLine = line.toCharArray();

            for (int i = 0; i < splitLine.length; i++) {
                mapList.get(i).put(splitLine[i], mapList.get(i).getOrDefault(splitLine[i], 0) + 1);
            }

        }

        StringBuilder finalText = new StringBuilder();
        StringBuilder finalTextPart2 = new StringBuilder();

        for (Map<Character, Integer> map : mapList) {

            if (map.size() == 0) {
                continue;
            }

            List<Map.Entry<Character, Integer>> sortedEntries = UtilsMaps.sortByFrequency(map);
            List<Map.Entry<Character, Integer>> sortedEntriesDesc = UtilsMaps.sortByFrequencyDesc(map);

            finalText.append(sortedEntries.get(0).getKey());
            finalTextPart2.append(sortedEntriesDesc.get(0).getKey());

        }

        System.out.println("Part 1. " + finalText);
        System.out.println("Part 2. " + finalTextPart2);

    }

}
