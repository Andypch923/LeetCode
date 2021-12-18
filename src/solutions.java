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
	
	//LeetCode Question #2
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        return addTwo(l1,l2,0);
	    }
	    
	    private ListNode addTwo(ListNode l1, ListNode l2, int remainder){
	        int temp = 0;
	        if (l1 != null && l2 != null){
	            temp = l1.val + l2.val + remainder;
	            remainder = 0;
	            if (temp >= 10){
	                temp -= 10;
	                remainder = 1;
	            }
	            return new ListNode(temp, addTwo(l1.next,l2.next,remainder));  
	        }else if (l1 != null && l2 == null){
	            temp = l1.val + remainder;
	            remainder = 0;
	            if (temp >= 10){
	                temp -= 10;
	                remainder = 1;
	            }
	            return new ListNode(temp, addTwo(l1.next,null,remainder));   
	        }else if (l1 == null && l2 != null){
	            temp = l2.val + remainder;
	            remainder = 0;
	            if (temp >= 10){
	                temp -= 10;
	                remainder = 1;
	            }
	            return new ListNode(temp, addTwo(l2.next,null,remainder));
	        }else if (l1 == null && l2 == null && remainder == 1){
	            return new ListNode(1, addTwo(null,null,0));
	        }
	        
	        return null;    
	    }
	    
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
