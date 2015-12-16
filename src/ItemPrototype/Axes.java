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
public class Axes extends Weapon {

    private int baseDamage;
    private int RARITYGRADE = 0;
    private final int CHANCEOFRARE = 100;
    private Random rand = new Random();

    public Axes(int a) {
        this.RARITYGRADE = a;

    }

    void buildAxe() {
        switch (RARITYGRADE) {
            case 1:
                buildCommonAxe();
                break;
            case 2:
                int percentage = ((int) (Math.random() * 100));
                if (percentage <= CHANCEOFRARE) {
                    buildCommonDoubleAxe();
                } else {
                    buildCommonAxe();
                }
                break;
            default:
                break;
        }
    }

    void buildCommonAxe() {
        setName("sekera");
        setType("zbran");
        setRarity("common");
        generateDamageCommon();
    }

    void buildCommonDoubleAxe() {
        setName("oboustranná sekera");
        setType("zbran");
        setRarity("common");
        generateDamageRare();
    }

    public void displayAxe() {
        System.out.println("Jmeno: " + getName());
        System.out.println("Typ: " + getType());
        System.out.println("Rarita: " + getRarity());
    }

    void generateDamageCommon() {
        baseDamage = rand.nextInt(5) + 2;
    }
    void generateDamageRare() {
        baseDamage = rand.nextInt(30) + 5;
    }
    public int getBaseDamage(){
    return baseDamage;
    }
    public void buildBarbarStartingWeapon(){
    setName("Pozlacená sekera");
    baseDamage = 10 /*55*/;
    }

}
