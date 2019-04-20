package com.fmi.laborator09.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsTestMain extends JPanel implements ActionListener {

    // we have three buttons
    protected JButton b1, b2, b3;
    protected JList<String> stringJList;

    public ButtonsTestMain() {
        b1 = new JButton("text1");
        b2 = new JButton("text1");
        b3 = new JButton("Start task");


        // set an ActionCommand, this is making easy the usage of ActionListener
        b1.setActionCommand("button-1");
        b2.setActionCommand("button-2");
        b3.setActionCommand("start-task");

        // configure this class as ActionListener, below is the implementation
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        add(b1);
        add(b2);
        add(b3);

        DefaultListModel<String> stringListModel = new DefaultListModel<>();
        stringListModel.addElement("List element 1");
        stringListModel.addElement("List element 2");
        stringListModel.addElement("List element 3");
        stringListModel.addElement("List element 4");
        stringListModel.addElement("List element 5");
        stringListModel.addElement("List element 6");
        stringListModel.addElement("List element 7");
        stringListModel.addElement("List element 8");

        stringJList = new JList<>(stringListModel);
//        stringJList.setPreferredSize(new Dimension(200, 200));
        stringListModel.addElement("added after");

        JScrollPane jScrollPane = new JScrollPane(stringJList);
        jScrollPane.setPreferredSize(new Dimension(150, 100));
        add(jScrollPane);


        JProgressBar jProgressBar = new JProgressBar(0, 100);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar.setValue(25);
                jProgressBar.setString("my string");
            }
        });

        add(jProgressBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        //click on X will close the window and the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ButtonsTestMain newContentPane = new ButtonsTestMain();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        // you can set a preferred size before build it
        frame.setPreferredSize(new Dimension(640, 480));
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //this is the swing approach to respect the threads
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
