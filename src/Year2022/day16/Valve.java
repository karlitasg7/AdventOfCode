package Year2022.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valve {

    String       code;
    Integer      rate;
    Boolean      isOpen;
    List<String> items = new ArrayList<>();

    private static final Pattern regex = Pattern.compile(
            "Valve ([A-Z]+) has flow rate=([\\d-]+); tunnel([s]?) lead([s]?) to valve([s]?) ([A-Z,\\s]+)");

    public Valve(String text) {
        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            code = matcher.group(1);
            rate = Integer.parseInt(matcher.group(2));

            String list = matcher.group(6);

            items.addAll(Arrays.asList(list.replace(" ", "").split(",")));

        }
    }

}
