package model.items.attack;

import model.items.IEquipableItem;
import model.items.attack.normal.Axe;
import model.items.attack.normal.Spear;
import model.items.attack.normal.Sword;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for swords
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordTest extends AbstractTestItem {

  private Sword sword;
  private Sword wrongSword;
  private SwordMaster swordMaster;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common sword";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    sword = new Sword(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return sword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  @Test
  public void damageTest(){

    double dañoFuerte = getTestItem().attack(new Axe("Axe", 10, 0, 10) );
    double dañoDebil = getTestItem().attack(new Spear("Spear", 10, 0, 10));
    assertEquals(dañoFuerte, 10*1.5);
    assertEquals(dañoDebil, 10*1 - 20);


  }
}
