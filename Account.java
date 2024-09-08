
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Account
{
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();
    
    ArrayList<TransactionHistory> tHistory = new ArrayList<>();
    
    
    public void createAccount(ArrayList<Customer> Customers)
    {   
            System.out.println("Please enter the first and last name of account holder");
            String name = scan.nextLine();
        
            System.out.println("Please enter initial deposit to your checking account.");
            double inCheck = scan.nextDouble();
            scan.nextLine();
        
            System.out.println("Please enter initial deposit to your savings account.");
            double inSav = scan.nextDouble();
            scan.nextLine();
            
            int pin = rand.nextInt(100000);
            int id = rand.nextInt(10000);
            
            Customer add = new Customer(name, id, inCheck, inSav, pin);
            Customers.add(add);
            
            System.out.println("Thank you for creating your new account! Here is your new account ID: " + id + "\n Here is your PIN :" + pin + "Please do not forget this number!");
    }
}
