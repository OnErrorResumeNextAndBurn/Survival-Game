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
public class ArmorPrefixes {

    Random rand = new Random();
    private String prefixName;
    private int prefixBonusArmor;
    private final int RUSTYCHANCE = 40;
    private final int POLISHEDCHANCE = 65;
    private final int MASTERCRAFTEDCHANCE = 95;
    private final int ANCIENTCHANCE = 100;

    public void givePrefix() {
        int percentage = ((int) (Math.random() * 100));

        if (percentage <= RUSTYCHANCE) {
            giveRusty();
        } else if (percentage <= POLISHEDCHANCE) {
            givePolished();
        } else if (percentage <= MASTERCRAFTEDCHANCE) {
            giveMastercrafted();
        } else {
            giveAncient();
        }
    }

    private void giveRusty() {
        prefixName = "Rezavy";
        prefixBonusArmor = rand.nextInt(10) + 3;
    }

    private void givePolished() {
        prefixName = "Vylesteny";
        prefixBonusArmor = rand.nextInt(15) + 13;

    }

    private void giveMastercrafted() {
        prefixName = "Remeslnicky";
        prefixBonusArmor = rand.nextInt(25) + 28;
    }

    private void giveAncient() {
        prefixName = "Anticky";
        prefixBonusArmor = rand.nextInt(45) + 22;
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
    public int getPrefixBonusArmor() {
        return prefixBonusArmor;
    }

}
