package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controller.*;
import model.*;

public class StaffUI extends JFrame {

    private StaffController controller;
    private Response response;

    private JButton btnView;

    private JTextField idTextField;

    public StaffUI() {
        setTitle("Assignment04");
        setDefaultCloseOperation(3);

        // sample: actionListener
        idTextField = new JTextField(10);
        btnView = new JButton("View");

        add(idTextField, BorderLayout.NORTH);
        add(btnView, BorderLayout.CENTER);

        btnView.addActionListener(new ActionListener() {

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

        });

        controller = new StaffController();
        setSize(300, 300);
        setVisible(true);
    }

    // sample
}
