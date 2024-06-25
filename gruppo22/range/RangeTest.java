package gruppo22.range;

public class RangeTest {
	public static void main(String[] args) {
		var r1 = new Range(0, 0);
		var r2 = new Range(3, 3);
		var r3 = new Range(0, 3);
		var r4 = new Range(1, 4);
		var r5 = new Range(3, 0);

		assert r1.equals(r2);
		assert !r3.equals(r4);
		assert !r3.equals(r5);

		for (Integer i : r3)
			System.out.println(i);
		System.out.println("");
		for (Integer i : r5)
			System.out.println(i);

	}
}