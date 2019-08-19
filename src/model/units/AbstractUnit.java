package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.items.normal.AbstractItem;
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
  protected int currentHitPoints;
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


  public int getCurrentHitPoints() {

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


  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  public void trade(AbstractUnit unit, IEquipableItem received, IEquipableItem delivered){

    int distanceX = this.location.getRow() - unit.location.getRow();
    int distanceY = this.location.getColumn() - unit.location.getColumn();

    if(Math.pow(distanceX,2) <= 1 && Math.pow(distanceY,2) <= 1){

      if(this.items.contains(delivered) && unit.items.contains(received)){

      }
    }
  }

  public void giveAway(AbstractUnit unit, IEquipableItem gift) {

    int distanceX = this.location.getRow() - unit.location.getRow();
    int distanceY = this.location.getColumn() - unit.location.getColumn();

    if (Math.pow(distanceX, 2) <= 1 && Math.pow(distanceY, 2) <= 1) {

      if(unit.items.size() < unit.maxItems){

        unit.items.add(gift);
        this.items.remove(gift);
      }
    }
  }

  public void receive(AbstractUnit unit, IEquipableItem received) {

      int distanceX = this.location.getRow() - unit.location.getRow();
      int distanceY = this.location.getColumn() - unit.location.getColumn();

      if(Math.pow(distanceX,2) <= 1 && Math.pow(distanceY,2) <= 1){

        if(this.items.size() < this.maxItems){

          this.items.add(received);
          unit.items.remove(received);
        }
    }
  }

  public void attack(AbstractUnit unit){

    if(this.equippedItem == null){}

    if(!this.equippedItem.isAttack()){}

    else if(!unit.getEquippedItem().isMagic() && !this.getEquippedItem().isMagic()){   // Ninguno tiene armas magicas


      if(this.getEquippedItem().Strong(unit.getEquippedItem().getName())){
        int damage = (this.getEquippedItem().getPower())*2;
        unit.takeDamage(this, damage);
      }
      else {
        int damage = (this.getEquippedItem().getPower());
        unit.takeDamage(this, damage);
      }
    }

    else if(unit.getEquippedItem().isMagic() && this.getEquippedItem().isMagic()) {

      if (this.getEquippedItem().Strong(unit.getEquippedItem().getName())) {
        int damage = (this.getEquippedItem().getPower()) * 2;
        unit.takeDamage(this, damage);
      }
      else{
        int damage = (this.getEquippedItem().getPower());
        unit.takeDamage(this, damage);
      }
    }

    else{

      int damage = (this.getEquippedItem().getPower()) * 2;
      unit.takeDamage(this, damage);
    }
  }

  public void takeDamage(AbstractUnit attacker, int damage){

    this.currentHitPoints -= damage;
    if(currentHitPoints <= 0){

      //muere
    }
    else{

      this.attack(attacker);

    }
  }

}
