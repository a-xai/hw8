package com.company.game.players;

public class Aurora extends Hero {
    private int invisibleTime;

    public int getInvisibleTime() {
        return invisibleTime;
    }

    public Aurora(int health, int damage, int invisibleTime) {
        super(health, damage, AbilityType.INVISIBLE);
        this.invisibleTime = invisibleTime;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 && invisibleTime != 0) {
            this.setHealth(this.getHealth() + 20);
            invisibleTime--;
            System.out.println("Aurora in the invisibility!");
        }
        if (invisibleTime == 0) {
            this.setDamage(boss.getDamage() * 2);
        }

    }
}
