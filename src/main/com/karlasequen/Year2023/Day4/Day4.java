package com.karlasequen.Year2023.Day4;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day4 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day4/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int total     = 0;
        int cardCount = 0;

        Map<Integer, Integer> mapCards = new HashMap<>();

        for (String line : input) {
            if (!Objects.equals(line, "")) {
                cardCount++;

                String[]      splitCard     = line.split(":");
                String[]      splitNumbers  = splitCard[1].split("\\|");
                List<Integer> numbersToWin  = Arrays.stream(splitNumbers[0].trim().split("\\s+")).map(Integer::parseInt).toList();
                List<Integer> havingNumbers = Arrays.stream(splitNumbers[1].trim().split("\\s+")).map(Integer::parseInt).toList();
                List<Integer> winnerNumbers = new ArrayList<>();

                int cardValue = 0;

                for (Integer number : havingNumbers) {
                    if (numbersToWin.contains(number)) {
                        winnerNumbers.add(number);

                        if (winnerNumbers.size() == 1) {
                            cardValue = 1;
                        } else {
                            cardValue = cardValue * 2;
                        }
                    }
                }

                total += cardValue;

                if (mapCards.containsKey(cardCount)) {
                    mapCards.put(cardCount, mapCards.get(cardCount) + 1);
                } else {
                    mapCards.put(cardCount, 1);
                }

                for (int i = 1; i < winnerNumbers.size() + 1; i++) {
                    if (mapCards.containsKey(cardCount + i)) {
                        mapCards.put(cardCount + i, mapCards.get(cardCount + i) + mapCards.get(cardCount));
                    } else {
                        mapCards.put(cardCount + i, mapCards.get(cardCount));
                    }
                }

            }
        }

        System.out.println("First Part = " + total);
        System.out.println("Second Part = " + mapCards.values().stream().mapToInt(Integer::intValue).sum());
    }

}
