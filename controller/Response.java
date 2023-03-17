package controller;

import model.*;

/*************************************************************************************************
 * Course_Name – Assignment 04
 * 
 * I declare that this assignment is my own work in accordance with Humber
 * Academic Policy. 
 * 
 * No part of this assignment has been copied manually or electronically from
 * any other source (including web sites) or distributed to other students/social media.
 * 
 * Name: Wenhao Fand 
 * Student ID: N01555914
 * Date: 2023/03/17
 * 
 *************************************************************************************************/

/**
 * This is a class that represents a response passing data from controller to
 * UI.
 * 
 * @author Wenhao Fang
 */
public class Response {

    // region Private members
    private Status status;// The status of the controller's action.
    private String message;// The message to be passed from controller to UI.
    private Staff staff;// A Staff object to be passed.

    // endregion

    // region Constuctors
    /**
     * Default constuctor.
     * Initializes values.
     */
    public Response() {
        this.status = Status.ERROR;// Default status.
        this.message = "";
        this.staff = null;// By default, the Staff object always be null.
    }

    /**
     * Constructors with 3 parameters.
     * 
     * @param status  The status sent from the IO.
     * @param message The message to pass to UI.
     * @param staff   A staff.
     */
    public Response(Status status, String message, Staff staff) {
        this.status = status;
        this.message = message;
        this.staff = staff;
    }

    // endregion

    // region Setters and Getters

    /**
     * Gets response's status
     * 
     * @return A status object.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets response's status
     * 
     * @param status A status object.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets response message.
     * 
     * @return A string message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets a response's message.
     * 
     * @param message A string message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets a response's Staff.
     * 
     * @return The staff object of this response.
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Sets a response's staff.
     * 
     * @param staff A staff object.
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    // endregion

    // region Supportive methods

    /**
     * Overrides the toString() method.
     * Print the information of reponse.
     */
    @Override
    public String toString() {
        return "%s\t%s\n%s".formatted(status, message, staff);
    }
    // endregion
}
