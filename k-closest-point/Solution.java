import java.util.*;

public class Solution {
	public int[][] kClosestPoints(int[][] points, int[] point, int k) {
		int[][] res = new int[k][2];
		if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
			return points;
		}
		if (point == null || point.length == 0) {
			return res;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (b[0] - point[0]) * (b[0] - point[0]) + (b[1] - point[1]) * (b[1] - point[1]) - (a[0] - point[0]) * (a[0] - point[0]) - (a[1] - point[1]) * (a[1] - point[1]);
			}
		});
		for (int i = 0; i < points.length; ++i) {
			int[] p = points[i];
			pq.offer(p);
			System.out.println("insert: (" + p[0] + "," + p[1] + ")");
			if (pq.size() > k) {
				int[] pop = pq.poll();
				System.out.println("poll: (" + pop[0] + "," + pop[1] + ")");
			}
		}
		for (int i = 0; i < k; ++i) {
			res[i] = pq.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] points = {{0,0}, {0,1}, {1,0}, {1,1}, {1,2}, {0,2}};
		int[] point = {2,0};
		int k = 3;
		int[][] res = s.kClosestPoints(points, point, k);
		for (int i = 0; i < res.length; ++i) {
			System.out.println("(" + res[i][0] + "," + res[i][1] + ")");
		}
	}
}