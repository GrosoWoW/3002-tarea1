package model.items;

import model.units.IUnit;

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
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

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
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * @return if the item is magic
   */
  boolean isMagic();

  /**
   * @return the item against who is strong
   */
  String getStrong();

  /**
   * @return the item against who is worse
   */

  String getWeak();

  /**
   *
   * @param item
   *       item to analyze
   * @return true if the item is strong against the entered parameter
   */

  boolean Strong(String item);

  /**
   *
   * @param item
   *      item to analyze
   * @return true if the item is worse against the entered parameter
   */

  boolean Weak(String item);

  boolean isAttack();
}
