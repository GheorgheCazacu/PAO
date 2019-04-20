package com.fmi.laborator09.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTestMain {

    public static void main(String[] args) {
        // create a frame with a title
        JFrame jFrame = new JFrame("My first Swing application");

        // set preferred size to be used in pack
        jFrame.setPreferredSize( new Dimension(800, 600));
        // set the default close action to be system exit
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a panel to be added later to the JFrame
        JPanel jPanel = new JPanel();
        // add a button in the panel
        JButton testButton = new JButton("Button");
        testButton.setPreferredSize(new Dimension(150, 40));
        jPanel.add(testButton);
        // add an action for clicking on the button,
        // ActionListener is an awt interface
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showConfirmDialog(jFrame, "the window message", "window title",
//                        JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
//                JOptionPane.showMessageDialog(jFrame, "the window message", "window title",
//                        JOptionPane.WARNING_MESSAGE);
//                Color color = JColorChooser.showDialog(jFrame,"Select a color",Color.BLUE);

                //Create a file chooser
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(jFrame);

            }
        });
        // add the panel to the frame
        jFrame.setContentPane(jPanel);
        // perform configuration of window
        jFrame.pack();
        // make it visible
        jFrame.setVisible(true);

    }
}
