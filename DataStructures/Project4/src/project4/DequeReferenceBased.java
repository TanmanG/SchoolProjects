/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author Tanner Good
 * @param <T>
 */
public class DequeReferenceBased<T> {
    Node<T> front;
    Node<T> back;
    int numitems;
    
    public DequeReferenceBased() {
        front = null;
        back = null;
        numitems = 0;
    }
    public void enqueueFirst(T data) {
        Node n = new Node(data);
        if (isEmpty()) {
            front = n;
            back = n;
        }
        else {
            n.next = front;
            front.last = n;
            front = n;
        }
        numitems++;
    }
    public void enqueueLast(T data) {
        Node n = new Node(data);
        if (isEmpty()) {
            front = n;
            back = n;
        }
        else {
            n.last = back;
            back.next = n;
            back = n;
        }
        numitems++;
    }
    public T dequeueFirst() throws DequeException {
        if (isEmpty()) {
            throw new DequeException("Deque is empty");
        }
        else if (numitems == 1) {
            T temp = front.data;
            front = null;
            back = null;
            numitems--;
            return temp;
        }
        else {
            T temp = front.data;
            front.next.last = null;
            front = front.next;
            numitems--;
            return temp;
        }
    }
    public T dequeueLast() throws DequeException {
        if (isEmpty()) {
            throw new DequeException("Deque is empty");
        }
        else if (numitems == 1) {
            T temp = back.data;
            front = null;
            back = null;
            numitems--;
            return temp;
        }
        else {
            T temp = back.data;
            back.last.next = null;
            back = back.last;
            numitems--;
            return temp;
        }
    }
    public T peekFirst() throws DequeException {
        if (isEmpty()) {
            throw new DequeException("Deque is empty");
        }
        else {
            return front.data;
        }
    }
    public T peekLast() throws DequeException {
        if (isEmpty()) {
            throw new DequeException("Deque is empty");
        }
        else {
            return back.data;
        }
    }
    public boolean isEmpty() {
        return numitems == 0;
    }
}

class Node<T> {
    Node next;
    Node last;
    T data;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.last = null;
    }
    public Node(T data, Node next, Node last) {
        this.data = data;
        this.next = next;
        this.last = last;
    }
}