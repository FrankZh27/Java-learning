class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder(0);
        sb.append(A);
        if (A.length() >= B.length()){
            if (A.contains(B)) return count;
            else {
                sb.append(A);
                count = sb.toString().contains(B) ? 2:-1;
                return count;
            }
        }
        else {
            while (sb.length() < B.length()){
                sb.append(A);count++;
            }
            if (sb.toString().contains(B)) return count;
            sb.append(A);
            count++;
            if (sb.toString().contains(B)) return count;
            return -1;
        }
    }
}
