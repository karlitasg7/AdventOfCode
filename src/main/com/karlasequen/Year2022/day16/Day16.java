package com.karlasequen.Year2022.day16;

import com.karlasequen.shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day16 {

    public static void main(String[] args) {
        try {

            File    inputFile = new File(Constant.BASE_PATH_2022 + "day16\\example.txt");
            Scanner myReader  = new Scanner(inputFile);

            List<Valve> valveList = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.isEmpty()) {
                    continue;
                }

                System.out.println(data);
                valveList.add(new Valve(data));

            }
            myReader.close();

            int pressure = 0;

            Valve currentValve = valveList.get(0);

            for (Valve v : valveList) {
                if (v.code.equals("AA")) {
                    currentValve = v;
                    break;
                }
            }

            boolean needOpen = false;

            if (currentValve.rate > 0) {
                needOpen = true;
            }

            String opened     = "";
            String codeBefore = "";

            for (int i = 1; i < 31; i++) {
                System.out.println("------------------------- Minut " + i + " -------------------------");
                System.out.println("Opened = " + opened + ".Pressure=" + pressure);

                if (currentValve.rate > 0 && needOpen) {
                    System.out.println("Open " + currentValve.code);
                    needOpen            = false;
                    pressure += currentValve.rate;
                    currentValve.isOpen = true;
                    opened += currentValve.code + ", ";

                } else {

                    String moveto = "";
                    for (String s : currentValve.items) {
                        if (!s.equals(codeBefore)) {
                            moveto = s;
                            break;
                        }
                    }

                    for (Valve v : valveList) {
                        if (Objects.equals(v.code, moveto)) {
                            System.out.println("Move to " + v.code);
                            currentValve = v;
                            break;
                        }
                    }

                    needOpen = true;
                }

            }

            System.out.println(pressure);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static Integer getRateFromValve(List<Valve> valveList, String code) {
        for (Valve v : valveList) {
            if (v.code.equals(code)) {
                return v.rate;
            }
        }

        return 0;
    }

}
