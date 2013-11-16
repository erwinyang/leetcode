package com.leetcode;

import java.util.*;
import java.lang.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(new TreeNode(1));
	}
	
    Map<Integer, ArrayList<Integer>> map;
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        map = new HashMap<Integer, ArrayList<Integer>>();
        dfs(root, 0);
        int depth = 0;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        while (map.containsKey(depth)) {
            ArrayList<Integer> list = map.get(depth);
            if (depth % 2 == 1) {
                reverse(list);
            }
            results.add(list);
            depth++;
        }
        return results;
    }
    public void dfs(TreeNode node, int depth) {
        if (node == null) return;
        ArrayList<Integer> list = map.get(depth);
        if (list == null) {
            list = new ArrayList<Integer>();
            map.put(depth, list);
        }
        list.add(node.val);
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
    public void reverse(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            Integer tmp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, tmp);
            left++;right--;
        }
    }
}
