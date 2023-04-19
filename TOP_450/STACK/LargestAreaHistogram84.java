package TOP_450.STACK;

import java.util.Stack;

/*
    Problem-84: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    Given an array representing histogram.
    Goal: Find the largest area formed in histogram.
    Constraint: 1. Width of each bar is 1 unit.
                2. All bar heights are non-negative.


 */
public class LargestAreaHistogram84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] leftBarSmallerThanCurrentBar = new int[heights.length];

        for (int currentBar = 0; currentBar < heights.length; currentBar++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[currentBar]) {
                st.pop();
            }

            if (st.isEmpty()) leftBarSmallerThanCurrentBar[currentBar] = 0;
            else if (heights[st.peek()] < heights[currentBar]) leftBarSmallerThanCurrentBar[currentBar] = st.peek() + 1;

            st.push(currentBar);
        }

        st.clear();
        int[] rightBarSmallerThanCurrentBar = new int[heights.length];
        for (int currentBar = heights.length - 1; currentBar >= 0; currentBar--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[currentBar]) {
                st.pop();
            }

            if (st.isEmpty()) rightBarSmallerThanCurrentBar[currentBar] = heights.length - 1;
            else if (heights[st.peek()] < heights[currentBar])
                rightBarSmallerThanCurrentBar[currentBar] = st.peek() - 1;

            st.push(currentBar);
        }

        int max_area = 0;
        for (int currentBar = 0; currentBar < heights.length; currentBar++) {
            int width = (rightBarSmallerThanCurrentBar[currentBar] - leftBarSmallerThanCurrentBar[currentBar] + 1);
            max_area = Math.max(max_area, heights[currentBar] * width);
        }

        return max_area;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestAreaHistogram84().largestRectangleArea(heights));
    }
}
