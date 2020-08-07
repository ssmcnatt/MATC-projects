package java112.labs1;


/**
 * @author Steve McNatt
 * class LabThree
 */
public class LabThree {

    public void run(String input) {

        System.out.println("input: " + input);
    }

    public static void main(String[] arguments) {

        if (arguments.length != 1) {

            System.out.println("Please enter one argument on the command line");
            return;
            
        } else {

            String inputString = arguments[0];

            LabThree labThree = new LabThree();

            labThree.run(inputString);
        }
    }
}
