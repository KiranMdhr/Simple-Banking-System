package Banking;

public class User {
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNo;
    private String userId;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public User(String firstName, String lastName, String address, int phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.userId = generateUserId();
        this.password = generatePassword();


    }

    public String generateUserId() {
        String first = firstName.substring(0, 3);
        String mid = lastName.substring(0, 3);
        int last = (int) (Math.random() * 100);
        return first + mid + last;
    }

    public String generatePassword() {
       String first = generateUserId();
       String last = "#safdd";
        return first + last;

    }
    public String toString(){
        return "FirstName : " + firstName +" " + "LastName : " +" " + lastName +" " + "Address : " + address +" " + "UserId : " + userId +" " + "Password : " + password;
    }
}
