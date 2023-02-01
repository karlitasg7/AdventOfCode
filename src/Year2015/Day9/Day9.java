package Year2015.Day9;

import shared.Constant;
import shared.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9 {

    // private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day9/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day9/input.txt";

    protected static Map<String, HashMap<String, Integer>> citiesMap = new HashMap<>();

    public static void main(String[] args) {
        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            String[] linePart = line.split(" ");

            String city1    = linePart[0];
            String city2    = linePart[2];
            int    distance = Integer.parseInt(linePart[4]);

            addToMap(city1, city2, distance);
            addToMap(city2, city1, distance);

        }

        System.out.println("Part 1. " + getShortestRoute());
        System.out.println("Part 2. " + getLongestRoute());
    }

    private static void addToMap(String city1, String city2, int distance) {
        if (!citiesMap.containsKey(city1)) {
            citiesMap.put(city1, new HashMap<>());
        }

        citiesMap.get(city1).put(city2, distance);
    }

    public static int getShortestRoute() {
        return getAllRoutes()
                .stream()
                .min(Integer::compare)
                .get();
    }

    public static int getLongestRoute() {
        return getAllRoutes()
                .stream()
                .max(Integer::compare)
                .get();
    }

    private static List<Integer> getAllRoutes() {
        List<String>  cities                    = new ArrayList<>(citiesMap.keySet());
        List<List<?>> allRoutesThroughTheCities = ListPermutation.getAll(cities);
        List<Integer> allRouteLengths           = getRouteLengths(allRoutesThroughTheCities);
        return allRouteLengths;
    }

    private static List<Integer> getRouteLengths(List<List<?>> allRoutes) {
        List<Integer> result = new ArrayList<>();
        for (List<?> aRoute : allRoutes) {
            int routeLength = 0;
            for (int i = 0; i < aRoute.size() - 1; i++) {
                routeLength += getDistanceBetweenCities(aRoute.get(i).toString(), aRoute.get(i + 1).toString());
            }
            result.add(routeLength);
        }
        return result;
    }

    private static int getDistanceBetweenCities(String city1, String city2) {
        return citiesMap.get(city1).get(city2);
    }

}
