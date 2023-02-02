package com.karlasequen.Year2015.Day7;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Day7 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day7/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day7/input.txt";

    private static final HashMap<String, String> circuitMap = new HashMap<>();

    private static final Function<String, Integer>           operationNot    = s -> (~getValue(s));
    private static final BiFunction<String, String, Integer> operationAnd    =
            (arg1, arg2) -> (getValue(arg1) & getValue(arg2));
    private static final BiFunction<String, String, Integer> operationOr     =
            (arg1, arg2) -> (getValue(arg1) | getValue(arg2));
    private static final BiFunction<String, String, Integer> operationLShift =
            (arg1, arg2) -> (getValue(arg1) << getValue(arg2));
    private static final BiFunction<String, String, Integer> operationRShift =
            (arg1, arg2) -> (getValue(arg1) >> getValue(arg2));

    public static void main(String[] args) {

        prepareCircuit();
        int valueA = getFinalValue("a");
        System.out.println("(Part 1). " + valueA);

        prepareCircuit();
        circuitMap.put("b", String.valueOf(valueA));
        System.out.println("(Part 2). " + getFinalValue("a"));

    }

    private static void prepareCircuit() {
        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            String[] lineParts = line.split(" -> ");
            circuitMap.put(lineParts[1], lineParts[0]);

        }
    }

    public static int getFinalValue(String key) {
        return 0xffff & getValue(key);
    }

    private static int getValue(String arg) {
        int value;
        if (arg.matches("\\d+")) {
            value = Integer.parseInt(arg);
        } else {
            value = processInstruction(circuitMap.get(arg));
            circuitMap.put(arg, String.valueOf(value));
        }
        return value;
    }


    private static int processInstruction(String instruction) {
        String[] opts = instruction.split(" ");

        String arg1      = "";
        String arg2      = "";
        String operation = "";

        switch (opts.length) {
            case 3 -> {
                operation = opts[1];
                arg1      = opts[0];
                arg2      = opts[2];
            }
            case 2 -> {
                operation = opts[0];
                arg1      = opts[1];
            }
            default -> {
                operation = "SET";
                arg1      = opts[0];
            }
        }

        int result = 0;

        switch (operation) {
            case "AND" -> result = operationAnd.apply(arg1, arg2);
            case "OR" -> result = operationOr.apply(arg1, arg2);
            case "LSHIFT" -> result = operationLShift.apply(arg1, arg2);
            case "RSHIFT" -> result = operationRShift.apply(arg1, arg2);
            case "NOT" -> result = operationNot.apply(arg1);
            case "SET" -> {
                result = getValue(instruction);
            }
        }
        return result;
    }

}
