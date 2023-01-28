package Year2022.day2;

import shared.Constant;
import shared.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day2/input.txt";

    private static final Map<String, Integer> mapScore       = new HashMap<>();
    private static final Map<String, String>  mapChooseWin   = new HashMap<>();
    private static final Map<String, String>  mapChooseLoose = new HashMap<>();
    private static final Map<String, String>  mapChooseDraw  = new HashMap<>();
    private static final Map<String, Integer> mapTotalScore  = new HashMap<>();

    static {
        mapScore.put("X", 1); // rock
        mapScore.put("Y", 2); // paper
        mapScore.put("Z", 3); // scissors

        mapChooseWin.put("A", "Y");
        mapChooseWin.put("B", "Z");
        mapChooseWin.put("C", "X");

        mapChooseLoose.put("A", "Z");
        mapChooseLoose.put("B", "X");
        mapChooseLoose.put("C", "Y");

        mapChooseDraw.put("A", "X");
        mapChooseDraw.put("B", "Y");
        mapChooseDraw.put("C", "Z");

        mapTotalScore.put("XA", 3);
        mapTotalScore.put("YB", 3);
        mapTotalScore.put("ZC", 3);
        mapTotalScore.put("XC", 6);
        mapTotalScore.put("ZB", 6);
        mapTotalScore.put("YA", 6);

    }

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int totalScore = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            String[] options = line.split(" ");

            totalScore += mapScore.get(options[1]);
            totalScore += mapTotalScore.getOrDefault(options[1] + options[0], 0);

        }

        System.out.println("(Part 1). Total score = " + totalScore);
    }

    private static void part2() {
        int totalScore = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            String[] options = line.split(" ");

            switch (options[1]) {
                case "X" -> options[1] = mapChooseLoose.get(options[0]);
                case "Y" -> options[1] = mapChooseDraw.get(options[0]);
                default -> options[1] = mapChooseWin.get(options[0]);
            }

            totalScore += mapScore.get(options[1]);
            totalScore += mapTotalScore.getOrDefault(options[1] + options[0], 0);

        }

        System.out.println("(Part 2). Total score = " + totalScore);
    }

}
