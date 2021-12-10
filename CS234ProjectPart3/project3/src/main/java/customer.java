

import java.io.Serializable;

public class customer implements Serializable{
	public int accountID;
	public String name;
	public String phoneNumber;
	public double points;
	
		public customer (int accountID, String name, String phoneNumber, double points){ //customer creation
			this.accountID = accountID;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.points = points;
		}
		
		public String toString() { //printing the data
			return "Account ID: " + accountID + 
					"\nName: " + name + 
					"\nPhone Number: " + phoneNumber + 
					"\nPoints: " + points + "\n" + "\n";
		}
	}
