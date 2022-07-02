package org.game;

public class Vampire extends Warrior{
    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    public Vampire() {
        super(40);
    }

    @Override
    public void hits(Warrior defender) {
        int in = defender.getHealth();
        super.hits(defender);
        setHealth(getHealth()+(defender.getHealth()-in)*getVampirism()/100);
    }
}
