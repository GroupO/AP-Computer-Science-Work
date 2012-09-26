// Example 13.1: Tests a text area

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestTextArea extends JFrame{

   private JTextArea ta = new JTextArea("");

   public TestTextArea(){
      JScrollPane sp = new JScrollPane(ta);
      JButton clearBtn = new JButton("Clear");
      JButton printBtn = new JButton("Print");
      JButton readBtn = new JButton("Read");
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(clearBtn);
      buttonPanel.add(printBtn);
      buttonPanel.add(readBtn);
      Container container = getContentPane();
      container.add(sp, BorderLayout.CENTER);
      container.add(buttonPanel, BorderLayout.SOUTH);
      clearBtn.addActionListener(new ClearListener());
      readBtn.addActionListener(new ReadListener());
      printBtn.addActionListener(new PrintListener());
   }


   private class ClearListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         ta.setText("");
      }
   }

   private class ReadListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         JOptionPane.showMessageDialog(TestTextArea.this, ta.getText());
      }
   }

   private class PrintListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         ta.append("This is a long sentence, with many words.  ");
         ta.append("append does not add a newline, so here one is.\n");
      }
   }

   public static void main(String[] args){
      TestTextArea theGUI = new TestTextArea();
      theGUI.setSize(250, 150);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setVisible(true);
   }
}
