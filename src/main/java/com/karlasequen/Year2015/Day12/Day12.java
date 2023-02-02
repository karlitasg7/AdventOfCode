package com.karlasequen.Year2015.Day12;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day12/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day12/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            int     total = 0;
            Pattern p     = Pattern.compile("-?\\d+");
            Matcher m     = p.matcher(line);
            while (m.find()) {
                total += Integer.parseInt(m.group());
            }

            System.out.println("(Part 1). " + total);

        }
        part2();

    }

    private static void part2() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(FILE_NAME));
            System.out.println("(Part 2). " + addIntegersInJson(root, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int addIntegersInJson(JsonNode node, int sum) {
        int result = sum;
        if (node.isInt())
            result += sum + node.asInt();
        if (node.isArray()) {
            for (JsonNode n : node) {
                result += addIntegersInJson(n, sum);
            }
        }
        if (node.isObject() && !objectHasRedAsValue(node)) {
            Iterator<JsonNode> it = node.elements();
            while (it.hasNext()) {
                JsonNode elem = it.next();
                result += addIntegersInJson(elem, sum);
            }
        }
        return result;
    }

    private static boolean objectHasRedAsValue(JsonNode node) {
        boolean            result = false;
        Iterator<JsonNode> it     = node.iterator();
        while (it.hasNext()) {
            if (it.next().asText().equals("red")) {
                result = true;
                break;
            }
        }
        return result;
    }

}
