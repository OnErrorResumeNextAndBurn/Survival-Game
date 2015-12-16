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
public class PlayerLevel {
private int pLevel, pExp;
private int expNeeded;
int[] playerLevelsTemp = new int[20];

public int levelLookupArray(int a){
int j = a;
playerLevelsTemp[0] = 0;
playerLevelsTemp[1] = 0;
int xpToLevel = 50;
playerLevelsTemp[2] = xpToLevel;
    for (int i=3;i<playerLevelsTemp.length;i++){
    xpToLevel = xpToLevel*3/2;
    playerLevelsTemp[i] = xpToLevel;
    }
    
    int playerLevel = playerLevelsTemp[j+1];
    return playerLevel;
}
public void printLevels(){

for(int el:playerLevelsTemp){
    System.out.println(el);
}
}

    
}
