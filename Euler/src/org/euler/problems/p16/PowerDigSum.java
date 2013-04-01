package org.euler.problems.p16;

import org.apache.commons.lang3.ArrayUtils;


public class PowerDigSum {

	public static void main(String... args) {

		PowerDigSum pds = new PowerDigSum();

		int[] digits = pds.twoToThe(1000);
		
		for(int i: digits)
			System.out.print(i);
		
		int sum = pds.sumDigits(digits);
		System.out.println();
		System.out.println();
		System.out.println(sum);
		
	}
	
	private int sumDigits(int[] digits) {
		int sum = 0;
		for(int i: digits) {
			sum+=i;
		}
		return sum;
	}

	public int[] twoToThe(int power) {
		
		int[] digits = {1};
		int p = 0;
		
		while(p < power) {
			digits = multBy2(digits);
			p++;
		}
		
		ArrayUtils.reverse(digits);
		
		return digits;
	}

	private int[] multBy2(int[] digits) {
		
		boolean carry = false;
		int[] newDigits = digits[digits.length - 1] > 0 ? new int[digits.length + 1] : new int[digits.length];
		
		for(int i = 0; i < digits.length; i++) {
			newDigits[i] = digits[i]*2;
			if(carry) newDigits[i]++;
			if (newDigits[i] > 9) {
				carry = true;
				newDigits[i]-=10;
			} else
				carry = false;
		}
		if(carry) newDigits[newDigits.length - 1]++;
		return newDigits;
	}

}
