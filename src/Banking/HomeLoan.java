package Banking;

public class HomeLoan extends Loan{

    double interestRate = 8;
    String loanType = "HomeLoan";
    public HomeLoan(String userId, double principalAmount,  int months){

        super(userId,  principalAmount,  months);

    }

    public String toString() {
        return "The User id is" + getUserid() + "The Amount is " + getPrincipalAmount() + "The duration month is" + getMonths() +"The Interest Rate is " + interestRate + "Type of Loan is " +loanType;
    }


}
