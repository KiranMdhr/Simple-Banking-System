package Banking;

public class Account {
    private int accountNo;
    private String userid;
    private float balance;

    public String getUserid() {
        return userid;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Account(User user) {
        this.accountNo = generateAccountNo();
        this.userid = user.generateUserId();
        this.balance = 10000;
    }

    public String toString() {
        return "Banking.User ID: " + userid + ", Banking.Account No: " + accountNo + ", Balance: " + balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int generateAccountNo() {
        return ((int) (Math.random() * 1000));
    }

    public void deposit(int amount) {
        if (amount < 100) {
            System.out.println("You cannot deposit amount less than 100");
            return;
        }
        balance += amount;

    }
    public void withdraw(int amount) {

        if (amount > balance) {
            System.out.println("You don't have sufficient balance");
            return;
        }
        balance -= amount;

    }


}