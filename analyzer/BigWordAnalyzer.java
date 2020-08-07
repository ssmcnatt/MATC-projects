package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of the big words in the input file,
 * and creates the big_words.txt output file.
 *
 * @author Steve McNatt
 */
public class BigWordAnalyzer implements Analyzer {

    private Set<String> bigWords;
    private Properties properties;
    private int minimumWordLength;


    /**
     * This is the empty constructor.
     */
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the properties 
     * object, and sets the minimumWordLength variable.
     *
     * @param properties the properties object
     */
    public BigWordAnalyzer(Properties properties) {

        this();
        this.properties = properties;

        minimumWordLength = Integer.valueOf(properties.getProperty("bigwords.minimum.length"));
    }


    /**
     * This is the get method for the big words list.
     *
     * @return bigWords the set list that contains the big words
     */
    public Set<String> getBigWords() {

        return bigWords;
    }


    /**
     * This method processes a token in the input file.  Adds the token to the
     * big words list if it is bigger than the minimum word length in the properties file.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        if (token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }


    /**
     * This method opens the big_words.txt output file, and calls
     * writeBigWords to write the big words to the file. It uses exception
     * handling when creating and writing to the file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.bigwords");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeBigWords(outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method creates the big_words.txt output file.  It writes all of
     * the tokens in the big words list to the file, one token per line.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeBigWords(PrintWriter outputFile)
    throws IOException {

        for (String token : bigWords) {

            outputFile.println(token);
        }
    }
}
