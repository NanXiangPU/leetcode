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
        int readBytes = 0;
        while (!eof && readBytes < n) {
            int currReadBytes = read4(buffer);
            if (currReadBytes != 4) {
                eof = true;
            }
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i = 0; i < length; ++i) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}