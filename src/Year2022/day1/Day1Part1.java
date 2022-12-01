package Year2022.day1;

import Year2021.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1Part1 {

    public static void main(String[] args) {

        List<Integer> listOfCaloriesByElf = new ArrayList<>();

        try {

            int totalCurrentElf = 0;

            File myObj = new File(Constant.BASE_PATH_2022 + "day1\\input.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if ("".equals(data)) {
                    listOfCaloriesByElf.add(totalCurrentElf);
                    totalCurrentElf = 0;
                } else {
                    totalCurrentElf += Integer.parseInt(data);
                }

            }
            myReader.close();

            if (totalCurrentElf > 0) {
                listOfCaloriesByElf.add(totalCurrentElf);
            }

            listOfCaloriesByElf.sort(Collections.reverseOrder());
            System.out.println("The most calories are: " + listOfCaloriesByElf.get(0));

            // part 2
            int totalFirstThree = listOfCaloriesByElf.get(0) + listOfCaloriesByElf.get(1) + listOfCaloriesByElf.get(2);

            System.out.println("Sum of first three: " + totalFirstThree);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
