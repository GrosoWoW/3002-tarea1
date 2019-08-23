package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


public class SorcererTest extends  AbstractTestUnit {

    private Sorcerer sorcerer;

    @Override
    public void setTestUnit() { sorcerer = new Sorcerer(50,2, field.getCell(0,0));}

    @Override
    public IUnit getTestUnit() { return sorcerer;}


    @Test
    public void equipBookTest() {

        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(anima);
        assertEquals(anima, sorcerer.getEquippedItem());
    }


}
