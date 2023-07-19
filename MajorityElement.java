/*
[Problem-169]
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

/* Approach : Boyer-Moore Voting Algorithm: 
Boyer-Moore does is look for a suffix suf of nums where suf[0] is the majority element in that suffix. To do this, we maintain a count, 
which is incremented whenever we see an instance of our current candidate for majority element and 
decremented whenever we see anything else. Whenever count equals 0, 
we effectively forget about everything in nums up to the current index and consider the current number as the candidate for majority element. 
Time Complexity: O(N), Space : O(1)
*/

public class MajorityElement {
    public int majorityElement(int[] arr) {
        int candidate = -1;
        int counter = 0;
        for (int num : arr) {
            if (counter == 0) {
                candidate = num;
            }
            counter += (num == candidate) ? 1 : -1;
        }
        return (counter == 0) ? -1 : candidate;
    }

    boolean pairTrue(int[] A, int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            if ((A[i] & A[i + 1]) == 0)
                continue;
            else {
                return false;
            }
        }
        return true;
    }

    public int longestSubarray(int[] A, int N) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = i + 1; j <= A.length - 1; j++) {
                if (pairTrue(A, i, j) && j - i + 1 > largest) {
                    largest = j - i + 1;
                }
            }
        }
        return largest;
    }


    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        //System.out.println(me.majorityElement(new int[]{3, 3, 1, 2}));
        int[] A = {1,2,3};
        System.out.println(me.longestSubarray(A, A.length));
//        me.Y();
    }
}