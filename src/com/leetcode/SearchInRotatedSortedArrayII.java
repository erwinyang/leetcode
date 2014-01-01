package com.leetcode;

import java.util.*;
import java.lang.*;

public class SearchInRotatedSortedArrayII {

	int[] A;
	int target;
	
	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArrayII().search(new int[] { 2, 3, 3, 0, 1, 1, 2 }, 2));
	}
	
    public boolean search(int[] A, int target) {
        this.A = A;
        this.target = target;
        int pivot = findPivot(0, A.length-1);
        if (pivot == -1) {
        	return binarySearch(0, A.length-1);
        } else {
        	return binarySearch(0, pivot) || binarySearch(pivot+1, A.length-1);
        }
    }
    
    public int findPivot(int l, int r) {
    	if (l > r) return -1;
    	
    	if (A[l] == A[r]) {
    		int mid = (l + r) / 2;
    		if (mid+1 < A.length && A[mid] > A[mid+1]) {
    			return mid;
    		} else {
    			int pivot = findPivot(l, mid-1);
    			if (pivot == -1) {
    				pivot = findPivot(mid+1, r);
    			}
    			return pivot;
    		}
    	} else if (A[l] < A[r]) {
    		return r+1<A.length && A[r] > A[r+1] ? r : -1;
    	} else {
    		int mid = (l + r) / 2;
    		if (mid+1 < A.length && A[mid] > A[mid+1]) {
    			return mid;
    		} else if (A[mid] >= A[l]) {
    			return findPivot(mid+1, r);
    		} else {
    			return findPivot(l, mid-1);
    		}
    	}
    }
    
	public boolean binarySearch(int l, int r) {
		if (l > r) return false;
		int mid = (l + r) / 2;
		if (A[mid] == target) {
			return true;
		} else if (A[mid] < target) {
			return binarySearch(mid + 1, r);
		} else {
			return binarySearch(l, mid - 1);
		}
	}
}
