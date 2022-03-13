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
public class StringRecognizer {
    
    public static void main(String[] args) {
        boolean jibberish = true;
        char currentParse;
        String userInput;
        
        LinkedStack<Character> processingStack = new LinkedStack();
        Scanner input = new Scanner(System.in);
        boolean stacking = true;
        
        System.out.println("Enter text to evaluate (w$w)");
        userInput = input.nextLine();
        
        for (int ind = 0; ind < userInput.length(); ind++) {
            currentParse = userInput.charAt(ind);
            if (stacking) {
                switch (currentParse) {
                    case '$':
                        stacking = false;
                        jibberish = false;
                        break;
                    default:
                        processingStack.push(currentParse);
                }   
            }
            else {
                if (!processingStack.isEmpty() && processingStack.peek() == currentParse) {
                    processingStack.pop();
                }
                else {
                    jibberish = true;
                    break;
                }
            }
        }
        if (!jibberish) {
            System.out.println("Input is within language.");
        }
        else {
            System.out.println("Input is not within language.");
        }
    }
}
