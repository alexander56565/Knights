package org.game;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior>{
       ArrayList<Warrior> troops = new ArrayList<>();
   /* public void addUnits(Class<? extends Warrior> clazz,int quantity)
    {
        for(int i=0;i<quantity;i++)
        {try {
            var constructor = clazz.getDeclaredConstructor();
            Warrior warrior = constructor.newInstance();
            troops.add(warrior);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        }
    }*/
    public void addUnits(Supplier<Warrior> factory, int quantity)
    {
        for(int i=0;i<quantity;i++)
        {
         troops.add(factory.get());
        }
    }


     public Warrior getFirst()
     {return troops.iterator().next();}

     public void removeFirst()
     {troops.remove(troops.iterator().next());}

     boolean isAlive() {return troops.size() > 0;}

      public boolean hits(Army defender) {
        return defender.hitby(this);
    }

    private boolean hitby(Army attacker) {
        Warrior A = attacker.getFirst();
        Warrior B = getFirst();
        if(Battle.fight(A,B))
        { removeFirst(); return false;}
        else { attacker.removeFirst(); return true;}
    }

    @Override
    public Iterator<Warrior> iterator() {
        return new WarriorIterator();
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }

    class FirstAliveIterator implements Iterator<Warrior> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
           while (cursor < troops.size() && !troops.get(cursor).isAlive())
           {cursor++;}
           return cursor< troops.size();
        }

        @Override
        public Warrior next() {
            if(!hasNext())
            {throw new NoSuchElementException();
            }
            return troops.get(cursor);
        }
    }

    class WarriorIterator implements Iterator<Warrior> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            while (cursor < troops.size() && !troops.get(cursor).isAlive())
            {cursor++;}
            return cursor< troops.size();
        }

        @Override
        public Warrior next() {
            if(!hasNext())
            {throw new NoSuchElementException();
            }
            return troops.get(cursor++);
        }
    }

     /* public void addUnits(Warrior prototype, int quantity)
    {
        for(int i=0;i<quantity;i++)
        {
         troops.add(prototype.clone());
        }
    }*/

}
