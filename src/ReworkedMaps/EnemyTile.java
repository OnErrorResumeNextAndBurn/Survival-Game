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
public interface EnemyTile {
Enemy[] getEnemies();
void setClearFlag();
String getFlavorText();
boolean getClearFlag();
}
