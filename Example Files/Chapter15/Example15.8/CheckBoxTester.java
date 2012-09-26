// Example 15.8: Test check boxes and radio buttons

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxTester extends JFrame{

   private JLabel checkLabel = new JLabel("Check Box State");
   private JLabel radioLabel = new JLabel("Radio Button State");
   private JTextField checkField = new JTextField("");
   private JTextField radioField = new JTextField("");

   private JCheckBox cbDriver    = new JCheckBox("Driver");
   private JCheckBox cbPassenger = new JCheckBox("Passenger");

   private JRadioButton  rbMarried  = new JRadioButton("Married");
   private JRadioButton  rbSingle   = new JRadioButton("Single");
   private JRadioButton  rbDivorced = new JRadioButton("Divorced");

   private JButton getStateBTN = new JButton("Get states");

   public CheckBoxTester(){
      // Mark the default check box and radio button
      cbDriver.setSelected (true);
      rbSingle.setSelected (true);
      
      // Add the radio buttons to a button group
      ButtonGroup bgMaritalStatus = new ButtonGroup();
      bgMaritalStatus.add(rbMarried);
      bgMaritalStatus.add(rbSingle);
      bgMaritalStatus.add(rbDivorced);

      // Attach listener to the command button
      getStateBTN.addActionListener(new GetStateListener());

      // Add the controls to the container
      JPanel crbPanel = new JPanel(new GridLayout(5, 1));
      crbPanel.add(cbDriver);
      crbPanel.add(cbPassenger);
      crbPanel.add(rbMarried);
      crbPanel.add(rbSingle);
      crbPanel.add(rbDivorced);
      JPanel dataPanel = new JPanel(new GridLayout(4, 1));
      dataPanel.add(checkLabel);
      dataPanel.add(checkField);
      dataPanel.add(radioLabel);
      dataPanel.add(radioField);
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(getStateBTN);
      Container container = getContentPane();
      container.add(crbPanel, BorderLayout.WEST);
      container.add(dataPanel, BorderLayout.EAST);
      container.add(buttonPanel, BorderLayout.SOUTH);
   }

   private class GetStateListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String cbStr = "", rbStr = "";
         if (cbDriver.isSelected())
            cbStr = "Driver";
         if (cbPassenger.isSelected())
            cbStr = cbStr + "Passenger";
         checkField.setText(cbStr);
         if (rbMarried.isSelected())
            rbStr = "Married";
         else if (rbDivorced.isSelected())
            rbStr = "Divorced";
         else if (rbSingle.isSelected())
            rbStr = "Single";
         radioField.setText(rbStr);
      }
   }

   public static void main(String[] args){
      CheckBoxTester theGUI = new CheckBoxTester();
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setSize (300, 200);
      theGUI.setVisible (true);
   }
}

