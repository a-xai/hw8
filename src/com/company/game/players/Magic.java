package com.company.game.players;

public class Magic extends Hero {
    private int boostPoints;

    public Magic(int health, int damage, int boostPoints) {
        super(health, damage, AbilityType.BOOST);
        this.boostPoints = boostPoints;
    }

    public int getBoostPoints() {
        return boostPoints;
    }

    public void setBoostPoints(int boostPoints) {
        this.boostPoints = boostPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && this.getHealth() > 0){
                boss.setHealth(boss.getHealth() - boostPoints);
        }

    }

}
}
