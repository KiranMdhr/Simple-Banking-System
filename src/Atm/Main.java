//package Atm;
//
//import Banking.User;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
////        System.out.println("ATM that can be used to withdraw money and show balance");
////
////
////        System.out.println("Dashboard");
////        System.out.println("Enter 1 to View Your Balance");
////        System.out.println("Enter 2 to Withdraw");
////        Scanner scanner = new Scanner(System.in);
////        int input = scanner.nextInt();
////        switch (input) {
////            case 1:
////                System.out.println("Enter your userid");
////                int uid = scanner.nextInt();
////              break;
////            case 2:
////                System.out.println("Enter your userid");
////                int userid = scanner.nextInt();
////                System.out.println("Enter the amount you want to withdraw");
////                int amountWithdraw = scanner.nextInt();
////
////        }
//        try {
//            Socket s = new Socket("localhost", 2222);
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//            DataInputStream its = new DataInputStream(s.getInputStream());
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter your Choice:");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter the Account No:");
//                    int accountNo = scanner.nextInt();
//                    System.out.println("Enter the amount you want to withdraw:");
//                    int amount = scanner.nextInt();
//                    dout.writeInt(accountNo);
//                    dout.writeInt(amount);
//                    String output_message = (String) its.readUTF();
//
//                    dout.flush();
//                    System.out.println("Message sent to server");
//                    System.out.println(output_message);
//                    break;
//
//
//                case 2:
//                    System.out.println("Enter your accountNo to check your balance:");
//                    int acctNo = scanner.nextInt();
//                    dout.writeInt(acctNo);
//                    String output_balance = (String) its.readUTF();
//                    System.out.println(output_balance);
//                    break;
//            }
//
//            dout.close();
//            s.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
package Atm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 2222);
             DataOutputStream dout = new DataOutputStream(s.getOutputStream());
             DataInputStream din = new DataInputStream(s.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter your Choice:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. View Balance");
            int choice = scanner.nextInt();

            dout.writeInt(choice);

            switch (choice) {
                case 1:
                    System.out.println("Enter the Account No:");
                    int accountNo = scanner.nextInt();
                    System.out.println("Enter the amount you want to withdraw:");
                    int amount = scanner.nextInt();

                    dout.writeInt(accountNo);
                    dout.writeInt(amount);

                    String withdrawMessage = din.readUTF();
                    System.out.println(withdrawMessage);
                    break;

                case 2:
                    System.out.println("Enter your account No to check your balance:");
                    int acctNo = scanner.nextInt();

                    dout.writeInt(acctNo);  // Send account number

                    String balanceMessage = din.readUTF();
                    System.out.println(balanceMessage);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
