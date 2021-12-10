

public class silverCustomer extends customer {
	public boolean coupon;
	
    public silverCustomer (int accountID, String name, String phoneNumber, double points, boolean coupon){ //coupon block
		super( accountID, name, phoneNumber, points);
		this.coupon = coupon;
	} //end of coupon
    
	public String toString(){ //generate the silver account info
		return "Account ID: " + accountID + 
				"\nName: " + name + 
				"\nPhone Number: " + phoneNumber + 
				"\nPoints: " + points + 
				"\nCoupon: " + coupon + "\n" + "\n";
	}
}