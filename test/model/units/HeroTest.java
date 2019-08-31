package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

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
    assertNull(hero.getEquippedItem());
    spear.equipItem(hero);
    assertEquals(spear, hero.getEquippedItem());
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
