import java.util.*;

public class Solution {
	private class Num {
		int from;
		int index;
		int val;
		public Num(int from, int index, int val) {
			this.from = from;
			this.index = index;
			this.val = val;
		}
		public Num(int val) {
			this.val = val;
		}
	}

	private class Result {
		int start;
		int end;
		int distance;
	}

	public Result minRange(int[][] array) {
		Result r = new Result();
		r.distance = Integer.MAX_VALUE;
		if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
			return r;
		}
		int m = array.length, n = array[0].length;
		PriorityQueue<Num> pq = new PriorityQueue<Num>(new Comparator<Num>(){
			public int compare(Num a, Num b) {
				return a.val - b.val;
			}
		});
		Num[][] numbers = new Num[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				numbers[i][j] = new Num(i, j, array[i][j]);
			}
		}
		Num min = new Num(Integer.MAX_VALUE);
		Num max = new Num(Integer.MIN_VALUE);
		for (int i = 0; i < m; ++i) {
			pq.add(numbers[i][0]);
			if (numbers[i][0].val > max.val) {
				max = numbers[i][0];
			}
		}
		while(true) {
			min = pq.poll();
			if (max.val - min.val < r.distance) {
				r.distance = max.val - min.val;
				r.start = array[min.from][min.index];
				r.end = array[max.from][max.index]; 
			}
			int from = min.from, index = min.index;
			if (min.index == array[from].length - 1) {
				break;
			}
			pq.add(numbers[from][index + 1]);
			if (numbers[from][index + 1].val > max.val) {
				max = numbers[from][index + 1];
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] array = {{4,10,15,24},{0,9,12,20},{5,18,22,30}};
		Result r = s.minRange(array);
		System.out.println(r.start);
		System.out.println(r.end);
		System.out.println(r.distance);
	}
}