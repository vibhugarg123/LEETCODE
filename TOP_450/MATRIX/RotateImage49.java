package TOP_450.MATRIX;

/*
Problem-49
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]


Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


Example 3:

Input: matrix = [[1]]
Output: [[1]]


Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]

Algorithm-1:
1 2 3
4 5 6
7 8 9
o/p
7  4  1
8  5  2
9  6  3

Observe: 1st row-> last column [0th row] -> N-1
         2nd row-> 2nd second last column [1st row] -> [1st column]
         3rd row-> 1st column  [2nd row]-> [2nd column]
Consider the four corners, every N*N is formed by N-1 *N-1, if we solve the outer matrix N*N, we can repeatedly solve for N-1 *N-1
Left, Right, Top, Bottom
Left=0, Right=N-1
Top=0, Bottom=N-1

Cover outer boundary with Left, Right, Top & Bottom
[0,0]-> [0,2] top left -> top right
[0,2]-> [2,2] top right -> bottom right
[2,2]-> [2,0] bottom right -> bottom left
[2,0]-> [0,0] bottom left -> top left
Since, we need to save every replaced variable , hence we can do it in reverse also.
Save top left:
    - top left -> bottom left
    - bottom left-> bottom right
    -> bottom right-> top right
    -> top right-> top left

Update the pointers, left =left +1; right= right-1;
                     top= top+1;   bottom=bottom-1;


Time Complexity: O(N*N)
Space Complexity: O(1)

Approach-2 : Rotate= Transpose the Matrix -> Reverse all the rows
 */

import java.util.Arrays;

class RotateImage49 {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {

            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;
                //Adding i to move to proper layered matrix element, move one step right left-> left+i
                int topLeft = matrix[top][left + i];

                //move upward using bottom-i
                matrix[top][left + i] = matrix[bottom - i][left];

                //move left using right-i
                matrix[bottom - i][left] = matrix[bottom][right - i];

                //move downward using top+i
                matrix[bottom][right - i] = matrix[top + i][right];

                //move right
                matrix[top + i][right] = topLeft;
            }

            left = left + 1;
            right = right - 1;
        }
    }

    public static void main(String[] args) {
        RotateImage49 r = new RotateImage49();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        r.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}