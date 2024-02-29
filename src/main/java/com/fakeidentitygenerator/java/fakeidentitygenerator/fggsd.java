package com.fakeidentitygenerator.java.fakeidentitygenerator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class fggsd {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    JFrame frame = new JFrame("Selecting Button");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton theButton = new JButton("Button");

    ActionListener aListener = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        AbstractButton aButton = (AbstractButton) event.getSource();
        boolean selected = aButton.getModel().isSelected();
        System.out.println("Action - selected=" + selected + "\n");
      }
    };

    ChangeListener cListener = new ChangeListener() {
      public void stateChanged(ChangeEvent event) {
        AbstractButton aButton = (AbstractButton) event.getSource();
        ButtonModel aModel = aButton.getModel();
        boolean armed = aModel.isArmed();
        boolean pressed = aModel.isPressed();
        boolean selected = aModel.isSelected();
        System.out.println("Changed: " + armed + "/" + pressed + "/" + selected);
      }
    };

    theButton.addActionListener(aListener);
    theButton.addChangeListener(cListener);
    Container contentPane = frame.getContentPane();
    contentPane.add(theButton, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  }


