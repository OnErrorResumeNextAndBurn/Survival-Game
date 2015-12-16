/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalgame;

import Inventory.Inventory;
import ItemPrototype.ArmorDecorator;
import ItemPrototype.ArmorFactory;
import ItemPrototype.FinalItem;
import ItemPrototype.WeaponDecorator;
import ItemPrototype.WeaponFactory;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class TestClass {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(10);

        Random rand = new Random();
        int random;
        for (int i = 0; i < 5; i++) {
            WeaponFactory weaponFactory = new WeaponFactory();
            WeaponDecorator weaponDecorator = new WeaponDecorator(weaponFactory.manufactureWeapon(2));
            FinalItem finalItem = new FinalItem(weaponDecorator);
            inventory.add(finalItem.getItem());

            ArmorFactory aFactory = new ArmorFactory();
            ArmorDecorator armorDecorator = new ArmorDecorator(aFactory.manufactureArmor(2));
            FinalItem armorItem = new FinalItem(armorDecorator);
            inventory.add(armorItem.getItem());
        }

        inventory.showInv();
        inventory.splitInv();

    }

}
