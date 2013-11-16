package com.leetcode;

public class RomanToInteger {
    public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[][] d = new char[][] { {'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'}, { 'M', '?', '?'} };
        int[][] dv = new int[][] { {1, 5, 10}, {10, 50, 100}, {100, 500, 1000}, { 1000, 5000, 10000 } };
        int result = 0;
        int index = 0;
        int dIndex = 3;
        while (index < s.length() && dIndex>=0) {
            int endIndex = index;
            while (endIndex<s.length() && (s.charAt(endIndex)==d[dIndex][0] || s.charAt(endIndex)==d[dIndex][1] || s.charAt(endIndex)==d[dIndex][2])) {
                endIndex++;
            }
            
            if (index<endIndex) {
                result += convert(s.substring(index, endIndex), d[dIndex], dv[dIndex]);
            }
            
            dIndex--;
            index = endIndex;
        }
        return result;
    }
    
    public int convert(String s, char[] digits, int[] dv) {
        int result = 0;
        int index = 0;
        while (index<s.length() && s.charAt(index)==digits[0]) {
            result += dv[0];
            index++;
        }
        if (result > 0) {
            if (index<s.length()) {
                if (s.charAt(index)==digits[1]) {
                    return dv[1]-result;
                } else if (s.charAt(index)==digits[2]) {
                    return dv[2]-result;
                }
            } else {
                return result;
            }
        } else {
            if (index<s.length() && s.charAt(index)==digits[1]) {
                index++;
                result += dv[1];
                while (index<s.length() && s.charAt(index)==digits[0]) {
                    result += dv[0];
                    index++;
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MMCCCVII"));
	}
}
