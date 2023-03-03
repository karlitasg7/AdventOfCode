package com.karlasequen.Year2016.Day1;

public record Point(int x, int y) {

    public Point add(Point that) {
        return new Point(this.x + that.x, this.y + that.y);
    }
}
