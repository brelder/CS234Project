//*******************************************************
//CS 234 2021F
//Eastern New Mexico Retro Paradise Project Part 2
//Elder and McFarlin
//**********************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
        
public class projectMain {
	
    public static void main(String args[]) {
		//array block
		ArrayList<purchaseInvoice> purchases = new ArrayList<purchaseInvoice>(); 
		ArrayList<salesInvoice> sales = new ArrayList<salesInvoice>(); 
		ArrayList<employee> employees = new ArrayList<employee>();
		ArrayList<customer> customers = new ArrayList<customer>();
		ArrayList<silverCustomer> silverCustomers = new ArrayList<silverCustomer>();
		//end of arrays
		
		//iterator block
		Iterator<employee> emiter = employees.iterator();
		Iterator<customer> citer = customers.iterator();
		Iterator<silverCustomer> sciter = silverCustomers.iterator();
		//end of iterators
		
		//creation of pre-existing data
		employees.add( new employee(12345, "Alan Scott", "5051241567", 22, 2000));
		customers.add( new customer(5678, "Lex Luthor", "5059876543", 100));
		customers.add( new customer(5679, "Solomon Grundy", "5058973484", 50));
		silverCustomers.add( new silverCustomer(4567, "Norman Osborne", "5059875678", 200, true));
		//end of data entry
        
		Scanner in = new Scanner(System.in); //initiaziing the scanner
		boolean valid = false; //creating a boolean as a pass-check
		System.out.println("Welcome to the Eastern New Mexico Retro Paradise Point-of-Sale System.");
		System.out.println("To use this system, enter the highlighted letter for the subsystem you wish to use.\nBoth uppercase and lowercase letters can be used.");

		while (!valid) { 
			System.out.println(" | P)urchase an item from a customer | S)ell an item to a customer | \n \n | C)ustomer Information | E)mployee Information | \n \n | Store I)nventory | V)iew Invoices | Q)uit");
			String choice = in.next();
			choice = choice.toLowerCase();
			switch (choice) {
				//This is where the options for the menu system start
				case "p": { //start of store purchasing system
					System.out.println("Pleas enter the customer's account number: ");
                    int addsaccountID = in.nextInt();
					
					System.out.println("Please enter a transaction ID number: ");
					int invoiceID = in.nextInt();
			
					System.out.println("Please enter the current date in (mm/dd/yy) format: ");
					String date = in.next();

					System.out.println("How many consoles would you like to purchase from the customer? ");
					int consolePurchased = in.nextInt();
                   
					System.out.println("How many games would you like to purchase from the customer? ");
					int gamesPurchased = in.nextInt();
			
					System.out.println("How many controllers would you like to purchase from the customer? ");
					int controllersPurchased = in.nextInt();
                   
					System.out.println("How many accessories would you like to purchase from the customer? ");
					int accessoriesPurchased = in.nextInt();
                   
					System.out.println("How many memoribilia items would you like to purchase from the customer? ");
					int memoribiliaPurchased = in.nextInt();
                   
					//This is where the price is tabulated
					double amount = (consolePurchased * 100) + 
									(gamesPurchased * 50) + 
									(controllersPurchased * 20) + 
									(accessoriesPurchased * 10) + 
									(memoribiliaPurchased * 5);
							
					System.out.println("Total: $" + amount);
			
					//customer points subsystem
					double pointsEarned = amount * .1;
					System.out.println("Points earned: " + pointsEarned);
					
					//assign points to customer
					for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();) { //add points to customer account
                        customer addscust = iterator.next();
							if (addscust.accountID == addsaccountID) {
                                    addscust.points = addscust.points + pointsEarned;
                            }
					}
				
					//start of inventory block
					inventory.addConsole(consolePurchased); 
					inventory.addGames(gamesPurchased);
					inventory.addControllers(controllersPurchased);
					inventory.addAccessories(accessoriesPurchased);
					inventory.addMemoribilia(memoribiliaPurchased);
					//end of inventory block
				
					//start of invoice
					purchases.add(new purchaseInvoice (
									addsaccountID,
									invoiceID, 
									date, 
									consolePurchased, 
									gamesPurchased, 
									controllersPurchased, 
									accessoriesPurchased, 
									memoribiliaPurchased, 
									amount, 
									pointsEarned)); //invoice creation
					break;	
				}//end of the store-purchase system
	
				case "s" : { //start of the store-sale system
					System.out.println("Please enter the employee ID: ");
                    int addemployeeID = in.nextInt();
                                        
                    System.out.println("Please enter the customer's ID: ");
                    int addaccountID = in.nextInt();
                                        
					System.out.println("Please enter a transaction ID number: ");
					int invoiceID = in.nextInt();

					System.out.println("Please enter the current date in (mm/dd/yy) format: ");
					String date = in.next();
				
					System.out.println("How many consoles does the customer want to purchase? ");
					int consoleSold = in.nextInt();
				
					System.out.println("How many games does the customer want to purchase? ");
					int gamesSold = in.nextInt();
                   
					System.out.println("How many controllers does the customer want to purchase?  ");
					int controllersSold = in.nextInt();
				
					System.out.println("How many accessories does the customer want topurchase? ");
					int accessoriesSold = in.nextInt();
					
					System.out.println("How many memoribilia items does the customer want to purchase? ");
					int memoribiliaSold = in.nextInt();
					
					double amount = (consoleSold * 100) +  //price tabulation
									(gamesSold * 50) + 
									(controllersSold * 20) + 
									(accessoriesSold * 10) + 
									(memoribiliaSold * 5); 
					System.out.println("Total: $" + amount);
				
					double pointsEarned = amount * .1; //points subsystem
					System.out.println("Points earned: " + pointsEarned);
					
					//assign sales to employee
					for (Iterator<employee> iterator = employees.iterator(); iterator.hasNext();) { //add amount to employee's sales total
                        employee addemp = iterator.next();
						if (addemp.employeeID == addemployeeID) {
                            addemp.weeklySales = addemp.weeklySales + amount;
                        }
					} 
                    
					//assign points to customer					
                    for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();) { //add points to customer account
                        customer addcust = iterator.next();
						if (addcust.accountID == addaccountID) {
                            addcust.points = addcust.points + pointsEarned;
                        }
					}
					
					
					//start of inventory
					inventory.removeConsole(consoleSold);
					inventory.removeGames(gamesSold);
					inventory.removeControllers(controllersSold);
					inventory.removeAccessories(accessoriesSold);
					inventory.removeMemoribilia(memoribiliaSold);
					//end of inventory 
				
					//start of invoice
					sales.add( new salesInvoice (
									addemployeeID,
									addaccountID,
									invoiceID, 
									date, 
									consoleSold, 
									gamesSold, 
									controllersSold, 
									accessoriesSold, 
									memoribiliaSold, 
									amount, 
									pointsEarned)); //invoice creation
					break;
				} //end of store-sale system
				
				case "c": { //start of customer system
					System.out.println("A)dd R)emove M)odify U)pgrade P)rint ");
					String cust = in.next();
					cust  = cust.toLowerCase();
				
					switch (cust) { //start of customer submenu
						case "a": { //start of add block
							System.out.println("What ID number would you like to give the new customer? ");
							int accountID = in.nextInt();
                                                        in.nextLine();
						
							System.out.println("What is their name? ");
							String name = in.nextLine();
							
							System.out.println("What is their phone number? ");
							String phoneNumber = in.nextLine();
                                                        
							customers.add(new customer (accountID, name, phoneNumber, 0));
							break;
						} //end of add block
				
						case "r": { //start of remove block
							System.out.println(customers);
							System.out.println(silverCustomers);
							System.out.println("Please enter the ID number for the customer you wish to remove: ");
							int raccountID = in.nextInt();
							
							for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();) {
								if (iterator.next().accountID == raccountID) {
									iterator.remove();
								}
							}   

							for (Iterator<silverCustomer> iterator = silverCustomers.iterator(); iterator.hasNext();) {
								if (iterator.next().accountID == raccountID) {
									iterator.remove();
								}
							}
							break;      
						}//end of remove block
					
						case "m": { //start of modify block
							System.out.println(customers);
                            System.out.println(silverCustomers);
							System.out.println("Please enter the ID number for the customer who's information you wish to change: ");
							int maccountID = in.nextInt();
                            in.nextLine();
						
							System.out.println("What is their name? ");
							String name = in.nextLine();
							
							System.out.println("What is their phone number? ");
							String phoneNumber = in.nextLine();
	
							System.out.println("What is their current point total? ");
							double points = in.nextDouble();

							for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();){ //start of the iterator
							       customer mcust = iterator.next();
								   if (mcust.accountID == maccountID){
								       int i = customers.indexOf(mcust);
								       customers.set(i, new customer(maccountID, name, phoneNumber, points));
								} //end of iterator
							}
							
							for (Iterator<silverCustomer> iterator = silverCustomers.iterator(); iterator.hasNext();){ //start of the iterator
							       silverCustomer mscust = iterator.next();
								   if (mscust.accountID == maccountID){
								       int i = silverCustomers.indexOf(mscust);
								       silverCustomers.set(i, new silverCustomer(maccountID, name, phoneNumber, points, mscust.coupon));
								} //end of iterator
							}
							break;
                        }//end of modify block
													
						case "u":{ //start of upgrade block
							System.out.println(customers);
							System.out.println(silverCustomers);
							System.out.println("Please enter customer's ID to upgrade to Silver status: ");
                            int uacc = in.nextInt();
                            for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();) { //start of the iterator
                                customer ucust = iterator.next();
								if (ucust.accountID == uacc) {
                                    silverCustomers.add(new silverCustomer (ucust.accountID, ucust.name, ucust.phoneNumber, ucust.points, true));
                                }
							}
							
							for (Iterator<customer> iterator = customers.iterator(); iterator.hasNext();) {
								if (iterator.next().accountID == uacc){ 
									iterator.remove();
								}
							} //end of the iterator
							break;	
						}//end of upgrade block
            
