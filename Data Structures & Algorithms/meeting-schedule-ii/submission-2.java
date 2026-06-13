/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
               return a.start - b.start;
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(intervals.get(0).end);

        for ( int i =1 ; i < intervals.size()  ; i ++)  {
            Interval current = intervals.get(i);
            if ( current.start >= q.peek()) {
                q.poll();
            }
            q.add(current.end);
        }
        return q.size();

    }
}
