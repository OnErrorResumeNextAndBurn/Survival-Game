/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedEntities;

/**
 *
 * @author Jura
 */
public class EntityBuilder implements GetEntityState, ModifyEntityState {

    private PlayerProfessions p;
    private EntityBuilder e;
    private int HP, ATK, DEF, DAMAGE, DROP, CRITCHANCE;
    private String currentWeapon,currentArmor;
    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public int getArmor() {
        return DEF;
    }

    @Override
    public int getDAMAGE() {
        return DAMAGE;
    }

    @Override
    public int getDrop() {
        return DROP;
    }

    @Override
    public void setHP(int a) {
        HP = a;
    }

    @Override
    public void setATK(int a) {
        ATK = a;
    }

    @Override
    public void setDEF(int a) {
        DEF = a;
    }

    @Override
    public void setDAMAGE() {
        DAMAGE = p.getDAMAGE();
    }

    public void buildHero() {
        p = new PlayerProfessions();
        p.build();
        HP = p.getHP();
        ATK = p.getATK();
        DEF = p.getArmor();
        DAMAGE = p.getDAMAGE();
        CRITCHANCE = p.getCRITCHANCE();
        DROP = p.getDrop();
        currentWeapon = p.getCurrentWeapon();
        currentArmor = p.getCurrentArmor();
    }
    


    /*public void Barbar() {
        setHP(200);
        setATK(15);
        setDEF(30);
        setCRITCHANCE(5);
        setDAMAGE();

    }*/

    public void Rogue() {
        setHP(150);
        setATK(30);
        setDEF(20);
        setCRITCHANCE(30);
        setDAMAGE();
    }

    @Override
    public int getCRITCHANCE() {
        return CRITCHANCE;
    }

    @Override
    public void setCRITCHANCE(int a) {
        CRITCHANCE = a;
    }

    /**
     * @return the currentWeapon
     */
    public String getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * @param currentWeapon the currentWeapon to set
     */
    public void setCurrentWeapon() {
        this.currentWeapon = p.getCurrentWeapon();
    }
      public String getCurrentArmor() {
        return currentArmor;
    }

    /**
     * @param currentWeapon the currentWeapon to set
     */
    public void setCurrentArmoR() {
        this.currentWeapon = p.getCurrentArmor();
    }

}
