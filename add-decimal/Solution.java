public class Solution {
	public String[] addDecimal(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new String[0];
		}
		String[] res = new String[strs.length];
		for (int i = 0; i < strs.length; ++i) {
			String str = strs[i];
			String[] parts = str.split("\\+");
			String[] num1 = parts[0].split("\\/");
			String[] num2 = parts[1].split("\\/");
			long up1 = Long.parseLong(num1[0]);
			long down1 = Long.parseLong(num1[1]);
			long up2 = Long.parseLong(num2[0]);
			long down2 = Long.parseLong(num2[1]);

			long down = down1 * down2;
			long up = up1 * down2 + up2 * down1;

			if (up % down == 0) {
				res[i] = up / down + "";
				continue;
			}

			long gcd = GCD(up, down);
			up /= gcd;
			down /= gcd;
			res[i] = up + "/" + down;
		}
		return res;
	}

	public long GCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}

	public static void main(String[] args) {
		String[] strs = {"1/4+2/3", "3/2+1/2", "12/5+15/7", "10000000/7+187/1000000", "7/16+1/16"};
		Solution s = new Solution();
		String[] res = s.addDecimal(strs);
		for(String str : res) {
			System.out.println(str);
		}
	}
}

/*
static String[] reducedFractionSums(String[] expressions) {
        String[] res = new String[expressions.length];
        for (int i = 0; i < expressions.length; ++i) {
            String str = expressions[i];
            String[] parts = str.split("\\+");
            String[] num1 = parts[0].split("\\/");
            String[] num2 = parts[1].split("\\/");
            //a,b,c,d < 2000, integer overflow cannot happen
            int up1 = Integer.parseInt(num1[0]);
            int down1 = Integer.parseInt(num1[1]);
            int up2 = Integer.parseInt(num2[0]);
            int down2 = Integer.parseInt(num2[1]);
            
            int down = down1 * down2;
            int up = up1 * down2 + up2 * down1;
            
            if (up % down == 0) {
                res[i] = up / down + "";
                continue;
            }
            
            int gcd = GCD(up, down);
            up /= gcd;
            down /= gcd;
            res[i] = up + "/" + down;
        }
        return res;
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a%b);
    }

*/