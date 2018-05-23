import java.util.ArrayList;
import java.util.Collections;


public class ComparatorExample {

	public static void main(String[] args) {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(10000, "A"));
		employees.add(new Employee(15000, "B"));
		employees.add(new Employee(10000, "C"));
		
		Collections.sort(employees);
		
		for (Employee emp : employees){
			System.out.println(emp.getName());
		}
	}	
}

class Employee implements Comparable<Employee>{
	private int salary;
	private String name;
	
	public Employee(int salary, String name) {			
		this.salary = salary;
		this.name = name;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * if x < y, return negative and x comes first in the list
	 * if x > y, return positive and y comes first in the list
	 * */
	public int compareTo(Employee e1){
		if (e1.getSalary() == this.getSalary()){
			return this.getName().compareTo(e1.getName());
		}
		return e1.getSalary() - this.getSalary();
	}
}
