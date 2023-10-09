package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {

    public static double calculateMonthlyPayment(double principal, double interestRate, double months){
        double temp1 = Math.pow((1 + interestRate), months);  //Temp exists to help keep my brain in check
        return (principal * interestRate * temp1) / (temp1 - 1);
        //monthlyPayment = (principal * interestRate * ((1 + interestRate)^months)) / (((1 + interestRate)^months) - 1)

    }

    public static double calculateTotalInterest(double monthlyPayment, double principal, int months){
        return (monthlyPayment * months) - principal;
    }
    public static void main(String[] args) {
        double monthlyPayment = 0.0; //Create variables
        double principal = 0.0;
        double interestPercentage = 0.0;
        double interestRate = 0.0;
        int months = 0;
        double totalInterest = 0.0;
        Scanner scanner = new Scanner(System.in);

        //Prompt user
        System.out.println("Hello there! Let's figure out what your monthly payment will be. \n");
        System.out.print("Firstly, I need to know what your principal is: ");
         while(principal <= 0.0){ //Basic error checking
            principal = scanner.nextDouble();
            if (principal <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }
        System.out.print("OK, next I need the percentage of the interest rate of your loan. Please type it here: ");
        while(interestPercentage <= 0.0){ //Basic error checking
            interestPercentage = scanner.nextDouble();
            if (interestPercentage <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }
        interestRate = (interestPercentage/12)/100;
        System.out.print("Finally, I need to know the length of the loan in months. What is it? ");
        while(months <= 0){ //Basic error checking
            months = scanner.nextInt();
            if (months <= 0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }

        //Perform calculations
        monthlyPayment = calculateMonthlyPayment(principal, interestRate, months);
        totalInterest = calculateTotalInterest(monthlyPayment, principal, months);

        //Convert months to years + months
        int years = months / 12;
        months %= 12;

        //Present results to user
        System.out.println("\nThank you for your input! After running the numbers, here is what I found:");
        System.out.printf(Locale.US, "You said you have a $%,.2f loan at %.3f%% interest set to last for %d years and %d months.\n", principal, interestPercentage, years, months);
        System.out.printf(Locale.US, "That means you can expect your monthly payment to be $%,.2f with a total interest of $%,.2f.", monthlyPayment, totalInterest);

        return;

    }


}
