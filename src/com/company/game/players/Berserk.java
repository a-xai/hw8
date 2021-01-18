package com.company.game.players;

import com.company.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, AbilityType.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(18) + 2;
        boss.setHealth(boss.getHealth() - coeff);
        System.out.println("Berserk save damage and revert: " + (this.getDamage() + coeff));

    }
}
