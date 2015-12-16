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
public class ArmorFactory {

    private Random rand = new Random();
    private Plates plateBuilder;
    private LeatherJackets leatherBuilder;
    int a;
    int itemToBuild;
    private int baseArmor,totalArmor;
    private String name;

    public ArmorFactory manufactureArmor(int a) {
        this.a = a;
        itemToBuild = rand.nextInt(2) + 1;

        switch (itemToBuild) {
            case 1:
                plateBuilder = new Plates(this.a);
                plateBuilder.buildPlate();
                break;
            case 2:
                leatherBuilder = new LeatherJackets(this.a);
                leatherBuilder.buildLeatherJacket();
                break;
        }
        setValues();
        return this;
    }

    private void setValues() {
        if (itemToBuild == 1) {
            setValuesPlate();
        } else {
            setValuesLeather();
        }
    }

    private void setValuesLeather() {
        baseArmor = leatherBuilder.getBaseArmor();
        name = leatherBuilder.getName();
    }
     private void setValuesPlate() {
        baseArmor = plateBuilder.getBaseArmor();
        name = plateBuilder.getName();
    }

    /**
     * @return the baseDamage
     */
    public int getBaseArmor() {
        return baseArmor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
   
}
