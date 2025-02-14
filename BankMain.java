package JavaTrains;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    // values from BankAcount class:
    static BankAccount bank = new BankAccount();
    static ArrayList<String> users = bank.users;
    static ArrayList<String> paswswords = bank.passwords;
    static ArrayList<Integer> balances = bank.balances;

    // main method for run:
    public static void main(String[] args) {
        firstPage();
    }

    // again method for inputs:
    static String again(String checking) {
        while (checking.equals("")) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Something went wrong! Enter again:");
            System.out.print("-->");
            checking = myObj.nextLine();
        }
        return checking;
    }

    // choosing between log in and sign up:
    static void firstPage () {
        Scanner myObj = new Scanner(System.in);
        System.out.println("login or signup?");
        System.out.print("-->");
        String step = again(myObj.nextLine());
        if (step.equals("signup")) {
            signup();
        } else if (step.equals("login")) {
            login();
        } else {
            System.out.println("Something went wrong! Try again.");
            firstPage();
        }
    }

    // sign up page:
    static void signup () {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter back or username:");
        System.out.print("-->");
        String name = again(myObj.nextLine());
        if (name.equals("back")) {
            firstPage();
        } else {
            if (users.contains(name)) {
                System.out.println("You signed up before. Going to login page...");
                login();
            } else {
                users.add(name);

                myObj = new Scanner(System.in);
                System.out.println("Enter your password:");
                System.out.print("-->");
                String password = again(myObj.nextLine());
                paswswords.add(password);

                myObj = new Scanner(System.in);
                System.out.println("How much money do you want to deposit into your account?");
                System.out.print("-->");
                int balance = myObj.nextInt();
                System.out.println(balance);
                balances.add(balance);

                System.out.println("Your informations are seted successfully!");
                System.out.println("Now you can log in. Going to login page...");
                login();
            }
        }
    }

    // log in page:
    static void login() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter back or username:");
        System.out.print("-->");
        String name = again(myObj.nextLine());
        if (name.equals("back")) {
            firstPage();
        } else {
            if (users.contains(name) == false) {
                System.out.println("You have to sign up first. Going to sign up page...");
                signup();
            } else {
                myObj = new Scanner(System.in);
                System.out.println("Enter your password:");
                System.out.print("-->");
                String password = again(myObj.nextLine());
                int myIndex = users.indexOf(name);

                while (password.equals(paswswords.get(myIndex))==false) {
                    myObj = new Scanner(System.in);
                    System.out.println("Incorrect password! Enter your password again:");
                    System.out.print("-->");
                    password = again(myObj.nextLine());
                }

                myObj = new Scanner(System.in);
                System.out.println("What do you want to do? transfer or changename or changepassword?");
                System.out.print("-->");
                String act = again(myObj.nextLine());

                while (act.equals("transfer")==false && act.equals("changepassword")==false && act.equals("changename")==false) {
                    System.out.println("Something went wrong. please enter again:");
                    myObj = new Scanner(System.in);
                    System.out.println("What do you want to do? transfer or changename or changepassword?");
                    act = again(myObj.nextLine());
                }

                if (act.equals("transfer")) {
                    transfer(myIndex);
                } else if (act.equals("changename")) {
                    changeName(name);
                } else if (act.equals("changepassword")) {
                    changePassword(name);
                }
            }
        }
    }

    // transfer page:
    static void transfer(int myIndex) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Who do you want to transfer to?");
        System.out.print("-->");
        String destination = again(myObj.nextLine());

        if (users.contains(destination) == false) {
            System.out.println("He/She does not have an account in this bank. Going to first page...");
            firstPage();
        } else {
            myObj = new Scanner(System.in);
            System.out.println("How much money do you want to transfer?");
            System.out.print("-->");
            int amount = myObj.nextInt();
            while (amount <= 0) {
                myObj = new Scanner(System.in);
                System.out.println("Something went wrong. please enter again:");
                System.out.print("-->");
                amount = myObj.nextInt();
            }
            while (amount > balances.get(myIndex)) {
                myObj = new Scanner(System.in);
                System.out.println("You don not have that much money. please enter again:");
                System.out.print("-->");
                amount = myObj.nextInt();
            }

            int different = balances.get(myIndex) - amount;
            balances.set(myIndex, different);

            int myIndex2 = users.indexOf(destination);
            different = balances.get(myIndex2) + amount;
            balances.set(myIndex2, different);

            System.out.println("Done successfully.");
            System.out.println("You have " + balances.get(myIndex) + "$ money.");
            System.out.println(users.get(myIndex2) + " have " + balances.get(myIndex2) + "$ money.");
            System.out.println("Going to first page...");
            firstPage();
        }

    }

    // change name page:
    static void changeName(String name) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter new name:");
        System.out.print("-->");
        String newName = again(myObj.nextLine());

        int myIndex = users.indexOf(name);
        users.set(myIndex, newName);
        System.out.println("New name registered. Going to first page");
        firstPage();
    }

    // change password page:
    static void changePassword(String name) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter new password:");
        System.out.print("-->");
        String newpassword = again(myObj.nextLine());

        int myIndex = users.indexOf(name);
        paswswords.set(myIndex, newpassword);
        System.out.println("New password registered. Going to first page");
        firstPage();
    }
}
