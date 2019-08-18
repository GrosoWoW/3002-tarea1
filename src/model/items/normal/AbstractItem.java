package model.items.normal;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;
  protected boolean magic;
  protected String weak;
  protected String strong;


  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
    this.magic = false;
    this.strong = null;
    this.weak = null;
  }


  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }

  public IUnit getOwner() {
    return owner;
  }

  public String getName() {
    return name;
  }

  public int getPower() {
    return power;
  }

  public int getMinRange() {
    return minRange;
  }

  public int getMaxRange() {
    return maxRange;
  }

  public boolean isMagic() {
    return magic;
  }

  public String getStrong(){
    return strong;
  }

  public String getWeak(){
    return weak;
  }

}
