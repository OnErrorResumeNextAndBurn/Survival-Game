/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Jura
 */
public class Beast extends Enemy {
protected boolean UseHarden = false;    
    
    public Beast divokyVlk() {
        name = "Divoký vlk";
        HP = 70;
        ATK = 9;
        DEF = 7;
        DAMAGE = setDAMAGE();
        DROPCHANCE = 85;
        CRITCHANCE = 15;
        rarityGrade = 1;
        SCORE = rand.nextInt(60) + 20;
        GOLD = rand.nextInt(2) + 5;
        return this;
    }

  

    public Beast medved() {
        UseHarden = true;
        name = "Medvěd";
        HP = 120;
        ATK = 15;
        DEF = 16;
        DAMAGE = setDAMAGE();
        DROPCHANCE = 80;
        CRITCHANCE = 50;
        rarityGrade = 2;
        SCORE = rand.nextInt(80) + 40;
        GOLD = rand.nextInt(25) + 45;
        return this;
    }

    public Beast drak() {
        name = "Drak";
        HP = 350;
        ATK = 50;
        DEF = 28;
        DAMAGE = setDAMAGE();
        DROPCHANCE = 80;
        CRITCHANCE = 5;
        rarityGrade = 2;
        SCORE = rand.nextInt(500) + 300;
        GOLD = rand.nextInt(250) + 70;
        return this;
    }    

    /**
     * @return the canUseHarden
     */
    @Override
    public boolean canUseTypeSpecial() {
        return UseHarden;
    }


}
