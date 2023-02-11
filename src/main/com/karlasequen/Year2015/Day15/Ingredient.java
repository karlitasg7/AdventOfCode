package com.karlasequen.Year2015.Day15;

public class Ingredient {

    public final String name;
    public final int    capacity;
    public final int    durability;
    public final int    flavor;
    public final int    texture;
    public final int    calories;

    public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name       = name;
        this.capacity   = capacity;
        this.durability = durability;
        this.flavor     = flavor;
        this.texture    = texture;
        this.calories   = calories;
    }

}
