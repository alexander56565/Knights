package org.game;

@FunctionalInterface
interface hasAttack{
    int getAttack();
}

public class Warrior implements Cloneable,hasAttack{
    private int health = 50;
    private static final int ATTACK = 5;

    @Override
    public Warrior clone()  {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        throw new IllegalStateException("Never get here");
    }

    public Warrior() {
    }

    protected Warrior(int initialHealth) {
        this.health = initialHealth;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void hits(Warrior defender) {
        defender.hitby(this);
    }

    protected void hitby(hasAttack attacker) {
     /*   System.out.printf("in health: %d ",getHealth());
        if(attacker.getATTACK()>getDefense()) {health += getDefense();
        health -= attacker.getATTACK();
        System.out.printf("def: %d att: %d health: %d\n",getDefense(),attacker.getATTACK(),getHealth());
        }*/

      setHealth(getHealth()-attacker.getAttack());

      System.out.printf(" att: %d health: %d\n",attacker.getAttack(),getHealth());
    }


}
