import java.util.Scanner;

public class Mortgage {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		double loan = 0;
		double interestRate = 0;
		double monthlyPayment = 0;
		double balance = 0;
		int compoundPeriod = 0;
		int terms;
		
		System.out.printf("Enter the loan amount: ");
		loan = keyboard.nextDouble();
		
		System.out.printf("Enter the interest rate on the loan: ");
		interestRate = keyboard.nextDouble();
		
		System.out.printf("Enter the term(years) for the loan: ");
		terms = keyboard.nextInt();
		
		System.out.printf("\nWhat is the compounding period\n"
				+ "[1 for continually, 2 for Daily, 3 for Weekly, 4 for monthly]: ");
		compoundPeriod = keyboard.nextInt();
		
		System.out.printf("\n================================================================\n");
		switch (compoundPeriod) {
			case 1:
				balance = (loan * Math.pow(Math.E, (interestRate / 100.0) * terms));
				monthlyPayment = balance / (terms * 12);
				System.out.printf("Amount owing: %.2f\n", balance);
				System.out.printf("Minimum monthly payments: %.2f\n", monthlyPayment);
				break;
				
			case 2:
				balance = periodicCompound(loan, interestRate, terms, 365);
				monthlyPayment = balance / (terms * 12);
				System.out.printf("Amount owing: %.2f\n", balance);
				System.out.printf("Minimum monthly payments: %.2f\n", monthlyPayment);
				break;
			
			case 3:
				balance = periodicCompound(loan, interestRate, terms, 54);
				monthlyPayment = balance / (terms * 12);
				System.out.printf("Amount owing: %.2f\n", balance);
				System.out.printf("Minimum monthly payments: %.2f\n", monthlyPayment);
				break;

			case 4:
				balance = periodicCompound(loan, interestRate, terms, 12);
				monthlyPayment = balance / (terms * 12);
				System.out.printf("Amount owing: %.2f\n", balance);
				System.out.printf("Minimum monthly payments: %.2f\n", monthlyPayment);
				break;
			default:
				System.out.printf("Invalid compoundind period\n");
		}
		
		keyboard.close();
	}
	/**
	 * Calculate the balance on a loan after a given term using the formula
	 * A(t) = A0 * ( 1 + (r / n))^(floor(n * t)), where A is the balance after
	 * the repayment term, A0 is the loan amount, r is the interest rate, n is
	 * the number of compounds in a year, and t is the repayment term in years. 
	 * 
	 * @param loan Amount borrowed
	 * @param interestRate Interest rate on the loan
	 * @param terms Repayment terms in years 
	 * @param compoundPeriods Number of compounds in a term
	 * @return The balance on the loan after the end of the repayment term
	 */
	public static double periodicCompound(double loan, double interestRate, int terms, int compoundPeriods) {
		double result = 0;
		result = loan * Math.pow((1 + ((interestRate / 100.0) / compoundPeriods)), Math.floor(compoundPeriods * terms));
		
		return result;
	}
}
