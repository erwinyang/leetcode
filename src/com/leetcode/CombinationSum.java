package com.leetcode;

import java.util.*;
import java.lang.*;

public class CombinationSum {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> results = new CombinationSum().combinationSum2(new int[] { 9,29,23,15,34,9,34,25,23,18,8,30,27,33,9,26,17,20,25,33,20,6,20,26,25,25,34,27,27,11,8,32,27,26,12,27,30,33,9,10,16,5,27,30,25,31,21,7,17,11,27,32,34,12,15,25,32,6,9,25,34 }, 28);
		for (ArrayList<Integer> result : results) {
			for (Integer v : result) {
				System.out.print(v + ", ");
			}
			
			System.out.println();
		}
	}
	
    int[] num;
    int target;
    
    Stack<Integer> st;
    ArrayList<ArrayList<Integer>> results;
    
    int[] sss;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        this.sss = new int[num.length];
        sss[num.length-1] = num[num.length-1];
        for (int i=num.length-2; i>=0; i--) {
            sss[i] = num[i] + sss[i+1];
        }
        
        unicheck = new HashSet<String>();
        
        this.num = num;
        this.target = target;
        
        this.st = new Stack<Integer>();
        this.results = new ArrayList<ArrayList<Integer>>();
        dfs(0, 0);
        return results;
    }
    
    HashSet<String> unicheck;
    
    public void dfs(int index, int sum) {
        if (sum > target) return;
        
        if (sum == target) {
            StringBuilder key = new StringBuilder();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i=0; i<st.size(); i++) {
                result.add(st.get(i));
                key.append(st.get(i));
                key.append(',');
            }
            String keystr = key.toString();
            if (!unicheck.contains(keystr)) {
                results.add(result);
                unicheck.add(keystr);
            }
        } else {
            if (index >= num.length) return;
            
            if (index+1 < num.length && sss[index+1] >= target-sum) dfs(index+1, sum);
            st.push(num[index]);
            if (index+1 < num.length && sss[index+1] >= target-sum-num[index]) dfs(index+1, sum+num[index]);
            st.pop();
        }
    }

}
