package com.leetcode;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArray().search(new int[] { 5, 1, 3 }, 5));
	}

    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) return -1;
        
        int p = findPivotIndex(A);
        int result = find(A, 0, p, target);
        if (result == -1 && p+1<=A.length-1) {
            result = find(A, p+1, A.length-1, target);
        }
        return result;
    }
    
    public int findPivotIndex(int[] A) {
        int l = 0;
        int r = A.length-1;
        while(l<r) {
            if (A[l] <= A[r]) {
                return r;
            } else {
                int mid = (l+r)/2;
                if (A[l] <= A[mid]) {
                	l = mid;
                	r = r-1;
                } else {
                	r = mid-1;
                }
            }
        }
        return l;
    }
    
    public int find(int[] A, int l, int r, int value) {
        while (l<=r) {
            int mid = (l+r)/2;
            if (value == A[mid]) {
                return mid;
            } else if (A[mid] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    
}
