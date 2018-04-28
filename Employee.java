
public abstract class Employee {
	
	protected int id;
	protected String name;
	
	public Employee(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public Employee(Employee e) {
		id=e.id;
		name=e.name;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract double calculateSalary();
	
	public String toString() {
		return "employee id and name"+id+","+name;
	}
	

}
