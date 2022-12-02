package Year2022.day2;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part1 {

    public static void main(String[] args) {
        try {

            Map<String, Integer> mapScore = new HashMap<>();
            mapScore.put("X", 1); // rock
            mapScore.put("Y", 2); // paper
            mapScore.put("Z", 3); // scissors

            int totalScore = 0;

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day2\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                String[] options = data.split(" ");

                totalScore += mapScore.get(options[1]);

                if ((options[1].equals("X") && options[0].equals("A")) ||
                        (options[1].equals("Y") && options[0].equals("B")) ||
                        (options[1].equals("Z") && options[0].equals("C"))) {
                    totalScore += 3;
                } else if ((options[1].equals("X") && options[0].equals("C")) ||
                        (options[1].equals("Z") && options[0].equals("B")) ||
                        (options[1].equals("Y") && options[0].equals("A"))) {
                    totalScore += 6;
                }

            }
            myReader.close();

            System.out.println("Total score = " + totalScore);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
