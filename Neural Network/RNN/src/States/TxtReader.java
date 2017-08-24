package States;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * One object of this class will read the file extension given from user.
 * Fill the arrays from the txt file extension
 * Created by diazagasatya on 8/16/17.
 * This should read "Data has 40591 characters, 59 are unique."
 */
public class TxtReader {

    private char[] characters;
    private char[] intToChars;
    private int[] charToInt;
    private Set<Character> uniqueChars;
    private int[] encodedChars;
    private int numberOfCharacters;
    private int currentIndex;
    private static final int MAXCHARACTERS = 50000;
    private double[][] vectorCharacter;
    private Set<Character> storingCharacter;

    /**
     * A default constructor that will return the number of characters stored in the array
     */
    public TxtReader() {
        numberOfCharacters = getNumberOfCharacters();
    }

    /**
     * A constructor that will take the file name.
     * Create new File object using Scanner.
     * Using the Scanner object, read the txt file one character using nextChar()
     * @param fileName                                     file extension to read
     */
    public TxtReader(String fileName) {
        File inFile;
        Scanner myScanner;
        characters = new char[MAXCHARACTERS];
        storingCharacter = new HashSet<>(); // will be used for vectorizing purposes

        // Use try block to catch FileNotFoundException
        try {
            inFile = new File(fileName);
            myScanner = new Scanner(inFile);

            while(myScanner.hasNextLine()) {
                String line = myScanner.nextLine(); // read file one line at a time
                String[] tokens = line.split(""); // split the words in each line
                for(int i = 0; i < tokens.length; i++) {
                    for(int b = 0; b < tokens[i].length(); b++) {
                        characters[currentIndex] = tokens[i].charAt(b);
                        numberOfCharacters++;
                        currentIndex++;
                    }
                }
                uniqueChars = new HashSet<>();
                for(int c = 0; c < numberOfCharacters; c++) {
                    if (!uniqueChars.contains(characters[c])) {
                        uniqueChars.add(characters[c]);
                    }
                }
                characters[currentIndex] = '\n';
                numberOfCharacters++;
                currentIndex++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " is not found!");
        }

        // Print out the arrays
        System.out.println("\nHere are the list of characters inside the array: ");
        for (int a = 0; a < numberOfCharacters; a++) {
            System.out.print(characters[a] + ",");
        }
        System.out.println("\n");

        System.out.println(uniqueChars.toString());

        System.out.println("\nThere are " + numberOfCharacters + " characters in the text file, and " +
                uniqueChars.size() + " unique characters. " );
    }

    /**
     * Create an array that holds an integer representation of each unique characters
     */
    public void encodeChars() {
        encodedChars = new int[uniqueChars.size()];
        Iterator<Character> mover = uniqueChars.iterator();
        Iterator<Character> moverTwo = uniqueChars.iterator();
        System.out.print("\nEncoding characters to its ASCII integer value:");
        for(int a = 0; a < uniqueChars.size(); a++) {
            encodedChars[a] = (int)mover.next();
            encodedChars[a] = encodedChars[a] / encodedChars[a] + a - 1;
            System.out.print(moverTwo.next() + " : " + encodedChars[a] + ", ");
        }
        System.out.println("\n");
    }

    public void encodeInt() {
        // Deep copy of unique characters to
        charToInt = new int[uniqueChars.size()];
        Iterator<Character> mover = uniqueChars.iterator();
        for(int b = 0; b < uniqueChars.size(); b++) {
            charToInt[b] = mover.next();
        }
        System.out.print("\nEncoding integer value to its ASCII characters:\n");
        intToChars = new char[uniqueChars.size()];
        for(int c = 0; c < uniqueChars.size(); c++) {
            intToChars[c] = (char)charToInt[c];
            charToInt[c] = charToInt[c] / charToInt[c] + c - 1;
            System.out.print(charToInt[c] + " : " + intToChars[c] + ", ");
        }

    }

    /**
     * Get the number of unique characters in this text
     * @return uniqueChars.size()  number of characters
     */
    public int getSizeOfUniqueChars() {
        return uniqueChars.size();
    }


    /**
     * Get the number of unique characters
     * @return numberOfCharacters
     */
    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    /**
     * Return the characters stored in the array
     * @return characters      reading the text per character
     */
    public char[] getCharacters() {
        return characters;
    }

    /**
     * Get the set of uniqueChars lists
     * @return uniqueChars      the list of unique characters in the text
     */
    public Set<Character> getUniqueChars() {
        return uniqueChars;
    }

    /**
     * Get the representation of integers to characters in a char array
     * @return intToChars                           array of characters
     */
    public char[] getIntToChars() {
        return intToChars;
    }
}
