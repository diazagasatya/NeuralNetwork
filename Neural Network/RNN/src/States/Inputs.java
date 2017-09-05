package States;

import java.util.Set;

/**
 * One object of this class represents the vectorized input of a character
 * Created by diazagasatya on 8/24/17.
 */
public class Inputs {

    private Set<Character> uniqueCharacters;
    private double[][] vectorizedInput;
    private char[] integerToCharacter;

    /**
     * A default constructor that initialize the arrays and other variables
     */
    public Inputs(TxtReader reader) {
        uniqueCharacters = reader.getUniqueChars();
        integerToCharacter = reader.getIntToChars();
        vectorizedInput = initializeArray();
    }

    /**
     * Initialize the vectorized inputs to 0
     * @return vectorizedInputs     vectorizedInputs
     */
    public double[][] initializeArray() {
        vectorizedInput = new double[uniqueCharacters.size()][1];
        for(int a = 0; a < uniqueCharacters.size(); a++) {
            for(int b = 0; b < 1; b++) {
                vectorizedInput[a][b] = 0;
            }
        }
        return vectorizedInput;

    }

    /**
     * Vectorized the characters into a matrices representation for feeding this to the RNN
     * @param vectorChar                                                  Unique Character
     * @return vectorCharacter                                        Vectorized Character
     */
    public void setVectorCharacter(Character vectorChar) {
        int hotIndex = 0;

        // Set every element to 0
        for(int b = 0; b < uniqueCharacters.size(); b++) {
            for(int a = 0; a < 1; a++) {
                vectorizedInput[b][a] = 0;
            }
        }

        for(int a = 0; a < uniqueCharacters.size(); a++) {
            if(integerToCharacter[a] == vectorChar) {
                hotIndex = a;
            }
        }

        vectorizedInput[hotIndex][0] = 1;
    }


    /**
     * Get vectorized inputs
     * @return vectorizedInputs        Vectorized Inputs
     */
    public double[][] getVectorizedInputs() {
        return vectorizedInput;
    }

    /**
     * Return a string representation of the vectorized inputs
     * @return fullString                String representation
     */
    public String toString() {
        String fullString = "";
        for(int a = 0; a < uniqueCharacters.size(); a++) {
            for(int b = 0; b < 1; b++) {
                fullString += vectorizedInput[a][b] + ", ";
            }
        }
        return fullString;
    }

}
