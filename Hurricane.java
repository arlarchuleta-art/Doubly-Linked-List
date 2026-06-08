/*
 * Name: Adam Archuleta
 * Date: June 7, 2026
 * Due Date: June 28, 2026
 * Purpose: Hurricane data object with support for legacy and new list constructors.
 */
public class Hurricane {
    private int year, ace, category, namedStorms, hurricanes;
    private String name;

    // Constructor for the new DoublyLinkedSortedList
    public Hurricane(int year, int ace, int category, int namedStorms, int hurricanes) {
        this.year = year;
        this.ace = ace;
        this.category = category;
        this.namedStorms = namedStorms;
        this.hurricanes = hurricanes;
    }

    // Legacy constructor for HurricaneTracker
    public Hurricane(int year, String name, int wind, int pressure) {
        this.year = year;
        this.name = name;
        this.category = 0; // Default
    }

    public int getAce() { return ace; }
    public int getYear() { return year; }
    public int getCategory() { return category; }
    
    @Override
    public String toString() {
        return year + "\t" + ace + "\t" + category + "\t" + namedStorms + "\t" + hurricanes;
    }
}