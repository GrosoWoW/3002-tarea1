package model.units;

import java.util.List;
import model.items.IEquipableItem;
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
  void equipItem(IEquipableItem item);

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

  void addItem(IEquipableItem item);

  void removeItem(IEquipableItem item);

  /**
   *
   * @param unit
   * @param received
   * @param delivered
   */

  void trade(IUnit unit, IEquipableItem received, IEquipableItem delivered);

  /**
   *
   * @param unit
   * @param gift
   */

  void giveAway(IUnit unit, IEquipableItem gift);

  /**
   *
   * @param unit
   * @param received
   */

  void receive(IUnit unit, IEquipableItem received);

  /**
   *
   * @return
   */

  void attackEnemy(AbstractUnit unit);

  /**
   *
   * @param damage
   */

  void takeDamage(AbstractUnit attacker, double damage);



}
