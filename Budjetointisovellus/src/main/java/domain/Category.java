
package domain;

/**
 * Kategoriaa kuvaava olio
 * 
 */

public class Category {

    private String name;
    
    /**
     * Luokan konstruktori.
     * 
     * @param name kategorian nimi
     */
    public Category(String name) {
        this.name = name;
    }
    
    /**
     * Category-olion nimi.
     * 
     * @return palauttaa Category-olion nimen
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Category-olion esitys merkkijonona.
     * 
     * @return palauttaa kategorian nimen 
     */
    @Override
    public String toString() {
        return this.name;
    }
    
}
