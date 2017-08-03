public class StringIterator {
    private int p;
    private int num;
    private String str;
    private char ch;
    public StringIterator(String compressedString) {
        this.str = compressedString;
        this.p = 0;
        this.num = 0;
        this.ch = ' ';
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            ch = str.charAt(p++);
            while (p < str.length() && Character.isDigit(str.charAt(p))) {
                num = num * 10 + str.charAt(p++) - '0';
            }
        }
        num--;
        return ch;
    }
    
    public boolean hasNext() {
        return p < str.length() || num != 0;
    }
}