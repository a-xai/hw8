package com.company.game.general;

import com.company.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1900, 50);
        Warrior warrior = new Warrior(270, 10);
        Medic doctor = new Medic(230, 5, 15);
        Berserk berserk = new Berserk(260, 15);
        Magic magic = new Magic(250, 20, 5);
        Medic assistant = new Medic(280, 10, 5);
        Tank tank = new Tank(300, 5);
        Witcher witcher = new Witcher(270, 10);
        Aurora aurora = new Aurora(150, 0, 2);

        Hero[] heroes = {warrior, doctor, berserk, magic, assistant, tank, witcher, aurora};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHits(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);


    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("________________");
        System.out.println("Boss's health: " + boss.getHealth() + "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + "'s health: " + heroes[i].getHealth() + "[" + heroes[i].getDamage() + "]");
        }
        System.out.println("________________");
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {

            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }
}
