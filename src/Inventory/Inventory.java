/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import ItemPrototype.WeaponDecorator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Jura
 */
public class Inventory {

    private String[] inventory;
    private boolean fullInventory = true;
    private String currentWeapon, currentArmor;
    private int armor, damage;

    public Inventory(int a) {
        this.inventory = new String[a];
    }

    public String search(int index) {
        if (inventory[index] == null)return null;
        if (index > inventory.length) {
            return null;
        }
        return inventory[index];
    }

    public String[] getInventoryContents() {
        return this.inventory;
    }

    public void add(String item) {

        for (int i = 0; i < inventory.length; i++) {
            fullInventory = true;
            if (inventory[i] == null) {

                inventory[i] = item;
                fullInventory = false;
                break;
            }

        }

    }

    public void swapItem(int index, String item) {
        delete(index);
        inventory[index] = item;
    }

    public void delete(int index) {
        for (int i = index; i < inventory.length; i++) {
            if (i == inventory.length - 1) {
                inventory[i] = null;
                break;
            }
            inventory[i] = inventory[i + 1];
        }
    }

    public String equipItem(int index) {
        String itemToEquip = inventory[index];
        if (itemToEquip.contains("Obrana")) {
            Pattern pattern = Pattern.compile(":|\\n");
            String[] itemElements = pattern.split(inventory[index]);

            currentArmor = itemElements[1].trim();
            itemElements[5] = itemElements[5].trim();
            armor = Integer.parseInt(itemElements[5]);
            return "armor";
        } else {
            Pattern pattern = Pattern.compile(":|\\n");
            String[] itemElements = pattern.split(inventory[index]);
            currentWeapon = itemElements[1];
            itemElements[5] = itemElements[5].trim();
            damage = Integer.parseInt(itemElements[5]);
        }
        return "weapon";
    }

    public void showInv() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                break;
            }
            System.out.format("\n<%d>\n%s\n", i + 1, inventory[i]);
        }
    }

    public void splitInv() {
        String a = inventory[1];
        String[] split = a.split("\n");
        String z = split[0];
        if (split[1].contains("zbraň")) {
            System.out.println("dong");
        }
        String x = split[2];
        System.out.println(z);
        System.out.println(x);

    }

    /**
     * @return the fullInventory
     */
    public boolean hasFullInventory() {
        return fullInventory;
    }

    /**
     * @return the currentWeapon
     */
    public String getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * @return the armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @return the currentArmor
     */
    public String getCurrentArmor() {
        return currentArmor;
    }

}
