package com.leetcode;

import java.util.*;
import java.lang.*;

public class WildcardMatchingDp {

	public static void main(String[] args) {
		String s = "aa";
		String p = "a";
		new WildcardMatchingDp().isMatch2(s, p);
	}
	
    // f[pattern][string]
    // f[0][j] = (j=0) true
    //           (j>0) false
    // f[i][0] = cp=='*' && f[i-1][0]
    // f[i][j] = (cp=='*') f[i-1][j] || f[i][j-1]    i.e. (f[i-1][0] || f[i-1][1] || ... || f[i-1][j] == f[i-1][j])
    //           (cp=='?') f[i-1][j-1]
    //           (cp=='c') cp==cs && f[i-1][j-1]
	
    String s;
    String p;
    HashMap<String, Boolean> m;
    
    public boolean isMatch2(String s, String p) {
        this.s = s;
        this.p = p;
        m = new HashMap<String, Boolean>();
        return f(p.length(), s.length());
    }
	
    public boolean f(int i, int j) {
        String key = i + "," + j;
        Boolean result = m.get(key);
        if (result == null) {
            if (i==0) {
                result = j==0;
            } else if (j==0) {
                result = p.charAt(i-1)=='*' && f(i-1, 0);
            } else {
                char cp = p.charAt(i-1);
                if (cp=='*') {
                    result = f(i-1, j) || f(i, j-1);
                } else if (cp=='?') {
                    result = f(i-1, j-1);
                } else {
                    result = cp==s.charAt(j-1) && f(i-1, j-1);
                }
            }
            
            m.put(key, result);
        }
        return result;
    }

    public boolean isMatch(String s, String p) {
        boolean[] a = new boolean[s.length()+1];
        boolean[] b = new boolean[s.length()+1];
        a[0] = true;
        for (int j=1; j<=s.length(); j++) a[j] = false;
        
        for (int i=1; i<=p.length(); i++) {
            char cp = p.charAt(i-1);
            b[0] = cp=='*' && a[0];
            for (int j=1; j<=s.length(); j++) {
                if (cp=='*') {
                    b[j] = a[j] || b[j-1];
                } else if (cp=='?') {
                    b[j] = a[j-1];
                } else {
                    b[j] = cp==s.charAt(j-1) && a[j-1];
                }
                
            }
            a = b;
        }
        return a[s.length()];
    }
    
}
