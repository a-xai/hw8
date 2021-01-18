package com.company.game.players;

import com.company.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, AbilityType.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(2) + 2;
        boss.setHealth(boss.getHealth() - getDamage() * coeff);
        System.out.println("Warrior hit with critical damage: " + getDamage() * coeff);
    }
}
