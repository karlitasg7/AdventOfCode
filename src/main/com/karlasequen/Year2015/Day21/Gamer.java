package com.karlasequen.Year2015.Day21;

public class Gamer {

    public int hitPoints;
    public int attack;
    public int armor;

    public Gamer(int hitPoints, int attack, int armor) {
        this.hitPoints = hitPoints;
        this.attack    = attack;
        this.armor     = armor;
    }

    public void attack(Gamer target) {
        int damage = Math.max(1, this.attack - target.armor);
        target.hitPoints -= damage;
    }

}
