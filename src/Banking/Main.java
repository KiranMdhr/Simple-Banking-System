//package Banking;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Bank bank = new Bank();
//        User user1 = new User("Alice", "Johnson", "123 Maple St", 5551234);
//        User user2 = new User("Bob", "Smith", "456 Oak St", 5559876);
//        User user3 = new User("Carol", "Williams", "789 Pine Ave", 6543210);
//        User user4 = new User("David", "Brown", "101 Birch Rd", 55104567);
//        User user5 = new User("Eve", "Davis", "202 Cedar Blvd", 5591234);
//
//        bank.userList.put(user1.getUserId(), user1);
//        bank.userList.put(user2.getUserId(), user2);
//        bank.userList.put(user3.getUserId(), user3);
//        bank.userList.put(user4.getUserId(), user4);
//        bank.userList.put(user5.getUserId(), user5);
//
//
//        bank.accountSet.add(new Account(user1));
//        bank.accountSet.add(new Account(user2));
//        bank.accountSet.add(new Account(user3));
//        bank.accountSet.add(new Account(user4));
//        bank.accountSet.add(new Account(user5));
//        bank.viewAllAccount();
//        try {
//            ServerSocket ss = new ServerSocket(2222);
//            Socket s = ss.accept();
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//            DataOutputStream os = new DataOutputStream(s.getOutputStream());
////            String  str=(String)dis.readUTF();
//            int choice = dis.readInt();
//            switch (choice) {
//                case 1:
//                    int atm_accountNo = (int) dis.readInt();
//                    int atm_amount = (int) dis.readInt();
////            System.out.println("message= "+str);
//                    System.out.println("The Userid= " + atm_accountNo);
//                    System.out.println("The amount is  " + atm_amount);
//                    bank.withdrawMoney(atm_accountNo, atm_amount);
//                    os.writeUTF("Successfully withdrawn");
//                    break;
//                case 2:
//                    int accNo = (int) dis.readInt();
//                    System.out.println("The accountNO is " + accNo);
//                    String balance = bank.viewBalance(accNo);
//                    os.writeUTF(balance);
//
//            }
//
//
//            os.flush();
//            os.close();
//
//            ss.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//
//        while (true) {
//            System.out.println("Hello! There");
//            System.out.println("Please Login to access the features");
//            System.out.println("Enter 1 to Login ");
//            System.out.println("Enter 2 to Register ");
//            System.out.println("Enter 3 to view all the users ");
//            System.out.println("Enter 4 to view all the accounts ");
//            System.out.println("Enter 5 to deposit amount in the bank account");
//            System.out.println("Enter 6 to withdraw amount in the bank account");
//            System.out.println("Enter 7 to change the password");
//            System.out.println("Enter 8 to apply for Personal Loan");
//            System.out.println("Enter 9 to apply for Home Loan");
//            System.out.println("Enter 10 to view all the Loans");
//            Scanner scanner = new Scanner(System.in);
//            try {
//                int input = scanner.nextInt();
//
//                switch (input) {
//                    case 1:
//                        System.out.println("Enter your UserName");
//                        String userName = scanner.next();
//                        if (bank.userList.containsKey(userName)) {
//
//                            System.out.println("Welcome ! " + userName);
//
//                        } else {
//                            System.out.println("No Banking.User of this name Found! Please register username ");
//                        }
//                        break;
//                    case 2:
//                        bank.registerUser();
//                        break;
//                    case 3:
//                        bank.viewAllUsers();
//                        break;
//
//                    case 4:
//                        bank.viewAllAccount();
//                        break;
//                    case 5:
//                        System.out.println("Enter your bank account no:");
//                        int account = scanner.nextInt();
//                        System.out.println("Enter the amount you want to deposit");
//                        int amount = scanner.nextInt();
//                        bank.addMoney(account, amount);
//                        break;
//                    case 6:
//                        System.out.println("Enter your bank account no:");
//                        int accountNo = scanner.nextInt();
//                        System.out.println("Enter the amount you want to withdraw");
//                        int withdrawAmount = scanner.nextInt();
//                        bank.withdrawMoney(accountNo, withdrawAmount);
//                        break;
//
//                    case 7:
//                        System.out.println("Enter your User Id:");
//                        String userId = scanner.next();
//                        System.out.println("Enter your currentPassword");
//                        String currentPassword = scanner.next();
//                        System.out.println("Enter new Password");
//                        String newPassword = scanner.next();
//                        bank.changePassword(userId, currentPassword, newPassword);
//                        break;
//                    case 8:
//                        System.out.println("Enter your Userid:");
//                        String uId = scanner.next();
//                        System.out.println("Enter Principle Amount:");
//                        int principle = scanner.nextInt();
//                        System.out.println("Enter the duration months:");
//                        int month = scanner.nextInt();
//                        PersonalLoan pa = new PersonalLoan(uId, principle, month);
//                        bank.loanSet.add(pa);
//                        System.out.println("Loan applied successfully");
//                        break;
//                    case 9:
//                        System.out.println("Enter your Userid:");
//                        String ud = scanner.next();
//                        System.out.println("Enter Principle Amount:");
//                        int principleAmt = scanner.nextInt();
//                        System.out.println("Enter the duration months:");
//                        int months = scanner.nextInt();
//                        HomeLoan hl = new HomeLoan(ud, -principleAmt, months);
//                        bank.loanSet.add(hl);
//                        System.out.println("Loan applied successfully");
//                        break;
//
//                    case 10:
//                        System.out.println("All the loans are :");
//                        bank.viewAllLoan();
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println("The input you have given is not a valid input .Please enter a valid no:");
//            }
//        }
//    }
//}

