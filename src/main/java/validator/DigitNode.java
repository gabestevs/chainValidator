package validator;

/**
 * The {@code DigitNode} class implements the {@link Node} interface and provides the logic to check and manage one- or two-digit
 * integers. Each instance of this class represents a single numeric value.
 */

public class DigitNode implements Node {
	private final int value;

	/**
     * Constructs a new digit node with the specified value.
     * 
     * The value must be an integer between 0 and 99. If the value provided is not within this range,
     * you must ensure that the value is within the limits defined in the program logic.
     * 
     * @param value The numeric value for the node. Must be an integer between 0 and 99.
     */
	
	public DigitNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean isValidDependency() {
		return value < 10;
	}

	public static DigitNode fromString(String str) {
		return new DigitNode(Integer.parseInt(str));
	}

	/**
     * Checks whether a string is a valid digit node.
     * 
     * A valid digit node is an integer between 0 and 99.
     * 
     * @param str The string to be checked.
     * @return true if the string represents an integer between 0 and 99, false otherwise.
     */
	
	public static boolean isDigitNode(String str) {
		try {
			int val = Integer.parseInt(str);
			return val >= 0 && val <= 99;

		} catch (NumberFormatException e) {
			return false;
		}
	}
}
