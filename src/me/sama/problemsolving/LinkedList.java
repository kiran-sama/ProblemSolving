package me.sama.problemsolving;

/**
 * Created by ksama on 10/6/15.
 */
public class LinkedList {
   Node head;
   Node tail;

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  private class Node {
    Node prev;
    Node next;
    int value;

    public Node(int value) {
      this.value = value;
    }

    public Node getPrev() {
      return prev;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  public Node getHead() {
    return head;
  }

  public void addNode(int value){
      if(head == null)
      {
        head = new Node(value);
        tail = head;
      }
      //Adding Node at the tail of the list
      else{
         Node toBeAdded = new Node(value);
         toBeAdded.setPrev(tail);
         tail.setNext(toBeAdded);
         tail = toBeAdded;


      }
  }

  public void printFromHead(){
    if(head == null){
      System.out.println("LinkedList is empty");
    }else{
      Node current = head;
      while(current!=null){
        System.out.println(current.getValue()+"  ");
        current = current.getNext();
      }
    }
  }

  public void printFromTail(){
    if(tail == null){
      System.out.println("LinkedList is empty");
    }else{
      Node current = tail;
      while(current!=null){
        System.out.println(current.getValue()+"  ");
        current = current.getPrev();
      }
    }
  }

  public static void main(String args[]){
    LinkedList list = new LinkedList();
    list.addNode(10);
    list.addNode(30);
    list.addNode(50);
    list.printFromHead();
    list.printFromTail();
  }
}
