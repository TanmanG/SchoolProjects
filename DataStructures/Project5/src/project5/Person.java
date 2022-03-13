/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

/**
 *
 * @author Tanner Good
 */
public class Person {
    long number;
    String name;
    
    public Person(){
        number = 0;
        name = " ";
    }
    public Person(long number, String name) {
        this.number = number;
        this.name = name;
    }
    @Override
    public String toString() {
        return "{" + name + ", " + number + "}";
    }
    
}
