package com.karlasequen.Year2015.Day17;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day17/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day17/input.txt";

    public static void main(String[] args) {

//        int litters = 25; // sample
        int litters = 150; // input

        ArrayList<Integer> containersList = new ArrayList<>();

        List<String> input = InputData.get(FILE_NAME);
        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            containersList.add(Integer.parseInt(line));
        }

        List<List<Integer>> combinations = getCombinations(containersList);

        List<List<Integer>> combinations2 = combinations
                .stream()
                .filter(x -> x.stream().mapToInt(Integer::intValue).sum() == litters)
                .toList();

        System.out.println("(Part 1). " + combinations2.size());

        // part 2
        int min = combinations2
                .stream()
                .map(List::size)
                .min(Integer::compareTo)
                .orElse(0);

        List<List<Integer>> combinations3 = combinations2
                .stream()
                .filter(x -> x.size() == min)
                .toList();

        System.out.println("(Part 2). " + combinations3.size());

    }

    public static void getCombinations(List<Integer> numbers,
                                       List<Integer> combination,
                                       List<List<Integer>> combinations) {
        combinations.add(new ArrayList<>(combination));
        for (int i = 0; i < numbers.size(); i++) {
            combination.add(numbers.get(i));
            getCombinations(numbers.subList(i + 1, numbers.size()), combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }

    public static List<List<Integer>> getCombinations(List<Integer> numbers) {
        List<List<Integer>> combinations = new ArrayList<>();
        getCombinations(numbers, new ArrayList<>(), combinations);
        return combinations;
    }

}
