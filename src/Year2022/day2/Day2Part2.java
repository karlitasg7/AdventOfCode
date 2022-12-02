package Year2022.day2;

import Year2021.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part2 {

    public static void main(String[] args) {
        try {

            Map<String, Integer> mapScore = new HashMap<>();
            mapScore.put("X", 1); // rock
            mapScore.put("Y", 2); // paper
            mapScore.put("Z", 3); // scissors

            Map<String, String> mapChooseWin = new HashMap<>();
            mapChooseWin.put("A", "Y");
            mapChooseWin.put("B", "Z");
            mapChooseWin.put("C", "X");

            Map<String, String> mapChooseLoose = new HashMap<>();
            mapChooseLoose.put("A", "Z");
            mapChooseLoose.put("B", "X");
            mapChooseLoose.put("C", "Y");

            Map<String, String> mapChooseDraw = new HashMap<>();
            mapChooseDraw.put("A", "X");
            mapChooseDraw.put("B", "Y");
            mapChooseDraw.put("C", "Z");

            /*
            A = Rock            X
            B = Paper           Y
            C = Scissors        Z

            X = lose
            Y = draw
            Z = win
             */

            int totalScore = 0;

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day2\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.isEmpty()) {
                    continue;
                }

                String[] options = data.split(" ");

                switch (options[1]) {
                    case "X" -> options[1] = mapChooseLoose.get(options[0]);
                    case "Y" -> options[1] = mapChooseDraw.get(options[0]);
                    default -> options[1] = mapChooseWin.get(options[0]);
                }

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
