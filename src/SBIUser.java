import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{

    //attributes
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    public SBIUser(String name, double balance, String password) {
        //already defined
        this.name = name;
        this.balance = balance;
        this.password = password;

        //bank is initializing
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override //annotation
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance += amount;
        return "Your balance is : " + balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)) {
            if (amount > balance) return "Sorry bro ! Insufficient Money";
            else {
                balance -= amount;
                return "money money !";
            }
        }
        else{
            return  "Wrong password !";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance * years * rateOfInterest) / 100;
    }
}
