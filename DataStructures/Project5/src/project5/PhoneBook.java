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
public class PhoneBook implements PhoneBookInterface{
    private TNode root;
    private int numitems;
    
    public PhoneBook(){
        root = null;
    }
    public PhoneBook(Person entry){
        root = new TNode(entry);
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void makeEmpty(){
        root = null;
        numitems = 0;
    }
    public boolean search(long number) throws TreeException{
        if(isEmpty()){
            throw new TreeException("Tree is empty");
        }
        else{
           return search(number, root); 
        }
    }
    private boolean search(long number, TNode curr){
        if(number == curr.entry.number)
            return true;
        else if(number < curr.entry.number)
            return search(number,curr.left);
        else
            return search(number, curr.right);
    }
    public void add(long number, String name) {
        Person temp = new Person(number, name);
        add(temp, root);
        numitems++;
    }
    public void add(Person entry){
        add(entry, root);
        numitems++;
    }
    private TNode add(Person entry, TNode curr){
        if(root == null) {
            root = new TNode(entry);
        }
        else if (curr == null){
            curr = new TNode(entry);
        }
        else if (entry.number < curr.entry.number){
            if (curr.left != null)
                add(entry, curr.left);
            else
                curr.left = new TNode(entry);
        }
        else{
            if (curr.right != null)
                add(entry, curr.right);
            else
                curr.right = new TNode(entry);
        }
        return curr;
    }
    public int count(){
        return numitems;
    }
    public String findName(long number) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Tree is empty");
        }
        else {
            return findName(number, root);
        }
    }
    private String findName(long number, TNode curr) {
        if(number == curr.entry.number)
            return curr.entry.name;
        else if(number < curr.entry.number)
            return findName(number, curr.left);
        else
            return findName(number, curr.right);
    }
    public long findNumber(String name) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Tree is empty");
        }
        else {
            return findNumber(name, root);
        }
    }
    private long findNumber(String name, TNode curr) {
        if (curr.entry.name.equals(name)) {
            return curr.entry.number;
        }
        else if (curr.left != null) {
            if (findNumber(name, curr.left) != -1)
                return findNumber(name, curr.left);
        }
        else if (curr.right != null) {
            if (findNumber(name, curr.right) != -1)
                return findNumber(name, curr.right);
        }
        return -1;
    }
    public void changeNumber(String name, long newNum) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Tree is empty");
        }
        else {
            changeNumber(name, newNum, root);
        }
    }
    private void changeNumber(String name, long newNum, TNode curr) {
        if (curr.entry.name.equals(name)) {
            curr.entry.number = newNum;
        }
        else if (curr.left != null) {
            changeNumber(name, newNum, curr.left);
        }
        else if (curr.right != null) {
            changeNumber(name, newNum, curr.right);
        }
    }
    public void delete(String name) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Tree is empty");
        }
        else {
            delete(name, root);
            numitems--;
        }
    }
    private void delete(String name, TNode curr) {
        System.out.println(name);
        if (curr != null) {
            if (curr.entry.name.equals(name)) {
                System.out.println("bump1");
                if (curr.left == null && curr.right == null) {
                    curr.entry = null;
                    curr = null;
                }
                else if (curr.left != null && curr.right != null) {
                    System.out.println("Hunting for successor");
                    TNode successor = inorderSuccessor(curr.right);
                    System.out.println("Successor found");
                    if (successor == null) {
                        curr = null;
                    }
                    else {
                        curr.entry.name = successor.entry.name;
                        curr.entry.number = successor.entry.number;
                        delete(successor.entry.name, curr.right);
                    }
                }
                else if (curr.left != null) {
                    System.out.println("Cutting in left");
                    curr = curr.left;
                }
                else if (curr.right != null) {
                    System.out.println("Cutting in right");
                    curr = curr.right;
                }
            }
            else if (curr.left != null) {
                System.out.println("Branch left");
                delete(name, curr.left);
            }
            else if (curr.right != null) {
                System.out.println("Branch right");
                delete(name, curr.right);
            }
            else {
                System.out.println("No luck");
            }
        }
    }
    private TNode inorderSuccessor(TNode curr) {
        if (curr == null) {
            System.out.println("Successor named: null");
            return null;
        }
        else if (curr.left == null) {
            System.out.println("Successor named: " + curr.entry.name);
            return curr;
        }
        else {
            return inorderSuccessor(curr.left);
        }
    }
    public String inorderString(){
        return inorderString(root);
    }
    private String inorderString(TNode curr){
        if(curr != null){
            return (inorderString(curr.left) + curr.entry.toString() + "\n" + inorderString(curr.right));
        }
        else {
            return null;
        }
    }
}

class TNode {
   Person entry;
   TNode left;
   TNode right;
   
   public TNode(Person entry){
       this.entry = entry;
   }
   public TNode(Person entry, TNode left , TNode right){
       this.entry = entry;
       this.left = left;
       this.right = right;
   }
}