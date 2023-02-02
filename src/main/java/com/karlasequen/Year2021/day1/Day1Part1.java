package com.karlasequen.Year2021.day1;

import com.karlasequen.shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {

    public static void main(String[] args) {

        int     lastNumber = 0;
        int     count      = 0;
        boolean isNotFirst = false;

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day1\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (isNotFirst && Integer.parseInt(data) > lastNumber) {
                    count++;
                }

                if (!isNotFirst) {
                    isNotFirst = true;
                }

                lastNumber = Integer.parseInt(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Total is: " + count);
    }

}
