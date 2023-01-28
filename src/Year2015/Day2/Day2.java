package Year2015.Day2;

import shared.Constant;
import shared.InputData;

import java.util.List;

public class Day2 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day2/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day2/input.txt";

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int    total       = 0;
        double totalRibbon = 0;

        for (String line : input) {
            if (line.isEmpty()) {
                continue;
            }

            String[] lineInfo = line.split("x");
            int      l        = Integer.parseInt(lineInfo[0]);
            int      w        = Integer.parseInt(lineInfo[1]);
            int      h        = Integer.parseInt(lineInfo[2]);

            int lXw         = l * w;
            int wXh         = w * h;
            int hXl         = h * l;
            int surfaceArea = (2 * lXw) + (2 * wXh) + (2 * hXl);

            int extraPaper = Math.min(Math.min(lXw, wXh), hXl);

            total += (surfaceArea + extraPaper);

            System.out.println(line);
            System.out.println("(Part 1). " + (surfaceArea + extraPaper));

            // part 2
            double shorterDistance = shortestDistance(l, w, h);
            int    volume          = l * w * h;

            totalRibbon += (shorterDistance + volume);

            System.out.println("(Part 2). " + (shorterDistance + volume));

            System.out.println("*************************");

        }

        System.out.println("(Part 1). Total = " + total);
        System.out.println("(Part 2). Total = " + totalRibbon);
    }

    public static double shortestDistance(double length, double width, double height) {
        double lw = 2 * (length + width);
        double wh = 2 * (width + height);
        double hl = 2 * (height + length);
        return Math.min(Math.min(lw, wh), hl);
    }

}
