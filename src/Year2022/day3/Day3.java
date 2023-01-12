package Year2022.day3;

import shared.Constant;
import shared.InputData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Day3 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day3\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day3\\input.txt";

    private static final String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ";

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int sumOfPriorities = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (Objects.equals(line, "")) {
                continue;
            }

            int size = line.length() / 2;

            String[] part1 = line.substring(0, size).split("");
            String   part2 = line.substring(size);

            String findedLetter = "";
            for (String letter : part1) {
                if (part2.contains(letter)) {
                    findedLetter = letter;
                    break;
                }
            }

            sumOfPriorities += priorities.indexOf(findedLetter) + 1;

        }

        System.out.println("(Part 1). Sum is = " + sumOfPriorities);
    }

    private static void part2() {
        int sumOfPriorities = 0;
        int countOfLine     = 0;

        List<String> listOfString = new ArrayList<>(3);

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (Objects.equals(line, "")) {
                continue;
            }

            if (countOfLine < 3) {
                listOfString.add(line);
                countOfLine += 1;
            } else {
                countOfLine = 0;
                listOfString.sort(Comparator.comparingInt(String::length));

                String findedLetter = "";
                for (String letter : listOfString.get(0).split("")) {
                    if (listOfString.get(1).contains(letter) && listOfString.get(2).contains(letter)) {
                        findedLetter = letter;
                        break;
                    }
                }

                sumOfPriorities += priorities.indexOf(findedLetter) + 1;

                listOfString.clear();
                listOfString.add(line);
                countOfLine += 1;
            }

        }

        if (!listOfString.isEmpty()) {
            String findedLetter = "";
            for (String letter : listOfString.get(0).split("")) {
                if (listOfString.get(1).contains(letter) && listOfString.get(2).contains(letter)) {
                    findedLetter = letter;
                    break;
                }
            }

            sumOfPriorities += priorities.indexOf(findedLetter) + 1;
        }


        System.out.println("(Part 2). Sum is = " + sumOfPriorities);
    }

}
