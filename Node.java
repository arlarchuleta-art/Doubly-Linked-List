public class Node {
    private Hurricane value;
    private Node next, previous;
    public Node(Hurricane value) { this.value = value; }
    public Hurricane getValue() { return value; }
    public boolean hasNext() { return next != null; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
    public boolean hasPrevious() { return previous != null; }
    public Node getPrevious() { return previous; }
    public void setPrevious(Node previous) { this.previous = previous; }
}