package com.fmi.laborator09.components;

import com.fmi.laborator09.models.User;
import com.fmi.laborator09.services.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * unhappy with the class name for now
 */
public class TableWithDataModelTestMain {

    /**
     * create a data model using Object arrays
     * @return
     */
    public static DefaultTableModel createDataModelWithArrays() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {
                { "some", "text" }, { "any", "text" }, { "even", "more" },
                { "text", "strings" }, { "and", "other" }, { "text", "values" } },
                new Object[] { "Column 1", "Column 2" });
        return defaultTableModel;
    }

    /**
     * create a data model using a list of users
     * @return
     */
    public static DefaultTableModel createDataModelWithLists() {
        // we are getting the users from the service
        List<User> users = UserService.getInstance().findAll();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("id");
        tableModel.addColumn("username");
        tableModel.addColumn("name");

        for(User user : users) {
            tableModel.addRow(new Object[] {user.getId(), user.getUsername(), user.getName()});
        }

        return tableModel;
    }



    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Table with DataModel test");



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(createDataModelWithLists());

        jFrame.add(new JScrollPane(table));
        jFrame.setSize(640, 480);

        jFrame.setVisible(true);


    }

}
