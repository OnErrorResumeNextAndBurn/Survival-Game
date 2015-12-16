/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import BattleEngine.Battle;
import Entities.Enemy;
import ReworkedEntities.Player;
import Rooms.Map;
import Rooms.MapBuilder;
import Rooms.Tile;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class TileMenu {
    private int numberDefeated = 0;
    private Battle battle;
    private Tile current;
    private Map map;
    private Tile tile;
    private Player player;
    private Enemy[] enemy;
    private boolean[] defeated;
    private int tileEnemies;

    public TileMenu(Player currentPlayer, Map map, int getTile) {
        this.map = map;
        current = map.getNextTile(getTile);
        System.out.println(current.getEnemiesOnTile());
        player = currentPlayer;
        defeated = new boolean[current.getEnemiesOnTile()];
        tileEnemies = current.getEnemiesOnTile()- 1;
    }

    public void listEnemies() {
        
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(map.getMapName()).append("\n\n");
            for (int i = 0; i < current.getEnemiesOnTile() -1; i++) {
                
                
                if (defeated[i]) {
                    sb
                            .append(i)
                            .append(". ")
                            .append(current.getEnemy(i).getName())
                            .append("[x]")
                            .append("\n");                
                } else {
                    sb
                            .append(i)
                            .append(". ")
                            .append(current.getEnemy(i).getName())
                            .append("\n");
                }
                
            }
            System.out.println(sb.toString());
            doBattle();
            sb.setLength(0);
          
        } while (numberDefeated != tileEnemies);
    }
    void doBattle(){
        System.out.println("Zadejte číslo nepřítele s kterým chcete bojovat");        
        int a = InputValidator.validate(current.getEnemiesOnTile());
        if(defeated[a] == false){
        battle = new Battle(player,current.getEnemy(a));
        battle.result(battle.BattleEngine());
        battle.GiveDrop();
        player.setPostHP(battle.returnHP());
        player.setSCORE(battle.giveScore());
        player.setGOLD(battle.giveGold());
        defeated[a] = true;
        numberDefeated++;
        } else {
            System.out.println("Nepřítel už je mrtev!");
        }
    }
}
