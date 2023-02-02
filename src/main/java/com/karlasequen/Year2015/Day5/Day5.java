package com.karlasequen.Year2015.Day5;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day5/sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day5/input.txt";

    private static final Predicate<String> containsAtLeastThreeVowels = (str) -> {
        Pattern containsAtLeastThreeVowelsPattern = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");
        Matcher matcher                           = containsAtLeastThreeVowelsPattern.matcher(str);
        return (matcher.find());
    };

    private static final Predicate<String> containsRepeatingLetters = (str) -> {
        Pattern containsRepeatingLettersPattern = Pattern.compile("(.)\\1");
        Matcher matcher                         = containsRepeatingLettersPattern.matcher(str);
        return matcher.find();
    };

    private static final Predicate<String> doesNotContainAbCdPqXy = (str) -> {
        Pattern doesNotContainSpecialCombinationPattern = Pattern.compile("(ab|cd|pq|xy)");
        Matcher matcher                                 = doesNotContainSpecialCombinationPattern.matcher(str);
        return !(matcher.find());
    };

    private static final Predicate<String> rulesNiceString = (str) -> containsAtLeastThreeVowels
            .and(containsRepeatingLetters)
            .and(doesNotContainAbCdPqXy)
            .test(str);

    private static final Predicate<String> containsRepeatingPairOfLetters = (str) -> {
        Pattern containsRepeatingPairOfLettersPattern = Pattern.compile("((.)(.)).*\\1");
        Matcher matcher                               = containsRepeatingPairOfLettersPattern.matcher(str);
        return matcher.find();
    };

    private static final Predicate<String> containsRepeatingLettersWithAnotherInBetween = (str) -> {
        Pattern containsRepeatingLettersWithAnotherInBetweenPattern = Pattern.compile("(.).\\1");
        Matcher matcher = containsRepeatingLettersWithAnotherInBetweenPattern.matcher(
                str);
        return matcher.find();
    };

    private static final Predicate<String> rulesPart2 = (str) -> containsRepeatingPairOfLetters
            .and(containsRepeatingLettersWithAnotherInBetween)
            .test(str);

    public static void main(String[] args) {

        List<String> input = InputData.get(FILE_NAME);

        long quantity = input.stream()
                .filter(s -> !s.isBlank())
                .filter(rulesNiceString)
                .count();

        System.out.println("(Part 1). " + quantity);

        long quantityPart2 = input.stream()
                .filter(s -> !s.isBlank())
                .filter(rulesPart2)
                .count();

        System.out.println("(Part 2). " + quantityPart2);

    }

}
