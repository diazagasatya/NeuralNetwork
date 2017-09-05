package States;

/**
 * Generate 200 characters of paragraph based upon text input
 * from client using Recurrent Neural Network.
 * Created by diazagasatya on 8/18/17.
 */
public class TestRNN {

    public static void main(String[] args) {

        // Read the file here ------------------------------------------------------------------------------------------
        TxtReader reader = new TxtReader("ICEDRAGON.txt");
        reader.encodeChars();
        reader.encodeInt();

        // Vectorize the characters from text
        int numberOfUniqueChars = reader.getSizeOfUniqueChars();
        double[][] vectorizedChars;

        // Create a reference to the Input object for testing purposes, NOT TRAINING
        Inputs current;

        current = new Inputs(reader);
        current.setVectorCharacter('b');
        vectorizedChars = current.getVectorizedInputs();

        System.out.println("\n--------------------------------------------------TESTING PURPOSES---------------------------------------------------\n");

        System.out.println("Here is the vector representation of letter a:");
        for(int b = 0; b < numberOfUniqueChars; b++) {
            for(int a = 0; a < 1; a++) {
                System.out.print(vectorizedChars[b][a] + ", ");
            }
        }

        current.setVectorCharacter('b');
        vectorizedChars = current.getVectorizedInputs();

        System.out.println("\n\nHere is the vector representation of letter b:");
        for(int b = 0; b < numberOfUniqueChars; b++) {
            for(int a = 0; a < 1; a++) {
                System.out.print(vectorizedChars[b][a] + ", ");
            }
        }

        System.out.println("\n--------------------------------------------------TESTING PURPOSES ENDS---------------------------------------------------\n");

        // Please define your HYPER PARAMETERS--------------------------------------------------------------------------
        int hiddenStateSize = 100;
        int sequenceLength = 25;
        // Remember if the learning rate is too low it wouldn't converge, and if it's too high it overshoot
        double learningRate = 1e-1;

        // Please define your MODEL PARAMETERS
        // x = input, w = weight of, h = hidden, nh = next hidden, y = output, b = bias
        // Generate random numbers for weight layers
        double[][] wXh, wHh, wHy, bH, bY;
        ModelParameters paramLayers = new ModelParameters(hiddenStateSize,numberOfUniqueChars);
        wXh = paramLayers.getInputToHidden();
        wHh = paramLayers.getHiddenToNextHidden();
        wHy = paramLayers.getHiddenToOutput();
        bH = paramLayers.getHiddenBias();
        bY = paramLayers.getOutputBias();

        // Print the parameters
        paramLayers.printAll(wXh, wHh, wHy, bH, bY, hiddenStateSize, numberOfUniqueChars);

        // DO THE FORWARD PASS -----------------------------------------------------------------------------------------
        Inputs vectorInput;
        ArrayList<Inputs> vectorizedInputs = new ArrayList<>();
        ArrayList<Inputs> vectorizedTargets = new ArrayList<>();
        char[] characters = reader.getCharacters();

        System.out.println("\n--------------------------------------------------TESTING 2 PURPOSES---------------------------------------------------\n");
        System.out.println("\nHere are the vector representation of the input characters: ");

        // Store the vectorized characters into the ArrayList inputs
        for (int a = 0; a < sequenceLength; a++) {
            vectorInput = new Inputs(reader);
            vectorInput.setVectorCharacter(characters[a]);
            System.out.println("This is character: " + characters[a]);
            vectorizedInputs.add(vectorInput);
        }

        System.out.println("\nHere are the vector representation of the target characters: ");
        // Store the vectorized characters Target into the ArrayList inputs
        for (int a = 1; a < sequenceLength + 1; a++) {
            vectorInput = new Inputs(reader);
            vectorInput.setVectorCharacter(characters[a]);

            System.out.println("This is character: " + characters[a]);
            vectorizedTargets.add(vectorInput);
        }
        System.out.println("\n--------------------------------------------------TESTING 2 PURPOSES ENDS---------------------------------------------------\n");

        ForwardPass calculateLoss = new ForwardPass(reader);
        double[][] previousHiddenState;
        previousHiddenState = paramLayers.getHiddenStatePrevious();
        double loss = 0;

        // Calculate the loss of the first sequence
        loss = calculateLoss.calculateLossFunction(vectorizedInputs, vectorizedTargets, previousHiddenState, wXh, wHh, wHy, bH, bY);



    }


}
