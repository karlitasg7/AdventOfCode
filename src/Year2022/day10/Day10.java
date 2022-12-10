package Year2022.day10;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10 {

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day10\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            int cycle = 1;
            int x     = 1;

            int cycle20  = 0;
            int cycle60  = 0;
            int cycle100 = 0;
            int cycle140 = 0;
            int cycle180 = 0;
            int cycle220 = 0;
            int count    = 1;

            String[][] crt = new String[6][40];

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                if (data.startsWith("noop")) {
                    count = 1;
                } else {
                    count = 2;
                }

                while (count > 0) {
                    System.out.println("vuelta=" + count + ".cycle =" + cycle + ".X=" + x);

                    switch (cycle) {
                        case 20 -> cycle20 = x;
                        case 60 -> cycle60 = x;
                        case 100 -> cycle100 = x;
                        case 140 -> cycle140 = x;
                        case 180 -> cycle180 = x;
                        case 220 -> cycle220 = x;
                    }

                    int r1 = Math.floorDiv((cycle - 1), 40);
                    int c1 = (cycle - 1) % 40;

                    if (Math.abs(x - ((cycle - 1) % 40)) <= 1) {
                        crt[r1][c1] = "#";
                    } else {
                        crt[r1][c1] = ".";
                    }

                    cycle += 1;
                    count -= 1;
                }

                if (data.startsWith("addx")) {
                    x += Integer.parseInt(data.split(" ")[1]);
                }

            }
            myReader.close();

            System.out.println("X =" + x);

            System.out.println("20 = " + cycle20);
            System.out.println("60 = " + cycle60);
            System.out.println("100 = " + cycle100);
            System.out.println("140 = " + cycle140);
            System.out.println("180 = " + cycle180);
            System.out.println("220 = " + cycle220);

            int total = (20 * cycle20) + (60 * cycle60) + (100 * cycle100) + (140 * cycle140) + (180 * cycle180) + (220 * cycle220);

            System.out.println("Total = " + total);

            System.out.println("------------------- PART 2 ------------------");
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 40; col++) {
                    System.out.print(crt[row][col]);
                }
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
