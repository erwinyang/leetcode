
package com.leetcode;

import java.util.*;
import java.lang.*;

public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}

		return sort(head, len);
	}

	public ListNode sort(ListNode p, int len) {
		if (len == 1) {
			return p;
		}
		ListNode a = p;
		ListNode b = p;
		ListNode atail = null;
		for (int i = 0; i < len / 2; i++) {
			atail = b;
			b = b.next;
		}
		atail.next = null;

		a = sort(a, len / 2); // don't forget renew a&b
		b = sort(b, len - len / 2);

		ListNode head = null;
		ListNode c = null;
		while (a != null && b != null) {
			ListNode chosen = null;
			if (a.val < b.val) {
				chosen = a;
				a = a.next;
			} else {
				chosen = b;
				b = b.next;
			}
			chosen.next = null;
			if (head == null) {
				head = c = chosen;
			} else {
				c.next = chosen;
				c = chosen;
			}
		}
		while (a != null) {
			c.next = a;
			c = a;
			a = a.next;
		}
		if (b != null) {
			c.next = b;
		}

		return head;
	}

}
