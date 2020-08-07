package edu.matc.entjava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

/**--- Day 1: Inverse Captcha ---

 Adapted from the Advent of Code Challenge Day 1 - 2017. https://adventofcode.com

 The captcha requires you to review a sequence of digits (resources/yourPuzzleInput.txt) and find the sum of all digits that match
 the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.

 For example:

 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
 1111 produces 4 because each digit (all 1) matches the next.
 1234 produces 0 because no digit matches the next.
 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

 HINT: each of the above would make good unit tests!

 Your goal is to solve the captcha for the file: resources/yourPuzzleInput.txt.

 Do NOT create a main method in your application, you will use only unit tests to find the answer. A stub has been created
 in the test directory for you.
 Add log4j to your code.
 At minimum you should
    1. log an error if there is a problem reading the file, and
    2. log the captcha answer.

 TODO: when committing and pushing your code, include screenshots showing
 1) The answer in your log file, i.e., what is the sum of the matching digits?
 2) How much code coverage you achieved (what percent?).

 **/

public class InverseCaptcha {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method reads the digit string from a file and calculates the captcha sum
     * of that string.
     *
     * @param fileLocationContainingDigits file path of file containing digits
     * @return captchaSum inverse captcha sum of digits in the file
     */
    public int determineInverseCaptcha(String fileLocationContainingDigits) {

        int captchaSum = 0;

        String listOfNumbers = readInputFile(fileLocationContainingDigits);

        if (listOfNumbers == null) {
            captchaSum = -1;
        } else {
            captchaSum = sumMatchingDigits(listOfNumbers);
        }

        return captchaSum;
    }

    /**
     * This method opens the input file, reads the string in the file, and returns that string.
     * It uses exception handling when processing the file.
     *
     * @param inputFilePath input file to read
     * @return inputLine the string in the file
     */
    private String readInputFile(String inputFilePath) {

        String inputLine = null;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {

            while (inputFile.ready()) {

                inputLine = inputFile.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {

            logger.error("File not found: " + inputFilePath, fileNotFoundException);
        } catch (IOException inputOutputException) {

            logger.error("IO exception in file: " + inputFilePath, inputOutputException);
        } catch (Exception exception) {

            logger.error("Other exception in file: " + inputFilePath, exception);
        }

        return inputLine;
    }

    /**
     * This method calculates the inverse captcha sum of the number string passed in.
     *
     * @param listOfNumbers the list of numbers
     * @return captchaSum the inverse captcha sum
     */
    protected int sumMatchingDigits(String listOfNumbers) {

        int captchaSum = 0;
        int listCount = listOfNumbers.length();
        String charString;

        for (int indx = 0 ; indx<listCount - 1; indx++) {
            if (listOfNumbers.charAt(indx) == listOfNumbers.charAt(indx + 1)) {
                charString = String.valueOf(listOfNumbers.charAt(indx));
                captchaSum += Integer.valueOf(charString);
            }
        }

        //Compare first and last characaters
        if (listOfNumbers.charAt(0) == listOfNumbers.charAt(listCount - 1)) {
            charString = String.valueOf(listOfNumbers.charAt(0));
            captchaSum += Integer.valueOf(charString);
        }

        logger.info("Captcha sum is: " + captchaSum);

        return captchaSum;
    }
}
