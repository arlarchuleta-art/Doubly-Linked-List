// Adam Archuleta
// July 2026
// Data class to store row metrics for individual hurricane seasons.

public class HurricaneRowData {
    private int year;
    private int ace;
    private int category;
    private int namedStorms;
    private int hurricanes;

    public HurricaneRowData(int year, int ace, int category, int namedStorms, int hurricanes) {
        this.year = year;
        this.ace = ace;
        this.category = category;
        this.namedStorms = namedStorms;
        this.hurricanes = hurricanes;
    }

    public int getYear() { return year; }
    public int getAce() { return ace; }
    public int getCategory() { return category; }
    public int getNamedStorms() { return namedStorms; }
    public int getHurricanes() { return hurricanes; }

    @Override
    public String toString() {
        return String.format("%10d %10d %10d %10d %10d", year, ace, category, namedStorms, hurricanes);
    }
}