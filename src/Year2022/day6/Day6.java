package Year2022.day6;

import shared.Constant;
import shared.InputData;

import java.util.HashMap;
import java.util.List;

public class Day6 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day6/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "Day6/input.txt";

    public static void main(String[] args) {
        calculate(4);

        System.out.println("********** Part 2 **********");
        calculate(14);
    }

    private static void calculate(Integer sizeOfChars) {
        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            int charPosition = 0;
            for (int i = 0; i < line.length() - (sizeOfChars + 1); i++) {

                String newText = line.substring(i, (i + sizeOfChars));

                HashMap<String, Integer> charsMap = new HashMap<>();

                for (String letter : newText.split("")) {
                    if (charsMap.containsKey(letter)) {
                        break;
                    }
                    charsMap.put(letter, 1);
                }

                if (charsMap.size() == sizeOfChars) {
                    charPosition = i;
                    break;
                }
            }

            System.out.println(charPosition + sizeOfChars);
        }
    }

}
