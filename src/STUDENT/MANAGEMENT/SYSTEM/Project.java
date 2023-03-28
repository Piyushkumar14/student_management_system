package STUDENT.MANAGEMENT.SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{

    Project(){
        setSize(1560,900);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/lpujalandhar.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1560, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // details menu item
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.white);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //leaves menu
        JMenu leave = new JMenu("Apply Leaves");
        leave.setForeground(Color.blue);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leaves");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leaves");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        // leave description
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.red);
        mb.add(leaveDetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.white);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);

        //Exams
        JMenu exam = new JMenu("Examinations");
        exam.setForeground(Color.blue);
        mb.add(exam);

        JMenuItem examdetails = new JMenuItem("Examinations Results");
        examdetails.setBackground(Color.white);
        examdetails.addActionListener(this);
        exam.add(examdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //update information
        JMenu updateinfo = new JMenu("Update Details");
        updateinfo.setForeground(Color.red);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);
        
        //fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);

        //exiting
        JMenu about = new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);

        //exiting
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String msg = ae.getActionCommand();

        if(msg.equals("Exit")){
            setVisible(false);
        } else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {

            }
        } else if(msg.equals("Notepad")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }
        } else if(msg.equals("New Faculty Information")){
            new addTeacher();
        }else if(msg.equals("New Student Information")){
            new addStudent();
        } else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        } else if(msg.equals("View Student Details")){
            new StudentDetails();
        } else if(msg.equals("Faculty Leaves")){
            new TeacherLeave();
        } else if(msg.equals("Student Leaves")){
            new StudentLeave();
        }  else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        } else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        } else if(msg.equals("Update Faculty Details")){
            new UpdateTeacherDetails();
        } else if(msg.equals("Update Student Details")){
            new UpdateStudentDetails();
        } else if(msg.equals("Enter Marks")){
            new EnterMarks();
        } else if(msg.equals("Examinations Results")){
            new ExaminationDetails();
        } else if(msg.equals("Fee Structure")){
            new FeeStructure();
        } else if(msg.equals("About")){
            new About();
        } else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }

    }
    
    public static void main(String[] args) {
        new Project();
    }
}
