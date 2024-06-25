package gruppo22.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

class RangeIterator implements Iterator<Integer> {
	private int current;
	private final int end;
	private final boolean reversed;

	RangeIterator(int start, int end) {
		current = start;
		this.end = end;
		reversed = start > end;
	}

	@Override
	public boolean hasNext() {
		return current != end;
	}

	@Override
	public Integer next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (reversed)
			return current--;
		return current++;
	}
}
