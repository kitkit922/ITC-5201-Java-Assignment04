package view;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

import controller.*;
import model.*;

/**
 *
 * Assignment: #04
 * ID: n01555831
 * Name: Tsz Kit Cheung (Kevin Cheung)
 *
 * @version v1.0
 *          GUI
 */
public class StaffUI extends JFrame {

    // region Private members

    // size
    private final int WIDTH = 500;
    private final int HEIGHT = 330;

    // 3 main panels
    private JPanel formPanel;
    private JPanel btnPanel;
    private JPanel statusPanel;

    // test field
    private JTextField idTextField;
    private JTextField lnameTextField;
    private JTextField fnameTextField;
    private JTextField miTextField;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField telephoneTextField;
    private JTextField emailTextField;

    // button
    private JButton btnView;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;

    // label for status
    private JLabel statusLabel;

    // controller items
    private StaffController controller;

    // endregion

    // Constructor
    public StaffUI() {

        setTitle("Assignment04");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(3);
        setResizable(false);

        // build 3 panels
        formPanel = createFormPanel();
        btnPanel = createControlPanel();
        statusPanel = createStatusPanel();

        // add panel to frame
        add(formPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        // create controller
        controller = new StaffController();

        checkConnection();// check whether

        setVisible(true);
    }

    // region Form Panel

    // build form panel
    private JPanel createFormPanel() {

        JPanel formPanel = new JPanel();

        formPanel.setLayout(new GridLayout(6, 1));
        formPanel.setBorder(new TitledBorder(new EtchedBorder(), "Staff Information"));

        formPanel.add(createIDPanel());
        formPanel.add(createNamePanel());
        formPanel.add(createAddressPanel());
        formPanel.add(createCityPanel());
        formPanel.add(createTelephonePanel());
        formPanel.add(createEmailPanel());

        return formPanel;
    }

    // build id panel
    private JPanel createIDPanel() {

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        idPanel.add(new JLabel("ID"));

        idTextField = new JTextField(15);
        Document doc = idTextField.getDocument();
        doc.addDocumentListener(new idInputListener());
        idPanel.add(idTextField);

        return idPanel;
    }

    // build name panel
    private JPanel createNamePanel() {

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        namePanel.add(new JLabel("Last Name"));
        fnameTextField = new JTextField(15);
        namePanel.add(fnameTextField);

        namePanel.add(new JLabel("First Name"));
        lnameTextField = new JTextField(15);
        namePanel.add(lnameTextField);

        namePanel.add(new JLabel("mi"));
        miTextField = new JTextField(2);
        namePanel.add(miTextField);

        return namePanel;
    }

    // build address panel
    private JPanel createAddressPanel() {

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        addressPanel.add(new JLabel("Address"));
        addressTextField = new JTextField(15);
        addressPanel.add(addressTextField);

        return addressPanel;
    }

    // build city panel
    private JPanel createCityPanel() {

        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        cityPanel.add(new JLabel("City"));
        cityTextField = new JTextField(15);
        cityPanel.add(cityTextField);

        cityPanel.add(new JLabel("State"));
        stateTextField = new JTextField(4);
        cityPanel.add(stateTextField);

        return cityPanel;
    }

    // build telephone panel
    private JPanel createTelephonePanel() {

        JPanel telephonePanel = new JPanel();
        telephonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        telephonePanel.add(new JLabel("Telephone"));
        telephoneTextField = new JTextField(15);
        telephonePanel.add(telephoneTextField);

        return telephonePanel;
    }

    // build email panel
    private JPanel createEmailPanel() {

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        emailPanel.add(new JLabel("Email"));
        emailTextField = new JTextField(15);
        emailPanel.add(emailTextField);

        return emailPanel;
    }

    // endregion

    // region button panel

    // build control panel
    private JPanel createControlPanel() {

        JPanel controlPanel = new JPanel();

        controlPanel.add(createButtonPanel(), BorderLayout.CENTER);

        return controlPanel;
    }

    // build button panel
    private JPanel createButtonPanel() {

        JPanel btnPanel = new JPanel();

        btnView = new JButton("View");
        btnInsert = new JButton("Insert");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        btnView.addActionListener(new btnViewActionListener());
        btnInsert.addActionListener(new btnInsertActionListener());
        btnUpdate.addActionListener(new btnUpdateActionListener());
        btnDelete.addActionListener(new btnDeleteActionListener());

        btnPanel.add(btnView);
        btnPanel.add(btnInsert);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);

        return btnPanel;
    }

    // endregion

    // region Status panel

    // build status panel
    private JPanel createStatusPanel() {

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        statusLabel = new JLabel("Wait for connecting ...");
        statusPanel.add(statusLabel);

        return statusPanel;
    }

    // endregion

