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
public class InfixToPostfix {
    public static String convert(String input) {
        LinkedStack<Character> parsingStack = new LinkedStack();
        String convertedEquasion = "";
        char currentParse;
        
        for (int ind = 0; ind < input.length(); ind++) {
            currentParse = input.charAt(ind);
            switch (currentParse) {
                case '+':
                    if (parsingStack.isEmpty()) {
                        parsingStack.push('+');
                    }
                    else {
                        if (parsingStack.peek() == '*' || parsingStack.peek() == '/' || parsingStack.peek() == '%') {
                            convertedEquasion += parsingStack.pop();
                            parsingStack.push('+');
                        }
                        else {
                            parsingStack.push('+');
                        }
                    }
                    break;
                case '-':
                    if (parsingStack.isEmpty()) {
                        parsingStack.push('-');
                    }
                    else {
                        if (parsingStack.peek() == '*' || parsingStack.peek() == '/' || parsingStack.peek() == '%') {
                            convertedEquasion += parsingStack.pop();
                            parsingStack.push('-');
                        }
                        else {
                            parsingStack.push('-');
                        }
                    }
                    break;
                case '*':
                    if (parsingStack.isEmpty()) {
                        parsingStack.push('*');
                    }
                    else {
                        if (parsingStack.peek() == '*' || parsingStack.peek() == '/' || 
                                parsingStack.peek() == '%') {
                            convertedEquasion += parsingStack.pop();
                            parsingStack.push('*');
                        }
                        else {
                            parsingStack.push('*');
                        }
                    }
                    break;
                case '/':
                    if (parsingStack.isEmpty()) {
                        parsingStack.push('/');
                    }
                    else {
                        if (parsingStack.peek() == '*' || parsingStack.peek() == '/' || 
                                parsingStack.peek() == '%') {
                            convertedEquasion += parsingStack.pop();
                            parsingStack.push('/');
                        }
                        else {
                            parsingStack.push('/');
                        }
                    }
                    break;
                case '%':
                    if (parsingStack.isEmpty()) {
                        parsingStack.push('%');
                    }
                    else {
                        if (parsingStack.peek() == '*' || parsingStack.peek() == '/' || 
                                parsingStack.peek() == '%') {
                            convertedEquasion += parsingStack.pop();
                            parsingStack.push('%');
                        }
                        else {
                            parsingStack.push('%');
                        }
                    }
                    break;
                case '(':
                    parsingStack.push('(');
                case ')':
                    boolean foundParenthesis = false;
                    while (!foundParenthesis) {
                        if (!parsingStack.isEmpty()) {
                            if (parsingStack.peek() == '(') {
                                foundParenthesis = true;
                                parsingStack.pop();
                            }
                            else {
                                convertedEquasion += parsingStack.pop();
                            }
                        }
                        break;
                    }
                default:
                    convertedEquasion += currentParse;
            }
        }
        
        int stackSize = parsingStack.size();
        for (int ind = 0; ind < stackSize; ind++) {
            convertedEquasion += parsingStack.pop();
        }
        
        return convertedEquasion;
    }
}
