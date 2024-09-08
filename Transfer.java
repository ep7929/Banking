 
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Transfer
{
    private Scanner scan = new Scanner(System.in);
    ArrayList<TransactionHistory> tHistory = new ArrayList<>();
    
    public boolean susTransfer(double amount){
        return amount >= 10000;
    }
    public void betweenAccounts(ArrayList<Customer> Customers)
    {
        System.out.println("Please enter your account ID: ");
        int checkID2 = scan.nextInt();
        
        for(Customer customer : Customers){
            if(customer.getID() == checkID2){
                System.out.println("Enter your PIN");
                int PIN2 = scan.nextInt();
                for(Customer customer1 : Customers)
                    {
                    if(customer1.getPIN() == PIN2)
                        {
                        System.out.println("Name:" + customer.getName() + "\n1. Checking Account Balance: $" + customer.getcheckBal() + "\n2. Savings Account Balance: $" + customer.getsavBal());
                        System.out.println("Please select account you would like to transfer from:\n1. Checking to savings\n2. Savings to checking");
                        int accChoice = scan.nextInt();
                            
                        switch(accChoice)
                        {
                            case 1: 
                                    while(true)
                                    {   
                                        System.out.println("Please enter amount you would like to transfer:");
                                        double transfer = scan.nextDouble();
                                        if(transfer <= customer.getcheckBal())
                                        {
                                            double checkbalAfter = (customer.getcheckBal() - transfer);
                                            double savbalAfter = (customer.getsavBal() + transfer);
                                            customer.setcheckBal(checkbalAfter);
                                            customer.setsavBal(savbalAfter);
                                            System.out.println("New account balances:\nChecking: $" + customer.getcheckBal() + "\n Savings: $" + customer.getsavBal());
                                            customer.addTransactionToHistory("Transfer(Checking to Savings)", transfer);
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("You don't have that much money in this account.");
                                        }
                                    }
                                    break;
                                
                            case 2: while(true)
                                    {   
                                        System.out.println("Please enter amount you would like to transfer:");
                                        double transfer2 = scan.nextDouble();
                                            
                                        if(transfer2 <= customer.getsavBal())
                                        {
                                            double checkbalAfter = (customer.getcheckBal() + transfer2);
                                            double savbalAfter = (customer.getsavBal() - transfer2);
                                            customer.setcheckBal(checkbalAfter);
                                            customer.setsavBal(savbalAfter);
                                            System.out.println("New account balances:\nChecking: $" + customer.getcheckBal() + "\n Savings: $" + customer.getsavBal());
                                            customer.addTransactionToHistory("Transfer(Savings to Checking)", transfer2);
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("You don't have that much money in this account.");
                                        }
                                    }
                                        break;
                        
                        }  
                    }
                }   
            }
        }
    }
    
        public void differentAccounts(ArrayList<Customer> Customers)
        {
            System.out.println("Please enter your account ID:");
            int ID1 = scan.nextInt();
            
            for(Customer customer1 : Customers){
                if(customer1.getID() == ID1){
                    System.out.println("Enter your PIN");
                    int PIN2 = scan.nextInt();
                for(Customer customer : Customers)
                {
                    if(customer.getPIN() == PIN2)
                    {
                        System.out.println("Name:" + customer1.getName() + "\n1. Checking Account Balance: $" + customer1.getcheckBal() + "\n2. Savings Account Balance: $" + customer1.getsavBal());
                        System.out.println("Please select account you would like to transfer from:\n1. Checking\n2. Savings");
                        int accChoice = scan.nextInt();
                        
                        switch(accChoice)
                        {
                            case 1: 
                                    while(true)
                                    {   
                                        System.out.println("Please enter amount you would like to transfer:");
                                        double transfer = scan.nextDouble();
                                        if(transfer <= customer1.getcheckBal())
                                        {
                                            double checkbalAfter = (customer1.getcheckBal() - transfer);
                                            System.out.println("You have entered $" + transfer + ", now please enter the account ID of the user you would like to transfer this money too:");
                                            int ID2 = scan.nextInt();
                                            scan.nextLine();
                                            
                                            for(Customer customer2 : Customers)
                                            {
                                                if(customer2.getID() == ID2)
                                                {
                                                    double balAfterTransfer = (customer2.getcheckBal() + transfer);
                                                    customer2.setcheckBal(balAfterTransfer);
                                                    String transfer1 = "Received amount from " + customer1.getName();
                                                    customer2.addTransactionToHistory(transfer1, transfer);
                                                    String transfer2 = "Transferred amount to " + customer2.getName();
                                                    customer1.addTransactionToHistory(transfer2, transfer);
                                                    customer1.setcheckBal(checkbalAfter);
                                                    
                                                    System.out.println("Transfer complete.\nChecking account balance: $" + customer1.getcheckBal());
                                                }
                                            }
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("Error. Please ensure you have that amount in selected account, and that the ID of the other person is correct");
                                        }
                                    }
                                    break;
                            
                            case 2: while(true)
                                    {   
                                        System.out.println("Please enter amount you would like to transfer:");
                                        double transfer = scan.nextDouble();
                                        if(susTransfer(transfer)){
                                            System.out.println("Alert! Suspicious Activity detected! Please contact support to complete this transaction!");
                                            return;
                                        }
                                        if(transfer <= customer1.getsavBal())
                                        {
                                            double checkbalAfter = (customer1.getsavBal() - transfer);
                                            System.out.println("You have entered $" + transfer + ", now please enter the account ID of the user you would like to transfer this money too:");
                                            int ID2 = scan.nextInt();
                                            scan.nextLine();
                                            
                                            for(Customer customer2 : Customers)
                                            {
                                                if(customer2.getID() == ID2)
                                                {
                                                    double balAfterTransfer = (customer2.getcheckBal() + transfer);
                                                    customer2.setcheckBal(balAfterTransfer);
                                                    String transfer1 = "Received amount from " + customer1.getName();
                                                    customer2.addTransactionToHistory(transfer1, transfer);
                                                    String transfer2 = "Transferred amount to " + customer2.getName();
                                                    customer1.addTransactionToHistory(transfer2, transfer);
                                                    customer1.setsavBal(checkbalAfter);
                                                    
                                                    System.out.println("Transfer complete.\nSavings account balance: $" + customer1.getsavBal());
                                                }
                                            }
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("Error. Please ensure you have that amount in selected account, and that the ID of the other person is correct");
                                        }
                                    }
                                    break;
                    
        
                        }
                    }
                }
            }
        }
    }
}
