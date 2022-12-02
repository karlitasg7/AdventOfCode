package Year2021.day3;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3Part1 {

    public static void main(String[] args) {

        Map<Integer, Map<Integer, Integer>> datas = new HashMap<>();

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day3\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                for (int i = 0; i < data.length(); i++) {

                    Integer currentChar = Integer.valueOf(Character.toString(data.charAt(i)));

                    if (datas.containsKey(i)) {
                        Map<Integer, Integer> detail = datas.get(i);

                        detail.put(currentChar, detail.get(currentChar) + 1);
                        datas.put(i, detail);

                    } else {

                        Map<Integer, Integer> detail = new HashMap<>(2);

                        detail.put(0, 0);
                        detail.put(1, 0);

                        detail.put(currentChar, 1);

                        datas.put(i, detail);
                    }

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String epsilon   = "";
        String gammaRate = "";

        for (Integer row : datas.keySet()) {
            Map<Integer, Integer> detail = datas.get(row);

            Integer countOf0 = detail.get(0);
            Integer countOf1 = detail.get(1);

            if (countOf0 > countOf1) {
                gammaRate += "0";
                epsilon += "1";
            } else {
                gammaRate += "1";
                epsilon += "0";
            }

        }

        System.out.println(datas);
        System.out.println("epsilon==" + epsilon);
        System.out.println("gammaRate==" + gammaRate);

        int decimalValue = Integer.parseInt(epsilon, 2) * Integer.parseInt(gammaRate, 2);
        System.out.println("The power is: " + decimalValue);
    }

}
