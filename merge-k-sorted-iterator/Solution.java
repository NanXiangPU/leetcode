import java.util.*;

public class Solution {
	private class IteratorWrapper {
		int next;
		Iterator<Integer> it;
		public IteratorWrapper(Iterator<Integer> it) {
			this.next = (int)it.next();
			this.it = it;
		}
	}
	public List<Integer> mergeKSortedIterator(List<Iterator<Integer>> iterators) {
		List<Integer> res = new ArrayList<>();
		if (iterators == null || iterators.size() == 0) {
			return res;
		}
		PriorityQueue<IteratorWrapper> pq = new PriorityQueue<IteratorWrapper>(new Comparator<IteratorWrapper>() {
			public int compare(IteratorWrapper itw1, IteratorWrapper itw2) {
				return itw1.next - itw2.next;
			}
		});
		for (int i = 0; i < iterators.size(); ++i) {
			if (iterators.get(i).hasNext()) {
				pq.add(new IteratorWrapper(iterators.get(i)));
			}
		}
		while (!pq.isEmpty()) {
			IteratorWrapper itWrapper = pq.poll();
			res.add(itWrapper.next);
			if (itWrapper.it.hasNext()) {
				pq.add(new IteratorWrapper(itWrapper.it));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		List<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(5);
		List<Integer> list4 = new ArrayList<>();
		List<Iterator<Integer>> iterators = new ArrayList<>();
		iterators.add(list1.iterator());
		iterators.add(list2.iterator());
		iterators.add(list3.iterator());
		iterators.add(list4.iterator());
		Solution s = new Solution();
		List<Integer> res = s.mergeKSortedIterator(iterators);
		for (int i = 0; i < res.size(); ++i) {
			System.out.println(res.get(i));
		}
	}
}