package com.leetcode;

import java.util.*;
import java.lang.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("of_characters_and_as", "aas"));
	}
	
	public static final int CHAR_COUNT = 65536;

    public String minWindow(String S, String T) {
        if (T.length() == 0 || S.length() == 0) return "";
        
        int[] tcount = new int[CHAR_COUNT];
        int[] scount = new int[CHAR_COUNT];
        for (int i=0; i<T.length(); i++) {
            tcount[T.charAt(i)]++;
        }
        int letters = 0;
        for (int i=0; i<CHAR_COUNT; i++) if (tcount[i] > 0) letters++;
        int min = S.length()+1;
        int minl = 0;
        int minr = 0;
        int l = 0;
        int r = 0;
        int matchedLetters = 0;
        while (r < S.length()) {
            // increase r until match
            while (r < S.length()) {
                int v = S.charAt(r++);
                if (tcount[v] > 0) {
                    scount[v]++;
                    if (scount[v] == tcount[v]) {
                        matchedLetters++;
                        if (matchedLetters == letters) {
                            break;
                        }
                    }
                }
            }
            
            // window not found
            if (matchedLetters < letters) {
                break;
            }
            
            // increase l until unmatch
            while (l < r) {
                if (r-l < min) {
                    min = r-l;
                    minl = l;
                    minr = r;
                }
                
                int v = S.charAt(l++);
                if (tcount[v] > 0) {
                    scount[v]--;
                    if (scount[v] == tcount[v] - 1) {
                        matchedLetters--;
                        if (matchedLetters < letters) {
                            break;
                        }
                    }
                }
            }
        }
        
        if (min > S.length()) {
            return "";
        } else {
            return S.substring(minl, minr);
        }
    }
    
}
