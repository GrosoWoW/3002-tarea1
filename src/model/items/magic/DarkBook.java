package model.items.magic;

import model.items.magic.AbstractBook;

/**
 *  * This class represents a DarkBook of the magic type
 *
 *
 *
 */

public class DarkBook extends AbstractBook {

    /**
     * Creates a new DarkBook
     *
     * @param name
     *      the name that identifies the weapon
     * @param power
     *      the base damage pf the weapon
     * @param minRange
     *      the minimum range of the weapon
     * @param maxRange
     *       the maximum range of the weapon
     */

    public DarkBook(final String name, final int power, final int minRange, final int maxRange){

        super(name, power, minRange, maxRange);
        this.strong = "AnimaBook";
        this.weak = "LightBook";
        this.attack = true;
    }


}
