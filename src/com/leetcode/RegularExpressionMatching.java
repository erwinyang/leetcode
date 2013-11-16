package com.leetcode;

public class RegularExpressionMatching {
	
	public static boolean isMatch(String s, String p) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean[][] isMatch = new boolean[s.length() + 1][p.length() + 1];

		isMatch[0][0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '.') {
					isMatch[i][j] = isMatch[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					isMatch[i][j] = isMatch[i][j-2];
					char c = p.charAt(j - 2);
					int index = i-1;
					while (index >= 0 && s.charAt(index) == c) {
						isMatch[i][j] = isMatch[i][j] || isMatch[index][j - 2];
						index--;
					}
				} else {
					isMatch[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && isMatch[i - 1][j - 1];
				}
			}
		}
		return isMatch[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
	}
}
