package java112.analyzer;


import java.io.*;


/**
 * This is the interface class implemented by the SummaryReport and
 * UniqueTokenAnalyzer classes.
 *
 * @author Steve McNatt
 */
public interface Analyzer{

    /**
     * This method processes a token in the input file.
     *
     * @param token one individual token (word)
     */
    void processToken(String token);
    /**
     * This method creates an output file.
     *
     * @param inputFilePath the file path of the input file
     */
    void writeOutputFile(String inputFilePath);
}
