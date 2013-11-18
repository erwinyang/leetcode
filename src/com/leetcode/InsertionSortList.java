
package com.leetcode;

import java.util.*;
import java.lang.*;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode p = head.next;
		while (p != null) {
			ListNode pnext = p.next;

			ListNode mid = head;
			ListNode prev = null;
			while (mid != null && mid.val < p.val) {
				prev = mid;
				mid = mid.next;
			}

			if (mid == null) {
				prev.next = p;
				p.next = mid;
			} else if (mid == head) {
				p.next = head;
				head = p;
			}

			p = pnext;
		}

		return head;
	}

}
