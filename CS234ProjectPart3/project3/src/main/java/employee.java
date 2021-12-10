
import java.io.Serializable;

public class employee implements Serializable {
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
		return "Employee ID: " + employeeID + 
				"\nName: " + name + 
				"\nPhone number: " + phoneNumber + 
				"\nHourly wage: " + wage + 
				"\nWeekly sales: " + weeklySales + "\n" + "\n";
	}
}
