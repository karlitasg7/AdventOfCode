package Year2021.day4;

import Year2021.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day4Part2 {

    static List<Integer> winners = new ArrayList<>();

    public static void main(String[] args) {

        List<String>       listOfNumbers = new ArrayList<>();
        List<CustomMatrix> listOfMatrix  = new ArrayList<>();
        CustomMatrix       currentMatrix = null;

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day4\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();

                if (listOfNumbers.isEmpty()) {
                    listOfNumbers = Arrays.stream(data.split(",")).toList();
                } else {

                    if (data.isEmpty()) {

                        if (currentMatrix != null) {
                            listOfMatrix.add(currentMatrix);
                        }

                        currentMatrix = new CustomMatrix();
                    } else {

                        List<Integer> currentRow      = new ArrayList<>(5);
                        List<Boolean> currentRowCheck = new ArrayList<>(5);

                        for (String d : data.split(" ")) {
                            if (d.isEmpty()) {
                                continue;
                            }

                            currentRow.add(Integer.valueOf(d));
                            currentRowCheck.add(false);

                        }
                        currentMatrix.row.add(currentRow);
                        currentMatrix.rowCheck.add(currentRowCheck);

                    }

                }
            }

            if (currentMatrix != null) {
                listOfMatrix.add(currentMatrix);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        CustomMatrix winner        = null;
        Integer      currentNumber = 0;

        boolean existWinner = false;

        // search numbers in boards (matrix)
        for (String n : listOfNumbers) {

            if (existWinner) {
                break;
            }
            currentNumber = Integer.valueOf(n);

            for (CustomMatrix customMatrix : listOfMatrix) {
                if (existWinner) {
                    break;
                }
                for (int row = 0; row < customMatrix.row.size(); row++) {
                    if (existWinner) {
                        break;
                    }
                    for (int column = 0; column < customMatrix.row.get(row).size(); column++) {
                        if (existWinner) {
                            break;
                        }
                        if (Objects.equals(customMatrix.row.get(row).get(column), currentNumber)) {
                            customMatrix.rowCheck.get(row).set(column, true);

                            winner = existWinner(listOfMatrix);

                            if (winners.size() == listOfMatrix.size()) {
                                existWinner = true;
                            }
                        }
                    }
                }
            }
        }

//        winner = listOfMatrix.get(winners.get(winners.size() - 1));

        if (winner != null) {

            System.out.println("winner:::::>>>>>");

            winner.printValues();
            winner.printValuesCheck();

            System.out.println("Current number is: " + currentNumber);

            Integer sumOfWinner = 0;
            for (int row = 0; row < winner.row.size(); row++) {
                for (int column = 0; column < winner.row.get(row).size(); column++) {
                    if (!winner.rowCheck.get(row).get(column)) {
                        sumOfWinner += winner.row.get(row).get(column);
                    }
                }
            }

            System.out.println("Sum Of winner is: " + sumOfWinner);

            System.out.println("Final result is: " + (sumOfWinner * currentNumber));

        }

    }

    private static void printToCheck(List<CustomMatrix> listOfMatrix) {
        System.out.println("Print to check::::: >>>>>");
        for (CustomMatrix customMatrix : listOfMatrix) {
            customMatrix.printValues();
            customMatrix.printValuesCheck();
        }
    }

    private static boolean existsWinnerInList(Integer indexOfWinner) {
        for (Integer number : winners) {
            if (number == indexOfWinner) {
                return true;
            }
        }
        return false;
    }

    private static CustomMatrix existWinner(List<CustomMatrix> listOfMatrix) {

        Integer currentIndexOfMatrix = -1;

        for (CustomMatrix customMatrix : listOfMatrix) {
            currentIndexOfMatrix++;

            // check if exists winner by row
            for (int row = 0; row < customMatrix.row.size(); row++) {
                boolean hasFalse = false;
                for (int column = 0; column < customMatrix.row.get(row).size(); column++) {
                    if (!customMatrix.rowCheck.get(row).get(column)) {
                        hasFalse = true;
                    }
                }

                if (!hasFalse && !existsWinnerInList(currentIndexOfMatrix)) {
                    winners.add(currentIndexOfMatrix);
                    return customMatrix;
                }
            }

            // check if exists winner by column
            for (int column = 0; column < 5; column++) {
                boolean hasFalse = false;
                for (int row = 0; row < customMatrix.row.size(); row++) {
                    if (!customMatrix.rowCheck.get(row).get(column)) {
                        hasFalse = true;
                    }
                }
                if (!hasFalse && !existsWinnerInList(currentIndexOfMatrix)) {
                    winners.add(currentIndexOfMatrix);
                    return customMatrix;
                }
            }

        }

        return null;
    }

}
