/*
John has $500 to invest. Sue knows of a mutual fund plan that pays 10%
interest annually, compounded quarterly. That is, every three months,
the principal is multiplied by 2.5% (the 10% annual rate divided by 4
because it is compounded 4 times per year) and the result is added to the
principal.

More generally, the new amount each quarter is equal to:
CurrentBalance * (1 + (QuarterlyInterestRate / 100))

This program tells John how much money will be in the fund after a specified number of years.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello");

        System.out.println("How much would you like to invest?");
        String userInvestment = scan.nextLine();
        int initialPrincipleAmount =Integer.parseInt(userInvestment) ; //initial amount of principle

        System.out.println("How many years would you like to invest for?");
        String numYears = scan.nextLine();
        int numFundYears = Integer.parseInt(numYears)  ; //number of years money on fund

        System.out.println("What is the annual interest rate % growth?");
        String interestGrowth = scan.nextLine();
        double annualInterestRate = Double.parseDouble(interestGrowth); //annual interest rate

        double quarterlyInterestRate = annualInterestRate/4; //calculates the interest rate for each financial quarter.

        double currentBalance = initialPrincipleAmount;
        int i = 0; // counter to keep track of the number of years/loops program has done.

        while (i < numFundYears){

           double balanceForFirstQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in first quarter of the year
           currentBalance += (balanceForFirstQuarter-currentBalance); //updates current balance variable to be used in the next quarter calculation

           double balanceForSecondQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in second quarter of the year
           currentBalance += (balanceForSecondQuarter-currentBalance); //updates current balance variable to be used in the next quarter calculation

          double balanceForThirdQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in third quarter of the year
           currentBalance += (balanceForThirdQuarter-currentBalance); //updates current balance variable to be used in the next quarter calculation

            double balanceForForthQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in fourth quarter of the year
            currentBalance += (balanceForForthQuarter-currentBalance); //updates current balance variable to be used in the next quarter calculation

            System.out.println(" balance for forth quarter: "+ balanceForForthQuarter);
           double yearlyBalance = currentBalance; // balance at the end of the financial year and will be start balance for the next year
            System.out.println("yearly balance:" + yearlyBalance);
           //double finalYearlyStartBalance = (balanceForForthQuarter - yearlyBalance) + yearlyBalance; // calculates the balance at the start of the year

           i+=1; // increases counter that keeps track of the number of loops program has done.

            System.out.println("Year "+ i +":"); //prints out year 1, year 2 etc

            if (i == 1){
                int yearlyStartBalance = initialPrincipleAmount;
                System.out.println("Current balance at the start of the year: £" + yearlyStartBalance);
                double firstYearEarnings = currentBalance - initialPrincipleAmount;
                System.out.println("You earned: " + "£" + firstYearEarnings );
            } else {
                System.out.println("Current balance at the start of the year: £" + currentBalance);
                double yearlyEarnings = balanceForForthQuarter - yearlyBalance;
                System.out.println(" You earned: " + "£" + yearlyEarnings);
            }
            System.out.println("Ended year with: " +"£" + currentBalance);
            System.out.println("_________________________________");
            System.out.println();
        } // need to work out how to get the ended with balance and yearly earnings for year 2 and onwards
    }
}