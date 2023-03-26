package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudentDetails extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfcourse, tfbranch;
    JLabel labelrollno;
    Choice crollno;
    JButton submit, cancel;

    UpdateStudentDetails(){

        setSize(900,650);
        setLocation(350,50);
        getContentPane().setBackground(Color.gray);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Information");
        heading.setBounds(100, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 40));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll number");
        lblrollno.setBounds(50, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel("");
        labelname.setBounds(200, 150, 150, 30);
        add(labelname);

        //father name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel("");
        labelfname.setBounds(600, 150, 150, 30);
        add(labelfname);

        //roll no.
        JLabel lbrollno = new JLabel("Roll Number");
        lbrollno.setBounds(50, 200, 200, 30);
        lbrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lbrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        //D-O-B
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        add(labeldob);

        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        //phone number
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        //e-mail
        JLabel lblemail = new JLabel("E-Mail ID");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        //Class X percentage
        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        add(labelx);

        //Class XII percentage
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        add(labelxii);

        //adhaar no.
        JLabel lbladhaar = new JLabel("Adhaar No.");
        lbladhaar.setBounds(400, 350, 200, 30);
        lbladhaar.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladhaar);

        JLabel labeladhaar = new JLabel();
        labeladhaar.setBounds(600, 350, 150, 30);
        add(labeladhaar);

        //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        //branch
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student where rollno = '" + crollno.getSelectedItem() + "'";

            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("xii"));
                labeladhaar.setText(rs.getString("adhaar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent ie) { 
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM student where rollno = '" + crollno.getSelectedItem() + "'";
    
                ResultSet rs = c.s.executeQuery(query);
    
                while(rs.next()){
                    labelname.setText(rs.getString("name"));
                    labelfname.setText(rs.getString("fname"));
                    labeldob.setText(rs.getString("dob"));
                    tfaddress.setText(rs.getString("address"));
                    tfphone.setText(rs.getString("phone"));
                    tfemail.setText(rs.getString("email"));
                    labelx.setText(rs.getString("class_x"));
                    labelxii.setText(rs.getString("xii"));
                    labeladhaar.setText(rs.getString("adhaar"));
                    labelrollno.setText(rs.getString("rollno"));
                    tfcourse.setText(rs.getString("course"));
                    tfbranch.setText(rs.getString("branch"));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
        });
        
        submit = new JButton("Add");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Lato", Font.ITALIC, 16));
        add(submit);

        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Lato", Font.ITALIC, 16));
        add(cancel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();
            try {
                String query = "update student set address ='"+address+"',phone = '"+phone+"', email ='"+email+"', course = '"+course+"', branch = '"+branch+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details updated Successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    


    public static void main(String[] args) {
        new UpdateStudentDetails();
    }
}
