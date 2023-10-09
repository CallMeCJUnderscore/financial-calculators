package com.pluralsight;
import java.util.Locale;
import java.util.Scanner;

public class PresentValue {
    public static double calculatePresentValue(double monthlyPayout, double interestRate, double years){
        double temp = 1 - Math.pow(1+interestRate, -years*12); //Temp exists to help keep my brain in check
        return monthlyPayout * (temp / interestRate);
        //presentValue = monthlyPayout * ((1 - (1 + interestRate)^(-years*12)) / interestRate)
    }
    public static void main(String[] args) {
        double monthlyPayout = 0.0; //Create variables
        double expectedInterestRate = 0.0;
        double expectedInterestPercentage = 0.0;
        double years = 0.0;
        double presentValue = 0.0;
        Scanner scanner = new Scanner(System.in);

        //Prompt user
        System.out.println("Let's calculate the present value of an ordinary annuity!");
        System.out.print("First, please type the monthly payout of the annuity: $");
        monthlyPayout = scanner.nextDouble();
        while(monthlyPayout <= 0.0){ //Basic error checking
            monthlyPayout = scanner.nextDouble();
            if (monthlyPayout <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }
        System.out.print("Second, please type the expected interest rate in percent: ");
        expectedInterestPercentage = scanner.nextDouble();
        while(expectedInterestPercentage <= 0.0){ //Basic error checking
            expectedInterestPercentage = scanner.nextDouble();
            if (expectedInterestPercentage <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }
        expectedInterestRate = expectedInterestPercentage / 12 / 100;
        System.out.print("Finally, please enter the number of years of interest (Decimals allowed): ");
        years = scanner.nextDouble();
        while(years <= 0.0){ //Basic error checking
            years = scanner.nextDouble();
            if (years <= 0.0){
                System.out.print("ERROR: Value must be positive!. Please try again. ");
            }
        }

        //Perform calculations
        presentValue= calculatePresentValue(monthlyPayout, expectedInterestRate, years);
        double months = years * 12;
        months %= 12;
        System.out.println(months);

        //Present results to user
        System.out.println("\nThank you for your input! After running the numbers, here is what I found:");
        System.out.printf(Locale.US, "You said you would like to have a $%,.2f monthly payout with a %.3f%% expected interest rate set to last for %d years and %.0f months.\n", monthlyPayout, expectedInterestPercentage, (int)years, months);  //casting to int so years is truncated
        System.out.printf(Locale.US, "That means you need to invest $%,.2f today.", presentValue);

        return;
    }
}
