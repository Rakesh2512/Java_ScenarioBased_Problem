package ExceptionBank;

public class BankAccount {

    private double Balance;
    String AccountNumber;

    BankAccount(Double InitialBalalce,String AccountNumber){
       this.Balance = InitialBalalce;
       this.AccountNumber = AccountNumber;
    }

    public void deposite(double amount)throws InvalidAmount{
        if(amount <= 0){
            throw new InvalidAmount("amount should be positice");
        }
        Balance+=amount;
        System.out.println("Amount is credited successfully");
    }

    public void withdrawn(double amount)throws InsufficientBalance{
        if(Balance <= 0){
            throw new InsufficientBalance("Balance is Insufficient");
        }
        Balance-=amount;
        System.out.println(amount+"is debited successfully"+" "+"Balance is remain"+Balance);
    }

    public double getBalance(){
        return Balance;
    }

    public static void main(String[] args) {
        BankAccount b = new BankAccount(50.0, "123");
        try{
            System.out.println("Initial Balance is "+b.getBalance());
            b.deposite(10.0);
            System.out.println("Current balance is "+b.getBalance());
            b.withdrawn(30);
            System.out.println("Current Balance is "+b.getBalance());
        }
        catch(InsufficientBalance e){
            System.out.println("Error:"+e.getMessage());
        }
        catch(InvalidAmount e){
            System.out.println("Error:"+e.getMessage());
        }
        finally{
            System.out.println("Transaction Completed: "+b.getBalance());
        }
    }
}