/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Assignment: Doubly-Linked Sorted List (Hurricane Data)
 * Purpose: Main driver for testing and parsing CSV hurricane data.
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();
        
        // Validation Tests
        testListLength();
        testListSorting();

        try (Scanner sc = new Scanner(new File("ace.csv"))) {
            if(sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                data.insert(new Hurricane(Integer.parseInt(p[0]), Integer.parseInt(p[1]), 
                            Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4])));
            }
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("Year of max ace: " + data.getFirst().getValue().getYear());
        System.out.println("All data in order of Ace:\n" + data);
    }

    public static void testListLength() {
        DoublyLinkedSortedList list = new DoublyLinkedSortedList();
        list.insert(new Hurricane(2000, 100, 0, 0, 0));
        list.insert(new Hurricane(2001, 150, 0, 0, 0));
        int count = 0;
        Node cur = list.getFirst();
        while(cur != null) { count++; cur = cur.getNext(); }
        System.out.println(count == 2 ? "Test 1: SUCCESS" : "Test 1: FAILED");
    }

    public static void testListSorting() {
        DoublyLinkedSortedList list = new DoublyLinkedSortedList();
        list.insert(new Hurricane(2000, 100, 0, 0, 0));
        list.insert(new Hurricane(2001, 200, 0, 0, 0));
        System.out.println(list.getFirst().getValue().getAce() == 200 ? "Test 2: SUCCESS" : "Test 2: FAILED");
    }
}