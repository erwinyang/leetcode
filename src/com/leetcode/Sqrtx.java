package com.leetcode;

import java.util.*;
import java.lang.*;
	import java.math.BigInteger;

public class Sqrtx {

	public static void main(String[] args) {
		System.out.println(new Sqrtx().sqrt(1));
	}
	
    public int sqrt(int x) {
    	BigInteger target = BigInteger.valueOf(x);
    	BigInteger l = BigInteger.valueOf(0);
    	BigInteger r = BigInteger.valueOf(x/2+1);
        while (l.compareTo(r)<0) {
        	BigInteger v = l.add(BigInteger.ONE).add(r).divide(BigInteger.valueOf(2));
        	BigInteger vv = v.multiply(v);
            if (vv.equals(target)) {
                return v.intValue();
            } else if (vv.compareTo(target) < 0) {
                l = v;
            } else if (vv.compareTo(target) > 0) {
                r = v.subtract(BigInteger.ONE);
            }
        }
        return r.intValue();
    }

}
