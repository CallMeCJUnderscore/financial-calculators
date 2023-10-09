package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class FutureValue {
    public static double calculateFutureValue(double deposit, double interestRate, double years){
        return deposit * Math.pow(1+interestRate, years);
    }
    public static void main(String[] args) {
        double deposit = 0.0; //Create variables
        double interestPercentage = 0.0;
        double interestRate = 0.0;
        double years = 0.0;
        Scanner scanner = new Scanner (System.in);
        double futureValue = 0.0;
        double totalInterest = 0.0;

        //Prompt user
        System.out.println("Let's calculate the future value of a one-time deposit!");
        System.out.print("Please type the value of your deposit: $");
        while(deposit <= 0.0){ //Basic error checking
            deposit = scanner.nextDouble();
            if (deposit <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }
        System.out.print("Please type the interest rate in percent: ");
        while(interestPercentage <= 0.0){ //Basic error checking
            interestPercentage = scanner.nextDouble();
            if (interestPercentage <= 0.0){
                System.out.println("ERROR: Value must be positive! Please try again. ");
            }
        }
        interestRate = interestPercentage/100;
        System.out.print("Finally, please enter the number of years of interest: ");
        while(years <= 0.0){ //Basic error checking
            years = scanner.nextDouble();
            if (years <= 0.0){
                System.out.println("ERROR: Value must be positive! Please try again.");
            }
        }
        //Perform calculations
        futureValue = calculateFutureValue(deposit, interestRate, years);
        totalInterest = futureValue - deposit;
        double months = years * 12;
        months %= 12;

        //Display results to user
        System.out.println("\nThank you for your input! After running the numbers, here is what I found:");
        System.out.printf(Locale.US, "You said you have a $%,.2f initial deposit at %.3f%% interest set to last for %d years and %.0f months.\n", deposit, interestPercentage, (int)years, months);
        System.out.printf(Locale.US, "That means you can expect the future value of your deposit to be $%,.2f with a total accrued interest of of $%,.2f.", futureValue, totalInterest);
    }
}
