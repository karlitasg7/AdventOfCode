package com.karlasequen.Year2015.Day14;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Day14 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day14/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day14/input.txt";

    public static void main(String[] args) {

        int totalDurationSeconds = 1000;
        if (FILE_NAME.contains("input.txt")) {
            totalDurationSeconds = 2503;
        }

        List<String> input = InputData.get(FILE_NAME);

        List<ReindeerFly> reindeerFlyList = new ArrayList<>();

        String winner      = null;
        double maxDistance = 0;

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            ReindeerFly reindeerFly = new ReindeerFly(line);
            reindeerFlyList.add(reindeerFly);

            double nbOfCycles      = (double) totalDurationSeconds / (reindeerFly.getSecondsToRun() + reindeerFly.getSecondsToRest());
            double nbOfSpeedCycles = Math.floor(nbOfCycles);
            if (nbOfCycles - nbOfSpeedCycles >= reindeerFly.getSecondsToRun().doubleValue() / (reindeerFly.getSecondsToRun() + reindeerFly.getSecondsToRest())) {
                nbOfSpeedCycles++;
            }
            double totalDistance = nbOfSpeedCycles * reindeerFly.getSecondsToRun() * reindeerFly.getKms();
            if (maxDistance < totalDistance) {
                winner      = reindeerFly.getName();
                maxDistance = totalDistance;
            }
        }

        System.out.println("(Part 1). " + winner + " Distance = " + maxDistance);

        for (int i = 0; i < totalDurationSeconds; i++) {
            for (ReindeerFly reindeer : reindeerFlyList) {
                if (i % (reindeer.getSecondsToRest() + reindeer.getSecondsToRun()) < reindeer.getSecondsToRun()) {
                    reindeer.distanceSoFar += reindeer.getKms();
                }
            }

            Optional<Double> max = reindeerFlyList
                    .stream()
                    .map(reindeer -> reindeer.distanceSoFar)
                    .max(Double::compareTo);

            max.ifPresent(aDouble ->
                                  reindeerFlyList
                                          .stream()
                                          .filter(reindeer -> reindeer.distanceSoFar == max.get())
                                          .forEach(reindeer -> reindeer.points++));
        }

        Optional<ReindeerFly> winnerReindeer = reindeerFlyList
                .stream()
                .max(Comparator.comparingDouble(o -> o.points));

        winnerReindeer
                .ifPresent(reindeer -> System.out.println("(Part 2). " + reindeer.getName() + " == " + reindeer.points + " points"));

    }

}
