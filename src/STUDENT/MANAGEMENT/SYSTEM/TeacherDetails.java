package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class TeacherDetails extends JFrame implements ActionListener{

    Choice cempid;
    JTable table;
    JButton search,add,print, update,cancel;
    
    TeacherDetails() {

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
         
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180, 20, 150, 20);
        add(cempid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 110, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(120, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        print = new JButton("Print");
        print.setBounds(220, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300,100);    
        getContentPane().setBackground(Color.gray);    
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ac) {
        if(ac.getSource() == search){
            String query = "Select * from teacher where rollno = '" + cempid.getSelectedItem()+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(ac.getSource() == print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ac.getSource() == add){
            setVisible(false);
            new addTeacher();
        } else if(ac.getSource() == update){
            setVisible(false);
            // new updateTeacher();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new TeacherDetails();
    }
}