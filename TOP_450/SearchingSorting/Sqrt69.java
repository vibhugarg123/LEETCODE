package TOP_450.SearchingSorting;

/*
    Problem-69: Sqrt(x)
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    The returned integer should be non-negative as well.

    You must not use any built-in exponent function or operator.
    Example 1:

    Input: x = 4
    Output: 2
    Explanation: The square root of 4 is 2, so we return 2.
    Example 2:

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

    Solution: Binary Search
 */
public class Sqrt69 {

  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    int start = 1;
    int end = x / 2; // The floor of the square root of x cannot be more than x/2 when x > 1).

    int result = 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      // prevent integer overflow
      if (mid <= (x / mid)) {
        // max of all the possible mids that can be output.
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int x = 35;
    System.out.println(new Sqrt69().mySqrt(x));
  }
}
