/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */
public class SmallArrow extends Weopen {

    private String name;

    public SmallArrow() {
        name = "SmallArrow";
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
        System.out.println("SmallArrow");
    }

    /**
     *
     * @return 1
     */
    @Override
    public int determineItem() {
        return 1;

    }
    
}
