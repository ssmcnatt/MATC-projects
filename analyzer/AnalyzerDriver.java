package java112.analyzer;


import java.io.*;


/**
 * <p>This is the main class for the Analyzer application.  It contains the main()
 * method for the application.  It calls the runAnalysis() method in the
 * AnalyzeFile class.</p>
 *
 * <p>This application receives 1 argument that contains the name of an input
 * file.  The application uses the AnalyzeFile class, the Analyzer interface,
 * and each of the classes that implement the interface.  It opens the input
 * file, reads through the file for individual tokens (words), and closes the
 * file.  The tokens are used to create 2 output reports:</p>
 *
 * <p><i>summary_report.txt</i> - Contains summary information about the application,
 * input file, and the total token count in the file.</p>
 *
 * <p><i>unique_tokens.txt</i> - Contains all of the unique tokens in the input file,
 * one on each line with no duplicates.</p>
 *
 * <p><i>big_words.txt</i> - Contains all of the big words in the input file, as
 * determined by bigwords.minimum.length in the properties file.</p>
 *
 * <p><i>token_count.txt</i> - Contains all of the unique tokens in the input file,
 * and the count of the number of each in the file.</p>
 *
 * @author Steve McNatt
 */
public class AnalyzerDriver {

    /**
     * This is the main method that creates an instance of the AnalyzeFile
     * class. It calls the runAnalysis() method to process the input file passed
     * in using the arguments parameter.
     *
     * @param arguments the command line arguments
     * @throws IOException description of the Exception
     */
    public static void main(String[] arguments) throws IOException {

        AnalyzeFile analyzer = new AnalyzeFile();

        analyzer.runAnalysis(arguments);
    }
}
