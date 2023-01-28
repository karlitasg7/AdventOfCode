package Year2015.Day6;

import shared.Constant;
import shared.InputData;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day6/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day6/input.txt";

    private static final Pattern lightingInstructionPattern = Pattern.compile("(.+) (\\d+),(\\d+) through (\\d+),(\\d+)");

    private static Integer lightGrid[][];
    private static int     numberOfRows;
    private static int     numberOfColumns;

    public Day6(int rows, int cols) {
        numberOfRows    = rows;
        numberOfColumns = cols;
        lightGrid       = new Integer[numberOfRows][numberOfColumns];
        this.resetLight();
    }

    public static Function<Integer, Integer> turnOff = i -> 0;
    public static Function<Integer, Integer> turnOn  = i -> 1;
    public static Function<Integer, Integer> toggle  = i -> i == 1 ? 0 : 1;

    public static Function<Integer, Integer> turnUp      = i -> ++i;
    public static Function<Integer, Integer> turnDown    = i -> i == 0 ? 0 : --i;
    public static Function<Integer, Integer> turnUpTwice = i -> i += 2;

    private void operateSetOfLights(int x1,
                                    int y1,
                                    int x2,
                                    int y2,
                                    Function<Integer, Integer> operation
    ) {
        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                lightGrid[row][col] = operation.apply(lightGrid[row][col]);
            }
        }
    }

    private void resetLight() {
        this.operateSetOfLights(0, 0, numberOfRows - 1, numberOfColumns - 1, turnOff);
    }

    private void processInstruction(String instruction, int part) {
        Matcher matcher = lightingInstructionPattern.matcher(instruction);

        if (matcher.find()) {

            String operation   = matcher.group(1);
            int    leftRow     = Integer.parseInt(matcher.group(2));
            int    leftColumn  = Integer.parseInt(matcher.group(3));
            int    rightRow    = Integer.parseInt(matcher.group(4));
            int    rightColumn = Integer.parseInt(matcher.group(5));

            Function<Integer, Integer> ope = i -> 0;

            if (part == 1) {
                switch (operation) {
                    case "turn on" -> ope = turnOn;
                    case "turn off" -> ope = turnOff;
                    case "toggle" -> ope = toggle;
                    default -> {
                    }
                }
            } else {
                switch (operation) {
                    case "turn on" -> ope = turnUp;
                    case "turn off" -> ope = turnDown;
                    case "toggle" -> ope = turnUpTwice;
                    default -> {
                    }
                }
            }
            operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, ope);
        }
    }

    private int getTotalTurnOnLights() {
        int count = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                count += lightGrid[row][col];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        List<String> input = InputData.get(FILE_NAME);

        Day6 day6 = new Day6(1000, 1000);

        input.forEach(str -> day6.processInstruction(str, 1));
        System.out.println("(Part 1). " + day6.getTotalTurnOnLights());

        day6.resetLight();

        input.forEach(str -> day6.processInstruction(str, 2));
        System.out.println("(Part 2). " + day6.getTotalTurnOnLights());
    }

}
