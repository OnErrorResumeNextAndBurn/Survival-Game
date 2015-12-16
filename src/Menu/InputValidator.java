/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class InputValidator {

    public static int validate(int maxBound) {
        int controlVar = maxBound;
        Scanner scan = new Scanner(System.in);
        boolean wrongInputLoopThrough = false;
        int validatedInput = -1;
        do {
            if (wrongInputLoopThrough) {
                System.out.println("Neplatná hodnota, prosím opakujte svou volbu!");
            }
            try {
                validatedInput = Integer.parseInt(scan.nextLine());
                wrongInputLoopThrough = true;
            } catch (NumberFormatException e) {
                System.out.println("Neplatná hodnota, prosím opakujte svou volbu!");
                validatedInput = validate(controlVar);
            }
        } while (validatedInput < 0 || validatedInput > controlVar);
        return validatedInput;
    }

    

}
