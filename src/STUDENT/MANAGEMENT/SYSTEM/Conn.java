package STUDENT.MANAGEMENT.SYSTEM;
// connecting database to project manager
import java.sql.*;
public class Conn {

    Connection c;
	Statement s;

    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///ums", "root", "rajput sahab");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
