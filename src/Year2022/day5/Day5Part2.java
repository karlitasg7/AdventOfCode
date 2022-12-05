package Year2022.day5;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day5Part2 {

    public static void main(String[] args) {

        // test
        /*
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();

        stack1.push("Z");
        stack1.push("N");

        stack2.push("M");
        stack2.push("C");
        stack2.push("D");

        stack3.push("P");

        List<Stack<String>> listOfStacks = new ArrayList<>();
        listOfStacks.add(stack1);
        listOfStacks.add(stack2);
        listOfStacks.add(stack3);


         */



        /* my input
[M] [H]         [N]
[S] [W]         [F]     [W] [V]
[J] [J]         [B]     [S] [B] [F]
[L] [F] [G]     [C]     [L] [N] [N]
[V] [Z] [D]     [P] [W] [G] [F] [Z]
[F] [D] [C] [S] [W] [M] [N] [H] [H]
[N] [N] [R] [B] [Z] [R] [T] [T] [M]
[R] [P] [W] [N] [M] [P] [R] [Q] [L]
 1   2   3   4   5   6   7   8   9

         */

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();
        Stack<String> stack4 = new Stack<>();
        Stack<String> stack5 = new Stack<>();
        Stack<String> stack6 = new Stack<>();
        Stack<String> stack7 = new Stack<>();
        Stack<String> stack8 = new Stack<>();
        Stack<String> stack9 = new Stack<>();

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

        List<Stack<String>> listOfStacks = new ArrayList<>();
        listOfStacks.add(stack1);
        listOfStacks.add(stack2);
        listOfStacks.add(stack3);
        listOfStacks.add(stack4);
        listOfStacks.add(stack5);
        listOfStacks.add(stack6);
        listOfStacks.add(stack7);
        listOfStacks.add(stack8);
        listOfStacks.add(stack9);

        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day5\\input.txt");
            Scanner myReader  = new Scanner(inputFile);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                String[] step             = data.split(" ");
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
            myReader.close();

            StringBuilder finalMessage = new StringBuilder();

            for (Stack<String> stack : listOfStacks) {
                finalMessage.append(stack.peek());
            }

            System.out.println(finalMessage);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
