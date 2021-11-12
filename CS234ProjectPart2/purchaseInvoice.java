public class purchaseInvoice { //start of init block
	private int addsAccountID;
	private int invoiceID;
	private String date;
	private int consolePurchased;
	private int gamesPurchased;
	private int controllersPurchased;
	private int accessoriesPurchased;
	private int memoribiliaPurchased;
	private double amount;
	private double pointsEarned; //end of init block

	public purchaseInvoice (int addsAccountID, int invoiceID, String date, int consolePurchased, 
							int gamesPurchased, int controllersPurchased, 
							int accessoriesPurchased, int memoribiliaPurchased, 
							double amount, double pointsEarned){ //invoice creation
		this.addsAccountID = addsAccountID;
		this.invoiceID = invoiceID;
		this.date = date;
		this.consolePurchased = consolePurchased;
		this.gamesPurchased = gamesPurchased;
		this.accessoriesPurchased = accessoriesPurchased;
		this.controllersPurchased = controllersPurchased;
		this.memoribiliaPurchased = memoribiliaPurchased;
		this.amount = amount;
		this.pointsEarned = pointsEarned;
	} //end of invoice
    
    public String toString(){ //generation of the invoice
		return  "\nAccountID: " + addsAccountID +
				"\nInvoice ID: " + invoiceID + 
				"\nDate: " + date + 
				"\nConsoles purchased: " + consolePurchased + 
				"\nGames purchased: " + gamesPurchased + 
				"\nAccessories purchased: " + accessoriesPurchased+
				"\nControllers purchased: " + controllersPurchased + 
				"\nMemoribilia purchased: " + memoribiliaPurchased +
				"\nAmount: " + amount + "\nPoints earned: " + pointsEarned;
	}
}
