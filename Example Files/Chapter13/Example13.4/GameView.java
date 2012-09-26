// Example 13.4: GUI version of start of design adventure game

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameView extends JFrame {

//---------------------- The model

   private GameWorld gameWorld = new GameWorld();

//---------------------- The view

   // Labels
   private JLabel lbPaths        = new JLabel("Paths");
   private JLabel lbEntities     = new JLabel("Entities");
   private JLabel lbPlaceItems   = new JLabel("Place items");
   private JLabel lbDescription  = new JLabel("Description"); 

   // List models
   private DefaultListModel modelPaths      = new DefaultListModel();
   private DefaultListModel modelEntities   = new DefaultListModel();
   private DefaultListModel modelPlaceItems = new DefaultListModel();

   // Scrolling lists
   private JList lstPaths      = new JList(modelPaths);
   private JList lstEntities   = new JList(modelEntities);
   private JList lstPlaceItems = new JList(modelPlaceItems);

   // Text area
   private JTextArea taDescription = new JTextArea("");

   // Menu items
   private JMenuItem openMI = new JMenuItem("Open");

   public GameView(){
      // Set up menus
      JMenu fileMenu = new JMenu("File");
      openMI.addActionListener(new OpenListener());
      lstPaths.addMouseListener(new PathsMouseListener());
      fileMenu.add(openMI);
      JMenuBar bar = new JMenuBar();
      bar.add(fileMenu);
      setJMenuBar(bar);
      // Set up text area and list boxes
      JPanel textPanel = makeLabeledPanel(taDescription, lbDescription);
      JPanel listPanel = new JPanel(new GridLayout(1, 3, 8, 8));
      listPanel.add(makeLabeledPanel(lstPaths, lbPaths));
      listPanel.add(makeLabeledPanel(lstEntities, lbEntities));
      listPanel.add(makeLabeledPanel(lstPlaceItems, lbPlaceItems));
      Container container = getContentPane();
      container.setLayout(new GridLayout(2, 1, 4, 4));
      container.add(textPanel);
      container.add(listPanel);
      // Set window attributes
      setTitle("The Treasures of Balbor");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize (600, 400);
      setVisible (true);
   }

   // Returns a panel that contains the label above and the widget, 
   // wrapped in a scroll pane, below
   private JPanel makeLabeledPanel(Component widget, JLabel label){
      JPanel panel = new JPanel(new BorderLayout());
      JScrollPane pane = new JScrollPane(widget);
      panel.add(label, BorderLayout.NORTH);
      panel.add(pane, BorderLayout.CENTER);
      return panel;
   }

//---------------------- Controller

   // Handles display of info and move on a path
   private class PathsMouseListener extends MouseAdapter{
      public void mouseClicked(MouseEvent e) {
         if (modelPaths.isEmpty())
            return;
         String name = (String)lstPaths.getSelectedValue();
         if (e.getClickCount() == 2){
            String errorMessage = gameWorld.move(name);
            if (! errorMessage.equals(""))
               taDescription.setText(errorMessage);
            else
               updateAllControls();
         }
         else if (e.getClickCount() == 1){
            String str = gameWorld.getPathString(name);
            taDescription.setText(str);
         }
      }
   }

   // Opens a game file, initially hard coded
   private class OpenListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         gameWorld.createHardCodedWorld();
         updateAllControls();
      }
   }


//---------------------- Private helper methods

   // Updates the text area and three scrolling lists
   private void updateAllControls(){
      // Update place description
      String str = gameWorld.getPlaceString();
      taDescription.setText(str);
      // Update lists
      updateList(lstPaths, gameWorld.getPathNames());
      updateList(lstEntities, gameWorld.getEntityNames());
      updateList(lstPlaceItems, gameWorld.getPlaceItemNames());
   }

   // Generic method to refresh any scrolling list with names
   private void updateList(JList list, String[] names){
      DefaultListModel listModel = (DefaultListModel)list.getModel();
      listModel.clear();
      for (String name : names)
         listModel.addElement(name);
   }
}
