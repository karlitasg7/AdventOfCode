package Year2022.day5;

import shared.Constant;
import shared.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day5\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day5\\input.txt";

    private static final Stack<String> stack1Sample = new Stack<>();
    private static final Stack<String> stack2Sample = new Stack<>();
    private static final Stack<String> stack3Sample = new Stack<>();

    private static final Stack<String> stack1 = new Stack<>();
    private static final Stack<String> stack2 = new Stack<>();
    private static final Stack<String> stack3 = new Stack<>();
    private static final Stack<String> stack4 = new Stack<>();
    private static final Stack<String> stack5 = new Stack<>();
    private static final Stack<String> stack6 = new Stack<>();
    private static final Stack<String> stack7 = new Stack<>();
    private static final Stack<String> stack8 = new Stack<>();
    private static final Stack<String> stack9 = new Stack<>();

    private static final List<Stack<String>> listOfStacks = new ArrayList<>();

    private static void prepareStacks() {

        stack1Sample.clear();
        stack2Sample.clear();
        stack3Sample.clear();
        stack1.clear();
        stack2.clear();
        stack3.clear();
        stack4.clear();
        stack5.clear();
        stack6.clear();
        stack7.clear();
        stack8.clear();
        stack9.clear();
        listOfStacks.clear();

        stack1Sample.push("Z");
        stack1Sample.push("N");

        stack2Sample.push("M");
        stack2Sample.push("C");
        stack2Sample.push("D");

        stack3Sample.push("P");

        stack1.push("R");
        stack1.push("N");
        stack1.push("F");
        stack1.push("V");
        stack1.push("L");
        stack1.push("J");
        stack1.push("S");
        stack1.push("M");

        stack2.push("P");
        stack2.push("N");
        stack2.push("D");
        stack2.push("Z");
        stack2.push("P");
        stack2.push("J");
        stack2.push("W");
        stack2.push("H");

        stack3.push("W");
        stack3.push("R");
        stack3.push("C");
        stack3.push("D");
        stack3.push("G");

        stack4.push("N");
        stack4.push("B");
        stack4.push("S");

        stack5.push("M");
        stack5.push("Z");
        stack5.push("W");
        stack5.push("P");
        stack5.push("C");
        stack5.push("B");
        stack5.push("F");
        stack5.push("N");

        stack6.push("P");
        stack6.push("R");
        stack6.push("M");
        stack6.push("W");

        stack7.push("R");
        stack7.push("T");
        stack7.push("N");
        stack7.push("G");
        stack7.push("L");
        stack7.push("S");
        stack7.push("W");

        stack8.push("Q");
        stack8.push("T");
        stack8.push("H");
        stack8.push("F");
        stack8.push("N");
        stack8.push("B");
        stack8.push("V");

        stack9.push("L");
        stack9.push("M");
        stack9.push("H");
        stack9.push("Z");
        stack9.push("N");
        stack9.push("F");

        if (FILE_NAME.endsWith("sample.txt")) {
            listOfStacks.add(stack1Sample);
            listOfStacks.add(stack2Sample);
            listOfStacks.add(stack3Sample);

        } else {

            listOfStacks.add(stack1);
            listOfStacks.add(stack2);
            listOfStacks.add(stack3);
            listOfStacks.add(stack4);
            listOfStacks.add(stack5);
            listOfStacks.add(stack6);
            listOfStacks.add(stack7);
            listOfStacks.add(stack8);
            listOfStacks.add(stack9);
        }

    }

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        prepareStacks();
        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            String[] step             = line.split(" ");
            int      quantityOfCrates = Integer.parseInt(step[1]);
            int      sourceStack      = Integer.parseInt(step[3]) - 1;
            int      targetStack      = Integer.parseInt(step[5]) - 1;

            while (quantityOfCrates > 0) {

                listOfStacks.get(targetStack).push(listOfStacks.get(sourceStack).pop());

                quantityOfCrates -= 1;
            }

        }

        StringBuilder finalMessage = new StringBuilder();

        for (Stack<String> stack : listOfStacks) {
            finalMessage.append(stack.peek());
        }

        System.out.println("(Part 1). " + finalMessage);
    }

    private static void part2() {
        prepareStacks();
        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            String[] step             = line.split(" ");
            int      quantityOfCrates = Integer.parseInt(step[1]);
            int      sourceStack      = Integer.parseInt(step[3]) - 1;
            int      targetStack      = Integer.parseInt(step[5]) - 1;

            Stack<String> temporalStack = new Stack<>();
            while (quantityOfCrates > 0) {

                temporalStack.push(listOfStacks.get(sourceStack).pop());

                quantityOfCrates -= 1;
            }

            while (temporalStack.size() > 0) {
                listOfStacks.get(targetStack).push(temporalStack.pop());
            }

        }

        StringBuilder finalMessage = new StringBuilder();

        for (Stack<String> stack : listOfStacks) {
            finalMessage.append(stack.peek());
        }

        System.out.println("(Part 2). " + finalMessage);
    }

}
