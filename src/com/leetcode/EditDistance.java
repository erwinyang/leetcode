package com.leetcode;

import java.util.*;
import java.lang.*;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("ab", "bc"));
	}
	
    public int minDistance(String word1, String word2) {
        // f[i][j] = min(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1)
        // 
        if (word1.length() < word2.length()) {
            String tmp = word1; word1 = word2; word2 = tmp;
        }
        
        int[] a = new int[word2.length()+1];
        int[] b = new int[word2.length()+1];
        for (int i=0; i<=word2.length(); i++) a[i] = i;
        for (int i=1; i<=word1.length(); i++) {
            b[0] = i;
            for (int j=1; j<=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    b[j] = a[j-1];
                } else {
                    b[j] = min(a[j], b[j-1], a[j-1]) + 1;
                }
            }
            int[] t = a;
            a = b;
            b = t;
        }
        return a[word2.length()];
    }
    
    public int min(int a, int b, int c) {
        int m = a;
        if (b < m) m = b;
        if (c < m) m = c;
        return m;
    }

}
