package com.company.game.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility{
    private AbilityType abilityType;

    public Hero(int health, int damage, AbilityType abilityType) {
        super(health, damage);
        this.abilityType = abilityType;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }
}
