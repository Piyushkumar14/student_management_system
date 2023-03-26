package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    Login(){

        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel lbusername = new JLabel("UserName");
        lbusername.setForeground(Color.white);
        lbusername.setBounds(40, 20, 100, 20);
        add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        JLabel lbpassword = new JLabel("Password");
        lbpassword.setForeground(Color.white);
        lbpassword.setBounds(40, 70, 100, 20);
        add(lbpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this);
        login.setFont(new Font("Lato", Font.ITALIC, 16));
        add(login);

        cancel = new JButton("cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Lato", Font.ITALIC, 16));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600,300);
        setLocation(450,225);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent ac) {
        
        if(ac.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();

             String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
             }

        } else if(ac.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
    }
    
}
