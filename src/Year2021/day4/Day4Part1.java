package Year2021.day4;

import Year2021.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day4Part1 {

    /*

    - read the file
    - if it's the first row save the data in a list
    - if it isn't the first row save the data in the matrix (maybe I need to create a custom class)
    - make a for with the numbers ahd search in every matrix if number exist
    - after save check if a row or column is complete
    - if it's complete we have a winner
    - if it isn't complete continue

     */

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

        // print values to check
        // printToCheck(listOfMatrix);

        CustomMatrix winner        = null;
        Integer      currentNumber = 0;

        // search numbers in boards (matrix)
        for (String n : listOfNumbers) {
            if (winner != null) {
                break;
            }
            currentNumber = Integer.valueOf(n);

            for (CustomMatrix customMatrix : listOfMatrix) {

                if (winner != null) {
                    break;
                }

                for (int row = 0; row < customMatrix.row.size(); row++) {
                    if (winner != null) {
                        break;
                    }

                    for (int column = 0; column < customMatrix.row.get(row).size(); column++) {

                        if (winner != null) {
                            break;
                        }

                        if (Objects.equals(customMatrix.row.get(row).get(column), currentNumber)) {
                            customMatrix.rowCheck.get(row).set(column, true);

                            winner = existWinner(listOfMatrix);
                        }
                    }
                }
            }
        }

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

    private static CustomMatrix existWinner(List<CustomMatrix> listOfMatrix) {

        for (CustomMatrix customMatrix : listOfMatrix) {

            // check if exists winner by row
            for (int row = 0; row < customMatrix.row.size(); row++) {
                boolean hasFalse = false;
                for (int column = 0; column < customMatrix.row.get(row).size(); column++) {
                    if (!customMatrix.rowCheck.get(row).get(column)) {
                        hasFalse = true;
                    }
                }

                if (!hasFalse) {
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
                if (!hasFalse) {
                    return customMatrix;
                }
            }

        }

        return null;
    }

}
