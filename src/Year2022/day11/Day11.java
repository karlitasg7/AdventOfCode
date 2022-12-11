package Year2022.day11;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day11 {

    public static void main(String[] args) {
        try {

            List<Monkey> monkeyList = new ArrayList<>();

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day11\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            Monkey currentMonkey = new Monkey();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    monkeyList.add(currentMonkey);
                }

                if (data.startsWith("Monkey")) {
                    currentMonkey = new Monkey();
                } else {

                    if (data.contains("Starting items:")) {

                        for (Integer item : Arrays.stream(data.split(": ")[1]
                                                                  .replace(" ", "")
                                                                  .split(",")
                                )
                                .mapToInt(Integer::parseInt)
                                .toArray()) {
                            currentMonkey.items.add(item.longValue());
                        }

                    }

                    if (data.contains("Operation:")) {
                        data                   = data
                                .replace("Operation: new = old", "")
                                .replace(" ", "");
                        currentMonkey.operator = data.substring(0, 1);

                        if (data.substring(1).equals("old")) {
                            currentMonkey.operatorByOld = true;
                        } else {
                            currentMonkey.operatorNumber = Integer.parseInt(data.substring(1));
                        }

                    }

                    if (data.contains("Test:")) {
                        currentMonkey.divisibleNumber = Integer.parseInt(data
                                                                                 .replace("Test: divisible by ",
                                                                                          "")
                                                                                 .replace(" ", "")
                        );
                    }

                    if (data.contains("If true:")) {
                        currentMonkey.monkeyIfTrue = Integer.parseInt(data
                                                                              .replace("If true: throw to monkey ",
                                                                                       "")
                                                                              .replace(" ", "")
                        );
                    }

                    if (data.contains("If false:")) {
                        currentMonkey.monkeyIfFalse = Integer.parseInt(data
                                                                               .replace("If false: throw to monkey ",
                                                                                        "")
                                                                               .replace(" ", "")
                        );
                    }

                }

            }
            monkeyList.add(currentMonkey);
            myReader.close();

            long number = monkeyList.get(0).divisibleNumber;
            for (int i = 1; i < monkeyList.size(); i++) {
                number *= monkeyList.get(i).divisibleNumber;
            }

            for (int i = 0; i < 10000; i++) {

                for (Monkey monkey : monkeyList) {

                    while (monkey.items.size() > 0) {

                        if (monkey.items.size() <= 0) {
                            continue;
                        }

                        long currentItem = monkey.items.remove();

                        if (monkey.operatorByOld) {
                            switch (monkey.operator) {
                                case "+" -> currentItem = currentItem + currentItem;
                                case "-" -> currentItem = currentItem - currentItem;
                                case "*" -> currentItem = currentItem * currentItem;
                                case "/" -> currentItem = currentItem / currentItem;
                            }
                        } else {
                            switch (monkey.operator) {
                                case "+" -> currentItem = currentItem + monkey.operatorNumber;
                                case "-" -> currentItem = currentItem - monkey.operatorNumber;
                                case "*" -> currentItem = currentItem * monkey.operatorNumber;
                                case "/" -> currentItem = currentItem / monkey.operatorNumber;
                            }
                        }

                        //currentItem = currentItem / 3; // only part 1
                        currentItem = currentItem % number; // part2

                        if (currentItem % monkey.divisibleNumber == 0) {
                            monkeyList.get((monkey.monkeyIfTrue)).items.add(currentItem);
                        } else {
                            monkeyList.get((monkey.monkeyIfFalse)).items.add(currentItem);
                        }

                        monkey.quantityItemChecks += 1;
                    }

                }
            }

            List<Long> listOfQuantity = new ArrayList<>();
            for (int i = 0; i < monkeyList.size(); i++) {
                System.out.println("Monkey=" + i + " = " + monkeyList.get(i).quantityItemChecks);
                listOfQuantity.add(monkeyList.get(i).quantityItemChecks);
            }

            listOfQuantity.sort(Collections.reverseOrder());

            Long position1 = listOfQuantity.get(0);
            Long position2 = listOfQuantity.get(1);
            long result    = position1 * position2;

            System.out.println("Total is = " + result);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static class Monkey {
        Queue<Long> items = new ArrayDeque<>();
        String      operator;
        int         operatorNumber;
        boolean     operatorByOld;
        int         divisibleNumber;

        int monkeyIfTrue;
        int monkeyIfFalse;

        long quantityItemChecks = 0;
    }

}
