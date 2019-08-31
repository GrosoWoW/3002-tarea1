package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  public void equipWeapon(IUnit unit){


    getAxe().equipItem(unit);
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(fighter.getEquippedItem());
    axe.equipItem(fighter);
    assertEquals(axe, fighter.getEquippedItem());
  }

  @Test
  @Override
  public void testCombat(){

    IUnit unidad = getTestUnit();
    equipWeapon(unidad);
    assertEquals(getAxe().getPower()*1.5, unidad.getEquippedItem().attack(getSpear()));
    assertEquals(getAxe().getPower() - 20, unidad.getEquippedItem().attack(getSword()));
    assertEquals(getAxe().getPower(), unidad.getEquippedItem().attack(getStaff()));

  }
}