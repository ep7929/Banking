import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class BankingSystemMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Bank Bank = new Bank();
        Account act = new Account();
        Transaction tran = new Transaction();
        Transfer transfer = new Transfer();
        
       
        ArrayList<Customer> Customers = new ArrayList<>();
        
        
        Customers.add(new Customer("Ben Snowden", 1234, 250, 1000, 12345));
        Customers.add(new Customer("John Doe", 4321, 1000, 7000, 4321));
        
        
        System.out.println("Welcome to Banking System Simulation.");
        
        while(true)
        {
            Bank.bankOptions();
            int n = scan.nextInt();
        
            switch(n)
            {   
                case 1: Bank.getCustomerInfo(Customers); break;
                
                case 2: System.out.println("Here is a list of all current customers.");
                        System.out.println("\nNames and IDs of Customers:");
                        for (Customer customer : Customers) 
                        {
                            System.out.println("Name:" + customer.getName() + ", ID:" + customer.getID());
                        }
                        break;
            
                case 3: System.out.println("1. Create New Account\n 2. Exit");
                        int choice1 = scan.nextInt();
                        switch(choice1)
                        {
                            case 1: act.createAccount(Customers); break;
                            
                            case 2: break;
                            
                            default: System.out.println("Error, please check you are entering the correct number.");
                        }
                        break;
                        
                case 4: System.out.println("Please make a selecion:\n1. Withdraw\n2. Deposit\n3. Exit");
                        int choice2 = scan.nextInt();
                        switch(choice2)
                        {
                            case 1: tran.withdraw(Customers); break;
                            
                            case 2: tran.deposit(Customers); break;
                            
                            case 3: break;
                            
                            default: System.out.println("Error, please check you are entering the correct number.");
                        }
                        break;
                        
                case 5: System.out.println("Please make a selection:\n1. Transfer between my Accounts\n2. Transfer to another person\n3. Exit");
                        int choice3 = scan.nextInt();
                        switch(choice3)
                        {
                            case 1: transfer.betweenAccounts(Customers); break;
                                
                            case 2: transfer.differentAccounts(Customers); break;
                            
                            case 3: break; 
                            
                            default: System.out.println("Error, please check you are entering the correct number.");
                        }
                        break;
                        
                case 6: System.out.println("Please enter your account ID to view your transaction history:");
                        int checkID = scan.nextInt();
                        System.out.println("Please enter in your PIN: ");
                        int checkPIN = scan.nextInt();
                        for (Customer customer : Customers) 
                        {
                            if (customer.getID() == checkID) 
                            {
                                ArrayList<TransactionHistory> history = customer.getTransactionHistory();
                                
                                for (TransactionHistory th : history) 
                                {
                                    System.out.println(th);
                                }
                            }
                        }
                        break;
                        
                    
                case 7: System.out.println("Exiting program. Thank you for using Bank System Simulation!"); 
                        System.exit(0); break;
                
                default: System.out.println("Option " + n + " is not available, please select an available option.");
            }
        }
    }
}
