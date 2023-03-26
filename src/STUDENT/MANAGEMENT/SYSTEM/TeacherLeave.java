package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    
    JDateChooser dcdate;
    Choice cempid, ctime;
    JButton submit, cancel;

    TeacherLeave(){

        setSize(500,550);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.gray);


        JLabel heading = new JLabel("Apply Leave(Teacher)");
        heading.setBounds(100, 50, 300, 30);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Employee ID");
        lblrollno.setBounds(60, 100, 150, 20);
        lblrollno.setFont(new Font("serif", Font.BOLD, 15));
        add(lblrollno);

        cempid = new Choice();
        cempid.setBounds(60, 130, 200, 20);
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

        JLabel lbldate = new JLabel("Search by Roll number");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("serif", Font.BOLD, 15));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Date");
        lbltime.setBounds(60, 250, 200, 20);
        lbltime.setFont(new Font("serif", Font.BOLD, 15));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Lato", Font.ITALIC, 16));
        add(submit);

        //cancel button

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Lato", Font.ITALIC, 16));
        add(cancel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String empid = cempid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave value('" +empid+"','" +date+"','" +duration+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confrimed");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
