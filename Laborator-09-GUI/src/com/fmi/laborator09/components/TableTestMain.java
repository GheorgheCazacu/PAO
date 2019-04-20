package com.fmi.laborator09.components;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableTestMain {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("JFrame title");


        String[] columnNames = {"User name", "Password"};
        String[][] tableData = {{"first user name", "first password"}, {"second user name", "second password"}};

        JTable jTable = new JTable(tableData, columnNames);

        // https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
        jTable.setBorder(BorderFactory.createLineBorder(Color.black));
        jTable.setFillsViewportHeight(true);

        // create a scroll pane
        JScrollPane jScrollPane = new JScrollPane(jTable);
        // no matter what we are showing the vertical column bar
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();
        panel.add(jScrollPane);

        // add scroll pane to the jframe
        jFrame.add(panel);

        // Frame Size
        jFrame.setSize(640, 480);
        // Frame Visible = true
        jFrame.setVisible(true);

        // set the default close action to be system exit
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
