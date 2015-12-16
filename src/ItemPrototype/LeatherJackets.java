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
public class LeatherJackets extends Armor {
private int baseArmor;
    private int RARITYGRADE = 0;
    private final int CHANCEOFRARE = 70;
    private Random rand = new Random();

    public LeatherJackets(int a) {
        this.RARITYGRADE = a;

    }

    void buildLeatherJacket() {
        switch (RARITYGRADE) {
            case 1:
                buildCommon();
                break;
            case 2:
                int percentage = ((int) (Math.random() * 100));
                if (percentage <= CHANCEOFRARE) {
                    buildRare();
                } else {
                    buildCommon();
                }
                break;
            default:
                break;
        }
    }

    private void buildCommon() {
        setName("kožená vesta");
        setType("brněni");
        setRarity("obyčejná");
        generateArmorCommon();
    }

    private void buildRare() {
        setName("tvrzená kožená vesta");
        setType("brnění");
        setRarity("vzacné");
        generateArmorRare();
    }

    public void displayPlate() {
        System.out.println("Jmeno: " + getName());
        System.out.println("Typ: " + getType());
        System.out.println("Rarita: " + getRarity());
    }

    private void generateArmorCommon() {
        baseArmor = rand.nextInt(10) + 13;
    }

    private void generateArmorRare() {
        baseArmor = rand.nextInt(35) + 25;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void buildRogueStartingAmor() {
        setName("Zdobená kožená vesta");
        baseArmor = 18;
    }
}    

