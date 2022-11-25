package employee;

public class Employee {
	private int id;
	private String empname;
	private String dob;
	private String doj;
	private String doe;
	private String dept;
	private String manager;
	private String project;
	private long salary;
	
//	Constructors
	
	public Employee(String empname, String dob, String doj, String doe, String dept, String manager, String project, long salary) {
		super();
		this.empname = empname;
		this.dob = dob;
		this.doj = doj;
		this.doe = doe;
		this.dept = dept;
		this.manager = manager;
		this.project = project;
		this.salary = salary;
	}

	public Employee(int id, String empname, String dob, String doj, String doe, String dept, String manager, String project, long salary) {
		super();
		this.id = id;
		this.empname = empname;
		this.dob = dob;
		this.doj = doj;
		this.doe = doe;
		this.dept = dept;
		this.manager = manager;
		this.project = project;
		this.salary = salary;
	}
//		default Constructor
	public Employee() {
		super();
	}
	
//		Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
//	toString method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", dob=" + dob + ", doj=" + doj + ", doe=" + doe
				+ ", dept=" + dept + ", manager=" + manager + ", project=" + project + ", salary=" + salary + "]";
	}
	
	
}
