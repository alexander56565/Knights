package org.game;

public class Defender extends Warrior {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
    }

    public int getAttack() {
       return ATTACK;
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    protected void hitby(hasAttack attacker) {
        /*class WarriorProxy extends Warrior{
            public int getATTACK() {
                return Math.max(0,attacker.getATTACK() - getDefense());
            }
        }*/

        /*hasAttack proxy = new hasAttack() {
            public int getAttack() {
                return Math.max(0,attacker.getATTACK() - getDefense());
            }
        };*/

        //hasAttack proxy = () -> Math.max(0,attacker.getATTACK() - getDefense());


        super.hitby(() -> Math.max(0, attacker.getAttack() - getDefense()));
    }

}
