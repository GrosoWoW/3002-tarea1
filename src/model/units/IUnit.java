package model.units;

import java.util.List;
import model.items.IEquipableItem;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.Axe;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */


  /**
   * @return hit points of the unit
   */
  double getCurrentHitPoints();

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */

  void moveTo(Location targetLocation);

  /**
   *
   * @return the maximum number of items
   */

  int getMaxItems();

  /**
   * add an item to the inventory
   *
   * @param item
   *        the item to add
   */

  void addItem(IEquipableItem item);

  /**
   * Remove an item from the inventory
   *
   * @param item
   *       the item to be removed
   */

  void removeItem(IEquipableItem item);

  /**
   * is responsible for an exchange
   *
   * @param unit
   *      the unit with whom it will trade
   * @param received
   *      the item that will be received
   * @param delivered
   *      the item that will be delivered
   */

  void trade(IUnit unit, IEquipableItem received, IEquipableItem delivered);

  /**
   * allows to give an item
   *
   * @param unit
   *      the unit to which it will be given
   * @param gift
   *      the item that will be given
   */

  void giveAway(IUnit unit, IEquipableItem gift);

  /**
   * allows to receive an item from another unit
   *
   * @param unit
   *      the unit that will deliver the item
   * @param received
   *      the item that will be received
   *
   */

  void receive(IUnit unit, IEquipableItem received);

  /**
   * allows to generate a combat between units
   *
   * @param unit
   *      the unit to which it would attack
   */

  void attackEnemy(IUnit unit);

  /**
   * allow one unit to attack another
   *
   * @param attacker
   *      the unit that will cause damage
   * @param damage
   *      the damage that will occur
   */

  void takeDamage( double damage);

  /**
   *
   * @return if a unit is alive
   */

  boolean getLive();

  /**
   *
   * @param unit
   *      unit that you want to attack
   * @return if you can attack the unit
   */

  boolean canAttack(IUnit unit);


  void heal(double heal);

  void healUnit(IUnit unit);

  int getMaxHitPoints();

  void unEquipItem();

  void Damage(IUnit attacker, double damage);

  void die();

  void equipAxe(IEquipableItem axe);

  void equipSpear(IEquipableItem item);

  void equipBow(IEquipableItem item);

  void equipSword(IEquipableItem item);

  void equipLight(IEquipableItem item);

  void equipDark(IEquipableItem item);

  void equipAnima(IEquipableItem item);

  void equipStaff(IEquipableItem item);

}
