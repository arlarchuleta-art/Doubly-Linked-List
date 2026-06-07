/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Assignment: Doubly-Linked Sorted List (Hurricane Data)
 * Purpose: Acts as the structural blueprint for a doubly-linked list, 
 * tracking the data payload and references to the previous and next nodes.
 * Sources: Assignment instructions and data attachments.
 * Note: Git repository used for version control (5pt Extra Credit).
 */

public class Node {
    private HurricaneRowData value;
    private Node next;
    private Node previous;

    public Node(HurricaneRowData value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public HurricaneRowData getValue() {
        return value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}