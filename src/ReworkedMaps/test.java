/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedMaps;

import Entities.Enemy;

/**
 *
 * @author Jura
 */
public class test {

    public static void main(String[] args) {
        EnemyTile enemyTile = new Tile().populateEnemies(5, "easy").build();
        Enemy[] enemy = enemyTile.getEnemies();
        for (int i = 0; i < enemy.length; i++) {
            System.out.println(enemy[i].getName());
        }

        enemyTile = new Tile().populateEnemies(5, "").build();
        enemy = enemyTile.getEnemies();
        for (int i = 0; i < enemy.length; i++) {
            System.out.println(enemy[i].getName());
        }
    }
}
