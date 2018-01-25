/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int sz = intervals.size();
        
        Collections.sort(intervals, new IntComparator());
        
        for (int i = sz-1; i > 0; i--){
            if (intervals.get(i-1).start <= intervals.get(i).start){
                if (intervals.get(i-1).end < intervals.get(i).start){
                    continue;
                }
                else {
                    intervals.get(i-1).end = 
                        intervals.get(i-1).end > intervals.get(i).end ?
                        intervals.get(i-1).end : intervals.get(i).end;
                    intervals.remove(i);
                }
            }
            else {
                if (intervals.get(i).end < intervals.get(i-1).start){
                    continue;
                }
                else {
                    intervals.get(i).end =
                        intervals.get(i).end > intervals.get(i-1).end ?
                        intervals.get(i).end : intervals.get(i-1).end;
                    intervals.remove(i-1);
                }
            }
        }
        return intervals;
    }
    private class IntComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            int ae = a.end;
            int be = b.end;
            return ae-be;
        }
    }
}
