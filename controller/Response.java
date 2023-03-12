package controller;

import model.*;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * 
 * This is a class represents the response sent from controller to UI.
 * 
 * @author Wenhao Fang
 */
public class Response {

    // region Private members
    private Status status;
    private String message;
    private Staff staff;

    // endregion

    // region Constructors

    /**
     * Default constuctor.
     */
    public Response() {
        this.status = Status.ERROR;// Default status.
        this.message = "";
        this.staff = null;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Staff getStaff() {
        return staff;
    }

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
