/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemPrototype;

import ItemPrototype.FinalItem;
import Inventory.Inventory;
import ReworkedEntities.Player;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class ItemDispenser {

    private WeaponDecorator wDecorator;
    private ArmorDecorator aDecorator;
    private Player playerInstance;
    private Inventory pInventory;
    private FinalItem finalItem;

    public ItemDispenser(WeaponDecorator decoratedWeapon) {
        this.wDecorator = decoratedWeapon;
    }

    public ItemDispenser(WeaponDecorator decoratedWeapon, Player playerInstance) {
        this.wDecorator = decoratedWeapon;
        this.playerInstance = playerInstance;
        System.out.println("Dostal jsi nový předmět!");
        System.out.format("Nová zbran:\n");
        showWeaponStats();
        System.out.println("Chceš novou zbraň použít? ANO/NE");
        Scanner scan = new Scanner(System.in, "Windows-1250");
        String choice = scan.nextLine().toLowerCase();
        switch (choice) {
            case "ano":
                equipWeapon();
                System.out.format("Zbraň %s byla použita.\n", wDecorator.getWeaponName());
                break;
            default:
                pInventory = playerInstance.getpInventory();
                finalItem = new FinalItem(wDecorator);
                pInventory.add(finalItem.getItem());
                if (pInventory.hasFullInventory()) {
                    System.out.println("Plný inventář!");
                } else {
                    System.out.format("Zbraň %s bylo přidána do inventáře\n", wDecorator.getWeaponName());
                }
                break;
        }

    }

    public ItemDispenser(ArmorDecorator decoratedArmor, Player playerInstance) {
        this.aDecorator = decoratedArmor;
        this.playerInstance = playerInstance;
        System.out.println("Dostal jsi nový předmět!");
        System.out.format("Nove brnění:\n");
        showArmorStats();
        System.out.println("Chceš nové brnění použít? ANO/NE");
        Scanner scan = new Scanner(System.in, "Windows-1250");
        String choice = scan.nextLine().toLowerCase();
        switch (choice) {
            case "ano":
                equipArmor();
                System.out.format("Brněni %s bylo použito.\n", aDecorator.getArmorName());
                break;
            default:
                System.out.println("Brnění bylo přidáno do inventáře\n");
                pInventory = playerInstance.getpInventory();
                finalItem = new FinalItem(aDecorator);
                pInventory.add(finalItem.getItem());
                if (pInventory.hasFullInventory()) {
                    System.out.println("Plný inventář!");
                } else {
                    System.out.format("Brnění %s bylo přidano do inventáře.", aDecorator.getArmorName());
                }
                break;
        }

    }

    public void showWeaponStats() {
        System.out.println("Jméno: " + wDecorator.getWeaponName());
        System.out.println("Poškození: " + wDecorator.getTotalDamage());
        System.out.println("Změna poškození: " + (wDecorator.getTotalDamage() - playerInstance.getDAMAGE()));
    }

    public void showArmorStats() {
        System.out.println("Jméno: " + aDecorator.getArmorName());
        System.out.println("Obrana: " + aDecorator.getTotalArmor());
        System.out.println("Změna obrany: " + (aDecorator.getTotalArmor() - playerInstance.getArmor()));
    }

    public void equipWeapon() {
        playerInstance.setDAMAGE(wDecorator.getTotalDamage());
        playerInstance.setCurrentWeapon(wDecorator.getWeaponName());
    }

    public void equipArmor() {
        playerInstance.setArmor(aDecorator.getTotalArmor());
        playerInstance.setCurrentArmor(aDecorator.getArmorName());
    }

    public void fanfare() {
        System.out.println("You got an item!");
        System.out.println("Jméno: " + wDecorator.getWeaponName());
        System.out.println("Poškození: " + wDecorator.getTotalDamage());
    }
}
