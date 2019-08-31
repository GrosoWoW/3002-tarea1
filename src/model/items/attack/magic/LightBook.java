package model.items.attack.magic;

import model.items.IEquipableItem;
import model.items.attack.magic.AbstractBook;
import model.units.IUnit;

import java.util.List;

/**
 *  * This class represents a LightBook of the magic type
 *
 *
 *
 */

public class LightBook extends AbstractBook {

    /**
     * Creates a new LightBook
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

    public LightBook(final String name, final int power, final int minRange, final int maxRange){

        super(name, power, minRange, maxRange);
    }

    @Override
    public double attack(IEquipableItem item){

        return item.counterLight(this);


    }
    @Override
    public double counterDark(IEquipableItem item){

        return item.getPower() - 20;
    }

    @Override
    public double counterAnima(IEquipableItem item){

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
    @Override
    public void equipItem(IUnit unit){

        unit.equipLight(this);

    }




}