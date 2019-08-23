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
  private final double power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;
  protected boolean magic;
  protected String weak;
  protected String strong;
  protected boolean attack;


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
    this.attack = false;
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

  public double getPower() {
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

  public boolean isAttack(){
    return attack;
  }

  public boolean Strong(String item){

    if(this.getStrong() == item){
      return true;
    }
    return false;
  }

  public boolean Weak(String item){

    if(this.getWeak() == item){
      return true;
    }
    return false;
  }

  public void attack(IEquipableItem item){

  }

  public double counterSword(IEquipableItem item){

    return item.getPower();
  }

  public double counterAxe(IEquipableItem item){

    return item.getPower();
  }

  public double counterSpear(IEquipableItem item){

    return item.getPower();
  }

  public double counterBow(IEquipableItem item){

    return item.getPower();
  }

  public double counterAnima(IEquipableItem item){

    return item.getPower();
  }

  public double counterDark(IEquipableItem item){

    return item.getPower();
  }

  public double counterLight(IEquipableItem item){

    return item.getPower();
  }




}
