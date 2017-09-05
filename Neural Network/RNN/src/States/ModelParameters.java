package States;

/**
 * One object of this class represents the model parameters of the Recurrent Neural Network
 * Created by diazagasatya on 8/18/17.
 */
public class ModelParameters {

    private double randomWeights;
    private double[][] inputToHidden, hiddenToNextHidden, hiddenToOutput, hiddenBias, outputBias, hiddenStatePrevious; // Input = input * weight

    /**
     * A constructor that will initialize the layers as 0 vector representation
     */
    public ModelParameters() {
        int initialize = 0;
        inputToHidden = this.randomizeInputToHidden(initialize,initialize);
        hiddenToNextHidden = this.randomizeHiddenToNextHidden(initialize);
        hiddenToOutput = this.randomizeHiddenToOutput(initialize,initialize);
        hiddenBias = this.initializeHiddenBias(initialize);
        outputBias = this.initializeOutputBias(initialize);
        hiddenStatePrevious = this.initializePrevHiddenState(initialize);
    }

    /**
     * A constructor that will initialize the weight layers and biases
     * @param hiddenSize                             hidden layer size
     * @param uniqueChars                  number of unique characters
     */
    public ModelParameters(int hiddenSize, int uniqueChars) {
        inputToHidden = this.randomizeInputToHidden(hiddenSize,uniqueChars);
        hiddenToNextHidden = this.randomizeHiddenToNextHidden(hiddenSize);
        hiddenToOutput = this.randomizeHiddenToOutput(uniqueChars,hiddenSize);
        hiddenBias = this.initializeHiddenBias(hiddenSize);
        outputBias = this.initializeOutputBias(uniqueChars);
        hiddenStatePrevious = this.initializePrevHiddenState(hiddenSize);
    }

    /**
     * Randomize the weights for input to hidden state layer
     * @param hiddenSize                   hidden layer size
     * @param uniqueChars        number of unique characters
     * @return inputToHidden     input to hidden state layer
     */
    public double[][] randomizeInputToHidden(int hiddenSize, int uniqueChars) {
        inputToHidden = new double[hiddenSize][uniqueChars];

        for (int a = 0; a < hiddenSize; a++) {
            for (int b = 0; b < uniqueChars; b++) {
                randomWeights = Math.random() * 0.01;
                inputToHidden[a][b] = randomWeights;
            }
        }
        return inputToHidden;
    }

    /**
     * Randomize the weights for hidden to next hidden state layer
     * @param hiddenSize                  size of the hidden layer
     * @return hiddenToNextHidden weights of hidden to next hidden
     */
    public double[][] randomizeHiddenToNextHidden(int hiddenSize) {
        hiddenToNextHidden = new double[hiddenSize][hiddenSize];

        for (int b = 0; b < hiddenSize; b++) {
            for (int c = 0; c < hiddenSize; c++) {
                randomWeights = Math.random() * 0.01;
                hiddenToNextHidden[b][c] = randomWeights;
            }
        }
        return hiddenToNextHidden;
    }

    /**
     * Randomize the weights for hidden to output state layer
     * @param uniqueChars         number of unique characters
     * @param hiddenSize             size of the hidden layer
     * @return hiddenToOutput     weights of hidden to output
     */
    public double[][] randomizeHiddenToOutput(int uniqueChars, int hiddenSize) {
        hiddenToOutput = new double[uniqueChars][hiddenSize];

        for (int c = 0; c < uniqueChars; c++) {
            for (int d = 0; d < hiddenSize; d++) {
                randomWeights = Math.random() * 0.01;
                hiddenToOutput[c][d] = randomWeights;
            }
        }
        return hiddenToOutput;
    }

    /**
     * Initialize the hidden bias of the RNN to 0
     * @param hiddenSize        hidden layer size
     * @return hiddenBias       hidden bias layer
     */
    public double[][] initializeHiddenBias(int hiddenSize) {
        hiddenBias = new double[hiddenSize][1];

        for (int e = 0; e < hiddenSize; e++) {
            for (int f = 0; f < 1; f++) {
                hiddenBias[e][f] = 0;
            }
        }
        return hiddenBias;
    }

