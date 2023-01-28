package Year2015.Day8;

import shared.Constant;
import shared.InputData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Day8 {

    // private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day8/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day8/input.txt";

    static Function<String, String> removeStartingQuotes                  = s -> s.replaceAll("^\"", "");
    static Function<String, String> removeEndingQuotes                    = s -> s.replaceAll("\"$", "");
    static Function<String, String> replaceBackSlashWithAt                = s -> s.replaceAll("\\\\", "@");
    static Function<String, String> replaceBackSlashAtWithExclamationMark = s -> s.replaceAll("@\\\"", "!");
    static Function<String, String> replaceDoubleAtWithPound              = s -> s.replaceAll("@@", "#");
    static Function<String, String> replaceHexWithPercentageSign          = s -> s.replaceAll("@x..", "%");
    static Function<String, String> convertToInMemoryStringEquivalent     = removeStartingQuotes
            .andThen(removeEndingQuotes)
            .andThen(replaceBackSlashWithAt)
            .andThen(replaceBackSlashAtWithExclamationMark)
            .andThen(replaceDoubleAtWithPound)
            .andThen(replaceHexWithPercentageSign);

    static Function<String, String> encodeStartingQuotes           = s -> s.replaceAll("^\"", "!@!");
    static Function<String, String> encodeEndingQuotes             = s -> s.replaceAll("\"$", "!@!");
    static Function<String, String> encodeBackSlash                = s -> s.replaceAll("\\\\", "@@");
    static Function<String, String> encodeQuotes                   = s -> s.replaceAll("\"", "@!");
    static Function<String, String> convertToEncodedTextEquivalent = encodeStartingQuotes
            .andThen(encodeEndingQuotes)
            .andThen(encodeBackSlash)
            .andThen(encodeQuotes);

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        int totalCharCode = 0;
        for (String line : input) {
            totalCharCode += line.length();
        }

        int totalMemory = countChars(input.stream(), convertToInMemoryStringEquivalent);

        System.out.println("Part 1 = " + (totalCharCode - totalMemory));

        int totalEncodedChars = countChars(input.stream(), convertToEncodedTextEquivalent);

        System.out.println("Part 2 Difference: " + (totalEncodedChars - totalCharCode));

    }

    static int countChars(Stream<String> stringStream, Function<String, String> stringMapper) {
        return stringStream
                .map(stringMapper)
                .mapToInt(String::length)
                .sum();
    }

}
