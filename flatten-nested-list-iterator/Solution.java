/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    //recursive
    Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(nestedList, list);
        this.it = list.iterator();
    }
    
    public void helper(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger ni : nestedList) {
            if (ni == null) {
                continue;
            } else if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                List<NestedInteger> niList = ni.getList();
                if (niList.size() == 0) {
                    continue;
                }
                helper(niList, list);
            }
        }
    }

    @Override
    public Integer next() {
        if (it.hasNext()) {
            return it.next();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    //iterative
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            if (nestedList.get(i) == null) {
                continue;
            }
            if (!nestedList.get(i).isInteger() && nestedList.get(i).getList().size() == 0) {
                continue;
            }
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return -1;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) {
                return true;
            } else {
                ni = stack.pop();
                List<NestedInteger> list = ni.getList();
                for (int i = list.size() - 1; i >= 0; --i) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}