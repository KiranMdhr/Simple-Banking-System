package Banking;

public class Loan {
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    private String userid;
    private double principalAmount;
    private int months;
    private double outstandingAmount;

    public Loan(String userid, double principalAmount, int months) {

        this.principalAmount = principalAmount;
        this.userid = userid;
        this.months = months;
        this.outstandingAmount = principalAmount;
    }



}