    /**
     * Initialize the previous hidden state of the RNN to 0
     * @param hiddenSize                  hidden layer size
     * @return hiddenStatePrev        hidden state previous
     */
    public double[][] initializePrevHiddenState(int hiddenSize) {
        hiddenStatePrevious = new double[hiddenSize][1];

        for (int e = 0; e < hiddenSize; e++) {
            for (int f = 0; f < 1; f++) {
                hiddenStatePrevious[e][f] = 0;
            }
        }
        return hiddenStatePrevious;
    }

    /**
     * Initialize the output bias of the RNN to 0
     * @param uniqueChars       unique characters
     * @return outputBias       output bias layer
     */
    public double[][] initializeOutputBias(int uniqueChars) {
        outputBias = new double[uniqueChars][1];

        for (int e = 0; e < uniqueChars; e++) {
            for (int f = 0; f < 1; f++) {
                outputBias[e][f] = 0;
            }
        }
        return outputBias;
    }

    /**
     * Get weight input to hidden layer
     * @return inputToHidden    input to hidden layer
     */
    public double[][] getInputToHidden() {
        return inputToHidden;
    }

    /**
     * Get weight hidden to next hidden layer
     * @return hiddenToNextHidden   hidden to next hidden layer
     */
    public double[][] getHiddenToNextHidden() {
        return hiddenToNextHidden;
    }

    /**
     * Get weight hidden to output layer
     * @return hiddenToOutput   hidden to output layer
     */
    public double[][] getHiddenToOutput() {
        return hiddenToOutput;
    }

    /**
     * Get weight hidden bias
     * @return hiddenBias   hidden bias layer
     */
    public double[][] getHiddenBias() {
        return hiddenBias;
    }

    /**
     * Get weight output bias
     * @return outputBias   output bias layer
     */
    public double[][] getOutputBias() {
        return outputBias;
    }

    /**
     * Get previous hidden state
     * @return hiddenStatePrevious hidden state layer 0
     */
    public double[][] getHiddenStatePrevious() { return hiddenStatePrevious; }

    /**
     * Printing all of the weights for debugging purposes
     * @param wXh        weights layer of input to hidden
     * @param wHh        weights layer of current hidden to next hidden
     * @param wHy        weights layer of hidden state to output
     * @param bH         bias of hidden layer
     * @param bY         bias of output layer
     * @param hiddenStateSize               size of hidden layer
     * @param numberOfUniqueChars           number of characters
     */
    public void printAll(double[][] wXh, double[][] wHh, double[][] wHy, double[][] bH, double[][] bY, int hiddenStateSize, int numberOfUniqueChars) {

        System.out.println("\nBelow is the weight layer of input to hidden state: ");
        for(int rows = 0; rows < hiddenStateSize; rows++) {
            for(int columns = 0; columns < numberOfUniqueChars; columns++) {
                System.out.print(wXh[rows][columns] + ", ");

            }
            System.out.println();
        }

        System.out.println("\n\nBelow is the weight layer of current hidden state to next hidden state: ");
        for(int rows = 0; rows < hiddenStateSize; rows++) {
            for(int columns = 0; columns < hiddenStateSize; columns++) {
                System.out.print(wHh[rows][columns] + ", ");

            }
            System.out.println();
        }

        System.out.println("\n\nBelow is the weight layer of hidden state to output: ");
        for(int rows = 0; rows < numberOfUniqueChars; rows++) {
            for(int columns = 0; columns < hiddenStateSize; columns++) {
                System.out.print(wHy[rows][columns] + ", ");

            }
            System.out.println();
        }

        System.out.println("\n\nBelow is the weight layer of the hidden bias");
        for(int rows = 0; rows < hiddenStateSize; rows++) {
            for(int columns = 0; columns < 1; columns++) {
                System.out.print(bH[rows][columns] + ", ");
            }
            System.out.println();
        }

        System.out.println("\n\nBelow is the weight layer of the output bias");
        for(int rows = 0; rows < numberOfUniqueChars; rows++) {
            for(int columns = 0; columns < 1; columns++) {
                System.out.print(bY[rows][columns] + ", ");
            }
            System.out.println();
        }
    }
}

