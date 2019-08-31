package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  public void equipWeapon(IUnit unit){

    getSword().equipItem(unit);
  }

  @Override
  public void equipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    sword.equipItem(swordMaster);
    assertEquals(sword, swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void testCombat(){

    IUnit unidad = getTestUnit();
    equipWeapon(unidad);
    assertEquals(getSword().getPower()*1.5, unidad.getEquippedItem().attack(getAxe()));
    assertEquals(getSword().getPower() - 20, unidad.getEquippedItem().attack(getSpear()));
    assertEquals(getSword().getPower(), unidad.getEquippedItem().attack(getStaff()));
  }
}