import java.util.ArrayList;
import java.util.Collections;

public class AttendMeetings {

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        // sort the intervals arraylist according to the 1st value of each interval in
        // ascending order
        // if the start time of two intervals are same then sort according to the end
        // time
        // once they are sorted - iterate through the intervals and compare the end time
        // and start tine of adjacent intervals
        Collections.sort(intervals, (a, b) -> {
            if (a.get(0) - b.get(0) == 0)
                return a.get(1) - b.get(1);
            return a.get(0) - b.get(1);
        });

        for (int i = 0; i < intervals.size() - 1; i++) {
            int curr_end = intervals.get(i).get(1);
            int next_start = intervals.get(i + 1).get(0);
            if (curr_end > next_start) {
                return 0;
            }
        }
        return 1;
    }

}
