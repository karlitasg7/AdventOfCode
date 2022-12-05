package Year2022.day3;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day3Part2 {

    private static final String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ";

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day3\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            int sumOfPriorities = 0;
            int countOfLine     = 0;

            List<String> listOfString = new ArrayList<>(3);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (Objects.equals(data, "")) {
                    continue;
                }

                if (countOfLine < 3) {
                    listOfString.add(data);
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
                    listOfString.add(data);
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

            myReader.close();

            System.out.println("Sum is = " + sumOfPriorities);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
