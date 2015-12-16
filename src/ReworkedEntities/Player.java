/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedEntities;

import Inventory.Inventory;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class Player implements GetEntityState {

    private int HP, ATK, Armor, DAMAGE, DROP, CRITCHANCE, SCORE, GOLD;
    protected int invSize;
    private String currentWeapon, currentArmor;
    private EntityBuilder c;
    private Scanner scan;
    private Inventory pInventory;

    public Player(Player playerinstance) {

    }

    public Player() {
    }

    /**
     * @return the pInventory
     */
    public Inventory getpInventory() {
        return pInventory;
    }

    /**
     * @param pInventory the pInventory to set
     */
    public void setpInventory(Inventory pInventory) {
        this.pInventory = pInventory;
    }

    public void Player() {
        c = new EntityBuilder();
        c.buildHero();
        HP = c.getHP();
        ATK = c.getATK();
        setArmor(c.getArmor());
        DAMAGE = c.getDAMAGE();
        CRITCHANCE = c.getCRITCHANCE();
        currentWeapon = c.getCurrentWeapon();
        currentArmor = c.getCurrentArmor();
        invSize = 5;
        setpInventory(new Inventory(invSize));
        SCORE = 0;
        GOLD = 15;
    }

    public void printStats() {
        System.out.format("HP %d");
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public int getArmor() {
        return Armor;
    }

    @Override
    public int getDAMAGE() {
        return DAMAGE;
    }

    @Override
    public int getDrop() {
        return DROP;
    }

    @Override
    public int getCRITCHANCE() {
        return CRITCHANCE;
    }

    public void setPostHP(int a) {
        HP = a;
    }

    public void setDAMAGE(int a) {
        DAMAGE = a;
    }

    public void setCurrentWeapon(String s) {
        currentWeapon = s;
    }

    /**
     * @return the currentWeapon
     */
    public String getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * @return the currentArmor
     */
    public String getCurrentArmor() {
        return currentArmor;
    }

    /**
     * @param currentArmor the currentArmor to set
     */
    public void setCurrentArmor(String currentArmor) {
        this.currentArmor = currentArmor;
    }

    /**
     * @param Armor the Armor to set
     */
    public void setArmor(int Armor) {
        this.Armor = Armor;
    }

    /**
     * @return the SCORE
     */
    public int getSCORE() {
        return SCORE;
    }

    /**
     * @param SCORE the SCORE to set
     */
    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }

    /**
     * @return the GOLD
     */
    public int getGOLD() {
        return GOLD;
    }

    /**
     * @param GOLD the GOLD to set
     */
    public void setGOLD(int GOLD) {
        this.GOLD = GOLD;
    }

    /**
     * @return the invSize
     */
    public int getInvSize() {
        return invSize;
    }

    /**
     * @param invSize the invSize to set
     */
    public void setInvSize(int invSize) {
        this.invSize = invSize;
    }
}
