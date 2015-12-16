/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemPrototype;

import java.util.Random;

/**
 *
 * @author Jura
 */
public class WeaponPrefixes {

    Random rand = new Random();
    private String prefixName;
    private int prefixBonusDamage;
    private final int RUSTYCHANCE = 40;
    private final int STEELCHANCE = 65;
    private final int SILVERCHANCE = 90;
    private final int MYTHRILCHANCE = 100;
    
    public void givePrefix() {
        
        int percentage = ((int) (Math.random() * 100));

        if (percentage <= RUSTYCHANCE) {
            giveRusty();
        } else if (percentage <= STEELCHANCE) {
            giveSteel();
        } else if (percentage <= SILVERCHANCE) {
            giveSilver();
        } else {
            giveMythril();
        }
    }

    private void giveRusty() {
        prefixName = "rezavá";
        prefixBonusDamage = rand.nextInt(10) + 3;
    }

    private void giveSteel() {
        prefixName = "železná";
        prefixBonusDamage = rand.nextInt(30) + 5;

    }

    private void giveSilver() {
        prefixName = "stříbrná";
        prefixBonusDamage = rand.nextInt(45) + 8;
    }

    private void giveMythril() {
        prefixName = "Mythrilová";
        prefixBonusDamage = rand.nextInt(60) + 10;
    }

    /**
     * @return the prefixName
     */
    public String getPrefixName() {
        return prefixName;
    }

    /**
     * @return the prefixBonusDamage
     */
    public int getPrefixBonusDamage() {
        return prefixBonusDamage;
    }

}
