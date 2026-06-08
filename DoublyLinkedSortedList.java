/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Assignment: Doubly-Linked Sorted List (Hurricane Data)
 * Purpose: Implements a custom doubly-linked list that automatically 
 * inserts and sorts HurricaneRowData by ACE in descending order. Includes Extra Credit search methods.
 * Sources: Assignment instructions and data attachments.
 * Note: Git repository used for version control (5pt Extra Credit).
 */

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node head;

    public DoublyLinkedSortedList() {
        this.head = null;
    }

    public Node getFirst() {
        return head;
    }

    // Automatically inserts the new data in descending order based on ACE
    public void add(HurricaneRowData data) {
        Node newNode = new Node(data);

        // Case 1: List is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Case 2: New node belongs at the very front (Highest ACE)
        if (data.getAce() >= head.getValue().getAce()) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            return;
        }

        // Case 3: Traverse to find the correct insertion point
        Node current = head;
        while (current.hasNext() && current.getNext().getValue().getAce() > data.getAce()) {
            current = current.getNext();
        }

        // Insert the new node after the 'current' node
        newNode.setNext(current.getNext());
        
        if (current.hasNext()) {
            current.getNext().setPrevious(newNode); // Link back from the node ahead
        }
        
        current.setNext(newNode);
        newNode.setPrevious(current);
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

    // ==========================================
    // EXTRA CREDIT METHODS
    // ==========================================

    /* Post: Returns true if this linked list contains the given value. */
    public boolean contains(HurricaneRowData value) {
        return getByValue(value) != null;
    }

    /* Pre: This linked list contains the given value.
     * Post: Returns the node whose value matches the given value. */
    public Node getByValue(HurricaneRowData value) {
        Node current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null; // Not found
    }
}