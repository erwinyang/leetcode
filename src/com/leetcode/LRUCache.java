package com.leetcode;

import java.util.*;
import java.lang.*;

public class LRUCache {
	
	public static void main(String args[]) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
	int capacity;
	HashMap<Integer, Node> map;
	Node head;
	Node tail;
	
	class Node {
		Node prev;
		Node next;
		int key;
		int value;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(-1, -1);
        this.tail = head;
    }
    
    public int get(int key) {
    	Node node = map.get(key);
    	if (node == null) {
    		return -1;
    	} else {
    		refresh(node);
    		return node.value;
    	}
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
    		node = new Node(key, value);
    		node.prev = tail;
    		tail.next = node;
    		tail = node;
    		map.put(key, node);
        } else {
        	node.value = value;
        }
        refresh(node);
    	if (map.size() > capacity) {
    		Node delNode = tail;
    		tail = tail.prev;
    		tail.next = null;
    		map.remove(delNode.key);
    	}
    }
    
    public void refresh(Node node) {
    	if (node.next != null) {
    		node.next.prev = node.prev;
    	}
    	node.prev.next = node.next;
    	if (tail == node) {
    		tail = node.prev;
    	}
    	node.prev = head;
    	node.next = head.next;
    	if (head.next != null) head.next.prev = node; // important!
    	head.next = node;
    	if (node.next == null) tail = node; // important!
    }
}
