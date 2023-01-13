package Year2015.Day1;

import shared.Constant;
import shared.InputData;

import java.util.List;

public class Day1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "day1\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "day1\\input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            line = line.trim();

            int floor            = 0;
            int position         = 1;
            int positionBasement = -1;

            for (String charLine : line.split("")) {
                if ("(".equals(charLine)) {
                    floor += 1;
                }
                if (")".equals(charLine)) {
                    floor -= 1;
                }

                // part 2
                if (floor == -1 && positionBasement == -1) {
                    positionBasement = position;
                }
                position += 1;

            }

            System.out.println(line);
            System.out.println("(Part 1). " + floor);
            System.out.println("(Part 2). " + positionBasement);
            System.out.println("*************************");

        }

    }

}
