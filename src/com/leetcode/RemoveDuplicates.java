package com.leetcode;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 2}));
	}
	
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index = 1;
        for (int i=1; i<A.length; i++) {
            if (A[i]!=A[i-1]) {
                A[index++]=A[i];
            }
        }
        return index;
    }

}
