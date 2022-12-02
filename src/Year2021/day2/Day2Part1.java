package Year2021.day2;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {

    public static void main(String[] args) {

        int horizontal = 0;
        int depth      = 0;

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day2\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                String option = data.split(" ")[0];
                int    value  = Integer.parseInt(data.split(" ")[1]);

                switch (option) {
                    case "forward":
                        horizontal += value;
                        break;

                    case "down":
                        depth += value;
                        break;

                    case "up":
                        depth -= value;
                        break;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Total is: " + (horizontal * depth));
    }

}
