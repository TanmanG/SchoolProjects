/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Tanner Good
 */
public class PostfixCalculator {
    public static double calculate(String inputEquasion) {
        char parsedValue;
        int returnEquasion;
        
        double num1;
        double num2;
        
        String currentValue = "";
        LinkedStack<String> parsingStack = new LinkedStack();
        
        for (int ind = 0; ind < inputEquasion.length(); ind++) {
            parsedValue = inputEquasion.charAt(ind);
            if (inputEquasion.charAt(ind) == ' ') {
                if (currentValue.equals("")) {
                    parsingStack.push(currentValue);
                    currentValue = "";
                }
            }
            else if (!(parsedValue == '+' || parsedValue == '-'||
                        parsedValue == '*' || parsedValue == '/' ||
                        parsedValue == '%')) {
                currentValue += parsedValue;
            }
            else {
                if (!currentValue.equals("")) {
                    parsingStack.push(currentValue);
                    currentValue = "";
                }
                if (parsingStack.size() >= 2) {
                    switch (parsedValue) {
                        case '+':
                            num2 = Double.parseDouble(parsingStack.pop());
                            num1 = Double.parseDouble(parsingStack.pop());
                            parsingStack.push("" + (num2 + num1));
                            break;
                        case '-':
                            num2 = Double.parseDouble(parsingStack.pop());
                            num1 = Double.parseDouble(parsingStack.pop());
                            parsingStack.push("" + (num2 - num1));
                            break;
                        case '*':
                            num2 = Double.parseDouble(parsingStack.pop());
                            num1 = Double.parseDouble(parsingStack.pop());
                            parsingStack.push("" + (num2 * num1));
                            break;
                        case '/':
                            num2 = Double.parseDouble(parsingStack.pop());
                            num1 = Double.parseDouble(parsingStack.pop());
                            parsingStack.push("" + (num2 / num1));
                            break;
                        case '%':
                            num2 = Double.parseDouble(parsingStack.pop());
                            num1 = Double.parseDouble(parsingStack.pop());
                            parsingStack.push("" + (num2 % num1));
                            break;
                    }
                }
                else {
                    System.out.println("Bad expression");
                }
            }
        }
        
        return Double.parseDouble(parsingStack.pop());
    }
}