package java112.employee;


import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * This is the main SQL processing class for project 4.  It contains modules to
 * do the appropriate SQL insert and select statements.
 *
 * @author Steve McNatt
 */
public class EmployeeDirectory {

    private Properties properties;


    /**
     * Empty constructor for EmployeeDirectory
     */
    public EmployeeDirectory() {}


    /**
     * Properties constructor for EmployeeDirectory.
     */
    public EmployeeDirectory(Properties properties) {

        this();
        this.properties = properties;
    }


    /**
     * This method establishes a connection to the database.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection establishConnection() throws ClassNotFoundException,
        SQLException {

        Connection connection = null;

        Class.forName(properties.getProperty("driver"));

        connection = DriverManager.getConnection(properties.getProperty("url"),
                                                properties.getProperty("username"),
                                                properties.getProperty("password"));

        return connection;
    }


    /**
     * This method adds an employee record to the database.
     */
    public String addEmployeeRecord(String employeeFirstName,
                                    String employeeLastName,
                                    String employeeSsn,
                                    String employeeDepartment,
                                    String employeeRoomNumber,
                                    String employeePhoneNumber) {

        System.out.println("In addEmployeeRecord");
        String employeeId = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = establishConnection();

            statement = connection.createStatement();

            String sqlString = String.format("INSERT INTO employees"
                                + " (first_name, last_name, ssn, dept, room, phone)"
                                + " VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                                    employeeFirstName, employeeLastName, employeeSsn,
                                    employeeDepartment, employeeRoomNumber, employeePhoneNumber);
            System.out.println("sqlString: " + sqlString);

            statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                employeeId = String.valueOf(resultSet.getInt(1));
            }
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }


                if (statement != null) {
                    statement.close();
                }


                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return employeeId;
    }


    /**
     * This method creates a query string for the employee search.
     */
    private String createQueryString(Search search) {

        String termString = null;

        switch (search.getSearchType()) {
            case "firstName":
                termString = "first_name like '" + search.getSearchTerm() + "%'";
                break;
            case "lastName":
                termString = "last_name like '" + search.getSearchTerm() + "%'";
                break;
            case "employeeId":
                termString = "emp_id = " + search.getSearchTerm();
                break;
        }


        String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
                                + " FROM employees " + " WHERE " + termString;

        return queryString;
    }


    /**
     * This method performs a SQL search for employees in the database.
     *
     * @param searchTerm the search term
     * @param searchType the search type
     */
    public Search searchEmployee(String searchTerm, String searchType) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        System.out.println("In searchEmployee");
        Search search = new Search();

        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        String sqlString = createQueryString(search);
        System.out.println("sqlString: " + sqlString);

        try {
            connection = establishConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlString);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString("emp_id"));
                employee.setEmployeeFirstName(resultSet.getString("first_name"));
                employee.setEmployeeLastName(resultSet.getString("last_name"));
                employee.setEmployeeSsn(resultSet.getString("ssn"));
                employee.setEmployeeDepartment(resultSet.getString("dept"));
                employee.setEmployeeRoomNumber(resultSet.getString("room"));
                employee.setEmployeePhoneNumber(resultSet.getString("phone"));

                search.addFoundEmployee(employee);
                search.setFoundEmployees(true);
            }
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }


                if (statement != null) {
                    statement.close();
                }


                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return search;
    }
}
