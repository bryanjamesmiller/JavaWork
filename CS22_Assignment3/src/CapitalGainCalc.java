/*
 * CapitalGainCalc.java
 *
 * Computer Science E-22
 * Modified by: <Bryan Miller>, <bmiller100wpm@gmail.com>
 */

import java.util.*;

/**
 * A class for calculating capital gains on stock sales.
 */
public class CapitalGainCalc {
	/* 
	 * An inner class for storing information about a stock purchase.
	 */
	private class Purchase {
		private int numShares;
		private int price;

		Purchase(int numShares, int price) {
			this.numShares = numShares;
			this.price = price;
		}
	}

	/* Put your fields/instance variables below. */
	private static int totalShares = 0;
	 
	LLQueue<Purchase> myQ = new LLQueue<Purchase>();

	public CapitalGainCalc() {
		/* Put your implementation of the constructor below. */
		
	}

	public void processPurchase(int numShares, int price) {
		/* Put your implementation of this method below. */
		
		Purchase onePurchase = new Purchase(numShares, price);
		totalShares += numShares;
		
		myQ.insert(onePurchase);
	}

	public int processSale(int numSharesToSell, int price) {
		/* Replace the line below with your implementation of this method. */

		if(numSharesToSell > totalShares)
			throw new IllegalArgumentException("You do not have that many shares available to sell");

		int salesDiff = 0;
		int totalGains = 0;

		while(numSharesToSell > 0)
		{
			int priceInOneNode = myQ.peek().price;
			int numSharesInOneNode = myQ.peek().numShares;
			
			if(numSharesToSell < numSharesInOneNode)
			{
				salesDiff = numSharesToSell * priceInOneNode;
				totalGains += numSharesToSell * price - salesDiff;
				myQ.peek().numShares = (numSharesInOneNode - numSharesToSell);
			}
			else if(numSharesToSell == numSharesInOneNode)
			{
				salesDiff = numSharesInOneNode * priceInOneNode;
				totalGains += numSharesToSell * price - salesDiff;
				myQ.remove();
			}
			else
			{			
				salesDiff = numSharesInOneNode * priceInOneNode;
				totalGains += numSharesInOneNode * price - salesDiff;
				myQ.remove();
			}
			totalShares -= numSharesToSell;
			numSharesToSell -= numSharesInOneNode;	
		}

		return totalGains;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CapitalGainCalc calc = new CapitalGainCalc();
		int totalGain = 0;
		int gain = 0;

		while (true) {
			// Get the choice of operation.
			System.out.print("\n(1) purchase, (2) sale, or (3) done: ");
			int choice = scan.nextInt();
			if (choice == 3)
				break;
			if (choice != 1 && choice != 2) {
				System.err.println("Please enter 1, 2, or 3.");
				continue;
			} 

			// Get the number of shares and the price.
			System.out.print("number of shares: ");
			int numShares = scan.nextInt();
			System.out.print("price: ");
			int price = scan.nextInt();
			if (numShares <= 0 || price <= 0) {
				System.err.println("Please enter positive numbers.");
				continue;
			}

			if (choice == 1)
				calc.processPurchase(numShares, price);
			else {
				try {
					gain = calc.processSale(numShares, price);
					System.out.println("Capital gain on sale: $" + gain);
					totalGain += gain;
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			}
		}               

		System.out.println("Total capital gain: $" + totalGain);
	}
}
