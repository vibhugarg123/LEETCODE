package MATRIX;

import java.util.ArrayList;
import java.util.List;


/*
[Problem-54]
Given an m x n matrix, return all elements of the matrix in spiral order.

Approach 1: Set Up Boundaries
Use 4 pointers, [left, right, top, bottom] & direction variable to track which direction we are currently moving in.
        left      right
 top    1  2  3   4
        5  6  7   8
        9  10 11 12
 bottom 13 14 15 16

 Time Complexity: O(MN)
 Space Complexity: O(1)
 */
class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int dir = 0;
        while (left <= right && top <= bottom) {
            //dir=0; moving from left to right
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            }
            //dir=1; moving from top to bottom
            else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }
            //dir=2; moving from right to left
            else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //dir=3; moving from bottom to top
            else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            //Changing direction , after moving one spiral, again same direction
            dir = (dir + 1) % 4;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix54 spiralMatrix54 = new SpiralMatrix54();
        List<Integer> list = spiralMatrix54.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        System.out.println(list.toString());
    }
}