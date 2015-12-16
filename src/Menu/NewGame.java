/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;
import ReworkedEntities.ClInfo;

/**
 *
 * @author Jura
 */
public class NewGame {
 private String userClass;
    public void newGame(){
    int menu;
    Scanner scan = new Scanner (System.in,"Windows-1250");
        ClInfo info = new ClInfo();
        do {            
            System.out.println("Surival Game");
            System.out.println("------------");
            System.out.println("Vyberte si jednu z následujícíh specializací o které "
                    + "chcete vědět vice");
            System.out.println("<1> Barbar");
            System.out.println("<2> Rogue");
            System.out.println("<3> Jsem připraven vybrat si specializaci");
            menu = InputValidator.validate(3);
                switch(menu){
                    case 1:
                        info.Barbar();
                        break;
                    case 2: 
                        info.Rogue();
                        break;
                    case 3: break;
                   
                }
                
        } while (menu!=3);
        
    }
    public String getUserClass(){
        Scanner scan = new Scanner (System.in,"Windows-1250");
        System.out.println("Zadej zvolenou specializaci: ");
        userClass = scan.nextLine();
        ;
    return userClass;        
    }
    public String returnClass(){
    return userClass;
    }
}
