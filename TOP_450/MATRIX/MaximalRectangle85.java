package TOP_450.MATRIX;

import java.util.Stack;

/*
    Problem-85: https://leetcode.com/problems/maximal-rectangle/description/

    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
    Example 1:

    Input: matrix = [["1","0","1","0","0"],
                     ["1","0","1","1","1"],
                     ["1","1","1","1","1"],
                     ["1","0","0","1","0"]]

        Time Complexity: O(R x C).
        Only one traversal of the matrix is required, so the time complexity is O(R X C)

        Space Complexity: O(C).
        Stack is required to store the columns, so space complexity is O(C)
    Output: 6
 */
public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int[] heights = new int[nCols];
        int max_area = 0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] = heights[col] + Integer.parseInt(String.valueOf(matrix[row][col]));
                }
            }
            max_area = Math.max(max_area, largestRectangleAreaInHistogram(heights));
        }
        return max_area;
    }

    private int largestRectangleAreaInHistogram(int[] heights) {
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
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(new MaximalRectangle85().maximalRectangle(matrix));
    }
}