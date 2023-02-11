package com.karlasequen.Year2015.Day16;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16 {

    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day16/input.txt";

    private static String message = """
            children: 3
            cats: 7
            samoyeds: 2
            pomeranians: 3
            akitas: 0
            vizslas: 0
            goldfish: 5
            trees: 3
            cars: 2
            perfumes: 1
            """;

    public static void main(String[] args) {

        Map<String, Integer> mapMessage = new HashMap<>();
        for (String line : message.split("\n")) {
            String[] words = line.split(":");
            mapMessage.put(words[0], Integer.parseInt(words[1].strip()));
        }

        List<String> input = InputData.get(FILE_NAME);

        mainLoop:
        for (String line : input) {
            int      sueNumber = Integer.parseInt(line.substring(4, line.indexOf(":")));
            String[] compounds = line.substring(line.indexOf(":") + 1).split(", ");

            for (String compound : compounds) {
                String[] compoundTerms = compound.split(":");
                String   name          = compoundTerms[0].strip();
                Integer  value         = Integer.parseInt(compoundTerms[1].strip());

                if (!mapMessage.get(name).equals(value)) {
                    continue mainLoop;
                }
            }
            System.out.println("(Part 1). " + sueNumber);
        }

        part2(input, mapMessage);

    }

    private static void part2(List<String> input, Map<String, Integer> mapMessage) {
        mainLoop:
        for (String line : input) {

            int      sueNumber = Integer.parseInt(line.substring(4, line.indexOf(":")));
            String[] compounds = line.substring(line.indexOf(":") + 1).split(", ");

            for (String compound : compounds) {
                String[] compoundTerms = compound.split(":");
                String   name          = compoundTerms[0].strip();
                Integer  value         = Integer.parseInt(compoundTerms[1].strip());

                switch (name) {
                    case "cats", "trees" -> {
                        if (mapMessage.get(name) >= value) {
                            continue mainLoop;
                        }
                    }
                    case "pomeranians", "goldfish" -> {
                        if (mapMessage.get(name) <= value) {
                            continue mainLoop;
                        }
                    }
                    default -> {
                        if (!mapMessage.get(name).equals(value)) {
                            continue mainLoop;
                        }
                    }
                }
            }
            System.out.println("(Part 2). " + sueNumber);
        }
    }

}
