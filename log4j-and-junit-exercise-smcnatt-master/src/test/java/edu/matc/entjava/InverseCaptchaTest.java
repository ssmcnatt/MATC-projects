package edu.matc.entjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Unit test class for the InverseCaptcha.
 *  This class is used to
 *  1. verify the individual methods of InverseCaptcha work properly using a few test string that were provided in the project specs, and
 *  2. determine the final answer to the Captcha for yourPuzzleInput.txt.
 */
class InverseCaptchaTest {

    InverseCaptcha captcha;

    /**
     * Create a new InverseCaptcha object before each test is run.
     */
    @BeforeEach
    void setUp() {
         captcha = new InverseCaptcha();

    }

    /**
     * Determine the sum for your puzzle input, which is passed in as a file location
     */
    @Test
    void determineInverseCaptchaForYourPuzzleInput() {
        assertEquals(1228, captcha.determineInverseCaptcha("src/main/resources/yourPuzzleInput.txt"));
    }


    /**
     *  Verifies 1111 produces 4 because each digit (all 1) matches the next.
     */
    @Test
    void sumMatchingDigitsWhereAllDigitsMatch() {

        assertEquals(4, captcha.sumMatchingDigits("1111"));
    }

    @Test
    void sumMatchingDigitsWhereSomeDigitsMatch() {

        assertEquals(3, captcha.sumMatchingDigits("1122"));
    }

    @Test
    void sumMatchingDigitsWhereNoDigitsMatch() {

        assertEquals(0, captcha.sumMatchingDigits("1234"));
    }

    @Test
    void sumMatchingDigitsWhereFirstLastDigitsMatch() {

        assertEquals(9, captcha.sumMatchingDigits("91212129"));
    }

    @Test
    void determineInverseCaptchaForFileNotFound() {
        assertEquals(-1, captcha.determineInverseCaptcha("fileNotFound.txt"));
    }
}