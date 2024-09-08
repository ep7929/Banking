
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Transaction
{
    private Scanner scan = new Scanner(System.in);
    
    public boolean Sus(double amount){
        return amount > 10000;
    }
    
    public void withdraw(ArrayList<Customer> Customers)
    {
        System.out.println("Please enter your account ID:");
        int checkID = scan.nextInt();
        
        for (Customer customer : Customers) 
        {
            if (customer.getID() == checkID)
            {
                System.out.println("Please enter your PIN: ");
                int checkPIN = scan.nextInt();
                
                for(Customer customer1 : Customers) 
                {
                    if(customer1.getPIN() == checkPIN)
                    {
                        System.out.println("Name:" + customer.getName() + "\n1. Checking Account Balance: $" + customer.getcheckBal() + "\n2. Savings Account Balance: $" + customer.getsavBal());
                        System.out.println("Please select the acount you would like to make a withdraw from:");
                        int choice =  scan.nextInt();
                        
                        switch(choice)
                        {
                            case 1: 
                                    while(true)
                                    {
                                        System.out.println("Please enter amount you would like to withdraw:");
                                        double withdraw = scan.nextDouble();
                                        
                                        if(Sus(withdraw)) {
                                            System.out.println("Alert! Suspicious Activity detected! Please contact support to complete this transaction!");
                                            return;
                                        }
                                        
                                        if(withdraw <= customer.getcheckBal())
                                        {
                                            double newBal = (customer.getcheckBal() - withdraw);
                                            customer.setcheckBal(newBal);
                                            System.out.println("New checking account balance: $" + customer.getcheckBal());
                                            customer.addTransactionToHistory("Withdraw from Checking", withdraw);
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("You do not have that much money in this account, please try again.");
                                        }
                                    }
                                    break;
                                    
                            case 2: 
                                    while(true)
                                    {
                                        System.out.println("Please enter amount you would like to withdraw:");
                                        double withdraw2 = scan.nextDouble();
                                        
                                        if(Sus(withdraw2)) {
                                            System.out.println("Alert! Suspicious Activity detected! Please contact support to complete this transaction!");
                                            return;
                                        }
                                        
                                        if(withdraw2 <= customer.getsavBal())
                                        {
                                            double newBal2 = (customer.getsavBal() - withdraw2);
                                            customer.setsavBal(newBal2);
                                            System.out.println("New savings account balance: $" + customer.getsavBal());
                                            customer.addTransactionToHistory("Withdraw from Savings", withdraw2);
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("You do not have that much money in this account, please try again.");
                                        }
                                    }
                                    break;
                            
                            default: System.out.println("Error, please make sure you're entering the correct number.");
                        }
                    }
                }
            }   
        }
    }
    
    
    public void deposit(ArrayList<Customer> Customers)
    {
        System.out.println("Please enter your account ID:");
        int checkID = scan.nextInt();
        
        for (Customer customer : Customers)
        {
            if (customer.getID() == checkID){  
                System.out.println("Please enter your PIN: ");
                int checkPIN = scan.nextInt();
                
                for (Customer customer1 : Customers) 
                {
                    if(customer1.getPIN() == checkPIN)
                    {
                        System.out.println("Name:" + customer.getName() + "\n1. Checking Account Balance: $" + customer.getcheckBal() + "\n2. Savings Account Balance: $" + customer.getsavBal());
                        System.out.println("Please select the acount you would like to make a deposit to:");
                        int choice =  scan.nextInt();
                        
                        switch(choice)
                        {
                            case 1: System.out.println("Please enter amount you would like to deposit:");
                                    double deposit = scan.nextDouble();
                                    double newBal = (customer.getcheckBal() + deposit);
                                    customer.setcheckBal(newBal);
                                    System.out.println("New checking account balance: $" + customer.getcheckBal());
                                    customer.addTransactionToHistory("Deposit to Checking", deposit);
                                    break;
                                    
                            case 2: System.out.println("Please enter amount you would like to deposit:");
                                    double deposit2 = scan.nextDouble();
                                    double newBal2 = (customer.getsavBal() + deposit2);
                                    customer.setsavBal(newBal2);
                                    System.out.println("New savings account balance: $" + customer.getsavBal());
                                    customer.addTransactionToHistory("Deposit to Savings", deposit2);
                                    break;            
                            
                            default: System.out.println("Error, please make sure you're entering the correct number.");
                        }
                    }   
                }
            }
        }
    }  
}