/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemPrototype;

/**
 *
 * @author Jura
 */
public class ArmorDecorator {

    private ArmorPrefixes aPrefixes;
    private int baseArmor, totalArmor;
    private ArmorFactory builtArmor;
    private String armorName;

    public ArmorDecorator(ArmorFactory builtArmor) {
        this.builtArmor = builtArmor;
        aPrefixes = new ArmorPrefixes();
        aPrefixes.givePrefix();
        setArmorName();
        setTotalArmor();
    }

    public void decorateAmor() {
        System.out.println("Jmeno: " +getArmorName());
        System.out.println("Obrana: " +getTotalArmor());
    }

    public void setTotalArmor() {
        totalArmor = this.builtArmor.getBaseArmor() + aPrefixes.getPrefixBonusArmor();
    }

    public int getTotalArmor() {
        return totalArmor;
    }
       public String getArmorName() {
        return this.armorName;
    }

    /**
     */
    public void setArmorName() {
        this.armorName = aPrefixes.getPrefixName()+" "+this.builtArmor.getName();
    }
}
