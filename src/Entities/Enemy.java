/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Menu.InputValidator;
import java.util.Random;

/**
 *
 * @author Jura
 */
public abstract class Enemy implements Entity {

    protected int HP;
    protected int ATK;
    protected int DEF;
    protected int DAMAGE;
    protected int DROPCHANCE;
    protected int rarityGrade;
    protected int CRITCHANCE;
    protected int SCORE;
    protected int GOLD;
    protected String name;
    
    /**
     * @return the GOLD
     */
    public int getGOLD() {
        return GOLD;
    }
    Random rand = new Random();

    /**
     * @return the SCORE
     */
    public int getSCORE() {
        return SCORE;
    }

    public abstract boolean canUseTypeSpecial();

    public Enemy choose() {

        System.out.println("Vyberte s kým chcete bojovat: ");
        System.out.println("<1> Vlk");
        System.out.println("<2> Obr");
        System.out.println("<3> Medvěd");
        System.out.println("<4> Drak");
        int volba = InputValidator.validate(4);
        Enemy enemy = null;
        switch (volba) {
            case 1:
                enemy = new Beast().divokyVlk();

                break;
            case 2:
                enemy = new Humanoid().obr();
                break;
            case 3:
                enemy = new Beast().medved();
                break;
            case 4:
                new Beast().drak();
                break;
            default:
                System.out.println("Neplatná volba");
                break;

        }
        return enemy;
    }

    /*nemy obr() {
     Enemy obr = new Enemy();
     obr.HP = 150;
     obr.ATK = 25;
     obr.DEF = 15;
     obr.DAMAGE = setDAMAGE();
     obr.DROPCHANCE = 90;
     obr.CRITCHANCE = 70;
     obr.rarityGrade = 2;
     obr.SCORE = rand.nextInt(300) + 200;
     obr.GOLD = rand.nextInt(70) + 15;
     return obr;
     }*/

    /* Enemy medved() {
     Enemy medved = new Enemy();
     HP = 120;
     ATK = 15;
     DEF = 16;
     DAMAGE = setDAMAGE();
     DROPCHANCE = 80;
     CRITCHANCE = 50;
     rarityGrade = 2;
     SCORE = rand.nextInt(80) + 40;
     GOLD = rand.nextInt(25) + 30;
     return this;
     }

     Enemy drak() {

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
     }*/
    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public int getDEF() {
        return DEF;
    }

    @Override
    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setHP(int a) {
        HP = a;
    }

    public int setDAMAGE() {
        DAMAGE = 2 * ATK;
        return DAMAGE;
    }

    public void setDAMAGE(int a) {
        DAMAGE = a;
    }

    @Override
    public int getDrop() {
        return DROPCHANCE;
    }

    public int getCrit() {
        return CRITCHANCE;
    }

    /**
     * @return the rarityGrade
     */
    public int getRarityGrade() {
        return rarityGrade;
    }

    void setDEF(int def) {
        DEF = def;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
