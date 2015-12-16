/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedEntities;

/**
 *
 * @author Jura
 */
public class PlayerInfo {

    public PlayerInfo(Player c) {
        System.out.format("\n"
                + "\nŽivoty:\t\t%d"
                + "\nObrana:\t\t%d"
                + "\nPoškozeni:\t%d"
                + "\nZbraň:\t\t%s"
                + "\nBrnění:\t\t%s"
                + "\nBody:\t\t%d"
                + "\nZlato:\t\t%d\n", c.getHP(), c.getArmor(), c.getDAMAGE(), c.getCurrentWeapon(), c.getCurrentArmor(),c.getSCORE(),c.getGOLD());
    }
}
