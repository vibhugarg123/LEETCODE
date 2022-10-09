package TOP_450.ARRAYS;

/*
    Problem-4: https://leetcode.com/problems/median-of-two-sorted-arrays/
         Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

        The overall run time complexity should be O(log (m+n)).

        Example 1:

        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.
        Example 2:

        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

        Solution: https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46

        Time Complexity: O(min(log m, log n)): Since binary search is being applied on the smallest of the 2 arrays
        Auxiliary Space: O(1)
 */
public class MedianOfTwoSortedArrays4 {
    public int GetLeftHalfLength(int l1, int l2) {
        /*
            if l1 + l2 is odd, then left half contains  (l1+l2+1)/2, eg for l1+l2=11, left half contains 6 elements.
            if l1 + l2 is even, then left half contains (l1+l2+1)/2  eg for l1+l2=12, left half contains 6 elements.
         */
        return (l1 + l2 + 1) / 2;
    }

    private boolean IsOdd(int x) {
        return (x & 1) == 1;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        // Swapping to make A smaller
        if (A.length > B.length)
            return findMedianSortedArrays(B, A);

        int leftHalfLen = GetLeftHalfLength(A.length, B.length);
        /*
           aMinCount and aMaxCount are the min and max number of values A can contribute to the left half of A ∪ B, respectively.
           Since A is guaranteed to be either shorter or of the same length as B, we know it can contribute
           0 or all of its values to the left half of A ∪ B.
         */
        int aMinCount = 0;
        int aMaxCount = A.length;

        while (aMinCount <= aMaxCount) {
            // Assuming A contributed mid number of elements to the left half of A ∪ B.
            // B will contribute Total Number of Elements in Left Half-Number of Elements contributed by A
            int aCount = aMinCount + ((aMaxCount - aMinCount) / 2);
            int bCount = leftHalfLen - aCount;

            // maxElementA can be null if A is not contributing any values to the left half of A ∪ B.
            // e.g. A = [10, 11], B = [3, 4]
            //  ⟹ left half = [3, 4], aCount = 0, bCount = 2.
            int maxElementA = (aCount > 0) ? A[aCount - 1] : Integer.MIN_VALUE;

            // maxElementB can be null if B is not contributing any values to the left half of A ∪ B.
            // e.g. A = [3, 4], B = [10, 11]
            //  ⟹ left half = [3, 4], aCount = 2, bCount = 0.
            int maxElementB = (bCount > 0) ? B[bCount - 1] : Integer.MIN_VALUE;

            // nextElementOfA can be null if A is contributing all of its values to the left half of A ∪ B.
            //  i.e. aCount = A.Length.
            // e.g. A = [3, 4], B = [10, 11]
            //  ⟹ left half = [3, 4], aCount = 2, bCount = 0.
            int nextElementOfA = (aCount < A.length) ? A[aCount] : Integer.MAX_VALUE;

            // nextElementOfB can be null if B is contributing all of its values to the left half of A ∪ B.
            // i.e. bCount = B.Length.
            // e.g. A = [10, 11], B = [3, 4]
            //  ⟹ left half = [3, 4], aCount = 0, bCount = 2.
            int nextElementOfB = (bCount < B.length) ? B[bCount] : Integer.MAX_VALUE;

            if (maxElementA > nextElementOfB) {
                aMaxCount = aCount - 1;
            } else if (maxElementB > nextElementOfA) {
                // y lies in the right half.
                aMinCount = aCount + 1;
            } else {
                int leftHalfEnd = Math.max(maxElementA, maxElementB);

                if (IsOdd(A.length + B.length)) {
                    return leftHalfEnd;
                } else {
                    int rightHalfStart = Math.min(nextElementOfA, nextElementOfB);
                    return (leftHalfEnd + rightHalfStart) / 2.0;
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] A = {};
        int[] B = {1};
        System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(A, B));
    }
}