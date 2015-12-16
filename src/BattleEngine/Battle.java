/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleEngine;

import Entities.Enemy;
import ItemPrototype.ArmorDecorator;
import ItemPrototype.ArmorFactory;
import ItemPrototype.ItemDispenser;
import ItemPrototype.WeaponDecorator;
import ItemPrototype.WeaponFactory;
import ReworkedEntities.Player;

/**
 *
 * @author Jura
 */
public class Battle extends BattleArena {

    private Player instance;

    private Enemy defeated;

    public Battle(Player instance, Enemy defeated) {
        super(instance, defeated);
        this.instance = instance;
        this.defeated = defeated;
    }

    public void GiveDrop() {
        boolean drop = this.hasDrop();
        if (drop == true) {

            int percentage = ((int) (Math.random() * 100));

            if (percentage <= 65) {
                WeaponFactory weaponFactory = new WeaponFactory().manufactureWeapon(eRarityGrade);
                WeaponDecorator wDecorator = new WeaponDecorator(weaponFactory);
                ItemDispenser itemDispenser = new ItemDispenser(wDecorator, instance);

            } else if (percentage > 65) {
                ArmorFactory armorFactory = new ArmorFactory().manufactureArmor(eRarityGrade);
                ArmorDecorator armorDecorator = new ArmorDecorator(armorFactory);
                ItemDispenser itemDispenser = new ItemDispenser(armorDecorator, instance);
            }
        }
        if (drop == false) {
            System.out.println("Nic jsi nedostal");
        }
    }

    public int giveScore() {
        int a = this.defeated.getSCORE();
        System.out.format("Dostal jsi %d bodů!\n",a);
        int b = this.instance.getSCORE();
        System.out.format("Tvé nové skóre je %s bodů.\n",a+b);
        return a + b;
    }
    public int giveGold(){
    int a = this.defeated.getGOLD();
    System.out.format("Za padlého nepřítele jsi dostal %d zlatých mincí!\n",a);
    int b = this.instance.getGOLD();
        System.out.format("Máš teď %d zlatých mincí\n",a+b);
        return a+b;
    }

}
