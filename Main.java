import java.util.*;
public class Main {

	public static void main(String[]args) {
		AuditDepartment ad=new AuditDepartment();
		Scanner sc=new Scanner(System.in);
		int in, add;
		boolean correct = false;
		while(!correct) {
			System.out.println("Enter name of the company and numbers of employees in the Audit Department\n");	
			String nCom=sc.next();
			try {
				int nE=sc.nextInt();
				AuditDepartment a=new AuditDepartment(nCom,nE);
				correct = true;;
			}
			catch(InputMismatchException e)  {
				sc.next();
				System.out.println("Input should be integer");
			}
			catch(NegativeArraySizeException NASE) {
				System.out.println("NegativeArraySizeException");
			}
		}
		//AuditDepartment a=new AuditDepartment();

		do {
			System.out.println("1 for add \n 2 for print \n 3 for print average \n "
					+ "4 for list the employees with certain salary range \n 5 for print all \n -1 to exit");
			in=0;
			try {
			in=sc.nextInt();
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Input should be integer");
			}
			
			switch(in) {

			case 1: System.out.println("Programmer enter 1 , Project Manager enter 2 ");
			add = -1;
			try {
			add=sc.nextInt();
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Input should be integer");
				continue;
			}
			
			if(add==1) {
				System.out.println("enter id, name, nbHours ");
				int id=0;
				try {
				id=sc.nextInt();
				}
				catch(InputMismatchException e) {
					sc.next();
					System.out.println("Input should be integer");
				}
				
				String name=sc.next();
				int h=0;
				try {
				h=sc.nextInt();
				}
				catch(InputMismatchException e) {
					sc.next();
					System.out.println("Input should be integer");
				}
				Programmer p=new Programmer(id,name,h);
			}
			else {
				System.out.println("enter id, name, nbProject");
				int id=0;
				try {
				id=sc.nextInt();
				}
				catch(InputMismatchException e) {
					sc.next();
					System.out.println("Input should be integer");
				}
				String name=sc.next();
				int p=0;
				try {
				p=sc.nextInt();
				}
				catch(InputMismatchException e) {
					sc.next();
					System.out.println("Input should be integer");
				}
				//Employee e=new Employee (id,name);
				ProjectManager m=new ProjectManager(id,name,p);
			}
			break;

			case 2: System.out.println(" Enter the index of the employee ");
			int index=0;
			try {
			index=sc.nextInt();
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Input should be integer");
			}
			
			try {
				System.out.println(ad.getEmployee(index));
			}
			catch(NullPointerException NPE) {
				System.out.println("NullPointerException");
			}
			catch(ArrayIndexOutOfBoundsException AIOOB) {
				System.out.println("ArrayIndexOutOfBoundsException");
			}

			break;

			case 3: try {
				ad.calculateAvgSalary();
			}
			catch(ArithmeticException AE) {
				System.out.println("ArithmeticException");
			}

			break;

			case 4: System.out.println(" Enter the lower and upper bounds ");
			double LB=0;
			double UB=0;
			try {
			LB=sc.nextDouble();
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Input should be integer");
			}
			//double UB;
			try {
			UB=sc.nextDouble();
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Input should be integer");
			}
			try {
				ad.getEmployeeWithSalary(LB, UB);
			}
			catch(IllegalArgumentException IAE) {
				System.out.println("IllegalArgumentException");
			}

			break;

			case 5: ad.display();
			}

		}
		while(in!=-1);

	}

}
