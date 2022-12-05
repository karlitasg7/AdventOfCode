package Year2022.day4;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4Part1 {

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day4\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            int total = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                String[] pairs = data.split(",");
                List<Integer> pair1 = Arrays.stream(pairs[0].split("-"))
                        .map(Integer::parseInt)
                        .toList();

                List<Integer> pair2 = Arrays.stream(pairs[1].split("-"))
                        .map(Integer::parseInt)
                        .toList();

                if (((pair1.get(0) <= pair2.get(0)) && (pair1.get(1) >= pair2.get(1))) ||
                        ((pair2.get(0) <= pair1.get(0)) && (pair2.get(1) >= pair1.get(1)))
                ) {
                    total += 1;
                }

            }

            myReader.close();

            System.out.println("Total is = " + total);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
