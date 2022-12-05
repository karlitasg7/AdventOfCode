package Year2022.day3;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Day3Part1 {

    private static final String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ";

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day3\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            int sumOfPriorities = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (Objects.equals(data, "")) {
                    continue;
                }

                int size = data.length() / 2;

                String[] part1 = data.substring(0, size).split("");
                String   part2 = data.substring(size);

                String findedLetter = "";
                for (String letter : part1) {
                    if (part2.contains(letter)) {
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
