//执行用时 :68 ms, 在所有 Java 提交中击败了99.40%的用户
//内存消耗 :35.8 MB, 在所有 Java 提交中击败了65.79%的用户
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> mIterator;
    Integer tempNext;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.mIterator = iterator;
        this.tempNext = mIterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return tempNext;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int res = tempNext;
        if(mIterator.hasNext()) tempNext = mIterator.next();
	    else tempNext = null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return tempNext!=null;
	}
}