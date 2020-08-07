package edu.matc.entjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * TODO Practice working with JUnit by writing the following test cases for the Interface List<E> using the concrete class ArrayList.
 * A BeforeEach method and a test for a successful add have been provided as examples.
 *
 * 1.1 void add(int index, E e)
 * 1.2 void remove(int index)
 * 1.3 void get(int index)
 * 1.4 Add at least one test for an exception.
 */
public class ListTest {

    private List<String> myList;

    @BeforeEach
    public void setup() {
        myList = new ArrayList<String>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
    }

    @Test
    public void testAddSuccess() {
        String elementToInsert = "Item 4";
        myList.add(elementToInsert);
        assertEquals(4, myList.size());
        assertTrue(myList.contains(elementToInsert));
    }

    @Test
    public void testAddRemove() {
        String elementToRemove = "Item 2";
        myList.remove(elementToRemove);
        assertEquals(2, myList.size());
        assertFalse(myList.contains(elementToRemove));
    }

    @Test
    public void testAddGet() {
        int indexToGet = 2;
        String elementToGet = myList.get(indexToGet);
        assertEquals(elementToGet, "Item 3");
    }

    @Test
    public void testIndexOutOfBoundsException() {
        int indexToTest = 3;
        boolean exceptionFound = false;
        try {
            String noElement = myList.get(indexToTest);
        } catch (IndexOutOfBoundsException e) {
            exceptionFound = true;
        }
        assertTrue(exceptionFound);
    }

}