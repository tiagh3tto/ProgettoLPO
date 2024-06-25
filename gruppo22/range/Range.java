package gruppo22.range;

import java.util.Objects;

public class Range implements Iterable<Integer> {
	public final int start, end;

	public Range(int a, int b) {
		start = a;
		end = b;
	}

	@Override
	public RangeIterator iterator() {
		return new RangeIterator(start, end);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Range))
			return false;
		Range r = (Range) obj;

		/* o hanno gli stessi estremi o sono entrambi vuoti */
		return (start == r.start && end == r.end) || (start == end && r.start == r.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

}
