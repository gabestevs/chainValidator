package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class responsible for validating node chains.
 * 
 * Validation ensures that each multi-character or number node in a list has its dependencies
 * satisfied by unique character nodes or numbers present in the list.
 */

public class ChainValidator {
	
	/**
     * Validates a list of nodes to ensure that all multi-character dependencies are satisfied
     * by single characters or numbers in the list.
     * 
     * The method checks whether:
     * - Every two-digit number has both digits (ones and tens) present in the node list.
     * - Each word or string of characters has all the required unique characters present in the node list.
     * 
     * @param nodes List of nodes to be validated. May contain instances of {@link DigitNode} and {@link WordNode}.
     * @return true if the node chain is valid, i.e. if all dependencies are satisfied, false otherwise.
     */
	
	public static boolean validate(List<Node> nodes) {
		Set<Integer> digitSet = new HashSet<>();
		Set<Character> charSet = new HashSet<>();

		for (Node node : nodes) {
			if (node instanceof DigitNode) {
				DigitNode digitNode = (DigitNode) node;
				if (digitNode.isValidDependency()) {
					digitSet.add(digitNode.getValue());
				}
			} else if (node instanceof WordNode) {
				WordNode wordNode = (WordNode) node;
				if (wordNode.isValidDependency()) {
					charSet.add(wordNode.getValue().charAt(0));
				}
			}
		}

		for (Node node : nodes) {
			if (node instanceof DigitNode) {
				DigitNode digitNode = (DigitNode) node;
				if (!digitNode.isValidDependency()) {
					int tens = digitNode.getValue() / 10;
					int units = digitNode.getValue() % 10;
					if (!digitSet.contains(tens) || !digitSet.contains(units)) {
						return false;
					}
				}
			} else if (node instanceof WordNode) {
				WordNode wordNode = (WordNode) node;
				if (!wordNode.isValidDependency()) {
					for (char c : wordNode.getDependencies()) {
						if (!charSet.contains(c)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
