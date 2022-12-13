package Year2022.day9;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day9 {

    public static final int gridSize = 1000;

    public static int[] grid = new int[gridSize * gridSize];

    public static int[] posRopX = new int[10];
    public static int[] posRopY = new int[10];

    public static void main(String[] args) {

        // part 2
        Arrays.fill(posRopX, 500);
        Arrays.fill(posRopY, 500);

        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day9\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                String[] move = data.split(" ");

                move(move[0], Integer.parseInt(move[1]));

            }
            myReader.close();

            int total = 0;
            for (int i : grid) {
                if (i > 0) {
                    total++;
                }
            }

            System.out.println("Total is = " + total);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void move(String dir, int amount) {
        for (int i = 0; i < amount; i++) {
            moveAStep(dir);
        }
    }

    private static void moveAStep(String dir) {
        switch (dir) {
            case "U" -> posRopY[0] -= 1;
            case "D" -> posRopY[0] += 1;
            case "L" -> posRopX[0] -= 1;
            case "R" -> posRopX[0] += 1;
        }

        for (int i = 0; i < posRopX.length - 1; i++) {
            boolean moveX  = Math.abs(posRopX[i] - posRopX[i + 1]) > 1;
            boolean moveY  = Math.abs(posRopY[i] - posRopY[i + 1]) > 1;
            boolean moveXY = Math.abs(posRopX[i] - posRopX[i + 1]) + Math.abs(posRopY[i] - posRopY[i + 1]) > 2;

            if (moveXY) {
                if (posRopX[i] > posRopX[i + 1]) {
                    posRopX[i + 1]++;
                } else {
                    posRopX[i + 1]--;
                }
                if (posRopY[i] > posRopY[i + 1]) {
                    posRopY[i + 1]++;
                } else {
                    posRopY[i + 1]--;
                }
            } else if (moveX) {
                if (posRopX[i] > posRopX[i + 1]) {
                    posRopX[i + 1]++;
                } else {
                    posRopX[i + 1]--;
                }
            } else if (moveY) {
                if (posRopY[i] > posRopY[i + 1]) {
                    posRopY[i + 1]++;
                } else {
                    posRopY[i + 1]--;
                }
            }

        }
        grid[posRopY[9] * gridSize + posRopX[9]] += 1;

    }

}
