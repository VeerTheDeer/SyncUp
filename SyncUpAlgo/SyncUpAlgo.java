import java.io.*;
import java.util.*;

/**
 * This class implements a synchronization algorithm to search for specific words in a set of lyrics.
 * @Collaborators: Veer Saini, Dhruva Pyapali, Noah Leong
 */
public class SyncUpAlgo {

    /**
     * The main method reads lyrics and search strings from files and searches for synchronized occurrences.
     * It prints the target word surrounded by two words on each side when it matches the surrounding context in the lyrics.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String lyricsFilePath = "lyrics.txt";
        String searchFilePath = "search.txt";

        ArrayList<String> searchStrings = readSearchStrings(searchFilePath);

        if (searchStrings == null) {
            System.out.println("Error reading search file.");
            return;
        }

        ArrayList<String> lyrics = readLyrics(lyricsFilePath);

        if (lyrics == null) {
            System.out.println("Error reading lyrics file.");
            return;
        }

        // Search for synchronized occurrences of target words in lyrics
        for (int i = 2; i < searchStrings.size() - 2; i++) {
            for (int j = 2; j < lyrics.size() - 2; j++) {
                if (searchStrings.get(i - 1).equals(lyrics.get(j - 1)) &&
                        searchStrings.get(i).equals(lyrics.get(j)) &&
                        searchStrings.get(i + 1).equals(lyrics.get(j + 1))) {
                    animateChange(lyrics, j);
                }
            }
        }
    }

    /**
     * Animate the word change.
     * @param lyrics The list of lyrics.
     * @param index The index of the word to be highlighted.
     */
    private static void animateChange(ArrayList<String> lyrics, int index) {
        StringBuilder builder = new StringBuilder();
        // Append the lyrics before the changed word
        for (int i = index - 2; i < index; i++) {
            builder.append(lyrics.get(i)).append(" ");
        }
        // Highlight the changed word
        builder.append("   *").append(lyrics.get(index)).append("*   ").append(" ");
        // Append the lyrics after the changed word
        for (int i = index + 1; i <= index + 2; i++) {
            builder.append(lyrics.get(i)).append(" ");
        }
        // Print the resulting string
        System.out.println(builder.toString());
        // Add a short delay for better visualization
        try {
            Thread.sleep(1000); // Adjust the duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads search strings from a file.
     * @param searchFilePath The path to the file containing search strings.
     * @return An ArrayList containing the search strings, or null if an error occurs.
     */
    private static ArrayList<String> readSearchStrings(String searchFilePath) {
        final ArrayList<String> searchStrings = new ArrayList<>();
        try (BufferedReader searchReader = new BufferedReader(new FileReader(searchFilePath))) {
            String searchWord;
            while ((searchWord = searchReader.readLine()) != null) {
                searchStrings.add(searchWord);
            }
        } catch (IOException e) {
            System.out.println("Error reading search file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return searchStrings;
    }

    /**
     * Reads lyrics from a file.
     * @param lyricsFilePath The path to the file containing lyrics.
     * @return An ArrayList containing the lyrics, or null if an error occurs.
     */
    private static ArrayList<String> readLyrics(String lyricsFilePath) {
        final ArrayList<String> lyrics = new ArrayList<>();
        try (BufferedReader lyricsReader = new BufferedReader(new FileReader(lyricsFilePath))) {
            String line;
            while ((line = lyricsReader.readLine()) != null) {
                String[] tempLine = line.split(" ");
                for (String input : tempLine) {
                    lyrics.add(input);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading lyrics file: " + e.getMessage());
            e.printStackTrace();
        }
        return lyrics;
    }
}
