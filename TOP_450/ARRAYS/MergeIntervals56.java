package TOP_450.ARRAYS;

import java.util.Arrays;
import java.util.LinkedList;

/*
    Problem-56: https://leetcode.com/problems/merge-intervals/
         Given an array of intervals where intervals[i] = [ start[i], end[i] ],
         merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

        Example 1:

        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        Example 2:

        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

        Time complexity :  O(nlogn)
        Space complexity : O(logN) or O(n)

        If we can sort intervals in place, we do not need more than constant additional space,
        although the sorting itself takes O(log n) space.
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        //Though not required, by default it sorts in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            // disjoint end of one interval < start of other interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                // end of merged  {v1,v2}, {v3,v4}= Math.max{v2,v4}
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};

        int[][] merged = new MergeIntervals56().merge(intervals);
        for (int i = 0; i < merged.length; i++) {
            System.out.println(merged[i][0] + " " + merged[i][1]);
        }
    }
}