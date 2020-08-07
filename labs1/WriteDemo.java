package java112.labs1;


import java.io.*;


/**
 * @author Your Name Here
 * class WriteDemo
 */
public class WriteDemo {

    /**
     * Run the demo
     */
    public void run() {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            out.println("Woo!");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        WriteDemo demo = new WriteDemo();
        demo.run();
    }
}