/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import ReworkedEntities.Player;
import Rooms.Map;
import Rooms.MapBuilder;
import java.util.Random;

/**
 *
 * @author Jura
 */
public class MapMenu {

    Map[] map;
    int numberOfMaps;
    int mapsCleared;
    boolean noMapLeft = true;
    Player player;

    public MapMenu() {
    }

    public MapMenu(Player player) {
        this.player = player;
    }

    private void generateMaps() {
        Random rand = new Random();
        numberOfMaps = rand.nextInt(3) + 1;
        map = new Map[numberOfMaps];
        for (int i = 0; i < numberOfMaps; i++) {
            map[i] = new MapBuilder().buildMap(rand.nextInt(10) + 2, 3);
        }
    }

    public void mapList() {
        StringBuilder sb = new StringBuilder();
        if (noMapLeft) {
            generateMaps();
        }
        for (int i = 0; i < map.length; i++) {
         sb.append(i+1).append(". ").append(map[i].getMapName()).append("\n");
        }
        System.out.println(sb.toString());

    }
    public void goToTile(){
        mapList();
        TileMenu tileMenu = new TileMenu(player,selectMap(),0);
        tileMenu.listEnemies();
    }
 public Map selectMap(){
     System.out.println("Zadejte číslo mapy: ");
     int mapNum = InputValidator.validate(numberOfMaps);
     
     return map[(mapNum-1)];
     
 }
}
