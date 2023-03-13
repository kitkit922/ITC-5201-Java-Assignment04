package controller;

import java.sql.*;

import model.*;

public class StaffController {

    private final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

    private final String HOST_NAME = "calvin.humber.ca";
    private final String PORT = "1521";
    private final String SID = "grok";
    private final String USER_NAME = "n01555914";
    private final String PWD = "oracle";

    private final String QUERY_SQL = "SELECT * FROM java_staff WHERE id = '%s'";
    private final String UNIQUE_SQL = "SELECT COUNT(*) AS COUNT FROM JAVA_STAFF WHERE ID = '%s'";
    private final String INSERT_SQL = "INSERT INTO java_staff VALUES('%s','%s','%s',upper('%s'),'%s','%s','%s','%s','%s')";
    private final String UPDATE_SQL = "UPDATE java_staff SET firstname='%s', lastname = '%s', mi = upper('%s'), address = '%s', city = '%s', state = '%s', telephone = '%s', email = '%s'WHERE id = '%s'";
    private final String DELETE_SQL = "DELETE FROM java_staff WHERE id = '%s'";

    private String connectionString = "";

    public StaffController() {
        connectionString = String.format("jdbc:oracle:thin:@%s:%s:%s",
                HOST_NAME, PORT, SID);
    }

    /**
     * 
     * @return
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
     * 
     * @param id
     * @return
     */
    public Response isUnique(String id) {

        Response response = new Response();

        try (Connection conn = buildConn();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(String.format(UNIQUE_SQL, id));) {

            if (rs.next()) {
                int count = rs.getInt("COUNT");
                if (count == 0) {
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
     * 
     * @param id
     * @return
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
     * 
     * @param staff
     * @return
     */
    public Response createStaff(Staff staff) {

        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();) {
            int rowCount = statement.executeUpdate(String.format(INSERT_SQL,
                    staff.getID(), staff.getFirstName(), staff.getLastName(), staff.getMi(), staff.getAddress(),
                    staff.getCity(), staff.getState(), staff.getTelephone(), staff.getEmail()));

            if (rowCount == 1) {
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Create a new staff with id %s.", staff.getID()));
            } else {
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
     * 
     * @param id
     * @param staff
     * @return
     */
    public Response updateStaff(String id, Staff staff) {
        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();) {
            int rowCount = statement.executeUpdate(String.format(UPDATE_SQL,
                    staff.getFirstName(), staff.getLastName(), staff.getMi(), staff.getAddress(),
                    staff.getCity(), staff.getState(), staff.getTelephone(), staff.getEmail(), staff.getID()));

            if (rowCount == 1) {
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Update staff with id %s.", staff.getID()));
            } else if (rowCount == 0) {
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

    /**
     * 
     * @param id
     * @return
     */
    public Response deleteStaff(String id) {
        Response response = new Response();

        try (
                Connection conn = buildConn();
                Statement statement = conn.createStatement();) {
            int rowCount = statement.executeUpdate(String.format(DELETE_SQL, id));

            if (rowCount == 1) {
                response.setStatus(Status.SUCCESS);
                response.setMessage(String.format("Delete staff with id %s.", id));
            } else if (rowCount == 0) {
                response.setStatus(Status.WARNING);
                response.setMessage(String.format("Delete fails. Cause: no exsting staff has id %s.", id));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            // ex.printStackTrace();
            response.setStatus(Status.ERROR);
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    // region Support function
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

    private Connection buildConn() throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(connectionString, USER_NAME, PWD);
    }

    // endregion
}
