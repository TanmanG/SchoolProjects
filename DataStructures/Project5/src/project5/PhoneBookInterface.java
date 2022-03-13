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
public interface PhoneBookInterface {
    public boolean isEmpty();
    public void makeEmpty();
    public boolean search(long number) throws TreeException;
    public void add(long number, String name);
    public void add(Person entry);
    public int count();
    public void delete(String name) throws TreeException;
    public String findName(long number) throws TreeException;
    public long findNumber(String name) throws TreeException;
}
