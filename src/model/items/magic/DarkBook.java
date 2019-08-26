package model.items.magic;

import model.items.IEquipableItem;

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
        this.attack = true;
    }

    @Override
    public double attack(IEquipableItem item){

        return item.counterDark(this);


    }

    @Override
    public double counterLight(IEquipableItem item){

        return item.getPower()*1.5;
    }

    @Override
    public double counterAxe(IEquipableItem item){

        return item.getPower()*1.5;
    }

    @Override
    public double counterBow(IEquipableItem item){

        return item.getPower()*1.5;
    }

    @Override
    public double counterSpear(IEquipableItem item){

        return item.getPower()*1.5;
    }

    @Override
    public double counterSword(IEquipableItem item){

        return item.getPower()*1.5;
    }





}
