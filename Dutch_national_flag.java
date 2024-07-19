// Given some balls of three colors arranged in a line, rearrange them such that all the red 
// balls go first, then green and then blue ones.

import java.util.ArrayList;

public class Dutch_national_flag {

    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        int i = 0;
        int j = balls.size() - 1;

        int current = 0;

        while (current <= j) {
            if (balls.get(current) == 'R') {
                swap(i, current, balls);
                current++;
                i++;
            } else if (balls.get(current) == 'B') {
                swap(j, current, balls);
                j--;
            } else {
                current++;
            }
        }
        return balls;
    }

    static void swap(int i, int j, ArrayList<Character> balls) {
        char temp = balls.get(i);
        balls.set(i, balls.get(j));
        balls.set(j, temp);
    }

}
