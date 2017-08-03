public class Solution {
	public boolean containsDuplicate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] != i) {
				swap(arr[i], i, arr);
			}
		}
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] != i) {
				return true;
			}
		}
		return false;
	}

	public void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {0,1,2,3,5,4};
		System.out.println(s.containsDuplicate(arr));
	}
}