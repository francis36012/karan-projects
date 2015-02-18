import java.util.Scanner;

public class Mortgage {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		double loan = 0;
		double interestRate = 0;
		double monthlyPayment = 0;
		double balance = 0;
		int compoundPeriod = 0;
		int term;
		
		System.out.printf("Enter the loan amount: ");
		loan = keyboard.nextDouble();
		
		System.out.printf("Enter the interest rate on the loan: ");
		interestRate = keyboard.nextDouble();
		
		System.out.printf("Enter the term(years) for the loan payment: ");
		term = keyboard.nextInt();
		
		System.out.printf("\n================================================================\n");
		keyboard.close();

		monthlyPayment = getMonthlyPayment(loan, interestRate, term);
		balance = -(monthlyPayment * (term * 12));
		System.out.format("%-30s$%-+10.2f%n", "Amount owed to bank:", balance);
		System.out.format("%-30s$%-10.2f%n", "Minimum monthly payment:", monthlyPayment);
	}

	/**
	 * Calculate the monthly payment of a loan.
	 * 
	 * @param loan Amount borrowed
	 * @param interestRate Interest rate on the loan
	 * @param term Repayment term in years 
	 * @return The monthly payment of a loan given interest rate, amount and term 
	 */
	public static double getMonthlyPayment(double loan, double interestRate, double term) {
		double rate = (interestRate / 100) / 12;
		double base = (rate + 1);
		double months = term * 12;
		double result = 0;
		result = loan * (rate * (Math.pow(base, months)) / ((Math.pow(base, months)) - 1)); 
		
		return result;
	}
}
