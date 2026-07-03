// Adam Archuleta
// July 2026
// Self-sorting doubly-linked list mapping metrics in sorted order on insertion.
// Citation: Reference materials for list pointers and link updates were adapted from AI drafts.

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node head;

    public Node getFirst() { return head; }

    public Node getLast() {
        if (head == null) return null;
        Node curr = head;
        while (curr.hasNext()) {
            curr = curr.getNext();
        }
        return curr;
    }

    public void insert(HurricaneRowData newValue) {
        Node newNode = new Node(newValue);

        // Case 1: List is empty or new item belongs at the very front
        if (head == null || newValue.getAce() >= head.getValue().getAce()) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrevious(newNode);
            }
            head = newNode;
            return;
        }

        // Case 2: Find correct position inside the list
        Node curr = head;
        while (curr.hasNext() && curr.getNext().getValue().getAce() > newValue.getAce()) {
            curr = curr.getNext();
        }

        newNode.setNext(curr.getNext());
        if (curr.hasNext()) {
            curr.getNext().setPrevious(newNode);
        }
        curr.setNext(newNode);
        newNode.setPrevious(curr);
    }

    public Node remove(HurricaneRowData toRemove) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            if (curr.getValue().getYear() == toRemove.getYear() && curr.getValue().getAce() == toRemove.getAce()) {
                if (curr == head) {
                    head = head.getNext();
                    if (head != null) head.setPrevious(null);
                } else {
                    if (curr.hasPrevious()) curr.getPrevious().setNext(curr.getNext());
                    if (curr.hasNext()) curr.getNext().setPrevious(curr.getPrevious());
                }
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    // EXTRA CREDIT +2: Contains value validation check
    public boolean contains(HurricaneRowData value) {
        return getByValue(value) != null;
    }

    // EXTRA CREDIT +2: Find node reference by values matches
    public Node getByValue(HurricaneRowData value) {
        Node curr = head;
        while (curr != null) {
            if (curr.getValue().getYear() == value.getYear() && curr.getValue().getAce() == value.getAce()) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.getValue().toString());
            if (curr.hasNext()) sb.append("\n");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