						case "p": { //start of print block
							System.out.println("Customers: " + customers);
							System.out.println("Silver customers: " + silverCustomers);
							break;
						} //end of print block
					
						default: { //if there is an invalid entry
						System.out.println("That is not a valid option. Please try again.");
						}
					}
					break;
				} //end of customer submenu
				
				case "e": {
					System.out.println("A)dd R)emove M)odify P)rint");
					String emp = in.next(); //employee
					emp = emp.toLowerCase();
					switch (emp) {
				
						//start of employee submenu
						case "a": { //start of add employee block
							System.out.println("Please create an ID number for the new employee: ");
							int employeeID = in.nextInt();
                                                        in.nextLine();
                                                        
							System.out.println("What is their name? ");
							String name = in.nextLine();
					
							System.out.println("What is their phone number? ");
							String phoneNumber = in.nextLine();
					
							System.out.println("What will be their hourly wage? ");
							int wage = in.nextInt();
					
							employees.add(new employee (employeeID, name, phoneNumber, wage, 0));
							break;
						} //end of add block

						case "r": { //start of remove employee block
							System.out.println(employees);
							System.out.println("Please enter the ID number for the employee you wish to remove: ");
							int remployeeID = in.nextInt();
		        
							for (Iterator<employee> iterator = employees.iterator(); iterator.hasNext();) {
								if (iterator.next().employeeID == remployeeID) 
								iterator.remove();
							}
							break;
						} //end of remove block
				
						case "m": { //start of modify employee block
							System.out.println(employees);
							System.out.println("Please enter the ID number for the employee who's information you wish to change: ");
							int memployeeID = in.nextInt(); 
                            in.nextLine();
                                                        
							System.out.println("Please enter their name: ");
							String name = in.nextLine();             
					
							System.out.println("Please enter their phone number: ");
							String phoneNumber = in.nextLine();
					
							System.out.println("Please enter their hourly wage: ");
							int wage = in.nextInt();
					
							for (Iterator<employee> iterator = employees.iterator(); iterator.hasNext();) {
								employee memp = iterator.next();
								if (memp.employeeID == memployeeID){ 
									double wksales = memp.weeklySales;
									int i = employees.indexOf(memp);
									employees.set(i, new employee(memployeeID, name, phoneNumber, wage, wksales));
								}
							}
							break;
						} //end of modify block
            
						case "p" : { //print
							System.out.println(employees);
							break;
						} //end of print
					
						default: { //if there is an invalid entry
						System.out.println("That is not a valid option. Please try again.");
						}
                       break;
					}
                   break;
				}//end of employee submenu
				
            
				case "i": { //view inventory
					inventory.getInventory();
					break;
				} //end of inventory
			
				case "v": { //start of view invoice block
					System.out.println("Which kind of invoice would you like to view?");
					System.out.println("S)ales to customers or P)urchases from customers?");
					String view = in.next();
					view = view.toLowerCase();
					switch (view){
						case "p" :{ //view purchases
							System.out.println(purchases);
							break;
						}
					
						case "s" :{//view sales
							System.out.println(sales);
						break;
						}
					
						default: { //if there is an invalid entry
							System.out.println("That is not a valid option. Please try again.");
						}
					}
					break;
				}//end of view invoice
			
				case "q": { //quitting subsystem
					valid = true;
					break;
				} //end of quitting :^()
		
				default: { //if there is an invalid entry
					System.out.println("That is not a valid option. Please try again.");
				} //final menu option/end of invalid entry catcher
			} //end of menu	code   
        } //end of loop for the menu   
    } //end of main
}//end of program
