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
public class Swords extends Weapon {

    private int baseDamage;
    private int RARITYGRADE = 0;
    private final int CHANCEOFRARE = 100;
    private Random rand = new Random();

    public Swords(int a) {
        this.RARITYGRADE = a;

    }

    void buildSword() {
        switch (RARITYGRADE) {
            case 1:
                buildCommon();
                break;
            case 2:
                int percentage = ((int) (Math.random() * 100));
                if (percentage <= CHANCEOFRARE) {
                    buildCommonDouble();
                } else {
                    buildCommon();
                }
                break;
            default:
                break;
        }
    }

    void buildCommon() {
        setName("sword");
        setType("zbran");
        setRarity("common");
        generateDamageCommon();

    }

    void buildCommonDouble() {
        setName("curved sword");
        setType("zbran");
        setRarity("common");
        generateDamageRare();
    }

    public void buildRogueWeapon() {
        setName("Antique short sword");
        baseDamage = 15;
    }

    void generateDamageCommon() {
        baseDamage = rand.nextInt(5) + 6;
    }

    void generateDamageRare() {
        baseDamage = rand.nextInt(25) + 6;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}
