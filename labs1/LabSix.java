package java112.labs1;

import java.io.*;

/**
 * @author Steve McNatt
 * class LabSix
 */
public class LabSix {
    
    public void run(String inputFile, String outputFile) {
        
        BufferedReader input = null;
        PrintWriter output = null;
        
        try {
            input = new BufferedReader(new FileReader(inputFile));
            output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

            while (input.ready()) {
                output.println(input.readLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                
                if (output != null) {
                    output.close();
                }
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            }
        }
    }
    
    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        
        if (arguments.length != 2) {
            System.out.println("Please enter two arguments on the command line" + 
                               ", an input file name and an output file name");
            return;
        }
        
        LabSix labSix = new LabSix();
        
        labSix.run(arguments[0], arguments[1]);
    }
    
}