    // region Initiate Connection
    private void checkConnection() {
        Response response = controller.isConnect();

        // show message dialog depends on the status
        if (response.getStatus() == Status.SUCCESS) {
            statusLabel.setText(response.getMessage());
        } else {
            failureDisplay();

            JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.ERROR.toString(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // endregion

    // region Inner class

    // button view action listener
    private class btnViewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (idTextField.getText().length() != 0) {

                Response response = controller.getStaff(idTextField.getText());

                // show message dialog depends on the status
                if (response.getStatus() == Status.SUCCESS) {
                    Staff staff = response.getStaff();
                    bindStaff(staff);
                    JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.SUCCESS.toString(),
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (response.getStatus() == Status.WARNING) {
                    JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.WARNING.toString(),
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.ERROR.toString(),
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(btnPanel, "ID cannot be empty", "Warning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class btnInsertActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (idTextField.getText().length() != 0) {

                String msg = validation();

                if (msg.length() != 0) {
                    JOptionPane.showMessageDialog(btnPanel, "<html>" + msg + "<html>", "Warning",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {

                    Staff staff = formStaff();

                    Response response = controller.createStaff(staff);

                    // show message dialog depends on the status
                    if (response.getStatus() == Status.SUCCESS) {
                        clearTextField();
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.SUCCESS.toString(),
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (response.getStatus() == Status.WARNING) {
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.WARNING.toString(),
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.ERROR.toString(),
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(btnPanel, "ID cannot be empty", "Warning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private class btnUpdateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (idTextField.getText().length() != 0) {

                String msg = validation();

                if (msg.length() != 0) {
                    JOptionPane.showMessageDialog(btnPanel, "<html>" + msg + "<html>", "Warning",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {

                    Staff staff = formStaff();

                    Response response = controller.updateStaff(idTextField.getText(), staff);

                    // show message dialog depends on the status
                    if (response.getStatus() == Status.SUCCESS) {
                        clearTextField();
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.SUCCESS.toString(),
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (response.getStatus() == Status.WARNING) {
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.WARNING.toString(),
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(btnView, response.getMessage(),
                                Status.ERROR.toString(),
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(btnPanel, "ID cannot be empty", "Warning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class btnDeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (idTextField.getText().length() != 0) {

                Response response = controller.deleteStaff(idTextField.getText());

                // show message dialog depends on the status
                if (response.getStatus() == Status.SUCCESS) {
                    clearTextField();
                    JOptionPane.showMessageDialog(btnView, response.getMessage(),
                            Status.SUCCESS.toString(),
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (response.getStatus() == Status.WARNING) {
                    JOptionPane.showMessageDialog(btnView, response.getMessage(),
                            Status.WARNING.toString(),
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(btnView, response.getMessage(),
                            Status.ERROR.toString(),
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(btnPanel, "ID cannot be empty", "Warning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private class idInputListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkIDDisplay();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkIDDisplay();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checkIDDisplay();
        }
    }

    // endregion

    // region Supportive function

    private void bindStaff(Staff staff) {
        System.out.println(staff);

        idTextField.setText(staff.getID());
        fnameTextField.setText(staff.getFirstName());

        lnameTextField.setText(staff.getLastName());
        miTextField.setText(staff.getMi());
        addressTextField.setText(staff.getAddress());
        cityTextField.setText(staff.getCity());
        stateTextField.setText(staff.getState());
        telephoneTextField.setText(staff.getTelephone());
        emailTextField.setText(staff.getEmail());

    }

    private Staff formStaff() {

        Staff staff = new Staff();

        staff.setID(idTextField.getText());
        staff.setFirstName(fnameTextField.getText());
        staff.setLastName(lnameTextField.getText());
        staff.setMi(miTextField.getText());
        staff.setAddress(addressTextField.getText());
        staff.setCity(cityTextField.getText());
        staff.setState(stateTextField.getText());
        staff.setTelephone(telephoneTextField.getText());
        staff.setEmail(emailTextField.getText());

        System.out.println(staff);

        return staff;
    }

    private void failureDisplay() {
        statusLabel.setText("Connection fails");
        statusLabel.setForeground(Color.RED);

        btnView.setEnabled(false);
        btnInsert.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private void clearTextField() {
        idTextField.setText("");
        fnameTextField.setText("");
        lnameTextField.setText("");
        miTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        telephoneTextField.setText("");
        emailTextField.setText("");
    }

    private void checkIDDisplay() {

        Response response = controller.isUnique(idTextField.getText());

        if (response.getStatus() == Status.SUCCESS) {
            idTextField.setBackground(Color.WHITE);
        } else {
            idTextField.setBackground(Color.YELLOW);
        }
    }

    private String validation() {

        String message = "";

        JTextField[] textFields = {
                idTextField,
                fnameTextField,
                lnameTextField,
                miTextField,
                addressTextField,
                cityTextField,
                stateTextField,
                telephoneTextField,
                emailTextField
        };

        int[] fieldSizes = {
                Staff.getIdSize(),
                Staff.getFirstNameSize(),
                Staff.getLastNameSize(),
                Staff.getMiSize(),
                Staff.getAddressSize(),
                Staff.getCitySize(),
                Staff.getStateSize(),
                Staff.getTelephoneSize(),
                Staff.getEmailSize()
        };

        String[] hints = {
                "ID cannot have more than %d Characters.",
                "First name cannot have more than %d Characters.",
                "Last name cannot have more than %d Characters.",
                "Mi cannot have more than %d Characters.",
                "Address cannot have more than %d Characters.",
                "City cannot have more than %d Characters.",
                "State cannot have more than %d Characters.",
                "Telephone cannot have more than %d Characters.",
                "Email cannot have more than %d Characters.",
        };

        for (int i = 0; i < textFields.length; i++) {// loop each text field object.
            if (textFields[i].getText().length() > fieldSizes[i]) {
                message += String.format("<p>" + hints[i] + "</p>", fieldSizes[i]);// collect messages.
            }
        }

        return message;
    }

    // endregion
}
