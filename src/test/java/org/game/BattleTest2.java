package org.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BattleTest2 {


    @ParameterizedTest
    @DisplayName("Fight")
    @MethodSource("armyPair")
    void name(Supplier w1,Supplier w2,int q1, int q2, boolean efr)
    {
        var a1 = new Army();
        var a2 = new Army();

        a1.addUnits(w1, q1);
        a2.addUnits(w2, q2);

        var test = Battle.fight(a1, a2);

        assertEquals(efr,test);

    }

    static Stream<Arguments> armyPair ()
    {return Stream.of(
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,1,2,false),
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,2,3,false),
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,5,7,false),
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,20,21,true),
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,10,11,true),
            arguments((Supplier<Warrior>)Warrior::new,(Supplier<Warrior>)Warrior::new,11,7,true)

    );

    }

    @Test
    @DisplayName("Test1")
    void name1() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 1);
        army_2.addUnits(Warrior::new, 2);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test2")
    void name2() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 2);
        army_2.addUnits(Warrior::new, 3);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test3")
    void name3() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 5);
        army_2.addUnits(Warrior::new, 7);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test4")
    void name4() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 20);
        army_2.addUnits(Warrior::new, 21);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test5")
    void name5() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 10);
        army_2.addUnits(Warrior::new, 11);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test6")
    void name6() {

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 11);
        army_2.addUnits(Warrior::new, 7);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test7")
    void name7(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 5);
        army_1.addUnits(Defender::new, 4);
        army_2.addUnits(Defender::new, 5);
        army_2.addUnits(Warrior::new, 4);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test8")
    void name8(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 5);
        army_1.addUnits(Warrior::new, 20);
        army_2.addUnits(Warrior::new, 21);
        army_2.addUnits(Defender::new, 4);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test9")
    void name9(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Warrior::new, 10);
        army_1.addUnits(Defender::new, 5);
        army_2.addUnits(Warrior::new, 5);
        army_1.addUnits(Defender::new, 10);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test10")
    void name10(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 2);
        army_1.addUnits(Warrior::new, 1);
        army_1.addUnits(Defender::new, 1);
        army_2.addUnits(Warrior::new, 5);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test11")
    void name11(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 4);
        army_1.addUnits(Vampire::new, 6);
        army_1.addUnits(Warrior::new, 7);
        army_2.addUnits(Warrior::new, 6);
        army_2.addUnits(Defender::new, 6);
        army_2.addUnits(Vampire::new, 6);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test12")
    void name12(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 2);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Warrior::new, 4);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Vampire::new, 3);

        var test = Battle.fight(army_1, army_2);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test13")
    void name13(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 11);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Warrior::new, 4);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Vampire::new, 13);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test14")
    void name14(){

        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(Defender::new, 9);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Warrior::new, 8);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Vampire::new, 13);

        var test = Battle.fight(army_1, army_2);

        assertTrue(test);

    }


}