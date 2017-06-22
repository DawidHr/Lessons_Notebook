import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
private static String url = "jdbc:sqlite:lessonsDB.db";
private static String driver ="org.sqlite.JDBC";
private Connection conn;
private Statement stat;


public DataBase() {
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        System.err.println("Brak sterownika JDBC");
        e.printStackTrace();
    }

    try {
        conn = DriverManager.getConnection(url);
        stat = conn.createStatement();
    } catch (SQLException e) {
        System.err.println("Problem z otwarciem polaczenia");
        e.printStackTrace();
    }


}


public ResultSet viewLessons() {
	String query = "select * from subject";
	try {
		ResultSet rs = stat.executeQuery(query);
		return rs;
	}
	catch(Exception e) {
	return null;}
}


public void addLessons(String subject) {
	try {String query = "insert into subject(subject) where(?)";
	PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, subject);
		int r = stat.executeUpdate();
		System.out.println(r);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
