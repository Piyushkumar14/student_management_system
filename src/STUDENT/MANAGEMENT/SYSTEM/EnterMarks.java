package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;


public class EnterMarks  extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox csem;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfsub6, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5, tfmarks6;
    JButton submit, cancel;

    EnterMarks(){

        setSize(1000,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.gray);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 40, 350, 250);
        add(image);

        JLabel heading = new JLabel("Enter marks of Students");
        heading.setBounds(100, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll number");
        lblrollno.setBounds(50, 100, 200, 20);
        lblrollno.setFont(new Font("serif", Font.ITALIC, 20));
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
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 150, 200, 20);
        lblsemester.setFont(new Font("serif", Font.ITALIC, 20));
        add(lblsemester);

        String sem[] = { "1st","2nd", "3rd","4th", "5th", "6th", "7th", "8th" };
        csem = new JComboBox(sem);
        csem.setBounds(250, 150, 200, 20);
        add(csem);

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 200, 200, 40);
        lblentersubject.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 200, 200, 40);
        lblentermarks.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentermarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(70, 250, 200, 20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(70, 280, 200, 20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(70, 310, 200, 20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(70, 340, 200, 20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(70, 370, 200, 20);
        add(tfsub5);

        tfsub6 = new JTextField();
        tfsub6.setBounds(70, 400, 200, 20);
        add(tfsub6);


        tfmarks1 = new JTextField();
        tfmarks1.setBounds(270, 250, 200, 20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(270, 280, 200, 20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(270, 310, 200, 20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(270, 340, 200, 20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(270, 370, 200, 20);
        add(tfmarks5);

        tfmarks6 = new JTextField();
        tfmarks6.setBounds(270, 400, 200, 20);
        add(tfmarks6);
        
        submit = new JButton("Add");
        submit.setBounds(70, 450, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Lato", Font.ITALIC, 16));
        add(submit);

        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(270, 450, 120, 30);
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

            try {
                Conn c = new Conn();
                // System.out.println(csem.getSelectedItem());
        
                String query1 = "insert into subject values('"+crollno.getSelectedItem() +"', '"+csem.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"', '"+tfsub6.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem() +"', '"+csem.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"', '"+tfmarks6.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
                // System.out.println("Galat h ");
            }
        }else{
            setVisible(false);
        }
    }
    

    public static void main(String[] args) {
        new EnterMarks();
    }   
}
