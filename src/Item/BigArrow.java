/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */
public class BigArrow extends Weopen {

    private String name;

    public BigArrow() {
        name = "BigArrow";
    }

    @Override
    public String ItemName() {
        return name;
    }

    @Override
    public void printItem() {
        System.out.println("BigArrow");
    }

    @Override
    public int determineItem() {
        return 3;

    }

    public boolean equals(String namei) {
        if (name.equalsIgnoreCase(namei)) {
            return true;
        } else {
            return false;
        }
    }
    
}
