/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemPrototype;

import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class TestClass {
    public static void main (String[] args){
        WeaponFactory weaponFactory = new WeaponFactory().manufactureWeapon(2);            
        WeaponDecorator weaponDecorator = new WeaponDecorator(weaponFactory);
        ItemDispenser itemDispenser = new ItemDispenser(weaponDecorator);
        itemDispenser.fanfare();
        
    }
}
