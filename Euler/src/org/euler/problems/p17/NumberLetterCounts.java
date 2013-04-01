package org.euler.problems.p17;

public class NumberLetterCounts {

	static int[] lenOnesTeens = { 0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 
			3, 6, 6, 8, 8, 7, 7,9, 8, 8 };
	static int[] lenTens = { 0, 0, 6, 6, 5, 5, 5, 7, 6, 6 };

	static int countLength(int n) {
		if (n < 20)
			return lenOnesTeens[n];
		else if (n < 100)
			return lenTens[n / 10] + countLength(n % 10);
		else if (n < 1000)
			return lenOnesTeens[n / 100] + 7 + (n % 100 > 0 ? 3 + countLength(n % 100) : 0);
		else
			return lenOnesTeens[n / 1000] + 8 + 
					(n % 1000 > 0 ? (n % 1000 > 100 ? countLength(n % 1000): 3 + countLength(n % 1000)) : 0);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 1; i <= 1000; i++)
			sum += countLength(i);
		long end = System.currentTimeMillis();
		System.out.println(sum + " in " + (end - start) + "ms");
	}

}
