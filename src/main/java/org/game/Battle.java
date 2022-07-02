package org.game;

public class Battle {

    public static boolean fight(Warrior A, Warrior B) {

        while (true) {
            A.hits(B);
            if (B.isAlive()) {
                B.hits(A);
                if (!(A.isAlive())) {
                    return false;
                }
            } else {
                return true;
            }
        }

    }

   /* public static boolean fight(Army A, Army B) {
       //Boolean turn = A.hits(B);
       // Boolean turn1;
        while (true) {
            if (!B.isAlive()) {
                return true;}
            if (!A.isAlive()) {
                return false;}
          A.hits(B);
      //      if(!turn)
      //      {turn = A.hits(B);}
      //      else
     //       {turn = !B.hits(A);}
        }
    } */

    public static boolean fight(Army A, Army B) {
        //Boolean turn = A.hits(B);
        // Boolean turn1;
        var it1 = A.firstAliveIterator();
        var it2 = B.firstAliveIterator();
        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();
    }
}


