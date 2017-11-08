/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */
public class Hawk extends Item {

    private String name;

    public Hawk() {
        name = "Hawk";
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
        System.out.println("Hawk");
    }

    /**
     *
     * @return 8
     */
    @Override
    public int determineItem() {
        return 8;

    }
    
}
