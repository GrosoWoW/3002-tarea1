package model.units;

import model.items.*;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.Axe;
import model.items.attack.normal.Bow;
import model.items.attack.normal.Spear;
import model.items.attack.normal.Sword;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected AnimaBook anima;
  protected DarkBook dark;
  protected LightBook light;
  protected IEquipableItem equippedItem;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }


  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }


  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 0, 3);
    this.sword = new Sword("Sword", 10, 0, 3);
    this.spear = new Spear("Spear", 10, 0, 3);
    this.staff = new Staff("Staff", 10, 0, 3);
    this.bow = new Bow("Bow", 10, 0, 3);
    this.anima = new AnimaBook("Anima", 10,0,3);
    this.dark = new DarkBook("Dark", 10, 0, 3);
    this.light = new LightBook("Light", 10, 0 ,3);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  @Override
  public AnimaBook getBook() {
    return anima;
  }

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Override
  public void equipWeapon(IUnit unit){




  }

  @Override
  @Test
  public void testTrade(){

    IUnit unit1 = getTestUnit();
    IUnit unit2 = getTargetAlpaca();
    unit1.addItem(getAxe());
    unit2.addItem(getSpear());
    unit1.trade(unit2,getSpear(),getAxe());
    assertTrue(unit1.getItems().contains(getSpear()));
    assertTrue(unit2.getItems().contains(getAxe()));
    assertFalse(unit1.getItems().contains(getAxe()));



  }

  @Override
  @Test
  public void testFailTrade(){

    IUnit unit1 = getTestUnit();
    IUnit unit2 = getTargetAlpaca();
    unit1.addItem(getAxe());
    unit2.addItem(getSword());
    unit1.trade(unit2, getAxe(), getSword());
    assertFalse(unit1.getItems().contains(getSword()));


  }

  @Override
  @Test
  public void testGift(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    IEquipableItem item = getAxe();
    assertFalse(segundo.getItems().contains(item));
    primero.addItem(item);
    assertTrue(primero.getItems().contains(item));
    primero.giveAway(segundo, item);
    assertNotEquals(primero.getItems(), segundo.getItems());
    assertTrue(segundo.getItems().contains(item));
    assertFalse(primero.getItems().contains(item));



    }

  @Override
  @Test

  public void testFailGift(){


  }

  @Override
  @Test
  public void testReceived(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    IEquipableItem item = getAxe();
    primero.addItem(item);
    segundo.receive(primero, item);
    assertTrue(segundo.getItems().contains(item));
    assertFalse(primero.getItems().contains(item));
  }

  @Override
  @Test
  public void testFailReceived(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    primero.addItem(getSword());
    primero.addItem(getSpear());
    primero.addItem(getAxe());
    segundo.addItem(getStaff());
    primero.receive(segundo, getStaff());
    assertTrue(segundo.getItems().contains(getStaff()));
    assertFalse(primero.getItems().contains(getStaff()));


  }

  @Override
  @Test
  public void testCombat(){

    IUnit primero = getTestUnit();
    IUnit segundo = new Fighter(500, 2, field.getCell(1, 1));
    equipWeapon(primero);
    segundo.equipItem(getAxe());
    primero.attackEnemy(segundo);
    assertNotEquals(segundo.getLive(), primero.getLive());
    assertFalse(primero.getLive());
    assertTrue(primero.canAttack(segundo));


    IUnit tercero = new SwordMaster(50, 2, field.getCell(2, 2));
    IUnit cuarto = new Hero(50, 2, field.getCell(0, 0));
    tercero.equipItem(getSword());
    cuarto.equipItem(getSpear());
    cuarto.attackEnemy(tercero);
    assertTrue(cuarto.getLive());
    assertTrue(tercero.getLive());
  }

  @Override
  @Test
  public void testHeal(){

    IUnit primero = getTestUnit();
    IUnit curita = new Cleric(50, 2, field.getCell(1, 1));
    primero.equipItem(getSpear());
    curita.equipItem(new Staff("La mata simios", 20,0,10));
    primero.takeDamage(30);
    curita.healUnit(primero);
    assertEquals(primero.getMaxHitPoints()-10, primero.getCurrentHitPoints());
    curita.equipItem(new Staff("La mata simios 2.0", 200000,0,10));
    curita.healUnit(primero);
    assertEquals(primero.getMaxHitPoints(), primero.getCurrentHitPoints());
    curita.unEquipItem();
    curita.equipItem(new Sword("La mata simios 2.0", 10,0,10));
    primero.takeDamage(60);
    curita.healUnit(primero);
    assertEquals(primero.getMaxHitPoints()-60, primero.getCurrentHitPoints());

  }



  }



