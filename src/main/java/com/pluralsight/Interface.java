package com.pluralsight;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        while(true){ //Infinite loop until they decide to leave
            System.out.println("Welcome to the main menu! You have the ability to choose one of several calculators!");
            System.out.println("Your options are:");
            System.out.println("            (M)ortgage Payment Calculator");
            System.out.println("            (F)uture Value of Deposit Calculator");
            System.out.println("            (P)resent Value of Annuity Calculator");
            System.out.println("            (Q)uit Program");
            System.out.print("Please select the calculator you'd like to use: ");
            choice = scanner.nextLine();
            choice = choice.toUpperCase();
            switch (choice){
                case "M": //Mortgage Calculator
                    System.out.println("Running Mortgage Calculator...");
                    MortgageCalculator.main(args);
                    System.out.println("\nReturning to main menu...\n\n");;
                    break;
                case "F": //Future Value Calculator
                    System.out.println("Running Future Value Calculator...");
                    FutureValue.main(args);
                    System.out.println("\nReturning to main menu...\n\n");;
                    break;
                case "P": //Present Value Calculator
                    System.out.println("Running Present Value Calculator...");
                    PresentValue.main(args);
                    System.out.println("\nReturning to main menu...\n\n");;
                    break;
                case "Q": //Quit
                    System.out.println("Thank you for using this calculator! Goodbye!");
                    return;
                default:
                    System.out.println("ERROR: Invalid Choice!");
                    System.out.println("Returning to main menu...\n\n");
            }
        }
    }
}