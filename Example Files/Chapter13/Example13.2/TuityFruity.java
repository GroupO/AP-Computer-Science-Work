// Example 13.2
// Tests a scrolling list box

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TuityFruity extends JFrame{

   private JMenuItem addMI = new JMenuItem("Add");
   private JMenuItem deleteMI = new JMenuItem("Delete");;
   private JTextField field = new JTextField("");
   private DefaultListModel listModel = new DefaultListModel();   
   private JList list = new JList(listModel);                   

   public TuityFruity(){
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JScrollPane listPane = new JScrollPane(list);
      // Add initial fruits to the list
      listModel.add(0, "Apple");
      listModel.add(1, "Banana");
      listModel.add(2, "Cherry");
      listModel.add(3, "Orange");
      listModel.add(4, "Peach");
      listModel.add(5, "Pear");
      // Select the first fruit in the list
      list.setSelectedIndex(0);
      field.setText((String)list.getSelectedValue());
      Container container = getContentPane();
      container.add(listPane, BorderLayout.CENTER);
      container.add(field, BorderLayout.SOUTH);
      JMenu menu = new JMenu("Edit");
      menu.add(addMI);
      menu.add(deleteMI);
      JMenuBar bar = new JMenuBar();
      bar.add(menu);
      setJMenuBar(bar);
      addMI.addActionListener(new AddListener());
      deleteMI.addActionListener(new DeleteListener());
      list.addMouseListener(new ListMouseListener());
   }

   // List mouse listener
   private class ListMouseListener extends MouseAdapter{
      public void mouseClicked(MouseEvent e) {
         if (listModel.isEmpty())
            return;
         String name = (String)list.getSelectedValue();
         if (e.getClickCount() == 2) 
            JOptionPane.showMessageDialog(TuityFruity.this, 
                                          "You double clicked " + 
                                          name + ".");
         else if (e.getClickCount() == 1){
            field.setText(name);
            deleteMI.setEnabled(true);
         }
      }
   }

   private class AddListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         // Add the user's input to the end of the list,
         // select it, and scroll to it if necessary
         String str = JOptionPane.showInputDialog("Enter a fruit");
         listModel.addElement(str);
         list.setSelectedValue(str, true);
      }
   }


   private class DeleteListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         // Delete the selected item and select the first
         // item
         listModel.removeElementAt(list.getSelectedIndex());
         if (listModel.size() != 0){
            list.setSelectedIndex(0);
            field.setText((String)list.getSelectedValue());
         }
         else
            deleteMI.setEnabled(false);
      }
   }

   public static void main(String[] args){
      TuityFruity theGUI = new TuityFruity();
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setSize(300, 150);
      theGUI.setVisible(true);
   }
}
