package org.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BattleTest {

    @Test
    @DisplayName("Smoke test")
    void nameD1() {

       // if(true) throw new IllegalStateException();

        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        var res1 = Battle.fight(chuck, bruce);
        var res2 = Battle.fight(dave, carl);

        assertTrue(res1);
        assertFalse(res2);
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());


    }

    @ParameterizedTest
    @DisplayName("Fight")
    @MethodSource("warriorPair")
    void name(Warrior w1, Warrior w2, boolean efr)
    {
      var test = Battle.fight(w1,w2);
      assertEquals( test,efr);
    }

    static Stream<Arguments> warriorPair ()
    {return Stream.of(
            arguments(new Warrior(),new Knight(),false),
            arguments(new Knight(),new Warrior(),true),
            arguments(new Warrior(),new Warrior(),true),
            arguments(new Knight(),new Knight(),true)

    );

    }



    @Test
    @DisplayName("Test1")
    void name1() {

        var carl = new Warrior();
        var jim = new Knight();

        var test = Battle.fight(carl, jim);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test2")
    void name2() {


        var slevin = new Warrior();
        var ramon = new Knight();

        var test = Battle.fight(ramon, slevin);

        assertTrue(test);

    }

    @Test
    @DisplayName("Test3")
    void name3() {

        var bob = new Warrior();
        var mars = new Warrior();

        var test = Battle.fight(bob, mars);

        assertTrue(bob.isAlive());

    }

    @Test
    @DisplayName("Test4")
    void name4() {

        var godkiller = new Warrior();
        var zeus = new Knight();

        var test = Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());

    }

    @Test
    @DisplayName("Test5")
    void name5() {

        var  husband = new Warrior();
        var wife = new Warrior();

        var test = Battle.fight(husband, wife);

        assertFalse(wife.isAlive());

    }

    @Test
    @DisplayName("Test6")
    void name6() {

        var dragon = new Warrior();
        var knight = new Knight();

        var test = Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());

    }

    @Test
    @DisplayName("Test7")
    void name7() {

        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var test = Battle.fight(unit_2, unit_3);

        assertFalse(test);

    }

    @Test
    @DisplayName("Test8")
    void name8() {

        var unit_1 = new Defender();
        var unit_2 = new Rookie();

        Battle.fight(unit_1, unit_2);


        assertEquals(60,unit_1.getHealth());

    }

    @Test
    @DisplayName("Test9")
    void name9() {

        var unit_1 = new Defender();
        var unit_2 = new Rookie();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var test = Battle.fight(unit_1, unit_3);

        assertTrue(test);

    }


}