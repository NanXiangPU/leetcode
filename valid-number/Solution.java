{
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean containsDigitBeforeE = false;
        boolean containsDigitAfterE = false;
        int decimalIndex = -1;
        int letterIndex = -1;
        int signIndex = -1;
        if (Character.isDigit(s.charAt(0))) {
            containsDigitBeforeE = true;
        } else if(s.charAt(0) == '.') {
            decimalIndex = 0;
        } else {
            if (s.charAt(0) != '+' && s.charAt(0) != '-') {
                return false;
            }
        }
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                if (decimalIndex == -1) {
                    decimalIndex = i;
                } else {
                    return false;   
                }
            } else if (s.charAt(i) == 'e') {
                if (letterIndex == -1) {
                    letterIndex = i;
                } else {
                    return false;
                }
            } else if (Character.isDigit(s.charAt(i))) {
                if (letterIndex == -1) {
                    containsDigitBeforeE = true;
                } else {
                    if (i > letterIndex) {
                        containsDigitAfterE = true;
                    }
                }
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }  
            } else {
                return false;
            }
        }
        if (letterIndex == -1) {
            return containsDigitBeforeE;
        } else {
            if (letterIndex == s.length() - 1 || s.startsWith(".e")) {
                return false;
            } else {
                return containsDigitBeforeE && containsDigitAfterE && decimalIndex < letterIndex;
            }
        }
    }
}