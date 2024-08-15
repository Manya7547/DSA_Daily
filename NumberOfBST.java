public class NumberOfBST {

    static Long how_many_bsts(Integer n) {
        return helper(n);
    }

    static Long helper(int n) {
        if (n == 0L || n == 1L) {
            return 1L;
        }

        long count = 0L;
        // recursive case:
        for (int i = 0; i < n; i++) {
            long left = helper(i);
            long right = helper(n - 1 - i);
            count += left * right;
        }
        return count;
    }
}
