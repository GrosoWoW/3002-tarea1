package model.items.magic;

import model.items.IEquipableItem;
import model.items.normal.Spear;
import model.items.normal.Sword;
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
class AnimaTest extends AbstractTestBook {

    private AnimaBook anima;
    private AnimaBook wrongAnima;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common anima";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        anima = new AnimaBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongAnima = new AnimaBook("Wrong axe", 0, -1, -2);
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
        return wrongAnima;
    }

    @Override
    public IEquipableItem getTestItem() {
        return anima;
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

        double dañoFuerte = getTestItem().attack(new LightBook("Light", 10, 0, 10) );
        double dañoDebil = getTestItem().attack(new DarkBook("Dark", 10, 0, 10));
        assertEquals(dañoFuerte, 10*1.5);
        assertEquals(dañoDebil, 10*1);


    }
}
