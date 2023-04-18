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
        System.out.println("Hello and welcome to the interest calculator!");
        System.out.println("");

        System.out.println("How much would you like to invest?");
        String userInvestment = scan.nextLine();
        int initialPrincipleAmount = Integer.parseInt(userInvestment); //initial amount of principle

        System.out.println("How many years would you like to invest for?");
        String numYears = scan.nextLine();
        int numFundYears = Integer.parseInt(numYears); //number of years user has chosen to keep money in fund for

        System.out.println("What is the annual interest rate % growth?");
        String interestGrowth = scan.nextLine();
        double annualInterestRate = Double.parseDouble(interestGrowth); //annual interest rate

        double quarterlyInterestRate = annualInterestRate / 4; //calculates the interest rate for each financial quarter.

        double currentBalance = initialPrincipleAmount; //current balance uses user's amount they have chosen to invest.
        int i = 0; // counter to keep track of the number of years/loops program has done.

        while (i < numFundYears) {
            double yearlyStartBalance = currentBalance; // used to keep track of balance for start of each year
            System.out.println("Year " + i + ":");
            System.out.println("Current balance at the start of the year: £" + String.format("%.2f",yearlyStartBalance));

            //Calculations to update current balance for first, second, third and fourth quarters of the year.
            //Current balance is updated to use the balance from the previous quarter.
        double balanceForFirstQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in first quarter of the year
        currentBalance += (balanceForFirstQuarter - currentBalance); //updates current balance variable to be used in the next quarter calculation

        double balanceForSecondQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in second quarter of the year
        currentBalance += (balanceForSecondQuarter - currentBalance); //updates current balance variable to be used in the next quarter calculation

        double balanceForThirdQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in third quarter of the year
        currentBalance += (balanceForThirdQuarter - currentBalance); //updates current balance variable to be used in the next quarter calculation

        double balanceForFourthQuarter = currentBalance * (1 + (quarterlyInterestRate / 100)); // calculates amount made in fourth quarter of the year
        currentBalance += (balanceForFourthQuarter - currentBalance); //updates current balance variable to be used in the next quarter calculation

            double yearlyEarnings = currentBalance - yearlyStartBalance;
            System.out.println("You earned: " + "£" + String.format("%.2f",yearlyEarnings));
            System.out.println("Ended year with: " + "£" + String.format("%.2f",currentBalance));
            System.out.println("_________________________________");
            System.out.println();

            i += 1; // increases counter that keeps track of the number of loops program has done.

    }
        }
    }
