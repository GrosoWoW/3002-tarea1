package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  protected double currentHitPoints;
  private final int maxHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;
  int maxItems;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.maxItems = maxItems;
  }


  public double getCurrentHitPoints() {

    return currentHitPoints;
  }

  public int getMaxHitPoints(){

    return maxHitPoints;
  }

  public List<IEquipableItem> getItems() {

    return List.copyOf(items);
  }

  public IEquipableItem getEquippedItem() {

    return equippedItem;
  }

  public void setEquippedItem(final IEquipableItem item) {

    this.equippedItem = item;
  }

  public Location getLocation() {

    return location;
  }

  public void setLocation(final Location location) {

    this.location = location;
  }

  public int getMovement() {

    return movement;
  }

  public int getMaxItems(){

    return maxItems;
  }

  public void addItem(IEquipableItem item){

    items.add(item);
  }

  public void removeItem(IEquipableItem item){


    this.items.remove(item);
  }

  public boolean canAttack(IUnit unit){

    return (this.getEquippedItem() != null) &&
            (this.getLocation().distanceTo(unit.getLocation()) <=this.getEquippedItem().getMaxRange()) &&
            (this.getLocation().distanceTo(unit.getLocation()) > this.getEquippedItem().getMinRange());
  }


  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  public void trade(IUnit unit, IEquipableItem received, IEquipableItem delivered){

    int distanceX = this.getLocation().getRow() - unit.getLocation().getRow();
    int distanceY = this.getLocation().getColumn() - unit.getLocation().getColumn();

    if(Math.pow(distanceX,2) <= 1 && Math.pow(distanceY,2) <= 1){

      if(this.getItems().contains(delivered) && unit.getItems().contains(received)){

        this.removeItem(delivered);
        unit.removeItem(received);
        this.addItem(received);
        unit.addItem(delivered);

      }
    }
  }

  public void giveAway(IUnit unit, IEquipableItem gift) {

    int distanceX = this.getLocation().getRow() - unit.getLocation().getRow();
    int distanceY = this.getLocation().getColumn() - unit.getLocation().getColumn();

    if (Math.pow(distanceX, 2) <= 1 && Math.pow(distanceY, 2) <= 1) {

      if(unit.getItems().size() < unit.getMaxItems()){

        this.items.remove(gift);
        unit.addItem(gift);

      }
    }
  }

  public void receive(IUnit unit, IEquipableItem received) {

      int distanceX = this.location.getRow() - unit.getLocation().getRow();
      int distanceY = this.location.getColumn() - unit.getLocation().getColumn();

      if(Math.pow(distanceX,2) <= 1 && Math.pow(distanceY,2) <= 1){

        if(this.items.size() < this.maxItems){

          this.getItems().add(received);
          unit.getItems().remove(received);
        }
    }
  }

  public void attackEnemy(AbstractUnit unit) {

    if (this.canAttack(unit)) {

      double damage = this.getEquippedItem().attack(unit.getEquippedItem());
      takeDamage(unit, damage);
    }
  }

  public void takeDamage(AbstractUnit attacker, double damage){

    this.currentHitPoints -= damage;
    if(currentHitPoints <= 0){

      //muere
    }
    else{

      this.attackEnemy(attacker);

    }
  }


}
