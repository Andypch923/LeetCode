import java.util.*;

public class solutions {
	
	//LeetCode Question #1
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> diff = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int diffNow = target - nums[i];
			if (diff.containsKey(diffNow)) {
				int[] results = { diff.get(diffNow), i };
				return results;
			}
			diff.put(nums[i], i);
		}
		return null;
	}
	
	//LeetCode Question #9
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		if (x == 0) {
			return true;
		}

		StringBuilder numString = new StringBuilder();
		numString.append(x);
		long reverseNum = Long.parseLong(numString.reverse().toString());
		if (x == reverseNum) {
			return true;
		}
		return false;
	}
	
	//LeetCode Question #206
	/**
	 * Definition for singly-linked list. public class ListNode {
	 * 
	 * }
	 */
	private class ListNode {
		public int val;
		public ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	ListNode newHead;

	public ListNode reverseList(ListNode p) {
		if (p == null) {
			return newHead;
		}
		ListNode temp = new ListNode(p.val);
		temp.next = newHead;
		newHead = temp;
		return reverseList(p.next);
	}

}
