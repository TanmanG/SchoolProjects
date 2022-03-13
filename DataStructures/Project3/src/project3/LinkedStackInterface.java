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
public interface LinkedStackInterface<T> {
    public boolean isEmpty();
    public int size();
    public void push(T data);
    public T pop() throws LinkedStackException;
    public void popAll();
    public T peek() throws LinkedStackException;
}
