package com.leetcode;

import java.util.*;
import java.lang.*;

public class Anagrams {
	
	public static void main(String[] args) {
		System.out.println(new Anagrams().anagrams(new String[] { "", "" }));
	}
	
    HashMap<String, ArrayList<String>> h;
    
    public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        h = new HashMap<String, ArrayList<String>>();
        for (int i=0; i<strs.length; i++) {
            String key = getKey(strs[i]);
            ArrayList<String> s = h.get(key);
            if (s == null) {
                s = new ArrayList<String>();
                h.put(key, s);
            }
            s.add(strs[i]);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<String> s : h.values()) {
            if (s.size() > 1) {
                result.addAll(s);
            }
        }
        return result;
    }
    
    public String getKey(String s) {
        char[] cc = new char[s.length()];
        for (int i=0; i<cc.length; i++) cc[i] = s.charAt(i);
        Arrays.sort(cc);
        return new String(cc);
    }
}
