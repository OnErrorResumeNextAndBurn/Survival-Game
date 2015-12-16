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
public class Plates extends Armor {

    private int baseArmor;
    private int RARITYGRADE = 0;
    private final int CHANCEOFRARE = 60;
    private Random rand = new Random();

    public Plates(int a) {
        this.RARITYGRADE = a;

    }

    void buildPlate() {
        switch (RARITYGRADE) {
            case 1:
                buildCommonPlate();
                break;
            case 2:
                int percentage = ((int) (Math.random() * 100));
                if (percentage <= CHANCEOFRARE) {
                    buildRarePlate();
                } else {
                    buildCommonPlate();
                }
                break;
            default:
                break;
        }
    }

    void buildCommonPlate() {
        setName("plátové brnění");
        setType("brněni");
        setRarity("common");
        generateArmorCommon();
    }

    void buildRarePlate() {
        setName("skleněné plátové brnění");
        setType("brněni");
        setRarity("vzacne");
        generateArmorRare();
    }

    public void displayPlate() {
        System.out.println("Jmeno: " + getName());
        System.out.println("Typ: " + getType());
        System.out.println("Rarita: " + getRarity());
    }

    void generateArmorCommon() {
        baseArmor = rand.nextInt(15) + 15;
    }

    void generateArmorRare() {
        baseArmor = rand.nextInt(27) + 22;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void buildBarbarStartingAmor() {
        setName("Težké platové brnění");
        baseArmor = 24 /*60*/;
    }
}
