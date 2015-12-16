/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalgame;

import Menu.InputValidator;
import Menu.MapMenu;
import Rooms.MapNames;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jura
 */
public interface Message{
   public void sendMessage();
}

class A implements Message{
   @Override
    public void sendMessage(){
      //call the sendMessage() in class B.
    }
}

 class B implements Message{
    @Override
     public void sendMessage(){
       System.out.println("Hola Stack!");
      }

 }

    

