package com.leetcode;

import java.util.ArrayList;

public class Concatenation {

	public static void main(String[] args) {
		System.out.println(new Concatenation().findSubstring("a", new String[] { "a", "a"}));
	}

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        int len = 0;
        for (int i=0; i<L.length; i++) {
            len += L[i].length();
        }
        
        for (int i=0; i<S.length()-len+1; i++) {
            
            boolean isMatch = true;
            boolean[] used = new boolean[L.length];
            int p = i;
            for (int times=0; times<L.length; times++) {
                int index = -1;
                for (int j=0; j<L.length; j++) {
                    if (!used[j] && L[j].equals(S.substring(p, p+L[j].length()))) {
                        p+=L[j].length();
                        used[j] = true;
                        index = j;
                        break;
                    }
                }
                if (index==-1) {
                    isMatch=false;
                    break;
                }
            }
            
            if (isMatch) {
                results.add(i);
            }
            
        }
        return results;
    }
}
