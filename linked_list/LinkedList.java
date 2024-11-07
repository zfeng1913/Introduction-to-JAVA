
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>{

  public int size;
  public Node<T> head = null;
  public Node<T> tail = null;

  public LinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // getter

  public Node<T> getHead(){
    return this.head;
  }

  public Node<T> getTail(){
    return this.tail;
  }

  public T getAtIndex(int index){
    if (index<0 || index > this.size-1){
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }
    Node<T> current = head;

    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }
  public T remove(T data) {
    if (data==null) {
      throw new IllegalArgumentException("You cannot remove null data from the list");
    }
    Node<T> removed = null;

    if (head.getData().equals(data)) {
      removed = head;
      head = head.getNext();
    } else {
      Node<T> current = head;
      Node<T> previous= head;
      for (int i = 0; i < size; i++) {
        if(current.getData().equals(data)){
          previous.setNext(current.getNext());
        if(i==size-1){
        tail = previous;
        }
        break;
      }
      current = current.getNext();
      }
    removed = current;
    }
    size--;
    return removed.getData();
  }


  public void addAtIndex(T data, int index){
    if (index<0 || index > this.size){
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }
    if (data == null){
      throw new IllegalArgumentException("You cannot add null data to the list");
    }
    Node<T> newNode = new Node<T>(data);
    if (index == 0) {
      newNode.setNext(head);
      head = newNode;
    if(isEmpty())
      tail = head;
    } else if (index == size) {
      tail.setNext(newNode);
      tail = newNode;
    } else {
      Node<T> current = head;
      for (int i = 0; i < index-1; i++) {
        current = current.getNext();
      }
      newNode.setNext(current.getNext());
      current.setNext(newNode);
      }
      this.size++;
    }



  public T removeAtIndex(int index){
    if (index<0 || index > this.size-1){
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }
    Node<T> removed = null;
    if (index == 0) {
      removed = head;
      head = head.getNext();
    } else {
      Node<T> current = head;
      int i = index;
      while (i>1){
        current = current.getNext();
        i --;}
      removed = current.getNext();

      if (index == size-1){
        tail=current;}

      current.setNext(current.getNext().getNext());
  }
  size --;
  return removed.getData();
  }

  public boolean isEmpty(){
    return this.size == 0;
  }

  public int size(){
    return this.size;
  }


  public void clear(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }


  public static void main(String[] args) {
  LinkedList<String> list = new LinkedList<>();
  list.addAtIndex("B", 0);
  list.addAtIndex("A", 0);
  list.addAtIndex("D", 2);
  list.addAtIndex("C", 2);
  System.out.println("Size of list: "+list.size());
  System.out.print("LinkedList: ");
  Node<String> start = list.getHead();
  while(start.getNext()!=null){
  System.out.print(start.getData()+"->");
  start = start.getNext();
  }
  System.out.println(start.getData());

  System.out.println("Data at 0: "+list.getAtIndex(0));
  System.out.println("Data at 3: "+list.getAtIndex(3));
  System.out.println("Data at 2: "+list.getAtIndex(2));

  System.out.println("Remove at 3: "+list.removeAtIndex(3));
  System.out.println("Remove at 0: "+list.removeAtIndex(0));

  System.out.println("Remove C: "+list.remove("C"));

  System.out.println("Size of list: "+list.size());
  System.out.print("LinkedList: ");
  start = list.getHead();
  while(start.getNext()!=null){
  System.out.print(start.getData()+"->");
  start = start.getNext();
  }
  System.out.println(start.getData());
  }
}
