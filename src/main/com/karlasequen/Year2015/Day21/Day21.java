package com.karlasequen.Year2015.Day21;

import java.util.List;

public class Day21 {

    private static final List<ShopItem> weapons = List.of(new ShopItem(4, 8),
                                                          new ShopItem(5, 10),
                                                          new ShopItem(6, 25),
                                                          new ShopItem(7, 40),
                                                          new ShopItem(8, 74));
    private static final List<ShopItem> armor   = List.of(new ShopItem(0, 0),
                                                          new ShopItem(1, 13),
                                                          new ShopItem(2, 31),
                                                          new ShopItem(3, 53),
                                                          new ShopItem(4, 75),
                                                          new ShopItem(5, 102));
    private static final List<ShopItem> rings   = List.of(new ShopItem(0, 0),
                                                          new ShopItem(0, 0),
                                                          new ShopItem(1, 25),
                                                          new ShopItem(2, 50),
                                                          new ShopItem(3, 100),
                                                          new ShopItem(1, 20),
                                                          new ShopItem(2, 40),
                                                          new ShopItem(3, 80)
    );

    private static final int bossHitPoints = 109;
    private static final int bossDamage    = 8;
    private static final int bossArmor     = 2;

    private static final int playerHitPoints = 100;
    private static final int playerDamage    = 0;
    private static final int playerArmor     = 0;

    public static void main(String[] args) {

        System.out.println("(Part 1). " + part1());
        System.out.println("(Part 2). " + part2());

    }

    private static int part1() {
        int lowestGoldUsed = Integer.MAX_VALUE;
        for (ShopItem weapon : weapons) {
            for (ShopItem armorPiece : armor) {
                for (int i = 0; i < rings.size() - 1; i++) {
                    for (int j = i + 1; j < rings.size(); j++) {
                        int weaponPower = weapon.points;
                        int armorPower  = armorPiece.points;
                        if (i < 5) {
                            weaponPower += rings.get(i).points;
                        } else {
                            armorPower += rings.get(i).points;
                        }
                        if (j < 5) {
                            weaponPower += rings.get(j).points;
                        } else {
                            armorPower += rings.get(j).points;
                        }

                        int goldUsed = weapon.cost + armorPiece.cost + rings.get(i).cost + rings.get(j).cost;
                        Gamer player = new Gamer(playerHitPoints,
                                                 playerDamage + weaponPower,
                                                 playerArmor + armorPower);
                        Gamer enemy = new Gamer(bossHitPoints, bossDamage, bossArmor);
                        if (playerWins(player, enemy) && goldUsed < lowestGoldUsed) {
                            lowestGoldUsed = goldUsed;
                        }
                    }
                }
            }
        }

        return lowestGoldUsed;
    }

    private static boolean playerWins(Gamer player, Gamer enemy) {
        while (player.hitPoints > 0 && enemy.hitPoints > 0) {
            player.attack(enemy);
            if (enemy.hitPoints > 0)
                enemy.attack(player);
        }

        return player.hitPoints > 0;
    }

    private static int part2() {
        int highestGoldUsed = 0;
        for (ShopItem weapon : weapons) {
            for (ShopItem armorPiece : armor) {
                for (int i = 0; i < rings.size() - 1; i++) {
                    for (int j = i + 1; j < rings.size(); j++) {
                        int weaponPower = weapon.points;
                        int armorPower  = armorPiece.points;
                        if (i < 5) {
                            weaponPower += rings.get(i).points;
                        } else {
                            armorPower += rings.get(i).points;
                        }
                        if (j < 5) {
                            weaponPower += rings.get(j).points;
                        } else {
                            armorPower += rings.get(j).points;
                        }

                        int goldUsed = weapon.cost + armorPiece.cost + rings.get(i).cost + rings.get(j).cost;
                        Gamer player = new Gamer(playerHitPoints,
                                                 playerDamage + weaponPower,
                                                 playerArmor + armorPower);
                        Gamer enemy = new Gamer(bossHitPoints, bossDamage, bossArmor);
                        if (!playerWins(player, enemy) && goldUsed > highestGoldUsed) {
                            highestGoldUsed = goldUsed;
                        }
                    }
                }
            }
        }

        return highestGoldUsed;
    }

}
