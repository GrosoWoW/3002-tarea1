package model.items.attack.normal;

import model.items.IEquipableItem;
import model.items.attack.normal.AbstractAttack;
import model.units.IUnit;

import java.util.List;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Spear extends AbstractAttack {



  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }


  @Override
  public double attack(IEquipableItem item){

    return item.counterSpear(this);

  }

  @Override
  public double counterAxe(IEquipableItem item){

    return item.getPower()*1.5;
  }

  @Override
  public double counterSword(IEquipableItem item){

    return item.getPower() -20;
  }

  @Override
  public double counterAnima(IEquipableItem item){

    return item.getPower()*1.5;
  }

  @Override
  public double counterDark(IEquipableItem item){

    return item.getPower()*1.5;
  }

  @Override
  public double counterLight(IEquipableItem item){

    return item.getPower()*1.5;
  }
  @Override
  public void equipItem(IUnit unit){

    unit.equipSpear(this);

  }



}
