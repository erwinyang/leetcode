package com.leetcode;

import java.util.HashMap;

public class ScrambleString {

	public static void main(String[] args) {
		System.out.println(new ScrambleString().isScramble("abc", "cba"));
	}

    HashMap<String, Boolean> map;
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        map = new HashMap<String, Boolean>();
        return go(s1, s2);
    }
    
    public boolean go(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1 && s1.charAt(0) != s2.charAt(0)) return false;
        
        String key = s1+','+s2;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            boolean result = false;
            if (s1.equals(s2)) {
                result = true;
            } else {
                for (int i=0; i<=s1.length()-2; i++) {
                	String parta = s1.substring(0, i+1);
                	String partb = s1.substring(i+1);
                	
                    if (go(parta, s2.substring(0, parta.length())) && go(partb, s2.substring(parta.length()))) {
                    	result = true; break;
                    }
                    if (go(parta, s2.substring(partb.length())) && go(partb, s2.substring(0, partb.length()))) {
                        result = true; break;
                    }
                }
            }
            map.put(key, result);
            return result;
        }
    }
}
