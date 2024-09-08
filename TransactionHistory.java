import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class TransactionHistory
{
    private int ID;
    private String type;
    private double amount;
    
    public TransactionHistory(String type, double amount)
    {
        this.type = type;
        this.amount = amount;
    }

    public String getType()
    {
        return type;
    }
    
    public double getAmount() 
    {
        return amount;
    }
    
    @Override
    public String toString()
    {
        return "Type: " + type + ", Amount: $" + amount;
    }
}

