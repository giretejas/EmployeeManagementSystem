package employee;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

	 public static Connection dbConnect(){
		Connection con = null;
		try {
//			driver load
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection to DB
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/empManagement","root","T3ej5as96@");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

