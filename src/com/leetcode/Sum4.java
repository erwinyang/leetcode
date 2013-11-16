package com.leetcode;

import java.util.*;
import java.lang.*;

public class Sum4 {

	class Node {
		int value;
		ArrayList<Node> prevs = new ArrayList<Node>();
		
		Node(int value) {
			this.value = value;
		}
		void addPrev(Node p) {
			prevs.add(p);
		}
	}
	
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        HashMap<Integer,char[]> m = new HashMap<Integer, char[]>();
        m.put(2, new char[] {'a', 'b', 'c'});
        
        
        
        
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        
        Object[][] f = new Object[num.length][5];
        
        for (int i=0; i<num.length; i++) {
        	HashMap<Integer, Node> dest = new HashMap<Integer, Node>();
        	dest.put(0, new Node(0));
        	f[i][0] = dest;
        }
        for (int i=0; i<num.length; i++) {
        	for (int j=1; j<=4; j++) {
        		HashMap<Integer, Node> dest = new HashMap<Integer, Node>();
        		for (int k=0; k<i; k++) {
        			HashMap<Integer, Node> src = (HashMap<Integer, Node>) f[k][j-1];
        			
        			for (Integer oldsum : src.keySet()) {
        				Integer newsum = oldsum + num[i];
        				Node destNode = dest.get(newsum);
        				if (destNode == null) {
        					destNode = new Node(num[i]);
        					dest.put(newsum, destNode);
        				}
        				destNode.addPrev(src.get(oldsum));
        			}
        		}
        		f[i][j] = dest;
        	}
        }
        
        for (int i=0; i<num.length; i++) {
        	HashMap<Integer, Node> dest = (HashMap<Integer, Node>) f[i][4];
        	if (dest.containsKey(target)) {
        		buildResults(dest.get(target), 0, new int[4], results, new HashSet<String>());
        	}
        }
        
        return results;
    }
    
    public void buildResults(Node node, int count, int[] currentList, ArrayList<ArrayList<Integer>> results, HashSet<String> used) {
    	if (count == 4) {
    		String sss = "";
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		for (int i=3; i>=0; i--) {
    			result.add(currentList[i]);
    			if (sss.isEmpty()) {
    				sss = "" + currentList[i];
    			} else {
    				sss += "," + currentList[i];
    			}
    		}
    		if (!used.contains(sss)) {
    			results.add(result);
    			used.add(sss);
    		}
    	} else {
    		currentList[count] = node.value;
    		for (Node prev : node.prevs) {
    			buildResults(prev, count+1, currentList, results, used);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[] num = {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
    	System.out.println(new Sum4().fourSum(num, 1057));
    }
    
}

