// Example 11.6: TestScoresView class (with menus)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestScoresView extends JFrame{

   // >>>>>>> The model <<<<<<<<

   // Declare the model
   private TestScoresModel model;

   // >>>>>>> The view <<<<<<<<

   // Declare and instantiate the window objects.
   private JMenuItem newMI        = new JMenuItem("New");
   private JMenuItem openMI       = new JMenuItem("Open");
   private JMenuItem saveMI       = new JMenuItem("Save");
   private JMenuItem addMI        = new JMenuItem("Add");
   private JMenuItem modifyMI     = new JMenuItem("Modify");
   private JMenuItem deleteMI     = new JMenuItem("Delete");
   private JMenuItem highScoreMI  = new JMenuItem("Highest Score");
   private JMenuItem aveScoreMI   = new JMenuItem("Class Average");
   private JButton    firstButton     = new JButton("<<");
   private JButton    previousButton  = new JButton("<");
   private JButton    nextButton      = new JButton(">");
   private JButton    lastButton      = new JButton(">>");
   private JLabel     nameLabel       = new JLabel("Name");
   private JLabel     test1Label      = new JLabel("Test 1"); 
   private JLabel     test2Label      = new JLabel("Test 2"); 
   private JLabel     test3Label      = new JLabel("Test 3");
   private JLabel     averageLabel    = new JLabel("Average");
   private JLabel     countLabel      = new JLabel("Count");
   private JLabel     indexLabel      = new JLabel("Index");
   private JTextField nameField       = new JTextField("");
   private JTextField test1Field      = new JTextField("0");
   private JTextField test2Field      = new JTextField("0");
   private JTextField test3Field      = new JTextField("0");
   private JTextField averageField    = new JTextField("0");
   private JTextField countField      = new JTextField("0");
   private JTextField indexField      = new JTextField("-1");

   // Constructor
   public TestScoresView(TestScoresModel m){
      model = m;
      // Create and install the menu system
      JMenu fileMenu =  new JMenu("File");
      fileMenu.add(newMI);  
      fileMenu.add(openMI);  
      fileMenu.add(saveMI);  
      JMenu editMenu =  new JMenu("Edit");
      editMenu.add(addMI);  
      editMenu.add(modifyMI);  
      editMenu.add(deleteMI);  
      JMenu dataMenu =  new JMenu("Data");
      dataMenu.add(highScoreMI);  
      dataMenu.add(aveScoreMI);  
      JMenuBar bar = new JMenuBar(); 
      bar.add(fileMenu);
      bar.add(editMenu); 
      bar.add(dataMenu); 
      setJMenuBar(bar);
      // Set attributes of fields
      averageField.setEditable(false);
      countField.setEditable(false);
      indexField.setEditable(false);
      averageField.setBackground(Color.white);
      countField.setBackground(Color.white);
      indexField.setBackground(Color.white);
      // Set up panels to organize widgets and
      // add them to the window
      JPanel centerPanel = new JPanel(new GridLayout(5, 4, 10, 5));
      JPanel southPanel = new JPanel();
      Container container = getContentPane();
      container.add(centerPanel, BorderLayout.CENTER);
      container.add(southPanel, BorderLayout.SOUTH);
      // Row 1
      centerPanel.add(nameLabel);
      centerPanel.add(nameField);
      centerPanel.add(countLabel);
      centerPanel.add(countField);
      // Row 2
      centerPanel.add(test1Label);
      centerPanel.add(test1Field);
      centerPanel.add(indexLabel);
      centerPanel.add(indexField);
      // Row 3
      centerPanel.add(test2Label);
      centerPanel.add(test2Field);
      centerPanel.add(new JLabel(""));
      centerPanel.add(new JLabel(""));
      // Row 4
      centerPanel.add(test3Label);
      centerPanel.add(test3Field);
      centerPanel.add(new JLabel(""));
      centerPanel.add(new JLabel(""));
      // Row 5
      centerPanel.add(averageLabel);
      centerPanel.add(averageField);
      centerPanel.add(new JLabel(""));
      centerPanel.add(new JLabel(""));
      // Navigation buttons
      southPanel.add(firstButton);  
      southPanel.add(previousButton);  
      southPanel.add(nextButton);  
      southPanel.add(lastButton);  
      // Attach listeners to buttons and menu items
      addMI.addActionListener(new AddListener());
      previousButton.addActionListener(new PreviousListener());
      // Other attachments will go here (exercise)
      // Set window attributes
      setTitle("Student Test Scores");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   // Updates fields with info from the model
   private void displayInfo(){
      Student s = model.currentStudent();
      if (s == null){
         nameField.setText("");
         test1Field.setText("0");
         test2Field.setText("0");
         test3Field.setText("0");
         averageField.setText("0");
         countField.setText("0");
         indexField.setText("-1");
      } else{
         nameField.setText(s.getName());
         test1Field.setText("" + s.getScore(1));
         test2Field.setText("" + s.getScore(2));
         test3Field.setText("" + s.getScore(3));
         averageField.setText("" + s.getAverage());
         countField.setText("" + model.size());
         indexField.setText("" + model.currentPosition());
      }
   }

   // Creates and returns new Student from field info
   private Student getInfoFromScreen(){
      Student s = new Student(nameField.getText());
      s.setScore(1, Integer.parseInt(test1Field.getText()));
      s.setScore(2, Integer.parseInt(test2Field.getText()));
      s.setScore(3, Integer.parseInt(test3Field.getText()));
      return s;
  }  
   
   // >>>>>>> The controller <<<<<<<<

   // Responds to a selection of the Add menu item
   private class AddListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         // Get inputs, validate, and display error and quit if invalid
         Student s = getInfoFromScreen();
         String message = s.validateData();
         if (message != null){
            JOptionPane.showMessageDialog(TestScoresView.this, message);
            return;
         }
         // Attempt to add student and display error or update fields
         message = model.add(s);
         if (message != null)
            JOptionPane.showMessageDialog(TestScoresView.this, message);
         else
            displayInfo();
      }
   }

   // Responds to a click on the < button
   private class PreviousListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         model.previous();
         displayInfo();
      }
   }

   // Other listeners for modify, highest score, class average, and
   // navigation go here (exercise)

}
