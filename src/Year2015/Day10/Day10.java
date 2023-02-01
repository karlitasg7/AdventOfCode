package Year2015.Day10;

import shared.Constant;
import shared.InputData;

import java.util.List;

public class Day10 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day10/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day10/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            processLine(line, 40);
            processLine(line, 50);
        }

    }

    private static void processLine(String line, int times) {
        String newChar = line;
        for (int i = 0; i < times; i++) {
            newChar = getNewChar(newChar);
        }

        System.out.println(line + " === " + newChar.length());
    }

    private static String getNewChar(String line) {
        StringBuilder newChar = new StringBuilder();

        String[] lineChar = line.split("");

        int    count    = 0;
        String previous = lineChar[0];
        for (int i = 0; i < lineChar.length; i++) {
            if (lineChar[i].equals(previous)) {
                count++;
            } else {
                newChar.append(count).append(previous);
                count = 1;
            }
            previous = lineChar[i];
        }

        newChar.append(count).append(previous);
        return newChar.toString();
    }

}
