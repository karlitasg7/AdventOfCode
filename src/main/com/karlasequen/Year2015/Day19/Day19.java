package com.karlasequen.Year2015.Day19;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    }

}
