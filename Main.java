/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Assignment: Doubly-Linked Sorted List (Hurricane Data)
 * Purpose: Application driver that parses CSV data, builds the self-sorting 
 * doubly-linked list, and runs validation tests to ensure length and sorting accuracy.
 * Sources: Assignment instructions and data attachments.
 * Note: Git repository used for version control (5pt Extra Credit).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // 1. Run the custom list tests first
        System.out.println("--- RUNNING LIST TESTS ---");
        testListLength();
        testListSorting();
        System.out.println("--------------------------\n");

        // 2. Original Hurricane Parsing Logic
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();

        try {
            File file = new File("ace.csv");
            Scanner scanner = new Scanner(file);
            
            // Skip header
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                
                // Assuming standard HurricaneRowData constructor layout: 
                // Year, ACE, etc. Adjust if your constructor is different.
                int year = Integer.parseInt(parts[0]);
                int ace = Integer.parseInt(parts[1]);
                int category = Integer.parseInt(parts[2]);
                int namedStorms = Integer.parseInt(parts[3]);
                int hurricanes = Integer.parseInt(parts[4]);
                
                HurricaneRowData row = new HurricaneRowData(year, ace, category, namedStorms, hurricanes);
                data.add(row);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // 3. Changed Output Logic per instructions
        if (data.getFirst() != null) {
            Node link = data.getFirst();
            HurricaneRowData dat = link.getValue();
            int max_year = dat.getYear();
            
            System.out.println("Year of max ace: " + max_year);
            System.out.println("All data in order of Ace:");
            System.out.println(data);
        }
    }

    // ==========================================
    // TEST METHODS
    // ==========================================

    public static void testListLength() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        testList.add(new HurricaneRowData(2000, 100, 0, 0, 0));
        testList.add(new HurricaneRowData(2001, 150, 0, 0, 0));
        testList.add(new HurricaneRowData(2002, 50, 0, 0, 0));

        int count = 0;
        Node current = testList.getFirst();
        while (current != null) {
            count++;
            current = current.getNext();
        }

        if (count == 3) {
            System.out.println("Test 1 (Length check): SUCCESS - List length is exactly 3.");
        } else {
            System.out.println("Test 1 (Length check): FAILED - Expected 3, got " + count);
        }
    }

    public static void testListSorting() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        testList.add(new HurricaneRowData(2000, 100, 0, 0, 0));
        testList.add(new HurricaneRowData(2001, 200, 0, 0, 0)); 
        testList.add(new HurricaneRowData(2002, 50, 0, 0, 0));

        boolean success = true;
        Node first = testList.getFirst();
        
        if (first == null || first.getValue().getAce() != 200) {
            success = false;
        }
        
        if (success) {
            System.out.println("Test 2 (Sorting check): SUCCESS - Highest ACE correctly sorted to the front.");
        } else {
            System.out.println("Test 2 (Sorting check): FAILED - List did not sort correctly upon insertion.");
        }
    }
}