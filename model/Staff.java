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

    private final int ID_SIZE = 9;
    private final int LAST_NAME_SIZE = 15;
    private final int FIRST_NAME_SIZE = 15;
    private final int MI_SIZE = 1;
    private final int ADDRESS_SIZE = 20;
    private final int CITY_SIZE = 20;
    private final int STATE_SIZE = 2;
    private final int TELEPHONE_SIZE = 10;
    private final int EMAIL_SIZE = 40;
    // endregion

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
        return this.ID;
    }

    public void setID(String id) {
        if (id.length() > ID_SIZE) {
            this.ID = id.substring(0, ID_SIZE);
        } else {
            this.ID = id;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > LAST_NAME_SIZE) {
            this.lastName = lastName.substring(0, LAST_NAME_SIZE);
        } else {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > FIRST_NAME_SIZE) {
            this.firstName = firstName.substring(0, FIRST_NAME_SIZE);
        } else {
            this.firstName = firstName;
        }
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        if (mi.length() > MI_SIZE) {
            this.mi = mi.substring(0, MI_SIZE);
        } else {
            this.mi = mi;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() > ADDRESS_SIZE) {
            this.address = address.substring(0, ADDRESS_SIZE);
        } else {
            this.address = address;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() > CITY_SIZE) {
            this.city = city.substring(0, CITY_SIZE);
        } else {
            this.city = city;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state.length() > STATE_SIZE) {
            this.state = state.substring(0, STATE_SIZE);
        } else {
            this.state = state;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone.length() > TELEPHONE_SIZE) {
            this.telephone = telephone.substring(0, TELEPHONE_SIZE);
        } else {
            this.telephone = telephone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() > EMAIL_SIZE) {
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
