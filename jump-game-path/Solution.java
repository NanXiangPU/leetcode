import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Solution {
	public String printPath(int[] nums) {
		StringBuilder sb = new StringBuilder();
		int start = 0, end = 0;
		while (end < nums.length) {
			int maxEnd = Integer.MIN_VALUE;
			int step = -1;
			for(; start <= end; ++start) {
				if (start + nums[start] > maxEnd) {
					step = start;
					maxEnd = start + nums[start];
				}
			}
			sb.append(step + " ");
			end = maxEnd;
			if (end >= nums.length) {
				return sb.toString();
			}
			if (end < start) {
				return "FAILURE";
			}
		}
		return "FAILURE";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array:");
		int size = 0;
		try {
			size = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Invalid input");
			return;
		}
		int[] array = new int[size];
		for (int i = 0; i < size; ++i) {
			int value = 0;
			try {
				value = Integer.parseInt(scanner.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Invalid input");
				return;
			}
			array[i] = value;
		}
		Solution s = new Solution();
		String res = s.printPath(array);
		System.out.println(res);
	}
}