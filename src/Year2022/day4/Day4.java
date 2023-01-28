package Year2022.day4;

import shared.Constant;
import shared.InputData;

import java.util.Arrays;
import java.util.List;

public class Day4 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day4/input.txt";

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int total = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            String[] pairs = line.split(",");
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

        System.out.println("(Part 1). Total is = " + total);
    }

    private static void part2() {
        int total = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            String[] pairs = line.split(",");
            List<Integer> pair1 = Arrays.stream(pairs[0].split("-"))
                    .map(Integer::parseInt)
                    .toList();

            List<Integer> pair2 = Arrays.stream(pairs[1].split("-"))
                    .map(Integer::parseInt)
                    .toList();

            if (
                    (pair2.get(0) <= pair1.get(1) && pair2.get(0) >= pair1.get(0)) ||
                            (pair2.get(1) <= pair1.get(1) && pair2.get(1) >= pair1.get(0)) ||
                            (pair1.get(0) <= pair2.get(1) && pair1.get(0) >= pair2.get(0)) ||
                            (pair1.get(1) <= pair2.get(1) && pair1.get(1) >= pair2.get(0))
            ) {
                total += 1;
            }

        }

        System.out.println("(Part 2). Total is = " + total);
    }

}
