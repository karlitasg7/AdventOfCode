package Year2022.day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MultiRunner implements Runnable {

    private static int maxValue = 4_000_001;

    private final List<Sensor> sensorList;
    private final int          y;

    public MultiRunner(List<Sensor> sensorList, int y) {
        this.sensorList = sensorList;
        this.y          = y;
    }

    @Override
    public void run() {

        List<Sensor> sortedSensors = new ArrayList<>(sensorList);
        sortedSensors.sort(Comparator.comparingInt(a -> a.yDistance(y)));

        main2:
        for (int x = 0; x < maxValue; x++) {
            for (Sensor sensor : sortedSensors) {
                if (sensor.hasBeacon(x, y) || sensor.isShorterDistance(x, y)) {
                    continue main2;
                }
            }

            System.out.println(x + " x " + y);
            System.out.println(4000000 * x + y);

            if (y % 1000 == 0) {
                System.out.print(".");
            }
        }
    }

}
