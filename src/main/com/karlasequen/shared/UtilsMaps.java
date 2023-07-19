package com.karlasequen.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilsMaps {

    public static List<Map.Entry<Character, Integer>> sortByFrequency(Map<Character, Integer> mapEntry) {
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(mapEntry.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int compare = entry2.getValue().compareTo(entry1.getValue());
            return compare != 0 ? compare : entry1.getKey().compareTo(entry2.getKey());
        });

        return sortedEntries;
    }

    public static List<Map.Entry<Character, Integer>> sortByFrequencyDesc(Map<Character, Integer> mapEntry) {
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(mapEntry.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int compare = entry1.getValue().compareTo(entry2.getValue());
            return compare != 0 ? compare : entry2.getKey().compareTo(entry1.getKey());
        });

        return sortedEntries;
    }

}
