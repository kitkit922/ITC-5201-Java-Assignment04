package model;

public class Staff {

    // #region Private members
    private String ID;
    private String lastName;
    private String firstName;
    private String mi;
    private String address;
    private String city;
    private String state;
    private String telephone;
    private String email;

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

    // Constructor
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

    // #region Getters and Setters

    public String getID() {
        return this.ID == null ? "" : this.ID.trim();
    }

    public void setID(String id) {
        if (id.length() > ID_SIZE) {
            this.ID = id.substring(0, ID_SIZE);
        } else {
            this.ID = id;
        }
    }

    public String getLastName() {
        return this.lastName == null ? "" : this.lastName.trim();
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else if (lastName.length() > LAST_NAME_SIZE) {
            this.lastName = lastName.substring(0, LAST_NAME_SIZE);
        } else {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return this.firstName == null ? "" : this.firstName.trim();
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else if (firstName.length() > FIRST_NAME_SIZE) {
            this.firstName = firstName.substring(0, FIRST_NAME_SIZE);
        } else {
            this.firstName = firstName;
        }
    }

    public String getMi() {
        return this.mi == null ? "" : this.mi.trim();
    }

    public void setMi(String mi) {
        if (mi == null) {
            this.mi = "";
        } else if (mi.length() > MI_SIZE) {
            this.mi = mi.substring(0, MI_SIZE);
        } else {
            this.mi = mi;
        }
    }

    public String getAddress() {
        return this.address == null ? "" : this.address.trim();
    }

    public void setAddress(String address) {
        if (address == null) {
            this.address = "";
        } else if (address.length() > ADDRESS_SIZE) {
            this.address = address.substring(0, ADDRESS_SIZE);
        } else {
            this.address = address;
        }
    }

    public String getCity() {
        return this.city == null ? "" : this.city.trim();
    }

    public void setCity(String city) {
        if (city == null) {
            this.city = "";
        } else if (city.length() > CITY_SIZE) {
            this.city = city.substring(0, CITY_SIZE);
        } else {
            this.city = city;
        }
    }

    public String getState() {
        return this.state == null ? "" : this.state.trim();
    }

    public void setState(String state) {
        if (state == null) {
            this.state = "";
        } else if (state.length() > STATE_SIZE) {
            this.state = state.substring(0, STATE_SIZE);
        } else {
            this.state = state;
        }
    }

    public String getTelephone() {
        return this.telephone == null ? "" : this.telephone.trim();
    }

    public void setTelephone(String telephone) {
        if (telephone == null) {
            this.telephone = "";
        } else if (telephone.length() > TELEPHONE_SIZE) {
            this.telephone = telephone.substring(0, TELEPHONE_SIZE);
        } else {
            this.telephone = telephone;
        }
    }

    public String getEmail() {
        return this.email == null ? "" : this.email.trim();
    }

    public void setEmail(String email) {
        if (email == null) {
            this.email = "";
        } else if (email.length() > EMAIL_SIZE) {
            this.email = email.substring(0, EMAIL_SIZE);
        } else {
            this.email = email;
        }
    }
    // endregion

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
                ID, lastName, firstName, mi, address, city, state, telephone, email);
    }

}
