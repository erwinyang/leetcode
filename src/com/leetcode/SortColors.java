package com.leetcode;

import java.util.*;
import java.lang.*;

public class SortColors {

	public static void main(String[] args) {
		new SortColors().sortColors(new int[] { 0 });
	}
	
    public void sortColors(int[] A) {
        int l = 0;
        int r = A.length-1;
        
        int i=0;
        while (i<=r) {
            boolean swapped = false;
            if (l < i && A[i] == 0) {
                swap(A, l, i);
                l++;
                swapped = true;
            } else if (i < r && A[i] == 2) {
                swap(A, i, r);
                r--;
                swapped = true;
            }
            if (!swapped) {
            	i++;
            }
        }
    }
    
    public void swap(int[] A, int a, int b) {
        int tmp = A[a]; A[a] = A[b]; A[b] = tmp;
    }

}
