/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        boolean eof = false;
        int count = 0;
        while(!eof) {
            char[] temp = new char[4];
            int curr = read4(temp);
            if (curr < 4) {
                eof = true;
            }
            for (int i = 0; i < curr; i++) {
                buf[count++] = temp[i];
                if (count == n) {
                    return count;
                }
            }
        }
        return count;
    }
}
