package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }

  public void equipWeapon(IUnit unit){


  }

  @Override
  @Test
  public void testFailReceived(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    primero.addItem(getSword());
    primero.addItem(getSpear());
    primero.addItem(getAxe());
    segundo.addItem(getStaff());
    primero.receive(segundo, getStaff());
    assertFalse(segundo.getItems().contains(getStaff()));
    assertTrue(primero.getItems().contains(getStaff()));


  }

  @Override
  @Test
  public void testCombat(){

    IUnit primero = getTargetAlpaca();
    IUnit segundo = new Alpaca(1, 2, field.getCell(0, 0));
    primero.attackEnemy(segundo);
    assertTrue(segundo.getLive());




  }
}