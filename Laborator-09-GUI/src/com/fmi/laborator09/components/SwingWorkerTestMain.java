package com.fmi.laborator09.components;

import com.fmi.laborator09.models.User;
import com.fmi.laborator09.services.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * unhappy with the class name for now
 */
public class SwingWorkerTestMain {

    /**
     * just copy from a list to another and added a sleep of 500ms
     * @return
     */
    public static List<User> getUserSlowly() {
        // we are getting the users from the service
        List<User> users = UserService.getInstance().findAll();
        List<User> result = new ArrayList<>();
        try {
            for (User user : users) {
                Thread.sleep(500);
                result.add(user);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        return result;
    }

    /**
     * create a data model using a list of users
     * @return
     */
    public static DefaultTableModel createDataModelWithLists(List<User> users) {

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
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.PAGE_AXIS));

        JTable table = new JTable(new DefaultTableModel());
        JProgressBar jProgressBar = new JProgressBar();
        JLabel jLabel = new JLabel("task messages");

        JButton search = new JButton("Search");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button press");

                SwingWorker<List<User>, String> worker = new SwingWorker<List<User>, String>() {

                    private int howMany = 0;

                    @Override
                    protected void process(List<String> chunks) {
                        howMany += chunks.size();
                        jProgressBar.setValue(howMany);
                        jLabel.setText(chunks.get(chunks.size() - 1));
                    }

                    @Override
                    protected List<User> doInBackground() throws Exception {
                        //TODO this is just a demo, don't do this in a real code
                        List<User> users = UserService.getInstance().findAll();

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                jProgressBar.setMinimum(0);
                                jProgressBar.setMaximum(users.size());
                                jProgressBar.setValue(0);
                            }
                        });

                        List<User> result = new ArrayList<>();
                        int counter = 0;
                        try {
                            for (User user : users) {
                                counter++;
                                Thread.sleep(500);
                                result.add(user);
                                publish("added user: " + user.getName());

                            }
                        } catch (InterruptedException exc) {
                            exc.printStackTrace();
                        }

                        return result;
                    }

                    @Override
                    protected void done() {
                        try {
                            // get computed result
                            List<User> result = get();
                            // update table
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = (DefaultTableModel)table.getModel();
                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Username");

                                    for(User user : result) {
                                        defaultTableModel.addRow(new Object[] {user.getId(), user.getName(), user.getUsername()});
                                    }
                                }
                            });
                            // show me the message dialog
                            JOptionPane.showMessageDialog(jFrame, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } catch (ExecutionException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };

                worker.execute();
            }

        });

        JScrollPane jScrollPane = new JScrollPane(table);
        jFrame.add(jScrollPane);
        jFrame.add(jLabel);
        jFrame.add(jProgressBar);
        jFrame.add(search);
        jFrame.pack();
        jFrame.setSize(640, 480);



        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //this is the swing approach to respect the threads
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jFrame.setVisible(true);
            }
        });

    }

}
