
public class AuditDepartment {
	
	private String company;
	private Employee [] arrEmp;
	private int nbEmp;
	
	public AuditDepartment() {
		company = "uknown";
		arrEmp = new Employee[10];
		nbEmp = 0;
	}
	
	public AuditDepartment(String company,int size)throws NegativeArraySizeException{
		this.company=company;
		arrEmp=new Employee [size];
		nbEmp=0;
	}
	
	public int search(int id) {
		for(int i=0;i<nbEmp;i++) {
			if(id==arrEmp[i].getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean addEmployee(Employee e) {
		int index=search(e.getId());
		if(nbEmp<arrEmp.length) {
			if(index==-1) {
				if(arrEmp[nbEmp] instanceof Programmer) {
					arrEmp[nbEmp++]=new Programmer ((Programmer)e);
				}
				else if(arrEmp[nbEmp] instanceof ProjectManager) {
					arrEmp[nbEmp++]=new ProjectManager((ProjectManager)e);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean removeEmployee(Employee e) {
		int index=search(e.getId());
		if(index!=-1) {
			arrEmp[index]=arrEmp[nbEmp-1];
			nbEmp--;
			return true;
		}
		return false;
	}
	
	public Employee getEmployee(int i)throws ArrayIndexOutOfBoundsException{
		int index=search(i);
		if(arrEmp[index].equals(null)) {
			throw new NullPointerException();
		}
		return arrEmp[index];
		
	}
	
	public double calculateAvgSalary()throws ArithmeticException {
		double sum=0;
		int n=0;
		for(int i=0;i<nbEmp;i++) {
				sum+=arrEmp[i].calculateSalary();
		}
		return sum/nbEmp;
	}
	
	public Employee[] getEmployeeWithSalary(double LB,double UB) {
		if(LB>UB) {
			throw new IllegalArgumentException();
		}
		Employee [] arE=new Employee [nbEmp];
		int nbE=0;
		for(int i=0;i<nbEmp;i++) {
				if(arrEmp[i].calculateSalary()<UB && LB < arrEmp[i].calculateSalary()) {
					arE[nbE++]=arrEmp[i];
				}
		}
		return arE;
	}
	
	public void display() {
		for(int i=0;i<nbEmp;i++) {
			System.out.println(arrEmp[i].toString());
		}
	}

}









