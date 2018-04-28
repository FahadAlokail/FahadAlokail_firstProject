
public class ProjectManager extends Employee{
	
	private int nbProjects;
	
	public ProjectManager(int id,String name,int nbProjects) {
		super(id,name);
		this.nbProjects=nbProjects;
	}
	
	public ProjectManager(ProjectManager p) {
		super(p);
		nbProjects=p.nbProjects;
	}
	
	public int getNbProjects() {
		return nbProjects;
	}
	
	public double calculateSalary() {
		return 30000+(1000*nbProjects);
	}
	
	public String toString() {
		return super.toString() + " Number of project for the Project Manager is"+nbProjects;
	}

}
