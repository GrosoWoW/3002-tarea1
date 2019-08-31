package model.items.attack.magic;

import model.items.IEquipableItem;
import model.items.attack.magic.AbstractTestBook;
import model.map.Location;
import model.units.Fighter;

import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test set for Axes
 *
 * @author Cristobal Jaramillo Andrade
 * @since 1.0
 */
class DarkTest extends AbstractTestBook {

    private DarkBook dark;
    private DarkBook wrongDark;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common dark";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        dark = new DarkBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongDark = new DarkBook("Wrong dark", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongDark;
    }

    @Override
    public IEquipableItem getTestItem() {
        return dark;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    @Test
    public void damageTest(){

        double dañoFuerte = getTestItem().attack(new AnimaBook("Anima", 10, 0, 10) );
        double dañoDebil = getTestItem().attack(new LightBook("Light", 10, 0, 10));
        assertEquals(dañoFuerte, 10*1.5);
        assertEquals(dañoDebil, 10*1 - 20);


    }
}
