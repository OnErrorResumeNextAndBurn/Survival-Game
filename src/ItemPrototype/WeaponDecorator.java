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
public class WeaponDecorator implements ItemProperties {
private WeaponPrefixes wPrefixes;
    private int baseDamage, atkMod, totalDamage, critChance;
    private WeaponFactory builtWeapon;
    private String weaponName;
    
    public WeaponDecorator(WeaponFactory builtWeapon){
    this.builtWeapon = builtWeapon;
    wPrefixes = new WeaponPrefixes();
    wPrefixes.givePrefix();
    setWeaponName();
    setTotalDamage();    
    }
    public void decorateWeapon(){
        System.out.println("Jmeno: "+getWeaponName());
        System.out.println("Poškození: "+getTotalDamage());
    }
    /**
     * @return the baseDamage
     */
    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * @param baseDamage the baseDamage to set
     */
    @Override
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    /**
     * @return the atkMod
     */
    @Override
    public int getAtkMod() {
        return atkMod;
    }

    /**
     * @param atkMod the atkMod to set
     */
    @Override
    public void setAtkMod(int atkMod) {
        this.atkMod = atkMod;
    }

    /**
     * @return the critChance
     */
    @Override
    public int getCritChance() {
        return critChance;
    }

    /**
     * @param critChance the critChance to set
     */
    @Override
    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    @Override
    public void setTotalDamage() {
        totalDamage = builtWeapon.getBaseDamage() + wPrefixes.getPrefixBonusDamage();
    }

    @Override
    public int getTotalDamage() {
        return totalDamage;
    }
    

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     */
    public void setWeaponName() {
        this.weaponName = wPrefixes.getPrefixName()+" "+builtWeapon.getName();
    }
}
