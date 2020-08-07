package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of where a set of keywords are in an
 * input file, and creates the keyword_locations.txt output file.
 *
 * @author Steve McNatt
 */
public class KeywordAnalyzer implements Analyzer {

    private static final int MAX_LINE_LENGTH = 70;
    private Map<String, List <Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;


    /**
     * This is the empty constructor.
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List <Integer>>();
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the
     * properties object.
     *
     * @param properties the properties object
     */
    public KeywordAnalyzer(Properties properties) {

        this();
        this.properties = properties;

        readKeywordFile();
    }


    /**
     * This is the get method for the keyword map.
     *
     * @return keywordMap the map that contains the keyword locations
     */
    public Map<String, List <Integer>> getKeywordMap() {

        return keywordMap;
    }


    /**
     * This method opens the keyword file and calls the readKeywordFileLines()
     * method.
     */
    private void readKeywordFile() {

        String keywordFilePath = properties.getProperty("file.path.keywords");

        try (BufferedReader keywordFile = new BufferedReader(new FileReader(keywordFilePath))) {

            readKeywordFileLines(keywordFile);
        } catch (FileNotFoundException fileNotFoundException) {

            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method reads each line of the keyword file and loads the keyword
     * map.
     *
     * @param keywordFile the keyword file
     * @throws IOException description of the Exception
     */
    private void readKeywordFileLines(BufferedReader keywordFile) throws IOException {

        String keyword = null;

        while (keywordFile.ready()) {

            keyword = keywordFile.readLine();

            if (keyword.length() > 0) {

                keywordMap.put(keyword, new ArrayList<Integer>());
            }
        }
    }


    /**
     * This method processes a token in the input file.  If the token exists in the
     * keyword map, it adds the location counter to the occurence list of that
     * token.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        tokenOccurence++;

        if (keywordMap.containsKey(token)) {

            List<Integer> occurenceList = keywordMap.get(token);

            occurenceList.add(tokenOccurence);
        }
    }


    /**
     * This method opens the keyword_locations.txt output file, and calls
     * writeKeywordMap to write the keyword locations to the file. It uses exception
     * handling when creating and writing to the output file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir")
        + properties.getProperty("output.file.keyword");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeKeywordMap(outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method creates the keyword_locations.txt output file.  It writes all of
     * the elements in the keyword map.
     *
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeKeywordMap(PrintWriter outputFile)
    throws IOException {

        List<Integer> occurenceList = new ArrayList<Integer>();

        for (Map.Entry <String, List <Integer>> entry : keywordMap.entrySet()) {

            outputFile.println(entry.getKey() + " =");

            occurenceList = entry.getValue();

            if (occurenceList.size() == 0) {
                outputFile.println("[]");
                outputFile.println();
            } else {
                writeKeywordMapValues(outputFile, occurenceList);
            }
        }
    }


    /**
     * This method creates the keyword_locations.txt output file.  It writes the
     * location list for each token.
     *
     * @param outputFile the output file
     * @param occurenceList the occurence list for each token
     * @throws IOException description of the Exception
     */
    public void writeKeywordMapValues(PrintWriter outputFile, List<Integer> occurenceList)
    throws IOException {

        String outputString = "[";
        int listSize = occurenceList.size();

        for (int count = 0; count < listSize - 1; count++) {
            if (outputString.length() > MAX_LINE_LENGTH) {
                outputString = outputString + occurenceList.get(count) + ",";
                outputFile.println(outputString);
                outputString = "";
            } else {
                outputString = outputString + occurenceList.get(count) + ", ";
            }
        }

        outputString = outputString + occurenceList.get(listSize - 1) + "]";
        outputFile.println(outputString);
        outputFile.println();
    }
}
