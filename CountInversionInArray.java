/* Count the number of inversions in a given array of numbers. A pair (nums[i], nums[j]) is said to form an inversion if nums[i] > nums[j] and i < j.

Example One
{
"nums": [3, 6, 1, 7, 2]
}
Output:

5
The given array has five inversions: (3, 1), (3, 2), (6, 1), (6, 2), and (7, 2). */

import java.util.ArrayList;

public class CountInversionInArray {

    static long count;

    static Long count_inversions(ArrayList<Integer> nums) {
        count = 0;
        mergeSort(nums, 0, nums.size() - 1);
        return count;
    }

    static void mergeSort(ArrayList<Integer> nums, int start, int end) {

        // base condition
        if (start >= end) {
            return;
        }

        // partitioning
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        // merge
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums.get(i) <= nums.get(j)) {
                temp.add(nums.get(i));
                i++;
            } else {
                temp.add(nums.get(j));
                count += (long) (mid - i + 1);
                j++;
            }
        }
        while (i <= mid) {
            temp.add(nums.get(i));
            i++;
        }
        while (j <= end) {
            temp.add(nums.get(j));
            j++;
        }
        i = start;
        for (int num : temp) {
            nums.set(i, num);
            i++;
        }

    }

}