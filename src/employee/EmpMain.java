package employee;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import departments.*;


public class EmpMain {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("*************************************");
				System.out.println("Welcome to Employee Management System");
				System.out.println("-------------------------------------");
				System.out.println("1.Add Employee Details");
				System.out.println("2.Update Employee Details");
				System.out.println("3.Delete Employee Details");
				System.out.println("4.View Employee Details");
				System.out.println("5.Exit");
				System.out.println("-------------------------------------");
				System.out.println("*************************************");
				System.out.println();
			
				System.out.println("Enter Choice");
				int num = sc.nextInt();
				
				switch(num) {
				
				case 1:
					
//				Add Employee Details
					try {
						System.out.println("___________________________________");
						System.out.println("Please Fill the Details");
						
						System.out.println("Enter id: ");
						int id = Integer.parseInt(br.readLine());
						System.out.println("Enter Name: ");
						String empname  = br.readLine();
						System.out.println("Enter Date of Birth(YYYY/MM/DD): ");
						String dob = br.readLine();
						System.out.println("Enter Date of Join(YYYY/MM/DD): ");
						String doj = br.readLine();
						System.out.println("Enter Date of End(YYYY/MM/DD): ");
						String doe = br.readLine();
						System.out.println("Enter Departmnent: ");
						String dept = br.readLine();
						System.out.println("Enter Manager: ");
						String manager = br.readLine();
						System.out.println("Enter Project Name: ");
						String project = br.readLine();
						System.out.println("Enter salary: ");
						long salary = Integer.parseInt(br.readLine());
						System.out.println("___________________________________");
						
						
						Employee emp = new Employee(id, empname, dob, doj, doe, dept, manager, project, salary);
						
//					Department wise Data Inserted to the Table 
						
						if(emp.getDept().equals("HR") || emp.getDept().equals("hr")) {
							HR.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("FCM") || emp.getDept().equals("fcm")) {
							FCM.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("IT") || emp.getDept().equals("it")) {
							IT.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("MANAGEMENT") || emp.getDept().equals("management")) {
							Management.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("OPERATION") || emp.getDept().equals("operation")) {
							Operation.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("RD") || emp.getDept().equals("rd")) {
							RD.inserDataToDB(emp);
							
						}else if(emp.getDept().equals("SERVICE") || emp.getDept().equals("service")) {
							Service.inserDataToDB(emp);
							
						}else {
							System.out.println("Something Went Wrong, Please try again ! ");
						}		
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
					
					
				case 2:
//				Update Employee Details
					
					try {
						
						System.out.println("Enter Department");
						String dept = br.readLine();
						
						System.out.println("Enter User ID");
						int id = Integer.parseInt(br.readLine());
						
//					Department wise Data Inserted to the Table 
						
						if(dept.equals("HR") || dept.equals("hr")) {
							HR.updateDataToDB(id);
							
						}else if(dept.equals("FCM") || dept.equals("fcm")) {
							FCM.updateDataToDB(id);
							
						}else if(dept.equals("IT") || dept.equals("it")) {
							IT.updateDataToDB(id);
							
						}else if(dept.equals("MANAGEMENT") || dept.equals("management")) {
							Management.updateDataToDB(id);
							
						}else if(dept.equals("OPERATION") || dept.equals("operation")) {
							Operation.updateDataToDB(id);
							
						}else if(dept.equals("RD") || dept.equals("rd")) {
							RD.updateDataToDB(id);
							
						}else if(dept.equals("SERVICE") || dept.equals("service")) {
							Service.updateDataToDB(id);
							
						}else {
							System.out.println("Something Went Wrong, Please try again ! ");
						}	
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
					
				case 3:
					
//				Delete Employee Details
					
					try {
						
						System.out.println("Enter Department");
						String dept = br.readLine();
						
						System.out.println("Enter User ID");
						int id = Integer.parseInt(br.readLine());
						
//					Department wise Data Inserted to the Table 
						
						if(dept.equals("HR") || dept.equals("hr")) {
							HR.moveToOtherDb(id);
							HR.deleteDataFromDB(id);
							
						}else if(dept.equals("FCM") || dept.equals("fcm")) {
							FCM.moveToOtherDb(id);
							FCM.deleteDataFromDB(id);
							
						}else if(dept.equals("IT") || dept.equals("it")) {
							IT.moveToOtherDb(id);
							IT.deleteDataFromDB(id);
							
						}else if(dept.equals("MANAGEMENT") || dept.equals("management")) {
							Management.moveToOtherDb(id);
							Management.deleteDataFromDB(id);
							
						}else if(dept.equals("OPERATION") || dept.equals("operation")) {
							Operation.moveToOtherDb(id);
							Operation.deleteDataFromDB(id);
							
						}else if(dept.equals("RD") || dept.equals("rd")) {
							RD.moveToOtherDb(id);
							RD.deleteDataFromDB(id);
							
						}else if(dept.equals("SERVICE") || dept.equals("service")) {
							Service.moveToOtherDb(id);
							Service.deleteDataFromDB(id);
							
						}else {
							System.out.println("Something Went Wrong, Please try again ! ");
						}		
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 4:
//				View Employee  Details  Department wise and All
					System.out.println("***************************************");
					System.out.println("Enter Choice");
					System.out.println();
					System.out.println("1.View Employee Detail");
					System.out.println("2.View Department wise All Employee Details ");
					System.out.println("3.View All Employees From Organisation  ");
					System.out.println("4.View Terminated Employee");
					System.out.println();
					System.out.println("***************************************");
					System.out.println();
					
					System.out.println("Enter Choice");
					int choice2 = sc.nextInt();
					
					switch(choice2) {
					case 1:
						try {
							System.out.println("Enter Department");
							String dept = br.readLine();
							
							System.out.println("Enter User ID");
							int id = Integer.parseInt(br.readLine());
							
//						Department wise Data Inserted to the Table 
							
							if(dept.equals("HR") || dept.equals("hr")) {
								HR.viewEmployee(id);
								
							}else if(dept.equals("FCM") || dept.equals("fcm")) {
								FCM.viewEmployee(id);
								
							}else if(dept.equals("IT") || dept.equals("it")) {
								IT.viewEmployee(id);
								
							}else if(dept.equals("MANAGEMENT") || dept.equals("management")) {
								Management.viewEmployee(id);
								
							}else if(dept.equals("OPERATION") || dept.equals("operation")) {
								Operation.viewEmployee(id);
								
							}else if(dept.equals("RD") || dept.equals("rd")) {
								RD.viewEmployee(id);
								
							}else if(dept.equals("SERVICE") || dept.equals("service")) {
								Service.viewEmployee(id);
								
							}else {
								System.out.println("Something Went Wrong, Please try again ! ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
						
					case 2:
//						All Employee from Department
						try {

							System.out.println("Enter Department");
							String dept = br.readLine();
							
							if(dept.equals("HR") || dept.equals("hr")) {
								HR.viewAllEmployee(dept);
								
							}else if(dept.equals("FCM") || dept.equals("fcm")) {
								FCM.viewAllEmployee(dept);
								
							}else if(dept.equals("IT") || dept.equals("it")) {
								IT.viewAllEmployee(dept);
								
							}else if(dept.equals("MANAGEMENT") || dept.equals("management")) {
								Management.viewAllEmployee(dept);
								
							}else if(dept.equals("OPERATION") || dept.equals("operation")) {
								Operation.viewAllEmployee(dept);
								
							}else if(dept.equals("RD") || dept.equals("rd")) {
								RD.viewAllEmployee(dept);
								
							}else if(dept.equals("SERVICE") || dept.equals("service")) {
								Service.viewAllEmployee(dept);
								
							}else {
								System.out.println("Something Went Wrong, Please try again ! ");
							}
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}break;
					case 3:
//						View All Organization Employee
						for(int i=0;i<7;i++) {
							IT.viewOrgEmp();
							Service.viewOrgEmp();
							RD.viewOrgEmp();
							HR.viewOrgEmp();
							FCM.viewOrgEmp();
							Operation.viewOrgEmp();
							Management.viewOrgEmp();						
						}
						break;
					case 4:
//						View Terminated Employee
						Connection con1=dbConnection.secondDbConnect();
						try {
							PreparedStatement stmt = con1.prepareStatement("SELECT * FROM inActiveEmp.emp");

							ResultSet set = stmt.executeQuery();
							ResultSetMetaData colname=set.getMetaData(); 
							
							while(set.next()) {
								System.out.println("********************************************************");
								System.out.println("\t\tDetails of "+set.getString("empName"));
								System.out.println("********************************************************");
								System.out.println();
								System.out.println(colname.getColumnName(1)+" \t= \t"+set.getInt("id"));
								System.out.println(colname.getColumnName(2)+"= \t"+set.getString("empName"));
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
						break;
					}
				
				case 5:
				
					break;
				}
				
			}
		}
	}
}
