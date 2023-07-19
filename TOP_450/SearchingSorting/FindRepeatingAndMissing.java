package TOP_450.SearchingSorting;

import java.util.Arrays;

public class FindRepeatingAndMissing {
    int[] findTwoElement(int[] A, int n) {
        int[] res = new int[2];
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                res[0] = A[i];
            }
            if (A[i] - A[i - 1] > 1) {
                res[1] = A[i] - A[i - 1];
            }
        }
        if (res[1] == 0) {
            res[1] = 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 3, 3};
        int[] res = new FindRepeatingAndMissing().findTwoElement(A, A.length);
        System.out.println(Arrays.toString(res));
    }
}