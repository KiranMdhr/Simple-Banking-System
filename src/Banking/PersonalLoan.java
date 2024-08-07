package Banking;

public class PersonalLoan extends Loan{

double interestRate = 12.2;
String loanType = "Personal";
    public PersonalLoan(String userId, double principalAmount,  int months){

        super(userId,  principalAmount,  months);

    }

    public String toString() {
        return "The User id is" + getUserid() + "The Amount is " + getPrincipalAmount() + "The duration month is" + getMonths() +"The Interest Rate is " + interestRate + "Type of Loan is " +loanType;
    }


}
