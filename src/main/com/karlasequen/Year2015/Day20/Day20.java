package com.karlasequen.Year2015.Day20;

import java.util.HashMap;
import java.util.Map;

public class Day20 {

    private static int number = 29_000_000;

    public static void main(String[] args) {
        int houseNumber = 1;
        while (numOfPresents(houseNumber) < number) {
            houseNumber++;
        }

        System.out.println("(Part 1). " + houseNumber);

        Map<Integer, Integer> houseNumberToDeliveries = new HashMap<>();
        houseNumber = 1;
        while (numOfPresents2(houseNumber, houseNumberToDeliveries) < number) {
            houseNumber++;
        }

        System.out.println("(Part 2). " + houseNumber);

    }

    private static long numOfPresents(int houseNumber) {
        long sum  = 0;
        int  root = (int) Math.sqrt(houseNumber);
        for (int i = 1; i <= root; i++) {
            if (houseNumber % i == 0) {
                if (houseNumber / i == i) {
                    sum += (10 * i);
                } else {
                    sum += (10 * i) + (10 * (houseNumber / i));
                }
            }
        }

        return sum;
    }

    private static long numOfPresents2(int houseNumber, Map<Integer, Integer> houseDeliveries) {
        long sum  = 0;
        int  root = (int) Math.sqrt(houseNumber);
        for (int i = 1; i <= root; i++) {
            if (houseNumber % i == 0) {
                houseDeliveries.putIfAbsent(i, 50);
                houseDeliveries.putIfAbsent(houseNumber / i, 50);
                if (houseNumber / i == i) {
                    if (houseDeliveries.get(i) > 0) {
                        sum += (11 * i);
                        houseDeliveries.put(i, houseDeliveries.get(i) - 1);
                    }

                } else {
                    if (houseDeliveries.get(i) > 0) {
                        sum += (11 * i);
                        houseDeliveries.put(i, houseDeliveries.get(i) - 1);
                    }
                    if (houseDeliveries.get(houseNumber / i) > 0) {
                        sum += (11 * (houseNumber / i));
                        houseDeliveries.put(houseNumber / i, houseDeliveries.get(houseNumber / i) - 1);
                    }
                }
            }
        }

        return sum;
    }

}
