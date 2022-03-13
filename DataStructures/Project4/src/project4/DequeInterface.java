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
public interface DequeInterface {
    public void enqueueFirst(Object data);
    public void enqueueLast(Object last);
    public Object dequeueFirst() throws DequeException;
    public Object dequeueLast() throws DequeException;
    public Object peekFirst() throws DequeException;
    public Object peekLast() throws DequeException;
    public boolean isEmpty();
}
