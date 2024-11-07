public class Node<T> {
  T data;
  Node<T> next;

  public Node(T data, Node<T> next){
    this.data = data;
    this.next = next;
  }

  public Node(T data){
    this.data = data;
    this.next = null;
  }

  public T getData(){
    return this.data;
  }

  public void setData(T new_data){
    this.data = new_data;
  }
  public Node<T> getNext(){
    return this.next;
  }

  public void setNext(Node<T> new_next){
    this.next = new_next;
  }
}
