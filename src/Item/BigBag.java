/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */
public class BigBag extends Item {

    private String name;

    public BigBag() {
        name = "BigBag";
    }

    @Override
    public boolean equals(String namei) {
        if (name.equalsIgnoreCase(namei)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String ItemName() {
        return name;
    }

    @Override
    public void printItem() {
        System.out.println("BigBag");
    }

    /**
     *
     * @return 11
     */
    @Override
    public int determineItem() {
        return 11;

    }
    
}
