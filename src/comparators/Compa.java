package comparators;

import java.util.Comparator;

public class Compa implements Comparator<String> {

	@Override
	/**
	 * Compara 2 strings entre si
	 */
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}
