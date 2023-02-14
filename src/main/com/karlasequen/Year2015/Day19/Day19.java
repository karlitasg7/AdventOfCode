package com.karlasequen.Year2015.Day19;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Day19 {

    //        private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day19/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day19/input.txt";

    public static void main(String[] args) {

        List<String> replacementsList = new ArrayList<>();

        String molecule = "";

        List<String> input = InputData.get(FILE_NAME);
        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            if (line.contains("=>")) {
                replacementsList.add(line);
            } else {
                molecule = line;
            }
        }

        Set<String> setMolecules = new HashSet<>();

        for (String replacement : replacementsList) {
            String[] parts = replacement.split("=>");
            for (int i = 0; i < molecule.length() - (parts[0].trim().length() - 1); i++) {

                if (molecule.substring(i, i + parts[0].trim().length()).equals(parts[0].trim())) {
                    setMolecules.add(
                            molecule.substring(0, i) +
                                    parts[1].trim() +
                                    molecule.substring(i + parts[0].trim().length(), molecule.length())
                    );
                }
            }
        }

        System.out.println("(Part 1). " + setMolecules.size());

        int count = part2(replacementsList, molecule);
        System.out.println("(Part 2). " + count);

    }

    public static int part2(List<String> replacementsList, String baseInput) {
        Map<String, String> invertedMap = invertMap(replacementsList);

        String fullMolecule = baseInput;

        Queue<String> queue = new LinkedList<>();
        queue.add(fullMolecule);

        List<Map.Entry<String, String>> entries = invertedMap.entrySet().stream().collect(Collectors.toList());

        int count = 0;
        while (!queue.isEmpty()) {
            String molecule = queue.poll();

            for (Map.Entry<String, String> entry : entries) {
                if (!entry.getValue().equals("e") && molecule.contains(entry.getKey())) {
                    queue.add(molecule.replaceFirst(entry.getKey(), entry.getValue()));
                    count++;
                    break;
                }
            }

            if (queue.isEmpty() && molecule.length() > 3) {
                queue.add(fullMolecule);
                Collections.shuffle(entries);
                count = 0;
            }
        }

        return count + 1;
    }

    private static Map<String, String> invertMap(List<String> replacementsList) {
        Map<String, String> invertedMap = new HashMap<>();

        for (String replacement : replacementsList) {
            String[] linePart = replacement.split(" => ");
            invertedMap.put(linePart[1], linePart[0]);
        }

        return invertedMap;
    }

}
