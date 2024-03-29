import java.util.*;

/*
[Problem-56] Given an array of intervals where intervals[i] = [ start [i],end [i] ],
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Time complexity : O(nlogn)
Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the complexity of sorting.
*/
class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        //Though not required, by default it sorts in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 4},
                {4, 5},
                {8, 10},
                {15, 18},
        };
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        int[][] result = mergeIntervals56.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}