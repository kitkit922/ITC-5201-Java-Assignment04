package view;

import javax.swing.*;
import javax.swing.border.*;

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
    private final int HEIGHT = 300;

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

    // button
    private JButton btnView;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;

    // label for status
    private JLabel statusLabel;

    // controller items
    private StaffController controller;
    private Response response;

    // endregion

    // Constructor
    public StaffUI() {

        setTitle("Assignment04");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(3);
        setResizable(false);

        // build 3 panels
        formPanel = createFormPanel();
        btnPanel = createButtonPanel();
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

        formPanel.setLayout(new GridLayout(5, 1));
        formPanel.setBorder(new TitledBorder(new EtchedBorder(), "<html><h3>Staff Information</html>"));

        formPanel.add(createIDPanel());
        formPanel.add(createNamePanel());
        formPanel.add(createAddressPanel());
        formPanel.add(createCityPanel());
        formPanel.add(createTelephonePanel());

        return formPanel;
    }

    // build id panel
    private JPanel createIDPanel() {

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        idPanel.add(new JLabel("ID"));
        idTextField = new JTextField(15);
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

        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        statePanel.add(new JLabel("Telephone"));
        telephoneTextField = new JTextField(15);
        statePanel.add(telephoneTextField);

        return statePanel;
    }

    // endregion

    // region button panel

    // build button panel
    private JPanel createButtonPanel() {

        JPanel btnPanel = new JPanel();

        btnView = new JButton("View");
        btnInsert = new JButton("Insert");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        btnView.addActionListener(new btnViewActionListener());

        btnPanel.add(btnView);
        btnPanel.add(btnInsert);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);

        return btnPanel;
    }

    // endregion

    // region button panel

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
        response = controller.isConnect();

        // show message dialog depends on the status
        if (response.getStatus() == Status.SUCCESS) {
            statusLabel.setText(response.getMessage());
        } else {
            statusLabel.setText("Connection fails");
            statusLabel.setForeground(Color.RED);

            btnView.setEnabled(false);
            btnInsert.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);

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
            response = controller.getStaff(idTextField.getText());

            // show message dialog depends on the status
            if (response.getStatus() == Status.SUCCESS) {
                Staff staff = response.getStaff();
                JOptionPane.showMessageDialog(btnView, staff.getFirstName(), Status.SUCCESS.toString(),
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (response.getStatus() == Status.WARNING) {
                JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.WARNING.toString(),
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(btnView, response.getMessage(), Status.ERROR.toString(),
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
