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
public class Tile implements EnemyTile, NonEnemyTile {

    private Enemy[] enemy;
    private boolean clearFlag = false;
    private String flavorText;
    private String type;

    @Override
    public Enemy[] getEnemies() {
        return enemy;
    }

    @Override
    public void setClearFlag() {
        clearFlag = true;
    }

    @Override
    public String getFlavorText() {
        return flavorText;
    }

    @Override
    public boolean getClearFlag() {
        return clearFlag;
    }

    @Override
    public String getType() {
        return type;
    }
    public Tile populateEnemies(int numberOfEnemies, String difficulty){
        enemy = new Enemy[numberOfEnemies];
        for (int i = 0; i < numberOfEnemies; i++) {
           enemy[i] = TilePopulator.generateEnemy(difficulty);            
        }
        return this;
    }

public Tile build(){
return this;
}

}
