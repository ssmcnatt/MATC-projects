package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of the token counts in the
 * input file, and creates the token_count.txt output file.
 *
 * @author Steve McNatt
 */
public class TokenCountAnalyzer implements Analyzer {

    private Map<String, Integer> tokenCounts;
    private Properties properties;


    /**
     * This is the empty constructor.
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the
     * properties object.
     *
     * @param properties the properties object
     */
    public TokenCountAnalyzer(Properties properties) {

        this();
        this.properties = properties;
    }


    /**
     * This is the get method for the token count list.
     *
     * @return tokenCounts the set list that contains token counts
     */
    public Map<String, Integer> getTokenCounts() {

        return tokenCounts;
    }


    /**
     * This method processes a token in the input file.  If the token exists in the
     * token counts list, it increments the counter, otherwise it adds the token
     * to the list.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        if (tokenCounts.containsKey(token)) {

            int count = tokenCounts.get(token);

            count++;
            tokenCounts.put(token, count);
        } else {

            tokenCounts.put(token, 1);
        }
    }


    /**
     * This method opens the token_count.txt output file, and calls
     * writeTokenCounts to write the token counts to the file. It uses exception
     * handling when creating and writing to the file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.token.count");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeTokenCounts(outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method creates the token_count.txt output file.  It writes all of
     * the elements in the token counts list to the file, one token per line.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeTokenCounts(PrintWriter outputFile)
    throws IOException {

        for (Map.Entry <String, Integer> entry : tokenCounts.entrySet()) {

            outputFile.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
