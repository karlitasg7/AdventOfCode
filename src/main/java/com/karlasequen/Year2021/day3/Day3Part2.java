package com.karlasequen.Year2021.day3;

import com.karlasequen.shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day3Part2 {

    private static Integer row = 0;

    public static void main(String[] args) {

        List<String> dataList = new ArrayList<>();

        try {
            File    myObj    = new File(Constant.BASE_PATH_2021 + "day3\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String oxygenGeneratorRating = processOxygen(dataList).get(0);
        row = 0;
        String c02Rating = processC02(dataList).get(0);

        System.out.println("Oxygen is = " + oxygenGeneratorRating);
        System.out.println("C02 is = " + c02Rating);

        int decimalValue = Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(c02Rating, 2);
        System.out.println("The life support is: " + decimalValue);
    }

    private static List<String> processOxygen(List<String> dataList) {

        if (dataList.size() == 1) {
            return dataList;
        }

        List<String>                        newDataList = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> datas       = new HashMap<>();

        for (String data : dataList) {
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

        Map<Integer, Integer> detail = datas.get(row);

        Integer countOf0 = detail.get(0);
        Integer countOf1 = detail.get(1);

        if (countOf0 > countOf1) {
            newDataList.addAll(dataList
                                       .stream()
                                       .filter(x -> Character.toString(x.charAt(row)).equals("0"))
                                       .toList());
        } else {
            newDataList.addAll(dataList
                                       .stream()
                                       .filter(x -> Character.toString(x.charAt(row)).equals("1"))
                                       .toList());
        }

        row += 1;
        return processOxygen(newDataList);

    }

    private static List<String> processC02(List<String> dataList) {

        if (dataList.size() == 1) {
            return dataList;
        }

        List<String>                        newDataList = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> datas       = new HashMap<>();

        for (String data : dataList) {
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

        Map<Integer, Integer> detail = datas.get(row);

        Integer countOf0 = detail.get(0);
        Integer countOf1 = detail.get(1);

        if (countOf0 <= countOf1) {
            newDataList.addAll(dataList
                                       .stream()
                                       .filter(x -> Character.toString(x.charAt(row)).equals("0"))
                                       .toList());
        } else {
            newDataList.addAll(dataList
                                       .stream()
                                       .filter(x -> Character.toString(x.charAt(row)).equals("1"))
                                       .toList());
        }

        row += 1;
        return processC02(newDataList);

    }

}
