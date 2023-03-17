package controller;

import java.sql.*;

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
 * This is a class that represents a controller handling database access and
 * returned response.
 * 
 * @author Wenhao Fang
 */
public class StaffController {

    // region Predefined connection configuration arguments
    private final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

    private final String HOST_NAME = "calvin.humber.ca";
    private final String PORT = "1521";
    private final String SID = "grok";
    private final String USER_NAME = "";// use individual ID
    private final String PWD = "oracle";
    // endregion

    // region Predefined SQL
    private final String QUERY_SQL = "SELECT * FROM java_staff WHERE id = '%s'";
    private final String UNIQUE_SQL = "SELECT COUNT(*) AS COUNT FROM JAVA_STAFF WHERE ID = '%s'";
    private final String INSERT_SQL = "INSERT INTO java_staff VALUES('%s','%s','%s',upper('%s'),'%s','%s','%s','%s','%s')";
    private final String UPDATE_SQL = "UPDATE java_staff SET firstname='%s', lastname = '%s', mi = upper('%s'), address = '%s', city = '%s', state = '%s', telephone = '%s', email = '%s'WHERE id = '%s'";
    // endregion

    // Connection url
    private String connectionUrl = "";

    /*
     * Default constructor.
     * Initializes connection url.
     */
    public StaffController() {
        connectionUrl = String.format("jdbc:oracle:thin:@%s:%s:%s",
                HOST_NAME, PORT, SID);
    }

    /**
     * Checks if the database connection is valid with given configuration
     * arguments.
     * If valid, the status is success. Otherwise, the status is error.
     * 
     * @return A response object
     */
    public Response isConnect() {
        try (Connection conn = buildConn()) {
            if (conn.isValid(3)) {
                return new Response(Status.SUCCESS, "Database connected", null);
            } else {
                return new Response(Status.ERROR, "Invalid connection!", null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            return new Response(Status.ERROR, ex.getMessage(), null);
        }
    }

    /**
     * Checks if a specific id already exists
     * If so, the status is warning. Otherwise, the status is success.
     * If a sql exception is raised, then the status is Error.
     * 
     * @param id The id passed from UI.
     * @return A response object.
     */
    public Response isUnique(String id) {

        Response response = new Response();

        try (Connection conn = buildConn();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(String.format(UNIQUE_SQL, id));) {

            if (rs.next()) {
                int count = rs.getInt("COUNT");// get the number of the existing rows.
                if (count == 0) {// if none, then success
                    response.setStatus(Status.SUCCESS);
                    response.setMessage(String.format("ID %s is valid.", id));
                } else {
                    response.setStatus(Status.WARNING);
                    response.setMessage(String.format("ID %s exists already!", id));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            response.setStatus(Status.ERROR);
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    /**
     * Gets a staff information.
     * If the staff with a given id exists, builds a staff object and passes it to UI.
     * Otherwise, returns a warning message.
     * If a sql exception is raised, then returns a error message.
     * 
     * @param id The id passed from UI to query a staff.
     * @return A response object.
     */
    public Response getStaff(String id) {

        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(String.format(QUERY_SQL, id));) {

            if (rs.next()) {
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Get staff with id %s", id));
                response.setStaff(buildStaff(rs));
            } else {
                response.setStatus(Status.WARNING);
                response.setMessage(String.format("No staff with id %s", id));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            response.setStatus(Status.ERROR);
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    /**
     * Creates a new staff record.
     * If a new record has been inserted, returns a success message.
     * Otherwise, returns a warning message.
     * If a sql exception is raised, then returns a error message.
     * 
     * @param staff A staff object of the new staff.
     * @return A response object.
     */
    public Response createStaff(Staff staff) {

        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();) {
            int rowCount = statement.executeUpdate(String.format(INSERT_SQL,
                    staff.getID(), staff.getFirstName(), staff.getLastName(), staff.getMi(), staff.getAddress(),
                    staff.getCity(), staff.getState(), staff.getTelephone(), staff.getEmail())); // get the number of
                                                                                                 // row affected by the
                                                                                                 // execution.

            if (rowCount == 1) { // If one row is created
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Create a new staff with id %s.", staff.getID()));
            } else { // If no row is created
                response.setStatus(Status.WARNING);
                response.setMessage(String.format("Fail to create a new staff with id %s. Unkown cause(createStaff) ",
                        staff.getID()));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            response.setStatus(Status.ERROR);
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    /**
     * Updates a staff record.
     * If a new record has been updated, returns a success message.
     * Otherwise, returns a warning message.
     * If a sql exception is raised, then returns a error message.
     * 
     * @param id    The id passed from UI to quiery a staff.
     * @param staff A staff object with new data
     * @return A response object.
     */
    public Response updateStaff(String id, Staff staff) {
        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();) {
            int rowCount = statement.executeUpdate(String.format(UPDATE_SQL,
                    staff.getFirstName(), staff.getLastName(), staff.getMi(), staff.getAddress(),
                    staff.getCity(), staff.getState(), staff.getTelephone(), staff.getEmail(), staff.getID()));// get
                                                                                                               // the
                                                                                                               // number
                                                                                                               // of row
                                                                                                               // affected
                                                                                                               // by the
                                                                                                               // execution.

            if (rowCount == 1) {// If one row is updated
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Update staff with id %s.", staff.getID()));
            } else if (rowCount == 0) {// If no row is updated
                response.setStatus(Status.WARNING);
                response.setMessage(String.format("Update fails. Cause: no exsting staff has id %s.", staff.getID()));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            response.setStatus(Status.ERROR);
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    // region Supportive function

    /**
     * Creates a staff object from a ResultSet object.
     * 
     * @param rs A ResultSet object with query data
     * @return A staff object
     * @throws SQLException Unhandled SQLEception to be thrown.
     */
    private Staff buildStaff(ResultSet rs) throws SQLException {
        Staff staff = new Staff();

        staff.setID(rs.getString("id"));
        staff.setLastName(rs.getString("lastname"));
        staff.setFirstName(rs.getString("firstname"));
        staff.setMi(rs.getString("mi"));
        staff.setAddress(rs.getString("address"));
        staff.setCity(rs.getString("city"));
        staff.setState(rs.getString("state"));
        staff.setTelephone(rs.getString("telephone"));
        staff.setEmail(rs.getString("email"));

        return staff;
    }

    /**
     * Builds a connection object.
     * 
     * @return A connection object built with predefined configuration arguements.
     * @throws ClassNotFoundException A ClassNotFoundEception caused by loading
     *                                driver.
     * @throws SQLException           A sql exception caused by creating a
     *                                connection.
     */
    private Connection buildConn() throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(connectionUrl, USER_NAME, PWD);
    }

    // endregion
}
