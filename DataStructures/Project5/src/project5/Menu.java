/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Tanner Good
 */
public class Menu {
    public static void main(String[] args) {
        runMenu();
    }
    
    public static void runMenu() {
        // Declaration & Assignment
        PhoneBook testPB = new PhoneBook();
        Scanner input = new Scanner(System.in);
        String newName;
        String newNum;
        String userInput;
        boolean exit = false;
        
        // File Creation
        try {
            File savedPhoneBook = new File("phonebook.txt");
            if (savedPhoneBook.createNewFile()) {
                System.out.println("CLEARED");
            }
            else {
                System.out.println("FILE ALREADY EXISTS");
            }
        }
        catch (IOException e) {
            System.out.println("EXCEPTION DURING FILE CREATION: " + e);
        }
        
        // Menu Navigation Loop
        while (!exit) {
            newName = " ";
            newNum = " ";
            System.out.println("------------------------------------------");
            System.out.println("Add: Add name to phonebook");
            System.out.println("Delete: Remove name from phonebook");
            System.out.println("Find: Find number from name");
            System.out.println("Change: Change number associated with name");
            System.out.println("Count: List number of people in phonebook");
            System.out.println("Quit: Exit selection");
            System.out.println("------------------------------------------");
            System.out.print("Enter Selection: ");
            userInput = input.nextLine();
            switch (userInput.toLowerCase()) {
                case("add"):
                    System.out.print("Enter name to add: ");
                    newName = input.nextLine();
                    System.out.print("Enter phone number for " + newName + ": ");
                    newNum = input.nextLine();
                    if (isParsible(newNum)) {
                        testPB.add(Long.parseLong(newNum), newName);
                        System.out.println(newName + " has been added to the phonebook.");
                    }
                    else {
                        System.out.println("Bad input! Expected positive whole number!");
                    }
                    break;
                case("delete"):
                    if (testPB.isEmpty()) {
                        System.out.println("The phonebook is empty!");
                    }
                    else {
                        System.out.print("Enter name to remove: ");
                        newName = input.nextLine();
                        if (testPB.findNumber(newName) > 0) {
                            testPB.delete(newName);
                            System.out.println(newName + " has been removed from the phonebook."); 
                        }
                        else {
                            System.out.println(newName + " does not exist in this phonebook.");
                        }
                    }
                    break;
                case("find"):
                    System.out.print("Enter name to find number to: ");
                    newName = input.nextLine();
                    if (testPB.findNumber(newName) == -1) {
                        System.out.println(newName + " does not exist in this phonebook.");
                    }
                    else {
                        System.out.println(newName + "'s number is: " + testPB.findNumber(newName));
                    }
                    break;
                case("change"):
                    System.out.print("Enter name to change number of: ");
                    newName = input.nextLine();
                    
                    if (testPB.findNumber(newName) != -1L) {
                        System.out.print("Enter new number: ");
                        newNum = input.nextLine();
                        if (isParsible(newNum)) {
                            if (Long.parseLong(newNum) > 0L) {
                                testPB.changeNumber(newName, Long.parseLong(newNum));
                                System.out.println(newName + "'s new number is " + testPB.findNumber(newName));
                            }
                            else {
                                System.out.println("Number must be positive!");
                            }
                        }
                        else {
                            System.out.println("Bad input! Expected positive whole number!");
                        }
                        
                    }
                    else {
                        System.out.println("Name not found!");
                    }
                    break;
                case("count"):
                    System.out.println("There are " + testPB.count() + " people in this phonebook.");
                    break;
                case("quit"):
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Bad input!");
            }
        }
        
        try {
            FileWriter textWriter = new FileWriter("phonebook.txt");
            textWriter.write(testPB.inorderString());
            textWriter.close();
        }
        catch (IOException e) {
            System.out.println("EXCEPTION DURING FILEWRITE: " + e);
        }
        
        // SAVE TREE TO FILE
    }
    
    public static boolean isParsible(String input) {
        boolean isParsible = true;
        long parsed;
        try {
            parsed = Long.parseLong(input);
        }
        catch(NumberFormatException e) {
            isParsible = false;
        }
        return isParsible;
    }
}
