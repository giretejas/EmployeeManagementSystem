package departments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import employee.inActiveEmp;
import employee.Employee;
import employee.dbConnection;

public class FCM {
	
	static Connection con=dbConnection.dbConnect();
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	
	public static void inserDataToDB(Employee emp) {
		try {
//			Insert into DB
			PreparedStatement stmt = con.prepareStatement("insert into empManagement.FCM values (?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, emp.getId());
			stmt.setNString(2, emp.getEmpname());
			stmt.setNString(3, emp.getDob());
			stmt.setNString(4, emp.getDoj());
			stmt.setNString(5, emp.getDoe());
			stmt.setNString(6, emp.getDept());
			stmt.setNString(7, emp.getManager());
			stmt.setNString(8, emp.getProject());
			stmt.setLong(9, emp.getSalary());
			
			stmt.executeUpdate();
			System.out.println("Inserted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteDataFromDB(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from empManagement.FCM where fid=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateDataToDB(int id) {
		try {
			System.out.println();
			System.out.println("***************************");
			System.out.println();
			System.out.println("Enter Name");
			String empName=br.readLine();
			System.out.println("Enter Date of Birth :");
			String dob = br.readLine();
			System.out.println("Date of Joining");
			String doj=br.readLine();
			System.out.println("Date of End");
			String doe=br.readLine();
			System.out.println("Enter Department");
			String dept =br.readLine();
			System.out.println("Enter Manager Name");
			String managerName=br.readLine();
			System.out.println("Enter Project Name");
			String project=br.readLine(); 
			System.out.println("Enter Salary");
			long salary=Integer.parseInt(br.readLine());
			System.out.println("***************************");
			System.out.println();
			
			if(dept.equals("FCM") || dept.equals("fcm")) {
				PreparedStatement stmt = con.prepareStatement("update empManagement.FCM set empName=? ,dob=? ,doj=? ,doe=? ,dept=? ,managerName=? ,project=? ,salary=? where fid =?");
				stmt.setString(1, empName);
				stmt.setString(2, dob);
				stmt.setString(3, doj);
				stmt.setString(4, doe);
				stmt.setString(5, dept);
				stmt.setString(6, managerName);
				stmt.setString(7, project);
				stmt.setLong(8, salary);
				
				stmt.setInt(9, id);
				
				stmt.executeUpdate();
				System.out.println("Updated");
				
			}else {
				System.out.println("Please Enter Correct Department");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void viewEmployee(int id) {
try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM empManagement.FCM WHERE fid=?");
			stmt.setInt(1, id);
			
			ResultSet set = stmt.executeQuery();
			ResultSetMetaData colname=set.getMetaData();  
			
			while(set.next()) {
				System.out.println("********************************************************");
				System.out.println("\t\tDetails of "+set.getString("empName"));
				System.out.println("********************************************************");
				System.out.println();
				System.out.println(colname.getColumnName(1)+" \t= \t"+set.getInt("fid"));
				System.out.println(colname.getColumnName(2)+" = \t"+set.getString("empName"));
				System.out.println(colname.getColumnName(3)+" \t= \t"+set.getString("dob"));
				System.out.println(colname.getColumnName(4)+" \t= \t"+set.getString("doj"));
				System.out.println(colname.getColumnName(5)+" \t= \t"+set.getString("doe"));
				System.out.println(colname.getColumnName(6)+" \t= \t"+set.getString("dept"));
				System.out.println(colname.getColumnName(7)+" = \t"+set.getString("managerName"));
				System.out.println(colname.getColumnName(8)+" = \t"+set.getString("project"));
				System.out.println(colname.getColumnName(9)+" \t= \t"+set.getLong("salary"));
				System.out.println();
				System.out.println("********************************************************");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void moveToOtherDb(int id) {
		// TODO Auto-generated method stub
try {
			
			PreparedStatement stmt2 = con.prepareStatement("select * from empManagement.FCM where fid=?");
			stmt2.setInt(1, id);
			ResultSet set2 =  stmt2.executeQuery();
			while(set2.next()) {
				
				
				String empName2 = set2.getString("empName");
				String dob2= set2.getString("dob");
				String doj2= set2.getString("doj");
				String doe2= set2.getString("doe");
				String dept2 = set2.getString("dept");
				String managerName2 =set2.getString("managerName");
				String project2 = set2.getString("project");
				long salary2 = set2.getLong("salary");
				Connection con1=dbConnection.secondDbConnect();
				
				inActiveEmp aemp = new inActiveEmp( empName2, dob2, doj2, doe2, dept2, managerName2, project2, salary2);

				
				PreparedStatement stmt3 = con1.prepareStatement("insert into inActiveEmp.emp(empName,dob,doj,doe,dept,managerName,project,salary) values (?,?,?,?,?,?,?,?)");
				
				stmt3.setNString(1, aemp.getEmpName2());
				stmt3.setNString(2, aemp.getDob2());
				stmt3.setNString(3, aemp.getDoj2());
				stmt3.setNString(4, aemp.getDoe2());
				stmt3.setNString(5, aemp.getDept2());
				stmt3.setNString(6, aemp.getManagerName2());
				stmt3.setNString(7, aemp.getProject2());
				stmt3.setLong(8, aemp.getSalary2());
				
				
				stmt3.executeUpdate();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}
	public static void viewAllEmployee(String dept) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM empManagement.FCM WHERE dept=?");
			stmt.setString(1, dept);

			ResultSet set = stmt.executeQuery();
			ResultSetMetaData colname=set.getMetaData(); 
			
			while(set.next()) {
				System.out.println("********************************************************");
				System.out.println("\t\tDetails of "+set.getString("empName"));
				System.out.println("********************************************************");
				System.out.println();
				System.out.println(colname.getColumnName(1)+" \t= \t"+set.getInt("fid"));
				System.out.println(colname.getColumnName(2)+" = \t"+set.getString("empName"));
				System.out.println(colname.getColumnName(3)+" \t= \t"+set.getString("dob"));
				System.out.println(colname.getColumnName(4)+" \t= \t"+set.getString("doj"));
				System.out.println(colname.getColumnName(5)+" \t= \t"+set.getString("doe"));
				System.out.println(colname.getColumnName(6)+" \t= \t"+set.getString("dept"));
				System.out.println(colname.getColumnName(7)+" = \t"+set.getString("managerName"));
				System.out.println(colname.getColumnName(8)+" = \t"+set.getString("project"));
				System.out.println(colname.getColumnName(9)+" \t= \t"+set.getLong("salary"));
				System.out.println();
				System.out.println("********************************************************");
				System.out.println();
				System.out.println();
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void viewOrgEmp() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM empManagement.FCM");

			ResultSet set = stmt.executeQuery();
			ResultSetMetaData colname=set.getMetaData(); 
			
			while(set.next()) {
				System.out.println("********************************************************");
				System.out.println("\t\tDetails of "+set.getString("empName"));
				System.out.println("********************************************************");
				System.out.println();
				System.out.println(colname.getColumnName(1)+" \t= \t"+set.getInt("fid"));
				System.out.println(colname.getColumnName(2)+" = \t"+set.getString("empName"));
				System.out.println(colname.getColumnName(3)+" \t= \t"+set.getString("dob"));
				System.out.println(colname.getColumnName(4)+" \t= \t"+set.getString("doj"));
				System.out.println(colname.getColumnName(5)+" \t= \t"+set.getString("doe"));
				System.out.println(colname.getColumnName(6)+" \t= \t"+set.getString("dept"));
				System.out.println(colname.getColumnName(7)+" = \t"+set.getString("managerName"));
				System.out.println(colname.getColumnName(8)+" = \t"+set.getString("project"));
				System.out.println(colname.getColumnName(9)+" \t= \t"+set.getLong("salary"));
				System.out.println();
				System.out.println("********************************************************");
				System.out.println();
				System.out.println();
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
