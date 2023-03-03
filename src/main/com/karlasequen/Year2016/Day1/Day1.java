package com.karlasequen.Year2016.Day1;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day1/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2016 + "Day1/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            String[] commandList = line.split(", ");
            System.out.println("Part 1. " + exec(commandList, false));
            System.out.println("Part 2. " + exec(commandList, true));
        }
    }

    private static int exec(String[] commandList, boolean isPart2) {
        Point[] unitVectors = {
                new Point(1, 0),
                new Point(0, -1),
                new Point(-1, 0),
                new Point(0, 1)
        };

        int   direction  = 3;
        Point currentPos = new Point(0, 0);

        // part2
        Set<Point> visited = new HashSet<>();

        for (String command : commandList) {
            char cmdDirection = command.charAt(0);
            int  stepCount    = Integer.parseInt(command.substring(1));

            if (cmdDirection == 'L')
                direction = Math.floorMod(direction - 1, unitVectors.length);
            else
                direction = Math.floorMod(direction + 1, unitVectors.length);

            for (int i = 0; i < stepCount; i++) {
                currentPos = currentPos.add(unitVectors[direction]);

                if (isPart2 && visited.contains(currentPos)) {
                    return Math.abs(currentPos.x()) + Math.abs(currentPos.y());
                }
                visited.add(currentPos);
            }
        }
        return Math.abs(currentPos.x()) + Math.abs(currentPos.y());
    }

}
