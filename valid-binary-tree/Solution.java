import java.util.*;

public class Solution {
	public boolean isValid(int[][] input) {
		return !hasCircle(input);
	}

	public boolean hasCircle(int[][] input) {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> greySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		for (int i = 0; i < input.length; ++i) {
			whiteSet.add(i);
		}
		while (!whiteSet.isEmpty()) {
			Integer node = whiteSet.iterator().next();
			if (dfs(input, node, whiteSet, greySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	public boolean dfs(int[][] input, Integer node, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet) {
		moveToSet(node, whiteSet, greySet);
		for (int i = 0; i < 2; ++i) {
			if (input[node][i] == -1 || blackSet.contains(input[node][i])) {
				continue;
			}
			if (greySet.contains(input[node][i])) {
				return true;
			}
			if (dfs(input, (Integer)input[node][i], whiteSet, greySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	public void moveToSet(Integer node, Set<Integer> preSet, Set<Integer> destSet) {
		preSet.remove(node);
		destSet.add(node);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input = {{1,2,},{3,4},{5,-1},{-1,-1},{-1,-1},{-1,-1}};
		System.out.println(s.isValid(input));
	}
}