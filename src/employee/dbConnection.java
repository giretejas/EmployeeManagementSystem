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
		}		return con;
	}	 	public static Connection secondDbConnect() {		Connection con1 =null;		try {//			driver load			Class.forName("com.mysql.cj.jdbc.Driver");//			Connection to DB			con1 =  DriverManager.getConnection("jdbc:mysql://localhost:3306/inActiveEmp","root","T3ej5as96@");		} catch (Exception e) {			e.printStackTrace();		}		return con1 ;			}		public static Connection thirdDbConnect() {		Connection con1 =null;		try {//			driver load//			Class.forName("com.mysql.cj.jdbc.Driver");//			Connection to DB			con1 =  DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=inActiveEmp","LAPTOP-T3EJ5AS9\\TEJAS","");			System.out.println("Connected to sql server");		} catch (Exception e) {			e.printStackTrace();		}		return con1 ;			}

}


