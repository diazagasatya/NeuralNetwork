package States;


/**
 * One object of this class will use the Model Parameters to calculate the next char given a char from training set.
 * Created by diazagasatya on 8/19/17.
 */
public class ForwardPass extends ModelParameters {

    private ArrayList inputState;
    private ArrayList hiddenState;
    private ArrayList outputState;
    private ArrayList probabilityState;
    private int[][] inputStateVectors;
    private char[] characters;
    private int loss;
    private int numberOfCharacters;

    /**
     * Default constructor that will initialize all of the needed variables for forward pass
     */
    public ForwardPass() {
        TxtReader testing = new TxtReader();
        characters = testing.getCharacters();
        numberOfCharacters = testing.getNumberOfCharacters();
        inputStateVectors = new int[numberOfCharacters][1];
        loss = 0;
    }

    public double calculateLossFunction(ArrayList<Inputs> inputs, ArrayList<Inputs> targets, double[][] previousHiddenState, double[][] wXh, double[][] wHh, double[][] wHy, double[][] bH, double[][] bY) {
        inputState = new ArrayList();
        hiddenState = new ArrayList();
        outputState = new ArrayList();
        probabilityState = new ArrayList<>();
        hiddenState.add(previousHiddenState); // hiddenState head = previous hidden state

        int counter = 0;
        int index = 0;

        // Do the Forward Pass
        while(counter <= inputs.size()) {
            inputStateVectors = initializeInputZero(); // Initialize the input to zero
            inputState.add(inputStateVectors);
            inputState.add(inputs.getIndex(index));
            counter++;
            index++;

        }
        return loss;
    }

    /**
     * Initialize the input state to 0
     * @return
     */
    public int[][] initializeInputZero() {
        for(int a = 0; a < numberOfCharacters; a++) {
            for(int b = 0; b < 1; b++) {
                inputStateVectors[a][b] = 0;
            }
        }
        return inputStateVectors;
    }



}