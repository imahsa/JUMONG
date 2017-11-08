/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Mahsa1
 */
public class Key extends Item {

    private String name;
    private int num;

    @Override
    public boolean equals(String namei) {
        if (name.equalsIgnoreCase(namei)) {
            return true;
        } else {
            return false;
        }
    }

    public Key() {
        name = "key";
    }
    
    public Key( int num){
        name = "key";
        this. num = num;
    }

    @Override
    public String ItemName() {
        return name;
    }
    
    public int getKeyNum(){
        return num;
    }
    @Override
    public void printItem() {
        System.out.println("Key");
    }

    /**
     *
     * @return 12
     */
    @Override
    public int determineItem() {
        return 12;

    }
    
}
