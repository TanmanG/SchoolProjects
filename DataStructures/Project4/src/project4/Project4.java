/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author Tanner Good
 */
public class Project4 {

    public static void main(String[] args) {
        String example1 = "$";
        String example2 = "w$w";
        String example3 = "wa$awa";
        String example4 = "waa$aa";
        
        System.out.println(languageDetector(example1));
        System.out.println(languageDetector(example2));
        System.out.println(languageDetector(example3));
        System.out.println(languageDetector(example4));
    }
    
    public static boolean languageDetector(String input) {
        DequeReferenceBased<Character> parseDeque = new DequeReferenceBased();
        boolean withinLanguage;
        boolean signFound = false;
        for (int ind = 0; ind < input.length(); ind++) {
            if (input.charAt(ind) == '$') {
                signFound = true;
            }
            else if (!signFound) {
                parseDeque.enqueueFirst(input.charAt(ind));
            }
            else if (parseDeque.isEmpty()) {
                return false;
            }
            else if (parseDeque.dequeueFirst() != input.charAt(ind)) {
                return false;
            }
        }
        return (parseDeque.isEmpty());
    }
    
}
