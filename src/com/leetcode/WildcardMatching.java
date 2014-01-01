package com.leetcode;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class WildcardMatching {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("wildcard_input.txt")));
		String s = br.readLine();
		String p = br.readLine();
		System.out.println(s.length() + ", " + p.length());
		br.close();
		
		WildcardMatching r = new WildcardMatching();
		System.out.println(r.isMatch(s, p));
	}
	
    public boolean isMatch(String s, String p) {
    	
    	int[] nextStar = new int[p.length()];
    	int next = -1;
    	for (int i=nextStar.length-1; i>=0; i--) {
    		nextStar[i] = next;
    		if (p.charAt(i) == '*') next = i;
    	}
    	
    	boolean afterStar = false;
    	int ps = 0;
    	int pp = 0;
    	while (ps < s.length() && pp < p.length()) {
    		if (p.charAt(pp) == '*') {
    			
    			pp++;
    			while (pp < p.length() && p.charAt(pp) == '*') {
    				pp++;
    			}
    			afterStar = true;
    			
    		} else {
    			
    			int nextps = isNonStarMatch(s, p, ps, pp, nextStar);
    			if (nextps == -1) {
    				if (afterStar) {
    					ps++;
    				} else {
    					return false;
    				}
    			} else {
    				pp += (nextps-ps);
    				ps = nextps;
    			}
    			
    		}
    		
    	}
    	
    	if (afterStar) { while (ps < s.length()) { ps++; } }
    	while (pp < p.length() && p.charAt(pp) == '*') { pp++; }
    	return ps == s.length() && pp == p.length();
    	
    }
    
    public int isNonStarMatch(String s, String p, int ps, int pp, int[] nextStar) {
    	int next = nextStar[pp];
    	if (next == - 1) {
    		int lens = s.length() - ps;
    		int lenp = p.length() - pp;
    		return lens == lenp && equals(s, p, ps, pp, lenp) ? s.length() : -1;
    	} else {
    		int lens = s.length() - ps;
    		int lenp = next - pp;
    		return lens >= lenp && equals(s, p, ps, pp, lenp) ? ps + lenp : -1;
    	}
    }
    
    public boolean equals(String s, String p, int indexS, int indexP, int len) {
    	for (int i=0; i<len; i++) {
    		if (p.charAt(indexP+i) != '?' && p.charAt(indexP+i) != s.charAt(indexS+i)) {
    			return false;
    		}
    	}
    	return true;
    }
}
