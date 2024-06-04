package TOP_450.SearchingSorting;

import java.util.Arrays;

/*
    Problem: https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
    You are given a read-only array of N integers with values also in the range
     [1, N] both inclusive.
     Each integer appears exactly once except A which appears twice and B which is missing.
     The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

    Example 1:
    Input Format:  array[] = {3,1,2,5,3}
    Result : {3,4)
    Explanation: A = 3 , B = 4
    Since 3 is appearing twice and 4 is missing

    Solution:
    1. Mathematical Approach
    2. Bitwise Approach

    Time Complexity: O(N), where N = the size of the given array.
    Reason: We are just using some loops running for N times. So, the time complexity will be approximately O(N).

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
 */
public class FindRepeatingAndMissing {

  int[] findTwoElementMathBasedApproach(int[] A, int n) {
    long Sn = (n * ((long) n + 1)) / 2; // Sum of 1st n natural numbers
    long S2n = (n * (n + 1) * (2L * n + 1)) / 6;// Sum of squares of 1st n natural numbers
    long S = 0;  // Sum of elements in Array A
    long S2 = 0; // Sum of squares of elements in Array A
    for (int i = 0; i < A.length; i++) {
      S += A[i];
      S2 += (long) A[i] * (long) A[i];
    }
    // Let X is repeating
    // Let Y is missing

    // S-Sn= (1+3+3)-(1+2+3)=(3-2) , i.e X-Y=1
    long XMinusY = (S - Sn);
    // S2-S2n= (1^2+ 3^2 + 3^2)-(1^2+ 2^2 + 3^2) , i.e X^2-Y^2=5
    // X^2-Y^2=5
    // (X-Y)(X+Y)=5 -> X+Y= (S2-S2n)/(X-Y)
    long XPlusY = ((S2 - S2n) / (XMinusY));

    long x = (XMinusY + XPlusY) / 2; // Add
    long y = (XPlusY - x);// X+Y= 5 , Y= 5-X= 5-3=2
    return new int[]{(int) x, (int) y};
  }

  int[] findTwoElementXORBasedApproach(int[] A, int n) {
    int XOR = 0;
    int XOR_N = 0;
    for (int i = 0; i < A.length; i++) {
      XOR = XOR ^ A[i];
      XOR_N = XOR_N ^ (i + 1);
    }
    int xXORy = XOR ^ XOR_N;

    int bitNumber = 0;
    while (true) {
      if ((xXORy & (1 << bitNumber)) != 0) {
        break;
      }
      bitNumber++;
    }

    int zeroClub = 0;
    int oneClub = 0;
    for (int i = 0; i < A.length; i++) {
      if ((A[i] & (1 << bitNumber)) != 0) {
        oneClub = oneClub ^ A[i];
      } else {
        zeroClub = zeroClub ^ A[i];
      }

      if (((i + 1) & (1 << bitNumber)) != 0) {
        oneClub = oneClub ^ (i + 1);
      } else {
        zeroClub = zeroClub ^ (i + 1);
      }
    }

    int cnt = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == zeroClub) {
        cnt++;
      }
    }
    if (cnt == 2) {
      return new int[]{zeroClub, oneClub};
    }
    return new int[]{oneClub, zeroClub};
  }

  public static void main(String[] args) {

    int[] A = {2, 2};
    int[] res = new FindRepeatingAndMissing().findTwoElementMathBasedApproach(A, A.length);
    System.out.println(Arrays.toString(res));

    int[] res2 = new FindRepeatingAndMissing().findTwoElementXORBasedApproach(A, A.length);
    System.out.println(Arrays.toString(res2));
  }
}