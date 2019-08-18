package model.units;

import model.items.IEquipableItem;
import model.items.magic.AbstractBook;
import model.items.magic.AnimaBook;
import model.map.Location;
import model.items.normal.Axe;

/**
 * This class represents a sorcerer type unit.
 * A sorcerer is a unit that can only use books type weapons.
 *
 * @author Cristobal Jaramillo
 * @since 1.0
 */

public class Sorcerer extends AbstractUnit {

    public Sorcerer(final int hitPoints, final int movement, final Location location,
                    IEquipableItem... items){
        super(hitPoints, movement, location,3, items);
    }

    /**
     *
     * @param item n
     *      the item to equip
     */

    @Override
    public void equipItem(final IEquipableItem item){
        if(item instanceof AbstractBook){
            equippedItem = item;
        }
    }


}
