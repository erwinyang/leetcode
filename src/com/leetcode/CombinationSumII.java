package com.leetcode;

import java.util.*;
import java.lang.*;

public class CombinationSumII {
	
	public static void main(String[] args) {
		new CombinationSumII().combinationSum2(new int[] { 1, 1 }, 1);
	}

	int[] num;
	int target;

	int[] selected;
	ArrayList<ArrayList<Integer>> results;

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		this.num = num;
		this.target = target;

		this.results = new ArrayList<ArrayList<Integer>>();
		this.selected = new int[num.length];
		dfs(0, 0, 0);
		return results;
	}

    public void dfs(int count, int index, int sum) {
        if (count > 0 && sum == target && !(index < num.length && selected[count-1]==num[index])) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i=0; i<count; i++) {
                result.add(num[selected[i]]);
            }
            results.add(result);
        } else if (sum < target && index < num.length) {
            
            if (!(index > 0 && num[index] == num[index-1] && count > 0 && selected[count-1] == index-1)) {
                dfs(count, index+1, sum);
            }
            
            selected[count]=index;
            dfs(count+1, index+1, sum+num[index]);
            
        }
    }
}
