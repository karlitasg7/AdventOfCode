package com.karlasequen.Year2022.day15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor {

    private int x        = 0;
    private int y        = 0;
    private int distance = 0;

    private int beaconX = 0;
    private int beaconY = 0;

    private static final Pattern regex = Pattern.compile(
            "Sensor at x=([\\d-]+), y=([\\d-]+): closest beacon is at x=([\\d-]+), y=([\\d-]+)");

    public Sensor(String text) {
        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            x = Integer.parseInt(matcher.group(1));
            y = Integer.parseInt(matcher.group(2));

            beaconX = Integer.parseInt(matcher.group(3));
            beaconY = Integer.parseInt(matcher.group(4));

            distance = Math.abs(x - beaconX) + Math.abs(y - beaconY);

        }
    }

    public int minX() {
        return x - distance;
    }

    public int maxX() {
        return x + distance;
    }

    public boolean isShorterDistance(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y) <= distance;
    }

    public boolean hasBeacon(int x, int y) {
        return this.beaconX == x && this.beaconY == y;
    }

    public int yDistance(int y) {
        return Math.abs(this.y - y);
    }
}
