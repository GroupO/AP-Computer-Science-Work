// Example H3: Testing file dialogs

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class TestFileDialog extends JFrame{

   private void openFile(){
      JFileChooser chooser = new JFileChooser("c:\\Javafiles");
      int result = chooser.showOpenDialog(this);
      if (result == JFileChooser.CANCEL_OPTION)
         JOptionPane.showMessageDialog(this, 
                                       "The dialog was cancelled.");
      else
         try{
            File file = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "File name: " +  
                                          file.getName());
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, 
                                          "Error opening input file " +
                                          e.toString());
         }
   }

   private void saveFile(){
      JFileChooser chooser = new JFileChooser("c:\\Javafiles");
      int result = chooser.showSaveDialog(this);
      if (result == JFileChooser.CANCEL_OPTION)
         JOptionPane.showMessageDialog(this,
                                       "The dialog was cancelled.");
      else
         try{
            File file = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(this,"File name: " + 
                                          file.getName());
         }catch(Exception e){
            JOptionPane.showMessageDialog(this,
                                          "Error opening input file " + 
                                          e.toString());
         }
   }

   private class OpenListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         openFile();
      }
   }

   private class SaveListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         saveFile();
      }
   }

   public TestFileDialog(){
      JMenu menu = new JMenu("File");
      JMenuItem openMI = new JMenuItem("Open");
      JMenuItem saveMI = new JMenuItem("Save");
      menu.add(openMI);
      menu.add(saveMI);
      JMenuBar bar = new JMenuBar();
      bar.add(menu);
      setJMenuBar(bar);
      openMI.addActionListener(new OpenListener());
      saveMI.addActionListener(new SaveListener());
   }

   public static void main(String[] args){
      TestFileDialog theGUI = new TestFileDialog();
      theGUI.setSize(100, 100);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setVisible(true);
   }
}
