package com.karlasequen.Year2022.day12;

import com.karlasequen.shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day12 {

    public static void main(String[] args) {
        try {

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day12\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            List<String> list = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }
                list.add(data);

            }
            myReader.close();

            int[] grid = new int[list.size() * list.get(0).length()];

            int i = 0;
            int x = 0;
            int y = 0;

            int startX = 0;
            int startY = 0;
            int endX   = 0;
            int endY   = 0;

            for (String s : list) {
                String[] letter = s.split("");
                for (String l : letter) {
                    if (l.equals("S")) {
                        grid[i] = 0;
                        startX  = x;
                        startY  = y;
                    } else if (l.equals("E")) {
                        grid[i] = 25;
                        endX    = x;
                        endY    = y;
                    } else {
                        grid[i] = l.getBytes()[0] - 97;
                    }
                    i++;
                    x++;
                }
                x = 0;
                y++;
            }

            Collection<Path> currentPaths = new ArrayList<>();
            List<Path>       finalPaths   = new ArrayList<>();
//            currentPaths.add(new Path(startX, startY, list.get(0).length(), list.size())); //part 1

            // ************** part 2 **************
            for (int y1 = 0; y1 < list.size(); y1++) {
                for (int x1 = 0; x1 < list.size(); x1++) {
                    if (grid[y1 * list.get(0).length() + x1] == 0) {
                        currentPaths.add(new Path(x1, y1, list.get(0).length(), list.size()));
                    }
                }
            }
            // ************** part 2 **************

            Set<Integer> visited = new HashSet<>();
            while (!currentPaths.isEmpty()) {
                Map<Integer, Path> newPaths = new HashMap<>();
                for (Path p : currentPaths) {
                    if (p.foundEnd(endX, endY)) {
                        finalPaths.add(p);
                        break;
                    } else {
                        for (Path p1 : p.getNewPaths(grid, visited)) {
                            newPaths.put(p1.getId(), p1);
                        }
                    }
                    visited.add(p.getId());
                }
                currentPaths = newPaths.values();
            }

            finalPaths.sort(Comparator.comparingInt(Path::getLength));

            System.out.println(finalPaths.get(0).getLength());

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
