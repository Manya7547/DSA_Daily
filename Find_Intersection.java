import java.util.ArrayList;

public class Find_Intersection {

    static ArrayList<Integer> find_intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2,
            ArrayList<Integer> arr3) {
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int a = arr1.get(i);
            int b = arr2.get(j);
            int c = arr3.get(k);

            if (a == b && b == c)
                ans.add(a);

            // find the minimum of the three and increment it
            int mini = Math.min(a, b);
            mini = Math.min(mini, c);

            if (mini == a)
                i++;
            if (mini == b)
                j++;
            if (mini == c)
                k++;
        }

        if (ans.size() == 0)
            ans.add(-1);
        return ans;
    }

}
