package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * Assignment: #04
 * ID: n01555831
 * Name: Tsz Kit Cheung (Kevin Cheung)
 *
 * @version v1.0
 *          GUI
 */

public class GUI extends JFrame {

    /**
     * 2 main panels
     */
    private JPanel upperPanel;
    private JPanel upperPanel1;
    private JPanel upperPanel2;
    private JPanel upperPanel3;
    private JPanel upperPanel4;
    private JPanel upperPanel5;
    private JPanel lowerPanel;
    private JPanel commentPanel;

    /**
     * Upper Panel Variable
     */
    private JLabel IDLabel;
    private JLabel LNLabel;
    private JLabel FNLabel;
    private JLabel MILabel;
    private JLabel AddressLabel;
    private JLabel CityLabel;
    private JLabel StateLabel;
    private JLabel TelLabel;
    private JTextField IDTF;
    private JTextField LNTF;
    private JTextField FNTF;
    private JTextField MITF;
    private JTextField AddressTF;
    private JTextField CityTF;
    private JTextField StateTF;
    private JTextField TelTF;

    /**
     * Lower Panel Variable
     */
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private JLabel commentLabel;

    /**
     * Main Statement
     * Provide frame settings and create main layout
     */
    public GUI() {

        /** Set frame */
        int FRAME_WIDTH = 700;
        int FRAME_HEIGHT = 300;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Staff Information Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        /** Display Upper, Middle and Lower Panel */
        // setLayout(new GridLayout(3, 1, 0, 50)); // grid layout, add layout according
        // to add
        add(createUpperPanel(), BorderLayout.NORTH);
        add(createLowerPanel(), BorderLayout.CENTER);
        add(createCommentPanel(), BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The Upper panel used a group layout to arrange the Labels and Text Fields
     * Dimensions and inputs are used for arranging dimensions
     * setHorizontalGroup and setVerticalGroup can assign the location for each
     * items
     * Then add group and add components to them
     */

    private JPanel createUpperPanel() {
        /** Set upper Panel */
        upperPanel = new JPanel(); // Using Group layout with a panel
        upperPanel.setPreferredSize(new Dimension(600, 200));
        upperPanel.setBorder(new TitledBorder(new EtchedBorder(), "<html><h3>Staff Information</html>"));

        /** Set Panel 1 - 5 */
        upperPanel.setLayout(new GridLayout(5, 1)); // grid layout, add layout according to add
        upperPanel.add(createUpperPanel1());
        upperPanel.add(createUpperPanel2());
        upperPanel.add(createUpperPanel3());
        upperPanel.add(createUpperPanel4());
        upperPanel.add(createUpperPanel5());
        return upperPanel;
    }

    private JPanel createUpperPanel1() {
        /** Set upper Panel 1 */
        upperPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using Group layout with a panel
        Font btnFont = new Font("Dialog", Font.BOLD, 12);

        /** ID label */
        IDLabel = new JLabel("ID");
        IDLabel.setFont(btnFont);
        IDLabel.setPreferredSize(new Dimension(40, 20));
        ;

        /** ID Text Field */
        IDTF = new JTextField(12);
        IDTF.setFont(btnFont);
        IDTF.setVisible(true);
        ;
        IDTF.setPreferredSize(new Dimension(100, 20));

        upperPanel1.add(IDLabel);
        upperPanel1.add(IDTF);

        return upperPanel1;
    };

    private JPanel createUpperPanel2() {
        /** Set upper Panel 2 */
        upperPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using Group layout with a panel
        Font btnFont = new Font("Dialog", Font.BOLD, 12);

        /** Last Name label */
        LNLabel = new JLabel("Last Name");
        LNLabel.setFont(btnFont);
        LNLabel.setPreferredSize(new Dimension(70, 20));
        ;

        /** Last Name Text Field */
        LNTF = new JTextField(12);
        LNTF.setFont(btnFont);
        LNTF.setVisible(true);
        ;
        LNTF.setPreferredSize(new Dimension(100, 20));

        /** First Name label */
        FNLabel = new JLabel("First Name");
        FNLabel.setFont(btnFont);
        FNLabel.setPreferredSize(new Dimension(70, 20));
        ;

        /** First Name Text Field */
        FNTF = new JTextField(12);
        FNTF.setFont(btnFont);
        FNTF.setVisible(true);
        ;
        FNTF.setPreferredSize(new Dimension(100, 20));

        /** mi label */
        MILabel = new JLabel("mi");
        MILabel.setFont(btnFont);
        MILabel.setPreferredSize(new Dimension(30, 20));
        ;

        /** mi Text Field */
        MITF = new JTextField(3);
        MITF.setFont(btnFont);
        MITF.setVisible(true);
        ;
        MITF.setPreferredSize(new Dimension(100, 20));

        upperPanel2.add(LNLabel);
        upperPanel2.add(LNTF);
        upperPanel2.add(FNLabel);
        upperPanel2.add(FNTF);
        upperPanel2.add(MILabel);
        upperPanel2.add(MITF);

        return upperPanel2;
    };

    private JPanel createUpperPanel3() {
        /** Set upper Panel */
        upperPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using Group layout with a panel
        Font btnFont = new Font("Dialog", Font.BOLD, 12);

        /** Address label */
        AddressLabel = new JLabel("Address");
        AddressLabel.setFont(btnFont);
        AddressLabel.setPreferredSize(new Dimension(60, 20));
        ;

        /** Address Text Field */
        AddressTF = new JTextField(18);
        AddressTF.setFont(btnFont);
        AddressTF.setVisible(true);
        ;
        AddressTF.setPreferredSize(new Dimension(100, 20));

        upperPanel3.add(AddressLabel);
        upperPanel3.add(AddressTF);

        return upperPanel3;
    };

    private JPanel createUpperPanel4() {
        /** Set City, State */
        upperPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using Group layout with a panel
        Font btnFont = new Font("Dialog", Font.BOLD, 12);

        /** City label */
        CityLabel = new JLabel("City");
        CityLabel.setFont(btnFont);
        CityLabel.setPreferredSize(new Dimension(40, 20));
        ;

        /** City Text Field */
        CityTF = new JTextField(20);
        CityTF.setFont(btnFont);
        CityTF.setVisible(true);
        ;
        CityTF.setPreferredSize(new Dimension(100, 20));

        /** State label */
        StateLabel = new JLabel("State");
        StateLabel.setFont(btnFont);
        StateLabel.setPreferredSize(new Dimension(40, 20));
        ;

        /** State Text Field */
        StateTF = new JTextField(3);
        StateTF.setFont(btnFont);
        StateTF.setVisible(true);
        ;
        StateTF.setPreferredSize(new Dimension(100, 20));

        upperPanel4.add(CityLabel);
        upperPanel4.add(CityTF);
        upperPanel4.add(StateLabel);
        upperPanel4.add(StateTF);

        return upperPanel4;
    };

    private JPanel createUpperPanel5() {
        /** Set Telephone */
        upperPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using Group layout with a panel
        Font btnFont = new Font("Dialog", Font.BOLD, 12);

        /** Telephone label */
        TelLabel = new JLabel("Telephone");
        TelLabel.setFont(btnFont);
        TelLabel.setPreferredSize(new Dimension(70, 20));
        ;

        /** Telephone Text Field */
        TelTF = new JTextField(16);
        TelTF.setFont(btnFont);
        TelTF.setVisible(true);
        ;
        TelTF.setPreferredSize(new Dimension(100, 20));

        upperPanel5.add(TelLabel);
        upperPanel5.add(TelTF);

        return upperPanel5;
    };

    /**
     * The Lower panel create 6 buttons with 2 empty panels by 4x2 grid layout
     *
     * @return lowerpanel
     */
    private JPanel createLowerPanel() {

        lowerPanel = new JPanel();
        lowerPanel.setPreferredSize(new Dimension(400, 50));
        Font btnFont = new Font("Dialog", Font.BOLD, 14);

        /** Button 1, Add */
        bt1 = new JButton("View");
        bt1.setFont(btnFont);
        bt1.setPreferredSize(new Dimension(100, 20));
        ;
        // bt1.addActionListener(new AddListener());

        /** Button 2, Update */
        bt2 = new JButton("Insert");
        bt2.setFont(btnFont);
        bt2.setPreferredSize(new Dimension(100, 20));
        ;
        // bt2.addActionListener(new UpdateListener());
        ;
        // status = Buttons.UPDATE;

        /** Button 3, First */
        bt3 = new JButton("Update");
        bt3.setFont(btnFont);
        bt3.setPreferredSize(new Dimension(100, 20));
        ;
        // bt3.addActionListener(new FirstListener());
        // status = Buttons.FIRST;

        /** Button 4, Previous */
        bt4 = new JButton("Clear");
        bt4.setFont(btnFont);
        bt4.setPreferredSize(new Dimension(100, 20));
        ;
        // bt4.addActionListener(new PreviousListener());
        // status = Buttons.PREVIOUS;

        /** Add buttons */
        lowerPanel.setLayout(new GridLayout(1, 4, 20, 0)); // grid layout, add layout according to add
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 80, 10, 80)); // 10 px empty border
        lowerPanel.add(bt1);
        lowerPanel.add(bt2);
        lowerPanel.add(bt3);
        lowerPanel.add(bt4);

        return lowerPanel;
    }

    private JPanel createCommentPanel() {
        commentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        commentPanel.setPreferredSize(new Dimension(400, 50));
        Font btnFont = new Font("Dialog", Font.BOLD, 14);

        /** Comment label */
        commentLabel = new JLabel("Database connection Status: Not connected"); // For commenting, Database Connected
        commentLabel.setFont(btnFont);
        commentLabel.setPreferredSize(new Dimension(350, 30));
        commentPanel.add(commentLabel, BorderLayout.WEST);

        return commentPanel;
    }

    public static void main(String args[]) {
        new GUI();
    }
}
