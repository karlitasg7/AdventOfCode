package Year2022.day15;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day15 {

    public static void main(String[] args) {
        try {

            List<Sensor> sensorList = new ArrayList<>();

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day15\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.isEmpty()) {
                    continue;
                }
                sensorList.add(new Sensor(data));

            }
            myReader.close();

            int minX = Integer.MAX_VALUE;
            int maxX = 0;
            for (Sensor sensor : sensorList) {
                minX = Math.min(sensor.minX(), minX);
                maxX = Math.max(sensor.maxX(), maxX);
            }

            int counter = 0;
            int y       = 2_000_000;

            main:
            for (int x = minX - 1; x < maxX + 1; x++) {
                for (Sensor sensor : sensorList) {
                    if (sensor.hasBeacon(x, y)) {
                        continue main;
                    }
                }

                for (Sensor sensor : sensorList) {
                    if (sensor.isShorterDistance(x, y)) {
                        counter++;
                        break;
                    }
                }
            }

            System.out.println(counter);

            ///////////////////////// part 2

            int maxValue = 4_000_000;

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int y1 = maxValue; y1 > -1; y1--) {
                executorService.submit(new MultiRunner(sensorList, y1));
            }

            executorService.wait();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
