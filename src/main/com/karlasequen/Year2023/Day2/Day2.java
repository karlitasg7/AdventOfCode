package com.karlasequen.Year2023.Day2;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.Objects;

public class Day2 {

//    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2023 + "Day2/input.txt";

    private static int cubesRed   = 12;
    private static int cubesGreen = 13;
    private static int cubesBlue  = 14;

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int total      = 0;
        int totalPower = 0;
        for (String line : input) {
            if (!Objects.equals(line, "")) {
                total += processLine(line);
                totalPower += part2(line);
            }

        }

        System.out.println("First Part = " + total);
        System.out.println("Second Part = " + totalPower);

    }

    private static int processLine(String text) {

        String[] game   = text.split(":");
        int      gameId = Integer.parseInt(game[0].replace("Game", "").trim());

        String[] gameParts = game[1].split(";");

        for (String gamePart : gameParts) {
            String[] part = gamePart.split(",");

            for (String s : part) {
                int partCubesRed   = 0;
                int partCubesGreen = 0;
                int partCubesBlue  = 0;

                if (s.endsWith("red")) {
                    partCubesRed = Integer.parseInt(s.replace("red", "").trim());
                } else if (s.endsWith("green")) {
                    partCubesGreen = Integer.parseInt(s.replace("green", "").trim());
                } else if (s.endsWith("blue")) {
                    partCubesBlue = Integer.parseInt(s.replace("blue", "").trim());
                }

                if (partCubesRed > cubesRed || partCubesGreen > cubesGreen || partCubesBlue > cubesBlue) {
                    return 0;
                }
            }

        }

        return gameId;
    }

    private static int part2(String text) {

        String[] game   = text.split(":");
        int      gameId = Integer.parseInt(game[0].replace("Game", "").trim());

        String[] gameParts = game[1].split(";");

        int minimumCubesRed   = 0;
        int minimumCubesGreen = 0;
        int minimumCubesBlue  = 0;

        for (String gamePart : gameParts) {
            String[] part = gamePart.split(",");

            for (String s : part) {
                int partCubesRed   = 0;
                int partCubesGreen = 0;
                int partCubesBlue  = 0;

                if (s.endsWith("red")) {
                    partCubesRed = Integer.parseInt(s.replace("red", "").trim());
                } else if (s.endsWith("green")) {
                    partCubesGreen = Integer.parseInt(s.replace("green", "").trim());
                } else if (s.endsWith("blue")) {
                    partCubesBlue = Integer.parseInt(s.replace("blue", "").trim());
                }

                if (partCubesRed > minimumCubesRed) {
                    minimumCubesRed = partCubesRed;
                }
                if (partCubesGreen > minimumCubesGreen) {
                    minimumCubesGreen = partCubesGreen;
                }
                if (partCubesBlue > minimumCubesBlue) {
                    minimumCubesBlue = partCubesBlue;
                }
            }

        }

        return minimumCubesRed * minimumCubesGreen * minimumCubesBlue;
    }

}
