/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import ReworkedEntities.Player;

/**
 *
 * @author Jura
 */
public class DeleteItem {

    private Inventory currentInventory;
    private Player currentPlayer;
    private int index;

    public DeleteItem(Player player,int index) {
        currentInventory = player.getpInventory();
        currentPlayer = player;
        this.index = index;
    }
    
}
