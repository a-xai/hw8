package com.company.game.players;

public class Tank extends Hero {
    public Tank(int health, int damage) {
        super(health, damage,AbilityType.ACCEPT_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && this.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage() / 5);
            }

        }

    }
}
