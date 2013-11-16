package com.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromePartitioning().partition("aaaaaaaaaaaaaaaaa"));
	}

    ArrayList<ArrayList<String>> results;
    int[] partition;
    String s;
    public ArrayList<ArrayList<String>> partition(String s) {
        results = new ArrayList<ArrayList<String>>();
        partition = new int[s.length()];
        this.s = s;
        go(0, 0);Stack<Integer> a;
        return results;
    }
    
    public void go(int index, int count) {
        if (index == s.length() && count > 0) {
            ArrayList<String> result = new ArrayList<String>();
            for (int i=0; i<count; i++) {
                result.add(s.substring(i==0?0:partition[i-1], partition[i]));
            }
            results.add(result);
        } else {
            for (int i=index+1; i<=s.length(); i++) {
                String prefix = s.substring(index, i);
                if (isPalindrome(prefix)) {
                    partition[count] = i;
                    go(i, count+1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int i=0; i<s.length()/2-1; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
