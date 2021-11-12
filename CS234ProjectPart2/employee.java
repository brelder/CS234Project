public class employee {
	public int employeeID;
	public String name;
	public String phoneNumber;
	public int wage;
	public double weeklySales;
	
	public employee (int employeeID, String name, String phoneNumber, int wage, double weeklySales){ //Employee creation
		this.employeeID = employeeID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.wage = wage;
		this.weeklySales = weeklySales;
	}
	
	public String toString(){ //print employee data
		return "\nEmployee ID: " + employeeID + 
				"\nName: " + name + 
				"\nPhone number: " + phoneNumber + 
				"\nHourly wage: " + wage + 
				"\nWeekly sales: " + weeklySales;
	}
}
