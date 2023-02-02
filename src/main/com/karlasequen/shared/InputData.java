package com.karlasequen.shared;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputData {

    public static List<String> get(String fileName) {
        List<String> list = new ArrayList<>();
        try {

            File file = new File("" + fileName);
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {
                    list.add(input.nextLine());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error on read input");
        }
        return list;
    }

}
