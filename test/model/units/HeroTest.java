package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  public void equipWeapon(IUnit unit){

    getSpear().equipItem(unit);
  }

  @Override
  @Test
  public void equipSpearTest() {
    assertNull(getTestUnit().getEquippedItem());
    getSpear().equipItem(getTestUnit());
    assertEquals(getSpear(), getTestUnit().getEquippedItem());


    getAxe().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
    getSword().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getStaff().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getStaff());
    getAnima().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAnima());
    getDark().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getDark());
    getLight().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getLight());
  }

  @Override
  @Test
  public void testCombat(){

    IUnit primero = getTestUnit();
    equipWeapon(primero);
    IUnit segundo = new Hero(1, 2, field.getCell(1, 0));
    equipWeapon(segundo);
    primero.attackEnemy(segundo);
    assertFalse(segundo.getLive());

    IUnit unidad = getTestUnit();
    equipWeapon(unidad);
    assertEquals(getSpear().getPower()*1.5, unidad.getEquippedItem().attack(getSword()));
    assertEquals(getSpear().getPower() - 20, unidad.getEquippedItem().attack(getAxe()));
    assertEquals(getSpear().getPower(), unidad.getEquippedItem().attack(getStaff()));
    }








  }
