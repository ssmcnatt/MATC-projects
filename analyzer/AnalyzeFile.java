package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains the runAnalysis() method called from the main() method
 * in the AnalyzeFile class.  It contains other methods used to process the
 * input file, and creates the output files for the Analyzer application.
 *
 * @author Steve McNatt
 */
public class AnalyzeFile {

    private final static int VALID_NUMBER_OF_ARGUMENTS = 2;
    private String inputFilePath;
    private Properties properties;
    private List<Analyzer> analyzers;


    /**
     * This method is called from the main() method in the AnalyzeFile class.
     * It checks to see if there are the correct number of command line arguments.
     * If there are, other methods are called to load the properties, create
     * interface instances,process the input file, and create the output files.
     *
     * @param arguments the command line arguments
     */
    public void runAnalysis(String[] arguments) {

        if (arguments.length != VALID_NUMBER_OF_ARGUMENTS) {

            System.out.println("There must be two arguments, an input file name and a properties file name");
            return;
        }


        inputFilePath = arguments[0];

        loadProperties(arguments[1]);
        createAnalyzers();
        openInputFile();
        writeAllOutputFiles();
    }


    /**
     * This method loads the given property file data into the properties object.
     *
     * @param propertiesFilePath the file path of the properties file
     */
    public void loadProperties(String propertiesFilePath) {

        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method creates an analyzer object for each analyzer, and loads them
     * into the analyzer array list.
     */
    private void createAnalyzers() {

        analyzers = new ArrayList<Analyzer>();

        analyzers.add(new SummaryReport(properties));
        analyzers.add(new UniqueTokenAnalyzer(properties));
        analyzers.add(new BigWordAnalyzer(properties));
        analyzers.add(new TokenCountAnalyzer(properties));
        analyzers.add(new TokenSizeAnalyzer(properties));
        analyzers.add(new KeywordAnalyzer(properties));
    }


    /**
     * This method processes the input file.  It opens the file, reads through the
     * file for individual tokens (words), and closes the file.  It uses exception
     * handling when processing the file.
     */
    private void openInputFile() {

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {

            readInputFileLines(inputFile);
        } catch (FileNotFoundException fileNotFoundException) {

            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method reads each line of the input file and calls the
     * processTokens() method for each one.
     *
     * @param inputFile the input file
     * @throws IOException description of the Exception
     */
    private void readInputFileLines(BufferedReader inputFile) throws IOException {

        String inputLine = null;

        while (inputFile.ready()) {

            inputLine = inputFile.readLine();
            processTokens(inputLine);
        }
    }


    /**
     * This method processes a line in the input file.  It splits the line into
     * individual tokens, and calls the callProcessTokens() method.
     *
     * @param inputLine one single line in the file
     */
    private void processTokens(String inputLine) {

        String[] tokenArray = inputLine.split("\\W");

        for (String token : tokenArray) {

            if (!token.isEmpty()) {

                callProcessTokens(token);
            }
        }
    }


    /**
     * This method processes an individual token.  It calls the processToken()
     * method for each analyzer.
     *
     * @param token an individual token in the file
     */
    private void callProcessTokens(String token) {

        for (Analyzer analyzer : analyzers) {

            analyzer.processToken(token);
        }
    }


    /**
     * This method creates the output reports.  It calls the writeOutputFile()
     * method for each analyzer.
     */
    private void writeAllOutputFiles() {

        for (Analyzer analyzer : analyzers) {

            analyzer.writeOutputFile(inputFilePath);
        }
    }
}
