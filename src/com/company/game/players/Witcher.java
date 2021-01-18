package com.company.game.players;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage, AbilityType.ARISE);
    }

    /*Добавить еще игрока Witcher, не наносит урон боссу, но получает урон от босса.
    Имеет 1 шанс оживить первого погибшего героя, отдав ему свою жизнь, при этом погибает сам.
     */
    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && boss.getHealth() > 0 && this.getHealth() > 0) {
            heroes[i].setHealth(this.getHealth());
            this.setHealth(0);
                System.out.println("Witcher gave his live to: " + heroes[i].getClass().getSimpleName());
            }

        }

    }
}
