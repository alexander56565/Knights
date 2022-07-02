package org.game;

public class Main {
    public static void main(String[] args) {

        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();

        assert Battle.fight(chuck, bruce) == true;

        System.out.println("Hello");

    }
}
