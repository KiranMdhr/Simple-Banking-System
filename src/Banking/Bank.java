package Banking;

import java.util.*;

public class Bank {
    Map<String, User> userList;
    Set<Account> accountSet;
    Set<Loan> loanSet;

    public Bank() {
        userList = new HashMap<>();
        accountSet = new HashSet<>();
        loanSet = new HashSet<>();

    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Name");
        String firstName = scanner.next();
        System.out.println("Enter the Last Name");
        String lastName = scanner.next();
        System.out.println("Enter the Address");
        String address = scanner.next();
        System.out.println("Enter the phoneNo");
        int phoneNo = scanner.nextInt();
        User newUser = new User(firstName, lastName, address, phoneNo);
        userList.put(newUser.getUserId(), newUser);
        Account newAccount = new Account(newUser);
        accountSet.add(newAccount);
        System.out.println("Banking.User Created Successfully");
        System.out.println("Your userName is :" + newUser.getUserId());
        System.out.println("Your Password is :" + newUser.getPassword());
        System.out.println("Your bankAccount no is :" + newAccount.generateAccountNo());

    }


    public void viewAllUsers() {
        System.out.println("All the users available are:");
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            System.out.println("Banking.User ID: " + entry.getKey() + ", Details: " + entry.getValue());
        }
    }

    public void addMoney(int accNo, int amount) {
        for (Account account : accountSet) {


            if (account.getAccountNo() == accNo) {

                if (amount <= 0) {
                    System.out.println("You cannot add money 0 or less than 0");
                    break;
                } else {
                    account.deposit(amount);
                    System.out.println("Money added successfully. New balance: " + account.getBalance());
                    return;
                }
            }
        }
        System.out.println("Banking.Account not found.");
    }


    public String viewBalance(int accountNo) {
        for (Account account : accountSet) {
            if (account.getAccountNo() == accountNo) {
                return " Balance: " + account.getBalance();
            }
        }
        return "Account not found.";
    }


    public void viewAllAccount() {
        for (Account accounts : accountSet) {
            System.out.println(accounts);
        }

    }

    public void viewAllLoan() {
        for (Loan loans : loanSet) {
            System.out.println(loans);
        }

    }

    public String withdrawMoney(int accountNo, int amount) {
        for (Account account : accountSet) {
            if (accountNo == account.getAccountNo()) {
                if (amount > account.getBalance()) {
                    System.out.println("You don't have sufficient balance ");
                    break;
                }
                account.withdraw(amount);
            }
        }

        return "Account not found";

    }

    public void changePassword(String userId, String currentPassword, String newPassword) {
        User user = userList.get(userId);
        if (user != null) {
            if (user.getPassword().equals(currentPassword)) {
                user.setPassword(newPassword);
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Current password is incorrect.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void applyForPersonalLoan() {
        //int months,double interestRate
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Userid");
        String userId = scanner.nextLine();
        System.out.println("Enter the Principle");
        double principle = scanner.nextDouble();
        System.out.println("Enter the Months");
        int months = scanner.nextInt();
        PersonalLoan pl = new PersonalLoan(userId, principle, months);
        loanSet.add(pl);
        System.out.println("Loan applied successfully");

    }


}
