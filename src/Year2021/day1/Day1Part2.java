package Year2021.day1;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Part2 {

    public static void main(String[] args) {
        int count      = 0;
        int lastNumber = 0;

        boolean hasAllNumbers = true;
        boolean isNotFirst    = false;

        List<Integer> arrayOfNumber = getListOfNumber();

        for (int i = 0; i < arrayOfNumber.size(); i++) {
            int number1 = arrayOfNumber.get(i);
            int number2 = 0;
            int number3 = 0;

            if (arrayOfNumber.size() > (i + 1)) {
                number2 = arrayOfNumber.get((i + 1));
            } else {
                hasAllNumbers = false;
            }

            if (arrayOfNumber.size() > (i + 2)) {
                number3 = arrayOfNumber.get((i + 2));
            } else {
                hasAllNumbers = false;
            }

            int sum = number1 + number2 + number3;

            if (isNotFirst && hasAllNumbers && sum > lastNumber) {
                count++;
            }

            if (!isNotFirst) {
                isNotFirst = true;
            }

            lastNumber = sum;

        }

        System.out.println("Total is: " + count);
    }

    private static List<Integer> getListOfNumber() {
        List<Integer> arrayOfNumber = new ArrayList<>();

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day1\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                arrayOfNumber.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arrayOfNumber;
    }

}
