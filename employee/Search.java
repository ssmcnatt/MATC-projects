package java112.employee;


import java.io.*;
import java.util.*;


/**
 * This is a JavaBean for the search object.
 *
 * @author Steve McNatt
 */
public class Search {

    private String searchType;
    private String searchTerm;
    private List<Employee> queryResults;
    private boolean foundEmployees;


    /**
     *  Constructor for the Search object.
     */
    public Search() {
        System.out.println("In Search()");
        queryResults = new ArrayList<Employee>();
    }


    /**
     * Returns the value of searchType.
     *
     * @return searchType
     */
    public String getSearchType() {
        return searchType;
    }


    /**
     * Sets the value of searchType.
     *
     * @param searchType The value to assign searchType.
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


    /**
     * Returns the value of searchTerm.
     *
     * @return searchTerm
     */
    public String getSearchTerm() {
        return searchTerm;
    }


    /**
     * Sets the value of searchTerm.
     *
     * @param searchTerm The value to assign searchTerm.
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    /**
     * Returns the value of queryResults.
     *
     * @return queryResults
     */
    public List<Employee> getQueryResults() {
        return queryResults;
    }


    /**
     * Sets the value of queryResults.
     *
     * @param queryResults The value to assign queryResults.
     */
    public void setQueryResults(List<Employee> queryResults) {
        this.queryResults = queryResults;
    }


    /**
     * Returns the value of foundEmployees.
     *
     * @return foundEmployees
     */
    public boolean getFoundEmployees() {
        return foundEmployees;
    }


    /**
     * Sets the value of foundEmployees.
     *
     * @param foundEmployees The value to assign foundEmployees.
     */
    public void setFoundEmployees(boolean foundEmployees) {
        this.foundEmployees = foundEmployees;
    }

    /**
     * This method adds an employee record to the queryResults list.
     */
    public void addFoundEmployee(Employee employee) {

        System.out.println("In addFoundEmployee");
        System.out.println(employee.toString());

        queryResults.add(employee);
    }


    public String toString() {

        String returnString = String.format("Search: %s, %s, %d", 
                                searchType, searchTerm, queryResults.size());
        return returnString;
    }
}
