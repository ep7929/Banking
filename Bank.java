
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bank
{
    private Scanner scan = new Scanner(System.in);
    
    public void bankOptions()
    {
        System.out.println("\nPlease choose one of the following options to continue.\n1. View my accounts\n2. View all customers\n3. Create new account\n4. Make a Deposit/Withdraw\n5. Make a Transfer\n6. View my Transaction History\n7. Exit program.");
    }
    
    public void getCustomerInfo(ArrayList<Customer> Customers)
    {
        System.out.println("Please enter your account ID:");
        int checkID = scan.nextInt();
        
        for (Customer customer : Customers) 
            {
                if(customer.getID() == checkID)
                {
                    System.out.println("Name:" + customer.getName() + "\nChecking Account Balance: $" + customer.getcheckBal() + "\nSavings Account Balance: $" + customer.getsavBal());
                }
            }
    }   
    
    /*public void viewTransactionHistory(Customer customer) 
    {
        ArrayList<TransactionHistory> history = customer.getTransactionHistory();
        
        for (TransactionHistory th : history) 
        {
            System.out.println(th);
        }
        
        System.out.println(customer.getTransactionHistory());
    }*/
}

