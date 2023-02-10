package com.karlasequen.Year2015.Day14;

public class ReindeerFly {

    private final String  name;
    private final Integer kms;
    private final Integer secondsToRun;
    private final Integer secondsToRest;

    public double distanceSoFar = 0;
    public int    points        = 0;

    public ReindeerFly(String text) {

        String[] textArray = text.split(" ");

        this.name          = textArray[0];
        this.kms           = Integer.parseInt(textArray[3]);
        this.secondsToRun  = Integer.parseInt(textArray[6]);
        this.secondsToRest = Integer.parseInt(textArray[13]);

    }

    public String getName() {
        return name;
    }

    public Integer getKms() {
        return kms;
    }

    public Integer getSecondsToRun() {
        return secondsToRun;
    }

    public Integer getSecondsToRest() {
        return secondsToRest;
    }

}
