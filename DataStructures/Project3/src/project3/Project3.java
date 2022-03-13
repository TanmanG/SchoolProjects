/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.Scanner;

/**
 *
 * @author Tanner Good
 */
public class Project3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter equasion to convert & Calculate: ");
        String userInput = input.nextLine();
        
        System.out.println(InfixToPostfix.convert(userInput));
        System.out.println(PostfixCalculator.calculate(InfixToPostfix.convert(userInput)));
    }
    
}
