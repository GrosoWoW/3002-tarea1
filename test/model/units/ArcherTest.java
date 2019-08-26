package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(getBow());
    assertEquals(getBow(), getTestUnit().getEquippedItem());


    getTestUnit().equipItem(getAxe());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
    getTestUnit().equipItem(getSword());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getTestUnit().equipItem(getStaff());
    assertNotEquals(getTestUnit().getEquippedItem(), getStaff());


  }
}