package com.leetcode;

import java.util.*;
import java.lang.*;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[] { 4,2,2 }));
	}
    public int largestRectangleArea(int[] height) {
    	int result = 0;
    	Stack<Integer> s = new Stack<Integer>();
    	for (int i=0; i<height.length; i++) {
    		if (s.isEmpty() || height[s.peek()] < height[i]) {
    			s.push(i);
    		} else {
    			while (!s.isEmpty() && height[s.peek()] > height[i]) {
    				int h = height[s.pop()];
    				int width = i - (s.isEmpty() ? -1 : s.peek()) - 1;
    				result = Math.max(result, width * h);
    			}
    			s.push(i);
    		}
    	}
    	while (!s.isEmpty() && height[s.peek()] >= 0) {
    		int h = height[s.pop()];
    		int width = height.length - (s.isEmpty() ? -1 : s.peek()) - 1;
    		result = Math.max(result, width * h);
    	}
    	return result;
    }
}
