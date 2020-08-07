package java112.employee;


import java.io.*;
import java.util.*;


/**
 * This is the Employee javaBean class.
 *
 * @author Steve McNatt
 */
public class Employee {

    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeSsn;
    private String employeeDepartment;
    private String employeeRoomNumber;
    private String employeePhoneNumber;


    /**
     * Constructor for Employee
     */
    public Employee() {
    }


    /**
     * Returns the value of employeeId.
     *
     * @return employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }


    /**
     * Sets the value of employeeId.
     *
     * @param employeeID The value to assign employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Returns the value of employeeFirstName.
     *
     * @return employeeFirstName
     */
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }


    /**
     * Sets the value of employeeFirstName.
     *
     * @param employeeFirstName The value to assign employeeFirstName.
     */
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }


    /**
     * Returns the value of employeeLastName.
     *
     * @return employeeLastName
     */
    public String getEmployeeLastName() {
        return employeeLastName;
    }


    /**
     * Sets the value of employeeLastName.
     *
     * @param employeeLastName The value to assign employeeLastName.
     */
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }


    /**
     * Returns the value of employeeSsn.
     *
     * @return employeeSsn
     */
    public String getEmployeeSsn() {
        return employeeSsn;
    }


    /**
     * Sets the value of employeeSsn.
     *
     * @param employeeSsn The value to assign employeeSsn.
     */
    public void setEmployeeSsn(String employeeSsn) {
        this.employeeSsn = employeeSsn;
    }


    /**
     * Returns the value of employeeDepartment.
     *
     * @return employeeDepartment
     */
    public String getEmployeeDepartment() {
        return employeeDepartment;
    }


    /**
     * Sets the value of employeeDepartment.
     *
     * @param employeeDepartment The value to assign employeeDepartment.
     */
    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


    /**
     * Returns the value of employeeRoomNumber.
     *
     * @return employeeRoomNumber
     */
    public String getEmployeeRoomNumber() {
        return employeeRoomNumber;
    }


    /**
     * Sets the value of employeeRoomNumber.
     *
     * @param employeeRoomNumber The value to assign employeeRoomNumber.
     */
    public void setEmployeeRoomNumber(String employeeRoomNumber) {
        this.employeeRoomNumber = employeeRoomNumber;
    }


    /**
     * Returns the value of employeePhoneNumber.
     *
     * @return employeePhoneNumber
     */
    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }


    /**
     * Sets the value of employeePhoneNumber.
     *
     * @param employeePhoneNumber The value to assign employeePhoneNumber.
     */
    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }


    public String toString() {

        String returnString = String.format("Employee: " 
                            + "%s, %s, %s, %s, %s, '%s, %s",
                            employeeId, employeeFirstName, employeeLastName,
                            employeeSsn, employeeDepartment, employeeRoomNumber,
                            employeePhoneNumber);
        return returnString;
    }
}

