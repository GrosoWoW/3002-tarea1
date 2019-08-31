package model.items;

import model.items.attack.magic.AnimaBook;
import model.units.IUnit;

import java.util.List;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {


  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  double getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  double counterAnima(IEquipableItem animaBook);

  double counterDark(IEquipableItem item);

  double counterLight(IEquipableItem item);

  double counterAxe(IEquipableItem item);

  double counterSpear(IEquipableItem item);

  double counterSword(IEquipableItem item);

  double counterBow(IEquipableItem item);

  double attack(IEquipableItem equippedItem);

  double counterStaff(IEquipableItem item);

  void equipItem(IUnit unit);

  void setOwner(IUnit unit);

}
