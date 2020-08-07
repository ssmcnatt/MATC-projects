package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of the token sizes in the
 * input file, and creates the token_size.txt output file.
 *
 * @author Steve McNatt
 */
public class TokenSizeAnalyzer implements Analyzer {

    private static final double HISTOGRAM_WIDTH = 76.0;
    private Map<Integer, Integer> tokenSizes;
    private Properties properties;
    private int maximumSize;


    /**
     * This is the empty constructor.
     */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the
     * properties object.
     *
     * @param properties the properties object
     */
    public TokenSizeAnalyzer(Properties properties) {

        this();
        this.properties = properties;
    }


    /**
     * This is the get method for the token size map.
     *
     * @return tokenSizes the map that contains token sizes
     */
    public Map<Integer, Integer> getTokenSizes() {

        return tokenSizes;
    }


    /**
     * This method gets the maximum token size it the token sizes map
     *
     * @return maximumSize the maximum token size
     */
    public int getMaximumSize() {

        maximumSize = Collections.max(tokenSizes.values());

        return maximumSize;
    }


    /**
     * This method processes a token in the input file.  If the token exists in the
     * token sizes map, it increments the counter, otherwise it adds the token
     * to the map.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        int tokenLength = token.length();

        if (tokenSizes.containsKey(tokenLength)) {

            int count = tokenSizes.get(tokenLength);

            count++;
            tokenSizes.put(tokenLength, count);
        } else {

            tokenSizes.put(tokenLength, 1);
        }
    }


    /**
     * This method opens the token_size.txt output file, calls
     * writeTokenSizes, getMaximumSize, writeHistogram, and writeHistogramVertical.
     * to output data to the output file. It uses exception handling when creating
     * and writing to the file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir")
        + properties.getProperty("output.file.token.size");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeTokenSizes(outputFile);
            outputFile.println();
            outputFile.println();
            getMaximumSize();
            writeHistogram(outputFile);
            outputFile.println();
            outputFile.println();
            writeHistogramVertical(outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method outputs the elements in the token size map and the value of
     * each.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeTokenSizes(PrintWriter outputFile)
    throws IOException {

        for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {

            outputFile.println(entry.getKey() + "\t" + entry.getValue());
        }
    }


    /**
     * This method writes a histogram graph to the output that represents the
     * elements in the token sizes map.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeHistogram(PrintWriter outputFile)
    throws IOException {

        double asteriskValue = maximumSize / HISTOGRAM_WIDTH;

        for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {

            outputFile.print(entry.getKey() + "\t");

            int loopCount = (int)(entry.getValue() / asteriskValue);

            if (loopCount == 0) {

                outputFile.print("*");
            } else {

                for (int count = 0; count < loopCount; count++) {
                    outputFile.print("*");
                }
            }


            outputFile.println();
        }

        outputFile.println();
        outputFile.println("Asterisk value = " + asteriskValue);
    }


    /**
     * This method writes a vertical histogram graph to the output that represents
     * the elements in the token sizes map.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeHistogramVertical(PrintWriter outputFile)
    throws IOException {

        double asteriskValue = maximumSize / HISTOGRAM_WIDTH;
        int loopCount = (int)(maximumSize / asteriskValue);

        for (int count = loopCount; count > 0; count--) {

            for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {

                if (entry.getKey() >= 10) {
                    outputFile.print(" ");
                }


                double printAsterisk = entry.getValue() / asteriskValue;
                if ((count == 1) || (printAsterisk >= count)) {
                    outputFile.print("   *");
                } else {
                    outputFile.print("    ");
                }
            }

            outputFile.println();
        }

        for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {
            outputFile.print("   " + entry.getKey());
        }

        outputFile.println();
        outputFile.println();
        outputFile.println("Asterisk value = " + asteriskValue);
    }
}
