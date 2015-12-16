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
public class ClInfo {
   private PlayerProfessions c = new PlayerProfessions();
   public void Barbar(){
   c.Barbar();
       System.out.println("Barbar: ");
   getStats(c);
   } 
   public void Rogue(){
   c.Rogue();
       System.out.println("Rogue: ");
   getStats(c);
   }
  
    
    private void getStats(PlayerProfessions c){
    
    System.out.format("Atributy:"
            + "\nZivoty: %d"
            + "\nUtok: %d"
            + "\nObrana: %d"
            + "\nKriticka sance: %d"
            + "\nPoskozeni: %d"
            + "\nZbran: %s"
            + "\nBrneni: %s\n",this.c.getHP(),c.getATK(),c.getArmor(),c.getCRITCHANCE(),c.getDAMAGE(),c.getCurrentWeapon(),c.getCurrentArmor());
    }  
}
