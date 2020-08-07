package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * This class contains methods to keep track of the total tokens count in the
 * input file, and creates the summary_report.txt output file.
 *
 * @author Steve McNatt
 */
public class SummaryReport implements Analyzer {

    private int totalTokensCount;
    private Properties properties;


    /**
     * This is the empty constructor.
     */
    public SummaryReport() {
    }


    /**
     * This is the constructor with one Properties parameter.  It gets the
     * properties object.
     *
     * @param properties the properties object
     */
    public SummaryReport(Properties properties) {

        this();
        this.properties = properties;
    }


    /**
     * This is the get method for the total tokens count variable.
     *
     * @return totalTokensCount the total number of tokens in the input file
     */
    public int getTotalTokensCount() {

        return totalTokensCount;
    }


    /**
     * This method processes a token in the input file.  It increments the total
     * tokens count.
     *
     * @param token one individual token (word)
     */
    public void processToken(String token) {

        totalTokensCount++;
    }


    /**
     * This method opens the summary_report.txt output file, and calls
     * writeSummaryReport to write the summary information to the file. It uses
     * exception handling when creating and writing to the file.
     *
     * @param inputFilePath the file path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.summary");

        try (PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeSummaryReport(inputFilePath, outputFile);
        } catch (IOException inputOutputException) {

            inputOutputException.printStackTrace();
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }


    /**
     * This method creates the summary_report.txt output file.  It writes summary
     * information to the file including the input file name, analysis date, and
     * total token count.
     *
     * @param inputFilePath the file path of the input file
     * @param outputFile the output file
     * @throws IOException description of the Exception
     */
    public void writeSummaryReport(String inputFilePath, PrintWriter outputFile)
    throws IOException {

        Date date = new Date();

        outputFile.println("Application: " + properties.getProperty("application.name"));
        outputFile.println("Author: " + properties.getProperty("author"));
        outputFile.println("Email: " + properties.getProperty("author.email.address"));
        outputFile.println("Inuput file: " + inputFilePath);
        outputFile.println("Analyzed on: " + date);
        outputFile.println("Total token count: " + totalTokensCount);
    }
}
