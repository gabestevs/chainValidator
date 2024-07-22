package validator;

/**
 * Interface that defines the contract for the nodes used in chain validation.
 * 
 * The {@code Node} interface is implemented by different types of nodes such as {@link DigitNode} and {@link WordNode},
 * which represent elements of a chain that can be validated to ensure that all of its dependencies are satisfied.
 */

public interface Node {
	boolean isValidDependency();
}
