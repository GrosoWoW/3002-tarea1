package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  public void equipWeapon(IUnit unit) {


    getStaff().equipItem(unit);
  }

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(getTestUnit().getEquippedItem());
    getStaff().equipItem(getTestUnit());
    assertEquals(getStaff(), getTestUnit().getEquippedItem());

    getBow().equipItem(getTestUnit());
    assertNotEquals(getBow(), getTestUnit().getEquippedItem());
    getAxe().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
    getSword().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getSpear().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSpear());
    getAnima().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAnima());
    getDark().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getDark());
    getLight().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getLight());
  }

  @Test
  @Override
  public void testCombat() {

    IUnit primero = getTestUnit();
    IUnit segundo = new Cleric(1, 2, field.getCell(0, 0));
    primero.attackEnemy(segundo);
    assertTrue(segundo.getLive());
  }
}
