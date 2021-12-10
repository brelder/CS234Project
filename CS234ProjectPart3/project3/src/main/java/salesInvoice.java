

import java.io.Serializable;

public class salesInvoice implements Serializable{ //start of init block
	private int addemployeeID;
    private int addaccountID;
	public int invoiceID;
	private String date;
	private int consoleSold;
	private int gamesSold;
	private int controllersSold;
	private int accessoriesSold;
	private int memoribiliaSold;
	private double amount;
	private double pointsEarned; //end of init block

	public salesInvoice (int addemployeeID, int addaccountID, int invoiceID, String date, 
						int consoleSold, int gamesSold, 
						int controllersSold, int accessoriesSold, 
						int memoribiliaSold, double amount, 
						double pointsEarned) { //invoice creation
		this.addemployeeID = addemployeeID;
		this.addaccountID = addaccountID;
		this.invoiceID = invoiceID;
		this.date = date;
		this.consoleSold = consoleSold;
		this.gamesSold = gamesSold;
		this.controllersSold = controllersSold;
		this.accessoriesSold = accessoriesSold;
		this.memoribiliaSold = memoribiliaSold;
		this.amount = amount;
		this.pointsEarned = pointsEarned;
	} //end of invoice
    
    public String toString() { //invoice generation
		return  "Employee ID: " + addemployeeID +
				"\nAccount ID: " + addaccountID +
				"\nInvoice ID: " + invoiceID + 
				"\nDate: " + date + 
				"\nConsoles sold: " + consoleSold + 
				"\nGames sold: " + gamesSold + 
				"\nAccessories sold: " + accessoriesSold + 
				"\nControllers sold: " + controllersSold + 
				"\nMemoribilia sold: " + memoribiliaSold + 
				"\nAmount: " + amount + 
				"\nPoints earned: " + pointsEarned + "\n" + "\n";
	} 
}
