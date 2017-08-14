/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0) {
            return 0;
        }
        char[] buffer = new char[4];
        boolean eof = false;
        int count = 0;
        while (count < n && !eof) {
            int size = read4(buffer);
            if (size < 4) {
                eof = true;
            }
            size = Math.min(size, n - count);
            for (int i = 0; i < size; ++i) {
                buf[count++] = buffer[i];
            }
        }
        return count;
    }
}