package Banking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        initializeBank(bank);

        try (ServerSocket ss = new ServerSocket(2222)) {
            System.out.println("Server is running and waiting for clients...");

            while (true) {
                try (Socket s = ss.accept();
                     DataInputStream dis = new DataInputStream(s.getInputStream());
                     DataOutputStream dos = new DataOutputStream(s.getOutputStream())) {

                    int choice = dis.readInt();  // Read the choice from the client

                    switch (choice) {
                        case 1:
                            handleWithdraw(bank, dis, dos);
                            break;
                        case 2:
                            handleViewBalance(bank, dis, dos);
                            break;
                        default:
                            dos.writeUTF("Invalid choice");
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        handleUserInteraction(bank);
    }

    private static void initializeBank(Bank bank) {
        User user1 = new User("Alice", "Johnson", "123 Maple St", 5551234);
        User user2 = new User("Bob", "Smith", "456 Oak St", 5559876);
        User user3 = new User("Carol", "Williams", "789 Pine Ave", 6543210);
        User user4 = new User("David", "Brown", "101 Birch Rd", 55104567);
        User user5 = new User("Eve", "Davis", "202 Cedar Blvd", 5591234);

        bank.userList.put(user1.getUserId(), user1);
        bank.userList.put(user2.getUserId(), user2);
        bank.userList.put(user3.getUserId(), user3);
        bank.userList.put(user4.getUserId(), user4);
        bank.userList.put(user5.getUserId(), user5);

        bank.accountSet.add(new Account(user1));
        bank.accountSet.add(new Account(user2));
        bank.accountSet.add(new Account(user3));
        bank.accountSet.add(new Account(user4));
        bank.accountSet.add(new Account(user5));
        bank.viewAllAccount();
    }

    private static void handleWithdraw(Bank bank, DataInputStream dis, DataOutputStream dos) throws Exception {
        int atm_accountNo = dis.readInt();
        int atm_amount = dis.readInt();
        System.out.println("The Userid= " + atm_accountNo);
        System.out.println("The amount is  " + atm_amount);
        String withdraw_info = bank.withdrawMoney(atm_accountNo, atm_amount);
        dos.writeUTF(withdraw_info);
    }

    private static void handleViewBalance(Bank bank, DataInputStream dis, DataOutputStream dos) throws Exception {
        int accNo = dis.readInt();
        System.out.println("The accountNO is " + accNo);
        String balance = bank.viewBalance(accNo);
        dos.writeUTF(balance);
    }

    private static void handleUserInteraction(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hello! There");
            System.out.println("Please Login to access the features");
            System.out.println("Enter 1 to Login ");
            System.out.println("Enter 2 to Register ");
            System.out.println("Enter 3 to view all the users ");
            System.out.println("Enter 4 to view all the accounts ");
            System.out.println("Enter 5 to deposit amount in the bank account");
            System.out.println("Enter 6 to withdraw amount in the bank account");
            System.out.println("Enter 7 to change the password");
            System.out.println("Enter 8 to apply for Personal Loan");
            System.out.println("Enter 9 to apply for Home Loan");
            System.out.println("Enter 10 to view all the Loans");

            try {
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("Enter your UserName");
                        String userName = scanner.next();
                        if (bank.userList.containsKey(userName)) {
                            System.out.println("Welcome ! " + userName);
                        } else {
                            System.out.println("No Banking.User of this name Found! Please register username ");
                        }
                        break;
                    case 2:
                        bank.registerUser();
                        break;
                    case 3:
                        bank.viewAllUsers();
                        break;
                    case 4:
                        bank.viewAllAccount();
                        break;
                    case 5:
                        System.out.println("Enter your bank account no:");
                        int account = scanner.nextInt();
                        System.out.println("Enter the amount you want to deposit");
                        int amount = scanner.nextInt();
                        bank.addMoney(account, amount);
                        break;
                    case 6:
                        System.out.println("Enter your bank account no:");
                        int accountNo = scanner.nextInt();
                        System.out.println("Enter the amount you want to withdraw");
                        int withdrawAmount = scanner.nextInt();
                        bank.withdrawMoney(accountNo, withdrawAmount);
                        break;
                    case 7:
                        System.out.println("Enter your User Id:");
                        String userId = scanner.next();
                        System.out.println("Enter your currentPassword");
                        String currentPassword = scanner.next();
                        System.out.println("Enter new Password");
                        String newPassword = scanner.next();
                        bank.changePassword(userId, currentPassword, newPassword);
                        break;
                    case 8:
                        System.out.println("Enter your Userid:");
                        String uId = scanner.next();
                        System.out.println("Enter Principle Amount:");
                        int principle = scanner.nextInt();
                        System.out.println("Enter the duration months:");
                        int month = scanner.nextInt();
                        PersonalLoan pa = new PersonalLoan(uId, principle, month);
                        bank.loanSet.add(pa);
                        System.out.println("Loan applied successfully");
                        break;
                    case 9:
                        System.out.println("Enter your Userid:");
                        String ud = scanner.next();
                        System.out.println("Enter Principle Amount:");
                        int principleAmt = scanner.nextInt();
                        System.out.println("Enter the duration months:");
                        int months = scanner.nextInt();
                        HomeLoan hl = new HomeLoan(ud, -principleAmt, months);
                        bank.loanSet.add(hl);
                        System.out.println("Loan applied successfully");
                        break;
                    case 10:
                        System.out.println("All the loans are :");
                        bank.viewAllLoan();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("The input you have given is not a valid input. Please enter a valid number.");
                scanner.next();  // clear the invalid input
            }
        }
    }
}
