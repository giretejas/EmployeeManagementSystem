package employee;

public class inActiveEmp {
	private int id2; 
	private String empName2 ;
	private String dob2;
	private String doj2;
	private String doe2;
	private String dept2;
	private String managerName2;
	private String project2;
	private long salary2;
	
	
	public inActiveEmp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public inActiveEmp(String empName2, String dob2, String doj2, String doe2, String dept2, String managerName2,
			String project2, long salary2) {
		super();
		this.empName2 = empName2;
		this.dob2 = dob2;
		this.doj2 = doj2;
		this.doe2 = doe2;
		this.dept2 = dept2;
		this.managerName2 = managerName2;
		this.project2 = project2;
		this.salary2 = salary2;
	}


	public inActiveEmp(int id2, String empName2, String dob2, String doj2, String doe2, String dept2,
			String managerName2, String project2, long salary2) {
		super();
		this.id2 = id2;
		this.empName2 = empName2;
		this.dob2 = dob2;
		this.doj2 = doj2;
		this.doe2 = doe2;
		this.dept2 = dept2;
		this.managerName2 = managerName2;
		this.project2 = project2;
		this.salary2 = salary2;
	}


	public int getId2() {
		return id2;
	}


	public void setId2(int id2) {
		this.id2 = id2;
	}


	public String getEmpName2() {
		return empName2;
	}


	public void setEmpName2(String empName2) {
		this.empName2 = empName2;
	}


	public String getDob2() {
		return dob2;
	}


	public void setDob2(String dob2) {
		this.dob2 = dob2;
	}


	public String getDoj2() {
		return doj2;
	}


	public void setDoj2(String doj2) {
		this.doj2 = doj2;
	}


	public String getDoe2() {
		return doe2;
	}


	public void setDoe2(String doe2) {
		this.doe2 = doe2;
	}


	public String getDept2() {
		return dept2;
	}


	public void setDept2(String dept2) {
		this.dept2 = dept2;
	}


	public String getManagerName2() {
		return managerName2;
	}


	public void setManagerName2(String managerName2) {
		this.managerName2 = managerName2;
	}


	public String getProject2() {
		return project2;
	}


	public void setProject2(String project2) {
		this.project2 = project2;
	}


	public long getSalary2() {
		return salary2;
	}


	public void setSalary2(long salary2) {
		this.salary2 = salary2;
	}


	@Override
	public String toString() {
		return "inActiveEmp [id2=" + id2 + ", empName2=" + empName2 + ", dob2=" + dob2 + ", doj2=" + doj2
				+ ", doe2=" + doe2 + ", dept2=" + dept2 + ", managerName2=" + managerName2 + ", project2=" + project2
				+ ", salary2=" + salary2 + "]";
	}
	
	
	
	
}
