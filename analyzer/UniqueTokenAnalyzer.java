package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of the unique tokens in the
 * input file, and creates the unique_tokens.txt output file.
 *
 * @author Steve McNatt
 */
public class UniqueTokenAnalyzer implements Analyzer {

    private Set<String> uniqueTokens;
    private Properties properties;


    /**
     * This is the empty constructor.
     */
    public UniqueTokenAnalyzer() {
        uniqueTokens = new TreeSet<String>();
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the
     * properties object.
     *
     * @param properties the properties object
     */
    public UniqueTokenAnalyzer(Properties properties) {

        this();
        this.properties = properties;
    }


    /**
     * This is the get method for the unique token list.
     *
     * @return uniqueTokens the set list that contains unique tokens
     */
    public Set<String> getUniqueTokensList() {

        return uniqueTokens;
    }


    /**
     * This method processes a token in the input file.  Adds the token to the
     * unique token list if it does not already exist in the list.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        uniqueTokens.add(token);
    }


    /**
     * This method opens the unique_tokens.txt output file, and calls
     * writeUniqueTokens to write the tokens to the file. It uses exception
     * handling when creating and writing to the file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.unique");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeUniqueTokens(inputFilePath, outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method creates the unique_tokens.txt output file.  It writes all of
     * the tokens in the unique tokens list to the file, one token per line.
     *
     * @param inputFilePath the file path of the input file
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeUniqueTokens(String inputFilePath, PrintWriter outputFile)
    throws IOException {

        for (String token : uniqueTokens) {

            outputFile.println(token);
        }
    }
}
