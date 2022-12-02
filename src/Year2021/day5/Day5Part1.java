package Year2021.day5;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day5Part1 {

    private static final int MAP_SIZE = 1000;

    public static void main(String[] args) {
        try {

            int    x1, x2, y1, y2;
            byte[] map = new byte[MAP_SIZE * MAP_SIZE];

            Arrays.fill(map, (byte) 0);

            File    myObj    = new File(Constant.BASE_PATH_2021 + "day5\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();

                String[] coordinates = data.split(" -> ");
                String[] positions   = coordinates[0].split(",");

                x1 = Integer.parseInt(positions[0]);
                y1 = Integer.parseInt(positions[1]);

                positions = coordinates[1].split(",");
                x2        = Integer.parseInt(positions[0]);
                y2        = Integer.parseInt(positions[1]);

                setMapPart2(map, x1, x2, y1, y2);

            }

            int count = 0;
            for (byte b : map) {
                if (b > 1) {
                    count++;
                }
            }

            System.out.println(count);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void setMap(byte[] map, int x1, int x2, int y1, int y2) {
        if (x1 != x2 && y1 != y2) {
            return;
        }

        if (x1 == x2) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                map[MAP_SIZE * i + x1]++;
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                map[MAP_SIZE * y1 + i]++;
            }
        }
    }

    private static void setMapPart2(byte[] map, int x1, int x2, int y1, int y2) {
        if (x1 == x2) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                map[MAP_SIZE * i + x1]++;
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                map[MAP_SIZE * y1 + i]++;
            }
        } else {
            if (y1 < y2 && x1 < x2) {
                for (int i = 0; i <= y2 - y1; i++) {
                    map[MAP_SIZE * (y1 + i) + (x1 + i)]++;
                }
            } else if (y1 > y2 && x1 > x2) {
                for (int i = 0; i <= y1 - y2; i++) {
                    map[MAP_SIZE * (y1 - i) + (x1 - i)]++;
                }
            } else if (y1 < y2 && x1 > x2) {
                for (int i = 0; i <= y2 - y1; i++) {
                    map[MAP_SIZE * (y1 + i) + (x1 - i)]++;
                }
            } else if (y1 > y2 && x1 < x2) {
                for (int i = 0; i <= x2 - x1; i++) {
                    map[MAP_SIZE * (y1 - i) + (x1 + i)]++;
                }
            }
        }
    }

}
