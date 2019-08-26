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

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(getStaff());
    assertEquals(getStaff(), getTestUnit().getEquippedItem());


    getTestUnit().equipItem(getBow());
    assertNotEquals(getBow(), getTestUnit().getEquippedItem());
    getTestUnit().equipItem(getAxe());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
    getTestUnit().equipItem(getSword());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getTestUnit().equipItem(getSpear());
    assertNotEquals(getTestUnit().getEquippedItem(), getSpear());
  }
}