package com.karlasequen.Year2015.Day15;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    //        private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day15/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day15/input.txt";

    public static void main(String[] args) {

        List<Ingredient> ingredientsList = new ArrayList<>();

        List<String> input = InputData.get(FILE_NAME);
        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            String[] words = line.split(" ");
            ingredientsList.add(
                    new Ingredient(
                            words[0].replace(":", ""),
                            Integer.parseInt(words[2].replace(",", "")),
                            Integer.parseInt(words[4].replace(",", "")),
                            Integer.parseInt(words[6].replace(",", "")),
                            Integer.parseInt(words[8].replace(",", "")),
                            Integer.parseInt(words[10])
                    ));
        }

        List<List<Integer>> combinations = new ArrayList<>();
        combinations(ingredientsList.size(), 100, new ArrayList<>(), combinations);

        List<Integer> winPart1     = null;
        List<Integer> winPart2     = null;
        int           lastSumPart1 = 0;
        int           lastSumPart2 = 0;

        for (List<Integer> spoonCombination : combinations) {

            int sum = Math.max(0, ingredientsList
                    .stream()
                    .mapToInt(ingredient -> ingredient.capacity * spoonCombination
                            .get(ingredientsList.indexOf(ingredient)))
                    .sum()
            ) *
                    Math.max(0, ingredientsList
                            .stream()
                            .mapToInt(ingredient -> ingredient.durability * spoonCombination
                                    .get(ingredientsList.indexOf(ingredient)))
                            .sum()
                    ) *
                    Math.max(0, ingredientsList
                            .stream()
                            .mapToInt(ingredient -> ingredient.flavor * spoonCombination
                                    .get(ingredientsList.indexOf(ingredient)))
                            .sum()
                    ) *
                    Math.max(0, ingredientsList
                            .stream()
                            .mapToInt(ingredient -> ingredient.texture * spoonCombination
                                    .get(ingredientsList.indexOf(ingredient)))
                            .sum()
                    );

            int calories = ingredientsList
                    .stream()
                    .mapToInt(ingredient -> ingredient.calories * spoonCombination
                            .get(ingredientsList.indexOf(ingredient))
                    )
                    .sum();

            if (sum > lastSumPart1) {
                lastSumPart1 = sum;
                winPart1     = spoonCombination;
            }

            if (calories == 500 && sum > lastSumPart2) {
                lastSumPart2 = sum;
                winPart2     = spoonCombination;
            }
        }

        System.out.println("(Part 1). Highest-scoring cookie = " + lastSumPart1 + ". Winning-recipe = " + winPart1);
        System.out.println("(Part 2). Highest-scoring cookie = " + lastSumPart2 + ". Winning-recipe = " + winPart2);

    }

    private static void combinations(int size,
                                     int maxSum,
                                     ArrayList<Integer> previousList,
                                     List<List<Integer>> combinations
    ) {
        ArrayList<Integer> tmpList = (ArrayList<Integer>) previousList.clone();

        if (size == 1) {
            tmpList.add(maxSum);
            combinations.add(tmpList);
        } else {
            for (int i = 0; i < maxSum; i++) {
                tmpList = (ArrayList<Integer>) previousList.clone();
                tmpList.add(i);
                combinations(size - 1, maxSum - i, tmpList, combinations);
            }
        }
    }

}
