import java.util.ArrayList;
import java.util.Arrays;


public class Customer
{
    private String name;
    private int ID;
    private double checkBal;
    private double savBal;
    private ArrayList<TransactionHistory> transactionHistory;
    private int PIN;
        
    public Customer(String name, int ID, double checkBal, double savBal, int PIN)
    {
        this.name = name;
        this.ID = ID;
        this.checkBal = checkBal;
        this.savBal = savBal;
        this.transactionHistory = new ArrayList<>();
        this.PIN = PIN;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    public double getcheckBal()
    {
        return checkBal;
    }
    
    public void setcheckBal(double checkBal)
    {
        this.checkBal = checkBal;
    }
    
    public double getsavBal()
    {
        return savBal;
    }
    
    public void setsavBal(double savBal)
    {
        this.savBal = savBal;
    }
    
    public int getPIN(){
        return PIN;
    }
    
    public void setPIN(){
        this.PIN = PIN;
    }
    
    public ArrayList<TransactionHistory> getTransactionHistory() 
    {
        return transactionHistory;
    }

    public void addTransactionToHistory(String type, double amount) 
    {
        transactionHistory.add(new TransactionHistory(type, amount));
    }
}
