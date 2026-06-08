/*
Adam Archuleta
May 19, 2026
Purpose: Parses ace.csv hurricane records, filters data, and prints summaries.
Sources:
    Java Scanner Documentation; Stackify SDLC guidelines.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HurricaneTracker 
{
    private static final int MAX_STORMS = 1000;

    public static void main(String[] args) 
    {
        Hurricane[] storms = new Hurricane[MAX_STORMS];
        int count = 0;

        File file = new File("ace.csv");
        if (!file.exists()) 
        {
            System.out.println("Error: ace.csv not found in this directory.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) 
        {
            // Skip CSV header line if present
            if (fileScanner.hasNextLine()) 
            {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine() && count < MAX_STORMS) 
            {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) 
                {
                    continue;
                }

                // Split line on comma delimiter
                String[] tokens = line.split(",");
                if (tokens.length >= 4) 
                {
                    int year = Integer.parseInt(tokens[0].trim());
                    String name = tokens[1].trim();
                    int wind = Integer.parseInt(tokens[2].trim());
                    int pressure = Integer.parseInt(tokens[3].trim());

                    storms[count] = new Hurricane(year, name, wind, pressure);
                    count++;
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        printReport(storms, count);
    }

    private static void printReport(Hurricane[] storms, int count) 
    {
        System.out.println("\n=============================================");
        System.out.println("         HISTORICAL HURRICANE REPORT         ");
        System.out.println("=============================================");
        System.out.printf("Total Storms Tracked: %d%n%n", count);

        System.out.printf("%-5s %-15s %-6s %-10s %-10s%n", 
            "Year", "Storm Name", "Cat", "Max Wind", "Min Press");
        System.out.println("---------------------------------------------");

        int cat5Count = 0;
        for (int i = 0; i < count; i++) 
        {
            System.out.println(storms[i].toString());
            if (storms[i].getCategory() == 5) 
            {
                cat5Count++;
            }
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Total Category 5 Hurricanes: %d%n", cat5Count);
        System.out.println("=============================================");
    }
}