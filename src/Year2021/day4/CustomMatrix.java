package Year2021.day4;

import java.util.ArrayList;
import java.util.List;

public class CustomMatrix {

    List<List<Integer>> row      = new ArrayList<>(5);
    List<List<Boolean>> rowCheck = new ArrayList<>(5);

    public void printValues() {
        for (List<Integer> r : row) {
            String values = "";
            for (Integer n : r) {
                values += n + " ";
            }
            System.out.println(values);
        }
        System.out.println(" ");
    }

    public void printValuesCheck() {
        for (List<Boolean> r : rowCheck) {
            String values = "";
            for (Boolean n : r) {
                values += n + " ";
            }
            System.out.println(values);
        }
        System.out.println(" ");
    }

}
