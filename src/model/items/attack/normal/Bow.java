package model.items.attack.normal;

import model.items.IEquipableItem;
import model.items.attack.normal.AbstractAttack;

/**
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractAttack {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
    this.attack = true;
  }

  @Override
  public double attack(IEquipableItem item){

    return item.counterBow(this);

  }

  public double counterBow(IEquipableItem item){

    return item.getPower();
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



}
