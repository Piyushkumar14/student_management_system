package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class addTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfadhaar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); 

    addTeacher(){

        setSize(900,700);
        setLocation(350,50);
        getContentPane().setBackground(Color.gray);
        
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        add(heading);

        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField("");
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        //father name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField("");
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        //roll no.
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);

        labelempid = new JLabel("200"+first4);
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);

        //D-O-B
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

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

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        //Class XII percentage
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        //adhaar no.
        JLabel lbladhaar = new JLabel("Adhaar No.");
        lbladhaar.setBounds(400, 350, 200, 30);
        lbladhaar.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladhaar);

        tfadhaar = new JTextField();
        tfadhaar.setBounds(600, 350, 150, 30);
        add(tfadhaar);

        //course
        JLabel lblcourse = new JLabel("Qualificatuion");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = { "M.Tech","MBA", "Msc", "MCA", "M.Com", "MA", "LLB", "MBBS" };
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        add(cbcourse);

        //branch
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"CSE", "IT", "Mathametics", "English", "Biology", "Law", "Physical Education", "Commerce"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        add(cbbranch);
        
        //submit button
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String adhaar = tfadhaar.getText();
            String qualification = (String) cbcourse.getSelectedItem();
            String dept = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhaar+"','"+qualification+"','"+dept+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else{
            setVisible(false);
        }
    }
    

    public static void main(String[] args) {
        new addTeacher();
    }

    
}
