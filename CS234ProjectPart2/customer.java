public class customer {
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
			return "\nAccount ID: " + accountID + 
					"\nName: " + name + 
					"\nPhone Number: " + phoneNumber + 
					"\nPoints: " + points;
		}
	}
