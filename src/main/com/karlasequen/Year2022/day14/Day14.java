package com.karlasequen.Year2022.day14;

import com.karlasequen.shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day14 {

    private static String INPUT = "";

    private static final char WALL = '#';
    private static final char SAND = 'o';

    public static void main(String[] args) {
        try {

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day14\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                INPUT += data + "\n";

            }
            myReader.close();

            var cave   = readCave();
            var bounds = Boundaries.findBoundaries(cave.keySet());
            System.out.println(part1(cave, bounds));
            System.out.println(part2(cave, bounds.maxY() + 1));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static long part1(Map<Coord, Character> cave, Boundaries bounds) {
        var source  = new Coord(500, 0);
        var changed = false;
        do {
            changed = fallWithBounds(cave, bounds, source);
        } while (changed);
        return cave.values().stream().filter(v -> v.charValue() == SAND).count();
    }

    private static long part2(Map<Coord, Character> cave, int lastFloor) {
        var source = new Coord(500, 0);
        while (!cave.containsKey(source)) {
            fallWithFloor(source, cave, lastFloor);
        }
        return cave.values().stream().filter(v -> v.charValue() == SAND).count();
    }

    private static boolean fallWithBounds(Map<Coord, Character> cave, Boundaries bounds, Coord source) {
        var sand = source;
        while (!cave.containsKey(sand) && bounds.inBounds(sand.x(), sand.y())) {
            var next = fallToNext(cave, sand);
            if (cave.containsKey(next)) {
                cave.put(sand, SAND);
                return true;
            } else {
                sand = next;
            }
        }
        return false;
    }

    private static void fallWithFloor(Coord source, Map<Coord, Character> cave, int lastFloor) {
        var sand = source;
        while (!cave.containsKey(sand)) {
            var next = fallToNext(cave, sand);
            if (cave.containsKey(next) || next.y() > lastFloor) {
                cave.put(sand, SAND);
            } else {
                sand = next;
            }
        }
    }

    private static Coord fallToNext(Map<Coord, Character> cave, Coord sand) {
        var next = sand.fall();
        if (cave.containsKey(next)) {
            next = sand.fallLeft();
            if (cave.containsKey(next)) {
                next = sand.fallRight();
            }
        }
        return next;
    }

    private static Map<Coord, Character> readCave() {
        var cave = new HashMap<Coord, Character>();
        INPUT.lines().map(line -> line.split(" -> ")).map(Day14::mapToCoordList).forEach(list -> {
            var prev = list.get(0);
            for (var i = 1; i < list.size(); ++i) {
                var next = list.get(i);
                if (prev.x() == next.x()) {
                    var x     = prev.x();
                    var fromY = Math.min(prev.y(), next.y());
                    var toY   = Math.max(prev.y(), next.y());
                    for (var y = fromY; y <= toY; ++y) {
                        cave.put(new Coord(x, y), WALL);
                    }
                } else {
                    var y     = prev.y();
                    var fromX = Math.min(prev.x(), next.x());
                    var toX   = Math.max(prev.x(), next.x());
                    for (var x = fromX; x <= toX; ++x) {
                        cave.put(new Coord(x, y), WALL);
                    }
                }
                prev = next;
            }
        });
        return cave;
    }

    private record Coord(int x, int y) {
        Coord fall() {
            return new Coord(x, y + 1);
        }

        Coord fallLeft() {
            return new Coord(x - 1, y + 1);
        }

        Coord fallRight() {
            return new Coord(x + 1, y + 1);
        }

        static Coord parse(String desc) {
            var xy = desc.split(",");
            return new Coord(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        }
    }

    private static List<Coord> mapToCoordList(String[] coordDescs) {
        return Arrays.stream(coordDescs).map(Coord::parse).toList();
    }

    private record Boundaries(int minX, int maxX, int minY, int maxY) {
        boolean inBounds(int x, int y) {
            return minX <= x && x <= maxX && y <= maxY;
        }

        static Boundaries findBoundaries(Set<Coord> coords) {
            var minX = Integer.MAX_VALUE;
            var maxX = Integer.MIN_VALUE;
            var maxY = Integer.MIN_VALUE;
            var minY = Integer.MAX_VALUE;
            for (var coord : coords) {
                if (coord.x() < minX) {
                    minX = coord.x();
                }
                if (coord.x() > maxX) {
                    maxX = coord.x();
                }
                if (coord.y() > maxY) {
                    maxY = coord.y();
                }
                if (coord.y() < minY) {
                    minY = coord.y();
                }
            }
            return new Boundaries(minX, maxX, minY, maxY);
        }
    }

}
