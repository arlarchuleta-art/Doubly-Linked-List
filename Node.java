// Adam Archuleta
// July 2026
// Standard node container for the doubly-linked list structure.

public class Node {
    private HurricaneRowData value;
    private Node next;
    private Node previous;

    public Node(HurricaneRowData value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public HurricaneRowData getValue() { return value; }
    public boolean hasNext() { return next != null; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
    public boolean hasPrevious() { return previous != null; }
    public Node getPrevious() { return previous; }
    public void setPrevious(Node previous) { this.previous = previous; }
}