// Import the File class to handle files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads unsorted numbers from a file,
 * sorts them using Insertion Sort, and writes them to a file.
 *
 * @author  Yoma Ozoh
 * @version 1.0
 * @since   2026-11-22
 */
public final class InsertSort {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private InsertSort() {
    }

    /**
     * Sorts an array of integers using the insertion sort algorithm.
     *
     * @param listOfNum Array of integers to be sorted
     */
    public static void insertSort(final int[] listOfNum) {
        // Get the length of the integer array
        final int n = listOfNum.length;

        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Store the current number to be compared
            final int key = listOfNum[i];
            // Set the index for the previous number
            int j = i - 1;

            // Loop backward as long as j is valid
            // and the previous number is bigger than the key
            while (j >= 0 && listOfNum[j] > key) {
                // Move the bigger number one position to the right
                listOfNum[j + 1] = listOfNum[j];
                // Move to the next number
                j = j - 1;
            }
            // Insert into the correct position
            listOfNum[j + 1] = key;
        }
    }

    /**
     * Main method to execute file reading and sorting.
     *
     * @param args Command line arguments
     * @throws FileNotFoundException If an input file is not found
     */
    public static void main(final String[] args) throws FileNotFoundException {
        // Create a Scanner object to read the input text file
        final Scanner scanner = new Scanner(new File("input.txt"));
        // Create a PrintWriter object to write to the output text file
        final PrintWriter writer = new PrintWriter(new File("output.txt"));

        // Loop through the file as long as there is another line of text
        while (scanner.hasNextLine()) {
            // Read line of text as a String
            final String line = scanner.nextLine();

            // Skip the line if it is completely empty
            if (line.isEmpty()) {
                // Move to the next line in the loop
                continue;
            }

            // Split the line by spaces and put the strings into an array
            final String[] stringNumbers = line.split(" ");

            // Create a new integer array with the same size as the string array
            final int[] numbers = new int[stringNumbers.length];

            // Loop through each item in the string array
            for (int i = 0; i < stringNumbers.length; i++) {
                // Convert the string into an integer and save it in the array
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }

            // Pass the integer array to the insertSort method to be sorted
            insertSort(numbers);

            // Loop through the newly sorted integer array
            for (int i = 0; i < numbers.length; i++) {
                // Write the number to the output file
                writer.print(numbers[i]);
                // Check if the current number is NOT the last one in the array
                if (i < numbers.length - 1) {
                    // Write a space after the number
                    writer.print(" ");
                }
            }
            // Move to the next line in the output file
            writer.println();
        }

        // Close the scanner so it stops reading the file
        scanner.close();
        // Close the writer so it saves the file properly
        writer.close();
        // Print a message to the console showing it finished
        System.out.println("Sorting done");
    }
}
