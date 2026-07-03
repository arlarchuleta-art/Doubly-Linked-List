// Adam Archuleta
// July 2026
// File parsing driver that tests the DoublyLinkedSortedList class.
// Citation: File parsing block was assisted by AI guidelines and customized manually.

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Run tests first
        runLengthTest();
        runSortedOrderTest();

        DoublyLinkedSortedList data = new DoublyLinkedSortedList();

        try (Scanner sc = new Scanner(new File("ace.csv"))) {
            if (sc.hasNextLine()) sc.nextLine(); // skip headers

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] tokens = line.split(",");
                if (tokens.length >= 5) {
                    int yr = Integer.parseInt(tokens[0].trim());
                    int ac = Integer.parseInt(tokens[1].trim());
                    int cat = Integer.parseInt(tokens[2].trim());
                    int ns = Integer.parseInt(tokens[3].trim());
                    int h = Integer.parseInt(tokens[4].trim());

                    data.insert(new HurricaneRowData(yr, ac, cat, ns, h));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading dataset: " + e.getMessage());
            return;
        }

        // Output formatting required verbatim by prompt instructions
        Node link = data.getFirst();
        HurricaneRowData dat = link.getValue();
        int max_year = dat.getYear();
        System.out.println("Year of max ace: " + max_year);
        System.out.println("All data in order of Ace:");
        System.out.println(data);
    }

    public static void runLengthTest() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        testList.insert(new HurricaneRowData(1990, 50, 1, 4, 1));
        testList.insert(new HurricaneRowData(1991, 60, 2, 5, 2));
        
        int count = 0;
        Node curr = testList.getFirst();
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        
        if (count == 2) {
            System.out.println("Test 1 (Length Tracking): SUCCESS");
        } else {
            System.out.println("Test 1 (Length Tracking): FAILED");
        }
    }

    public static void runSortedOrderTest() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        testList.insert(new HurricaneRowData(1990, 50, 1, 4, 1));
        testList.insert(new HurricaneRowData(1992, 120, 3, 6, 2)); // Should go first
        testList.insert(new HurricaneRowData(1991, 10, 0, 2, 0));  // Should go last

        boolean passes = (testList.getFirst().getValue().getAce() == 120) && 
                         (testList.getLast().getValue().getAce() == 10);

        if (passes) {
            System.out.println("Test 2 (Sorted Order Bound Check): SUCCESS");
        } else {
            System.out.println("Test 2 (Sorted Order Bound Check): FAILED");
        }
    }
}