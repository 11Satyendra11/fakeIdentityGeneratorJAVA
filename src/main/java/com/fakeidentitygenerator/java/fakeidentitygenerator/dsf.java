package com.fakeidentitygenerator.java.fakeidentitygenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class dsf {

  private JFrame frame;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          dsf window = new dsf();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public dsf() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    textField = new JTextField();
    textField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println(textField.getText());
        
      }
    });
    textField.setText("2");
    textField.setBounds(144, 41, 114, 21);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("This" + textField.getText());
      }
    });
    btnNewButton.setBounds(163, 124, 105, 27);
    frame.getContentPane().add(btnNewButton);
  }
}
