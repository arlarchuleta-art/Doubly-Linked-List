/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Assignment: Doubly-Linked Sorted List
 * Purpose: Implements the required interface with self-sorting insertion.
 */
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node head;

    public Node getFirst() { return head; }

    public Node getLast() {
        if (head == null) return null;
        Node current = head;
        while (current.hasNext()) current = current.getNext();
        return current;
    }

    public void insert(Hurricane data) {
        Node newNode = new Node(data);
        if (head == null || data.getAce() >= head.getValue().getAce()) {
            newNode.setNext(head);
            if (head != null) head.setPrevious(newNode);
            head = newNode;
            return;
        }
        Node current = head;
        while (current.hasNext() && current.getNext().getValue().getAce() > data.getAce()) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        if (current.hasNext()) current.getNext().setPrevious(newNode);
        current.setNext(newNode);
        newNode.setPrevious(current);
    }

    public Node remove(Hurricane toRemove) {
        // Implementation logic for removal would go here
        return null; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getValue().toString()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}