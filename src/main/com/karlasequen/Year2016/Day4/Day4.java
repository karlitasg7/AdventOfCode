package com.karlasequen.Year2016.Day4;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;
import com.karlasequen.shared.UtilsMaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day4/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day4/input.txt";

    private static final Pattern regex = Pattern.compile("^([A-Za-z-]+)-(\\d+)\\[([A-Za-z]+)]$");

    private static Integer total = 0;

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            processLine(line);
        }

        System.out.println("Part 1. " + total);

    }

    private static void processLine(String line) {

        Matcher matcher = regex.matcher(line);
        if (matcher.matches()) {
            String text = matcher.group(1);
            int number = Integer.parseInt(matcher.group(2));
            String checkSum = matcher.group(3);

            String originText = text;
            text = text.replace("-", "");

            Map<Character, Integer> mapLettersCount = new HashMap<>();

            for (char c : text.toCharArray()) {
                mapLettersCount.put(c, mapLettersCount.getOrDefault(c, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> sortedEntries = UtilsMaps.sortByFrequency(mapLettersCount);

            int count = 0;
            StringBuilder first5Letters = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                if (count >= 5) {
                    break;
                }
                first5Letters.append(entry.getKey());
                count++;
            }

            if (Objects.equals(checkSum, first5Letters.toString())) {
                total += number;
            }

            String decryptedName = decryptRoomName(originText, number);

            if (decryptedName.toLowerCase().contains("northpole object")) {
                System.out.println("Part 2. " + number);
            }

        }
    }

    public static String decryptRoomName(String encryptedRoomName, int sectorId) {
        StringBuilder decryptedName = new StringBuilder();

        for (char c : encryptedRoomName.toCharArray()) {
            if (c == '-') {
                decryptedName.append(' ');
            } else {
                char decryptedChar = (char) ('a' + (c - 'a' + sectorId) % 26);
                decryptedName.append(decryptedChar);
            }
        }

        return decryptedName.toString();
    }

}
