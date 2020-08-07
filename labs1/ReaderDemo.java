package java112.labs1;


import java.io.*;


/**
 * @author Your Name Here
 * class ReaderDemo
 */
public class ReaderDemo {

    /**
     * Run the demo
     */
    public void run() {

        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("sample.txt"));

            while (input.ready()) {
                System.out.println(input.readLine());
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
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            }
        }
    }


    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        ReaderDemo demo = new ReaderDemo();
        demo.run();
    }
}