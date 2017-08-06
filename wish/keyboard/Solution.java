/*
 * Complete the function below.
 */

    static int entryTime(String s, String keypad) {
        int[][] mapping = new int[10][10];
        int[][] keys = new int[3][3];
        int count = 0;
        int time = 0;
        //keys
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                keys[i][j] = keypad.charAt(count++) - '0';
            }
        }
        
        //mapping
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int num1 = keys[i][j];
                mapping[num1][num1] = 0;
                for (int m = 0; m < 3; ++m) {
                    for (int n = 0; n < 3; ++n) {
                        int num2 = keys[m][n];
                        if (num1 == num2) {
                            continue;
                        } else {
                            int distance = (m - i) * (m - i) + (n - j) * (n - j);
                            if (distance <= 2) {
                                mapping[num1][num2] = 1;
                            } else {
                                mapping[num1][num2] = 2;
                            }
                        }
                    }
                }
            }
        }
        
        //calculate result
        for (int i = 1; i < s.length(); ++i) {
            int pre = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            time += mapping[pre][curr];
        }
        return time;
    }

