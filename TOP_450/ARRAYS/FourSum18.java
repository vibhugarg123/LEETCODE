package TOP_450.ARRAYS;

import java.util.*;

/*
    Problem-18:4Sum-https://leetcode.com/problems/4sum/
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.

    Example 1:
    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    Example 2:
    Input: nums = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]
 */
public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, LinkedList<int[]>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = nums[i] + nums[j];
                LinkedList<int[]> ll = hm.getOrDefault(twoSum, new LinkedList<>());
                ll.add(new int[]{i, j});
                hm.put(twoSum, ll);
            }
        }

        hm.forEach((twoSum, pairs) -> {
            if (hm.containsKey(target - twoSum)) {
                for (int[] pair1 : pairs) {
                    LinkedList<int[]> ll = hm.get(target - twoSum);
                    int i = pair1[0];
                    int j = pair1[1];

                    for (int[] pair2 : ll) {
                        int k = pair2[0];
                        int l = pair2[1];

                        if (k > j) {
                            List<Integer> tail = res.isEmpty() ? null : res.get(res.size() - 1);
                            if (null != tail && (tail.get(0) == nums[i] &&
                                    tail.get(1) == nums[j] &&
                                    tail.get(2) == nums[k] &&
                                    tail.get(3) == nums[l])) {
                                continue;
                            }

                            List<Integer> subList = new ArrayList<>();
                            subList.add(nums[i]);
                            subList.add(nums[j]);
                            subList.add(nums[k]);
                            subList.add(nums[l]);
                            res.add(subList);
                        }
                    }
                }
            }
        });
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = new FourSum18().fourSum(nums, target);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}