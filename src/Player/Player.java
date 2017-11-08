/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.ArrayList;
import Item.*;

/**
 *
 * @author Mahsa1
 */
public class Player {
    private int x, y;
    public int hit_points;
    private int energy;
    private int golds = 0;
    private int timeBagBigged = 0;
    private ArrayList<Item> bag;
    private ArrayList<Key> keyes;
    private int bag_size;
    private boolean isFireAUsed = false;

    public Player() {
        x = 0;
        y = 0;
        bag = new ArrayList<Item>();
        int i = 0;
        for (i = 0; i < 10; i++) {
            bag.add(new SmallArrow());
        }
        bag.add(new StoneBreaker());
        hit_points = 100;
        energy = 100;
        golds = 0;
        keyes = new ArrayList<Key>();
    }

    public int getHit_points() {
        return hit_points;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getBagSize() {
        return bag_size;
    }

    public void setBagSize() {
        bag_size = bag.size();
        bag_size += timeBagBigged * 10;
    }
public void setisFireAUsed( boolean used){
    isFireAUsed = used;
}
    public boolean getisFireAUsed(){
        return isFireAUsed;
    }
    public void bigBagSize() {
        timeBagBigged++;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEnergy() {
        return energy;
    }
    
    public int getGolds(){
        return golds;
    }

    public void hit(int enemy_number) {
        hit_points -= enemy_number * 10;
    }

    public void setGolds(int g) {
        golds += g;
    }

    public void setHit_points(int p) {
        hit_points += p;
        if (hit_points >= 100) {
            hit_points = 100;
        }
    }

    public void setEnergy() {
        energy += 10;
    }

    public void move() {
        setBagSize();
        if (getBagSize() < 37) {
            energy--;
        }
        if (getBagSize() >= 37) {
            energy -= 2;
        }
    }

    public boolean playerItemesHaveThisName(String name) {
        for (Item item : bag) {
            if (item.ItemName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        System.out.println("there is not" + name + " in your bag");
        return false;
    }

    public Item getPlayerItemeWithThisName(String name) {
        for (Item item : bag) {
            if (item.ItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void pick(Item item) {
        bag.add(item);
    }

    public void drop(String name) {
        if (playerItemesHaveThisName(name)) {
            bag.remove(getPlayerItemeWithThisName(name));
        }
    }

    public void use(String name) {
    }

    public int inventory( int  in ) {
        int sa = 0, fa = 0, ba = 0, shp = 0, bhp = 0, ep = 0, ha = 0, sho = 0, bb = 0, sb = 0, rs = 0, k = 0;
        for (Item item : bag) {
            if (item.equals("smallArrow")) {
                sa++;
            }
            if (item.equals("fireArrow")) {
                fa++;
            }
            if (item.equals("bigArrow")) {
                ba++;
            }
            if (item.equals("smallHealthPotion")) {
                shp++;
            }
            if (item.equals("bigHealthPotion")) {
                bhp++;
            }
            if (item.equals("EnergyPotion")) {
                ep++;
            }
            if (item.equals("hawk")) {
                ha++;
            }
            if (item.equals("shovel")) {
                sho++;
            }
            if (item.equals("bigBag")) {
                bb++;
            }
            if (item.equals("stoneBreaker")) {
                sb++;
            }
            if (item.equals("reviveScroll")) {
                rs++;
            }
            if (item.equals("key")) {
                k++;
            }
        }


        if ( in == 1) {
            return sa;
        }
        if ( in == 2) {
            return fa;
        }
        if ( in == 3) {
           return ba;
        }
        if ( in == 4) {
          return shp;
        }
        if ( in == 5) {
            return bhp;
        }
        if ( in == 6) {
            return ep;
        }
        if (in == 7) {
            return ha;
        }
        if ( in == 8) {
            return sho;
        }
        if (in == 9) {
            return sb;
        }
        if (in == 10) {
            return rs;
        }
        if (in == 11) {
            return bb;
        }
        if (in == 12) {
          return k;
        }
        return  445;
    }

    public void status() {
        System.out.println("Your hit_points" + getHit_points());
        System.out.println("Your energy" + getEnergy());
    }
    
    public void setKey( Key key){
        keyes.add(key);
    }
    public ArrayList<Key> getKeyes(){
        return keyes;
    }
}
