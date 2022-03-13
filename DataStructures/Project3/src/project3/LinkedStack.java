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
public class LinkedStack<T> implements LinkedStackInterface<T> {
    Node<T> top;
    int numitems;
    
    public LinkedStack(){
        top = null;
        numitems = 0;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int size(){
        return numitems;
    }
    public void push(T data) {
        Node newnode = new Node(data);
        newnode.next = top;
        top = newnode;
        numitems++;
    }
    public T pop() throws LinkedStackException{
        if(!isEmpty()){
            T temp = top.data;
            top = top.next;
            numitems--;
            return temp;
        }
        else{
            throw new LinkedStackException("stack is empty");
        }
    }
    public void popAll(){
        top = null;
        numitems = 0;
    }
    public T peek() throws LinkedStackException{
        if(!isEmpty()){
            return top.data;
        }
        else{
            throw new LinkedStackException("stack empty");
        }
    }
}

class Node<T> {
    T data;
    Node next;
    
    public Node(T data){
        this.data = data;
        this.next = null;
        
    }
    public Node(T data, Node next){
        this.data = data;
        this.next = next;
        
    }
}
