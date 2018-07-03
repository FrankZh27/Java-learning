/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        int duplicates;
        int curr;
        int max = 0;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            duplicates = 0;
            curr = 0;
            Point p1 = points[i];
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int j = i+1; j < n; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    duplicates++;
                }
                else {
                    String key = getSlope(p1, p2);
                    if (!map.containsKey(key)) {
                        map.put(key, 1);
                        curr = Math.max(curr, 1);
                    }
                    else {
                        int temp = map.get(key);
                        map.put(key, ++temp);
                        curr = Math.max(curr, temp);
                    }
                }
            }
            max = Math.max(max, curr+duplicates+1);
        }
        return max;
    }
    private String getSlope(Point p1, Point p2) {
        int dy = p1.y - p2.y;
        int dx = p1.x - p2.x;
        int divisor = gcd(dy, dx);
        dy = dy/divisor;
        dx = dx/divisor;
        return Integer.toString(dy)+"#"+Integer.toString(dx);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
