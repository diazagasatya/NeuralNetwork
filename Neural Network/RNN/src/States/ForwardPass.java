package States;


import java.text.DecimalFormat;

/**
 * One object of this class will use the Model Parameters to calculate the next char given a char from training set.
 * Created by diazagasatya on 8/19/17.
 */
public class ForwardPass extends ModelParameters {

    private ArrayList<double[][]> inputState;
    private ArrayList<double[][]> hiddenState;
    private ArrayList outputState;
    private ArrayList probabilityState;
    private double[][] inputStateVectors;
    private double[][] vectorizedVariable;
    private char[] characters;
    private int loss;
    private int numberOfCharacters;

    /**
     * Default constructor that will initialize all of the needed variables for forward pass
     */
    public ForwardPass(TxtReader reader) {
        characters = reader.getCharacters();
        numberOfCharacters = reader.getUniqueChars().size();
        System.out.println("Number of Characters: " + numberOfCharacters);
        inputStateVectors = new double[numberOfCharacters][1];
        loss = 0;
    }

    public double calculateLossFunction(ArrayList<Inputs> sequenceInputs, ArrayList<Inputs> targets, double[][] previousHiddenState, double[][] wXh, double[][] wHh, double[][] wHy, double[][] bH, double[][] bY) {
        inputState = new ArrayList<>();
        hiddenState = new ArrayList<>();
        outputState = new ArrayList();
        probabilityState = new ArrayList<>();
        hiddenState.add(previousHiddenState);

        int counter = 0;
        int index = 0;


        // Do the Forward Pass2
        while(counter < sequenceInputs.size()) {

            double[][] getVectorized, dotProductOne, addedHiddenState, dotProductTwo;
            System.out.println("This is index " + index + " : " + sequenceInputs.getIndex(index));
            getVectorized = sequenceInputs.getIndex(index).getVectorizedInputs(); // Create a reference to an index of the array list
            inputState.add(getVectorized);
            vectorizedVariable = inputState.getIndex(index);

            // Dot product of input weight matrix layer with input state vector
            dotProductOne = dotProductFirst(wXh, vectorizedVariable);

            // Get previous hidden state matrix
            vectorizedVariable = hiddenState.getIndex(index);
            addedHiddenState = addMatricies(vectorizedVariable, bH);

            // Dor product of hidden state to hidden state weight layer with the newly sum of addedHiddenState
            dotProductTwo = dotProductSecond(wHh, addedHiddenState);




            counter++;
            index++;
        }
        return loss;
    }

    /**
     * Initialize the input state to 0
     * @return
     */
    public double[][] initializeInputZero() {
        for(int a = 0; a < numberOfCharacters; a++) {
            for(int b = 0; b < 1; b++) {
                inputStateVectors[a][b] = 0;
            }
        }
        return inputStateVectors;
    }


    /**
     * Multiply the dot product of input to weight matrices with the current input state vectorized
     * @param wXh                                                           Weight of input to weight layer matrices
     * @param currentInputStateVectorized                                             Current Input State Vectorized
     * @return results                                                                   Dot product of two matrices
     */
    public double[][] dotProductFirst(double[][] wXh, double[][] currentInputStateVectorized) {

        double[][] results = new double[wXh.length][1];

        int maxLength = wXh.length;

        int rows = 0;
        int columns = 0;

        for(int a = 0; a < maxLength; a++) {
            for(int b = 0; b < numberOfCharacters; b++) {
                results[rows][columns] += (wXh[a][b] * currentInputStateVectorized[b][0]);
            }
            System.out.println("Result of calc " + rows + ": " + String.format("%.10f" , results[rows][columns]));
            rows++;
        }

        return results;
    }

    public double[][] dotProductSecond(double[][] wHh, double[][] addedHiddenStatePreviousWithHiddenBias) {

    }


    /**
     * Sum of two matrices
     * @param previousHiddenState           previous hidden state
     * @param hiddenBias                    hidden bias
     * @return results                      sum of two matrices
     */
    public double[][] addMatricies(double[][] previousHiddenState, double[][] hiddenBias) {

        double[][] results = new double[previousHiddenState.length][1];

        for(int a = 0; a < previousHiddenState.length; a++) {
            for(int b = 0; b < 1; b++) {
                results[a][b] = previousHiddenState[a][b] + hiddenBias[a][b];
            }
        }
        return results;
    }


    public int getNumberOfCharacters(){
        return numberOfCharacters;
    }

}