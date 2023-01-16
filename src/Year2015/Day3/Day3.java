package Year2015.Day3;

import shared.Constant;
import shared.InputData;

import java.util.HashMap;
import java.util.List;

public class Day3 {

    //        private static final String FILE_NAME = Constant.BASE_PATH_2015 + "day3\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "day3\\input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }
            calculate(line);

        }

    }

    private static void calculate(String input) {
        HashMap<String, Integer> presentsInHouses          = new HashMap<>();
        HashMap<String, Integer> presentsInHousesOnlySanta = new HashMap<>();

        presentsInHouses.put("1;1", 2);
        presentsInHousesOnlySanta.put("1;1", 1);

        int     x          = 1;
        int     y          = 1;
        int     xSanta     = 1;
        int     ySanta     = 1;
        int     xRoboSanta = 1;
        int     yRoboSanta = 1;
        boolean santaFirst = true;

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '^':
                    y++;
                    if (santaFirst) ySanta++;
                    else yRoboSanta++;
                    break;
                case '>':
                    x++;
                    if (santaFirst) xSanta++;
                    else xRoboSanta++;
                    break;
                case '<':
                    x--;
                    if (santaFirst) xSanta--;
                    else xRoboSanta--;
                    break;
                case 'v':
                    y--;
                    if (santaFirst) ySanta--;
                    else yRoboSanta--;
                    break;
            }

            if (santaFirst)
                presentsInHouses.put(xSanta + ";" + ySanta,
                                     presentsInHouses.getOrDefault(xSanta + ";" + ySanta, 1) + 1);
            else
                presentsInHouses.put(xRoboSanta + ";" + yRoboSanta,
                                     presentsInHouses.getOrDefault(xRoboSanta + ";" + yRoboSanta, 1) + 1);

            presentsInHousesOnlySanta.put(x + ";" + y, presentsInHousesOnlySanta.getOrDefault(x + ";" + y, 1) + 1);

            santaFirst = !santaFirst;
        }

        System.out.println("(Part 1). " + presentsInHousesOnlySanta.keySet().size());
        System.out.println("(Part 2). " + presentsInHouses.keySet().size());
    }

}
