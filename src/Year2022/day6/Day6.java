package Year2022.day6;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day6 {

    //public static final int SIZE_OF_CHARS = 4;
    public static final int SIZE_OF_CHARS = 14; // Part2

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day6\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                int charPosition = 0;
                for (int i = 0; i < data.length() - (SIZE_OF_CHARS + 1); i++) {

                    String newText = data.substring(i, (i + SIZE_OF_CHARS));

                    HashMap<String, Integer> charsMap = new HashMap<>();

                    for (String letter : newText.split("")) {
                        if (charsMap.containsKey(letter)) {
                            break;
                        }
                        charsMap.put(letter, 1);
                    }

                    if (charsMap.size() == SIZE_OF_CHARS) {
                        charPosition = i;
                        break;
                    }
                }

                System.out.println(charPosition + SIZE_OF_CHARS);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
