/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedEntities;

import ItemPrototype.Axes;
import ItemPrototype.LeatherJackets;
import ItemPrototype.Plates;
import ItemPrototype.Swords;
;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class PlayerProfessions implements GetEntityState,ModifyEntityState {
private Axes playerWeapon;
private boolean correctInput = false;
private Swords playerWeapon2;
private Plates playerPlate;
private LeatherJackets playerJacket;
    private int HP, ATK, Armor, DAMAGE,CRITCHANCE,DROP;
    private String currentWeapon,currentArmor;
    
    public void build(){
       Scanner scan = new Scanner(System.in, "Windows-1250");
       while(correctInput == false){ 
       System.out.println("Zadejte vaši specializaci: ");
        String trida = scan.nextLine().toLowerCase();
        switch (trida) {
            case "barbar":
                Barbar();
                correctInput=true;
                break;
            case "rogue":
                Rogue();
                correctInput=true;
                break;
            default:
                System.out.println("Neplatná hodnota!");
                correctInput = false;
                break;}
        }
        
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
        Armor = a;
    }

    @Override
    public void setDAMAGE() {
        DAMAGE = DAMAGE;
    }

    @Override
    public void setCRITCHANCE(int a) {
        CRITCHANCE = a;
    }
    
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
        return Armor;
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
    public int getCRITCHANCE() {
        return CRITCHANCE;
    }
    
        public void Barbar() {
        setHP(290);
        setATK(45);
        setCRITCHANCE(15);
        playerPlate = new Plates(1);
        playerPlate.buildBarbarStartingAmor();
        Armor = playerPlate.getBaseArmor();
        currentArmor = playerPlate.getName();
        playerWeapon = new Axes(1);
        playerWeapon.buildBarbarStartingWeapon();
        DAMAGE = playerWeapon.getBaseDamage();
        currentWeapon = playerWeapon.getName();

    }

    public void Rogue() {
        setHP(200);
        setATK(30);
        setCRITCHANCE(35);
        playerJacket = new LeatherJackets(1);
        playerJacket.buildRogueStartingAmor();
        Armor = playerJacket.getBaseArmor();
        currentArmor = playerJacket.getName();
        playerWeapon2 = new Swords(1);
        playerWeapon2.buildRogueWeapon();
        DAMAGE = playerWeapon2.getBaseDamage();
        currentWeapon = playerWeapon2.getName();
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
        
    }

    /**
     * @return the currentArmor
     */
    public String getCurrentArmor() {
        return currentArmor;
    }

}

