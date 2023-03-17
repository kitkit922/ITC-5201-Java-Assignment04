package model;

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
 * This is an class represents a staff.
 * 
 * @author Wenhao Fang
 */
public class Staff {

    // #region Fields of a staff, defined by data table.
    private String ID;
    private String lastName;
    private String firstName;
    private String mi;
    private String address;
    private String city;
    private String state;
    private String telephone;
    private String email;

    // endregion

    // #region Size of each field defined by data table.
    private static final int ID_SIZE = 9;
    private static final int LAST_NAME_SIZE = 15;
    private static final int FIRST_NAME_SIZE = 15;
    private static final int MI_SIZE = 1;
    private static final int ADDRESS_SIZE = 20;
    private static final int CITY_SIZE = 20;
    private static final int STATE_SIZE = 2;
    private static final int TELEPHONE_SIZE = 10;
    private static final int EMAIL_SIZE = 40;
    // endregion

    /**
     * Default constructor
     * Initializes private members.
     */
    public Staff() {
        this.ID = "";
        this.lastName = "";
        this.firstName = "";
        this.mi = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.telephone = "";
        this.email = "";
    }

    // #region Getters and Setters of fields

    /**
     * Gets Staff's id.
     * 
     * @return This staff's id.
     */
    public String getID() {
        return this.ID == null ? "" : this.ID.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's id.
     * 
     * @param id This staff's id.
     */
    public void setID(String id) {
        if (id.length() > ID_SIZE) {
            this.ID = id.substring(0, ID_SIZE);// if oversize, then trims.
        } else {
            this.ID = id;
        }
    }

    /**
     * Gets Staff's last name.
     * 
     * @return This staff's last name.
     */
    public String getLastName() {
        return this.lastName == null ? "" : this.lastName.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's last name.
     * 
     * @param lastName This staff's last name.
     */
    public void setLastName(String lastName) {
        if (lastName == null) {// if null argument, then set as empty string.
            this.lastName = "";
        } else if (lastName.length() > LAST_NAME_SIZE) {
            this.lastName = lastName.substring(0, LAST_NAME_SIZE); // if oversize, then trims.
        } else {
            this.lastName = lastName;
        }
    }

    /**
     * Gets Staff's first name.
     * 
     * @return This staff's first name.
     */
    public String getFirstName() {
        return this.firstName == null ? "" : this.firstName.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's first name.
     * 
     * @param firstName This staff's first name.
     */
    public void setFirstName(String firstName) {
        if (firstName == null) {// if null argument, then set as empty string.
            this.firstName = "";
        } else if (firstName.length() > FIRST_NAME_SIZE) {
            this.firstName = firstName.substring(0, FIRST_NAME_SIZE);// if oversize, then trims.
        } else {
            this.firstName = firstName;
        }
    }

    /**
     * Gets Staff's mi.
     * 
     * @return This staff's mi.
     */
    public String getMi() {
        return this.mi == null ? "" : this.mi.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's mi.
     * 
     * @param mi This staff's mi.
     */
    public void setMi(String mi) {
        if (mi == null) {// if null argument, then set as empty string.
            this.mi = "";
        } else if (mi.length() > MI_SIZE) {
            this.mi = mi.substring(0, MI_SIZE);// if oversize, then trims.
        } else {
            this.mi = mi;
        }
    }

    /**
     * Gets Staff's address.
     * 
     * @return This staff's address.
     */
    public String getAddress() {
        return this.address == null ? "" : this.address.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's address.
     * 
     * @param address This staff's maddress.
     */
    public void setAddress(String address) {
        if (address == null) {// if null argument, then set as empty string.
            this.address = "";
        } else if (address.length() > ADDRESS_SIZE) {
            this.address = address.substring(0, ADDRESS_SIZE);// if oversize, then trims.
        } else {
            this.address = address;
        }
    }

    /**
     * Gets Staff's city.
     * 
     * @return This staff's city.
     */
    public String getCity() {
        return this.city == null ? "" : this.city.trim();// If null, then return empty string.
    }

    /**
     * Sets Staff's city.
     * 
     * @param city This staff's city.
     */
    public void setCity(String city) {
        if (city == null) {// if null argument, then set as empty string.
            this.city = "";
        } else if (city.length() > CITY_SIZE) {
            this.city = city.substring(0, CITY_SIZE);// if oversize, then trims.
        } else {
            this.city = city;
        }
    }

    /**
     * Gets Staff's state.
     * 
     * @return This staff's state.
     */
    public String getState() {
        return this.state == null ? "" : this.state.trim(); // If null, then return empty string.
    }

    /**
     * Sets Staff's state.
     * 
     * @param state This staff's state.
     */
    public void setState(String state) {
        if (state == null) {// if null argument, then set as empty string.
            this.state = "";
        } else if (state.length() > STATE_SIZE) {
            this.state = state.substring(0, STATE_SIZE);// if oversize, then trims.
        } else {
            this.state = state;
        }
    }

    /**
     * Gets Staff's phone.
     * 
     * @return This staff's phone.
     */
    public String getTelephone() {
        return this.telephone == null ? "" : this.telephone.trim(); // If null, then return empty string.
    }

    /**
     * Sets Staff's phone.
     * 
     * @param phone This staff's phone.
     */
    public void setTelephone(String telephone) {
        if (telephone == null) {// if null argument, then set as empty string.
            this.telephone = "";
        } else if (telephone.length() > TELEPHONE_SIZE) {
            this.telephone = telephone.substring(0, TELEPHONE_SIZE);// if oversize, then trims.
        } else {
            this.telephone = telephone;
        }
    }

    /**
     * Gets Staff's email.
     * 
     * @return This staff's email.
     */
    public String getEmail() {
        return this.email == null ? "" : this.email.trim();
    }

    /**
     * Sets Staff's email.
     * 
     * @param email This staff's email.
     */
    public void setEmail(String email) {
        if (email == null) {// if null argument, then set as empty string.
            this.email = "";
        } else if (email.length() > EMAIL_SIZE) {
            this.email = email.substring(0, EMAIL_SIZE);// if oversize, then trims.
        } else {
            this.email = email;
        }
    }
    // endregion

    // region Geters of sizes
    public static int getIdSize() {
        return ID_SIZE;
    }

    public static int getLastNameSize() {
        return LAST_NAME_SIZE;
    }

    public static int getFirstNameSize() {
        return FIRST_NAME_SIZE;
    }

    public static int getMiSize() {
        return MI_SIZE;
    }

    public static int getAddressSize() {
        return ADDRESS_SIZE;
    }

    public static int getCitySize() {
        return CITY_SIZE;
    }

    public static int getStateSize() {
        return STATE_SIZE;
    }

    public static int getTelephoneSize() {
        return TELEPHONE_SIZE;
    }

    public static int getEmailSize() {
        return EMAIL_SIZE;
    }
    // endregion

    /**
     * Overrides toString()
     * Return a string information about a staff.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
                ID, lastName, firstName, mi, address, city, state, telephone, email);
    }

}
