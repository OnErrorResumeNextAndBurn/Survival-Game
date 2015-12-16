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
public class WeaponFactory {

    private Random rand = new Random();
    private Axes axeBuilder;
    private Swords swordBuilder;
    int a;
    int itemToBuild;
    private int baseDamage;
    private String name;

    public WeaponFactory manufactureWeapon(int a) {
        this.a = a;
        itemToBuild = rand.nextInt(2) + 1;
        

        switch (itemToBuild) {
            case 1:
                swordBuilder = new Swords(this.a);
                swordBuilder.buildSword();
                break;
            case 2:
                axeBuilder = new Axes(this.a);
                axeBuilder.buildAxe();
                break;
        }
        wrapValues();
        return this;
    }

    public void wrapValues() {
        if (itemToBuild == 1) {
            passValuesSwords();
        } else {
            passValuesAxes();
        }
    }

    private void passValuesAxes() {
        baseDamage = axeBuilder.getBaseDamage();
        name = axeBuilder.getName();
    }

    private void passValuesSwords() {
        baseDamage = swordBuilder.getBaseDamage();
        name = swordBuilder.getName();
    }

    /**
     * @return the baseDamage
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
