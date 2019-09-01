package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SorcererTest extends  AbstractTestUnit {

    private Sorcerer sorcerer;

    @Override
    public void setTestUnit() { sorcerer = new Sorcerer(50,2, field.getCell(0,0));}

    @Override
    public IUnit getTestUnit() { return sorcerer;}

    public void equipWeapon(IUnit unit){

        getAnima().equipItem(unit);
    }


    @Test
    public void equipBookTest() {
        assertNull(getTestUnit().getEquippedItem());
        getAnima().equipItem(getTestUnit());
        assertEquals(getAnima(), getTestUnit().getEquippedItem());
        getLight().equipItem(getTestUnit());
        assertEquals(getLight(), getTestUnit().getEquippedItem());
        assertNotEquals(getAnima(), getTestUnit().getEquippedItem());
        getDark().equipItem(getTestUnit());
        assertEquals(getDark(), getTestUnit().getEquippedItem());



        getAxe().equipItem(getTestUnit());
        assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
        getSword().equipItem(getTestUnit());
        assertNotEquals(getTestUnit().getEquippedItem(), getSword());
        getStaff().equipItem(getTestUnit());
        assertNotEquals(getTestUnit().getEquippedItem(), getStaff());
        getSpear().equipItem(getTestUnit());
        assertNotEquals(getTestUnit().getEquippedItem(), getSpear());
        getBow().equipItem(getTestUnit());
        assertNotEquals(getTestUnit().getEquippedItem(), getBow());

    }


}
