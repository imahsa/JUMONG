/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */public class BigHealthPotion extends Item {

    private String name;

    public BigHealthPotion() {
        name = "BigHealthPotion";
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
        System.out.println("BigHealthPotion");
    }

    /**
     *
     * @return 5
     */
    @Override
    public int determineItem() {
        return 5;

    }
    
}
