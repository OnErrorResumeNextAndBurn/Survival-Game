/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleEngine;

import java.util.Scanner;
import Entities.Enemy;
import Entities.EnemyAI;

import ReworkedEntities.Player;

import java.util.Random;

/**
 *
 * @author Jura
 */
public class BattleArena {

    private int pATK, pDEF, pHP, pDMG, pCrit;
    private int eATK, eDEF, eHP, eDMG, eDROP, eCRIT;
    public int eRarityGrade;
    private Player p;
    private Enemy f;
    private boolean playerWon = false, enemyWon = false;
    private boolean drop = false;

    Random rand = new Random();

    public BattleArena(Player p, Enemy e) {

        this.p = p;
        f = e;
        pHP = this.p.getHP();
        pATK = this.p.getATK();
        pDEF = p.getArmor();
        pDMG = p.getDAMAGE();
        pCrit = p.getCRITCHANCE();
        eHP = f.getHP();
        eATK = f.getATK();
        eDEF = f.getDEF();
        eDMG = f.getDAMAGE();
        eDROP = f.getDrop();
        eCRIT = f.getCrit();
        eRarityGrade = f.getRarityGrade();

    }

    public boolean BattleEngine() {
        int pDamage, eDamage;

        Scanner scan = new Scanner(System.in);

        int turn = 1;
        EnemyAI enemyAI = new EnemyAI(f);
        int i = 0;
        int b = 0;
        do {
            enemyAI.getTurn(turn);
            enemyAI.resolveAI();

            f = enemyAI.turnResult();
            eHP = f.getHP();

            eDMG = f.getDAMAGE();
            eDEF = f.getDEF();

            int randomNum = rand.nextInt(pATK) + 1;
            int percentage = ((int) (Math.random() * 100));
            if (percentage <= pCrit) {
                pDamage = (pDMG * 2 + randomNum) - eDEF;
                System.out.println("Hráč způsobuje kritické poškození!");
            } else {
                pDamage = (pDMG + randomNum) - eDEF;
            }

            percentage = ((int) (Math.random() * 100));
            randomNum = rand.nextInt(eATK / 2) + 1;
            int randomDef = rand.nextInt(pDEF / 3);
            if (percentage <= eCRIT) {
                eDamage = (eDMG * 2 + randomNum) - (randomDef + pDEF);
                System.out.println("Nepřítel způsobuje kritické poškození!");
            } else {
                eDamage = (eDMG + randomNum) - pDEF;
            }

            if (pDamage <= 0) {
                pDamage = 0;
            }
            if (eDamage <= 0) {
                eDamage = 0;
            }
            if (eDamage == 0 && pDamage == 0) {
                System.out.println("Chyba");
                break;
            }

            eHP = eHP - pDamage;

            f.setHP(eHP);
            System.out.format("Hráč způsobuje %d poškození, nepříteli zbývá %d života\n", pDamage, eHP);
            if (eHP <= 0) {
                eDamage = 0;
                i = 1;
            }
            if (i == 1) {
                break;
            }
            pHP = pHP - eDamage;
            System.out.format("Nepřítel způsobuje %d poškození, hráči zbývá %d života\n", eDamage, pHP);
            turn++;
            System.out.println("Stiskni ENTER pro pokračování");
            scan.nextLine();

            if (pHP <= 0) {
                b = 1;
            }

        } while (b == 0);

        if (pHP <= 0) {
            System.out.println("Byl jsi zabit! Konec hry!");
            System.out.format("Konečné skóre: %d bodů\n", p.getSCORE());
            System.out.println("Stiskni ENTER pro pokračování");
            scan.nextLine();
            System.exit(0);
        } else {

            p.setPostHP(pHP);

        }
        return playerWon = true;
    }

    public boolean result(boolean BattleEngine) {
        if (playerWon) {
            System.out.println("Vyhrál jsi!");

            return drop = true;
        }
        if (enemyWon) {
            System.out.println("Byl jsi zabit");
        }
        return drop = false;
    }

    public boolean getDROP() {
        return drop;
    }

    public boolean hasDrop() {
        drop = getDROP();
        if (drop == true) {
            int percentage = ((int) (Math.random() * 100));
            if (percentage <= eDROP) {
                return true;
            }
        }
        return false;
    }

    public int returnHP() {
        return this.p.getHP();
    }

}
