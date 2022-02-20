package exceptions;

@SuppressWarnings("serial")
public class ColaExceededSizeException extends Exception {
	
	public ColaExceededSizeException(String m) {
		super(m);
	}
}
