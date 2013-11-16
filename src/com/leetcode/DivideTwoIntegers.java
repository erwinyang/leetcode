package com.leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DivideTwoIntegers().divide(1, 1));
	}
	
    public int divide(int dividend, int divisor) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        long dividendl = dividend;
        long divisorl = divisor;
        
        boolean negative = dividendl < 0 ^ divisorl < 0;
        // don't use int: -(-2147483648) cause overflow!
        if (dividendl < 0) dividendl = -dividendl;
        if (divisorl < 0) divisorl = -divisorl;
        
        // forbid * / %
        int count = 0;
        while (divisorl <= dividendl) {
            long s = dividendl;
            long n = divisorl;
            int c = 1;
            while (n+n <= s) {
                n += n;
                c += c;
            }
            count += c;
            dividend -= n;
        }
        if (negative) {
            count = -count;
        }
        return count;
    }

}
