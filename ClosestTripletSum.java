/* Given a target number and a list of numbers, find a triplet of numbers from the list such that sum of that triplet is the closest to the target. Return that sum.

Example One
{
"target": 9,
"numbers": [2, 8, 3, 2]
}
Output:

7
 */

import java.util.ArrayList;
import java.util.Collections;

public class ClosestTripletSum {

    static Integer find_closest_triplet_sum(Integer target, ArrayList<Integer> numbers) {

        Collections.sort(numbers);
        int closestTriplet = numbers.get(0) + numbers.get(1) + numbers.get(2);
        for (int i = 0; i < numbers.size() - 2; i++) {
            int right = numbers.size() - 1;
            int left = i + 1;
            while (left < right) {
                int curr = numbers.get(i) + numbers.get(left) + numbers.get(right);
                if (Math.abs(curr - target) < Math.abs(closestTriplet - target)) {
                    closestTriplet = curr;
                }

                if (curr < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestTriplet;
    }

}
