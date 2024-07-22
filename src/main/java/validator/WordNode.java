package validator;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code WordNode} class implements the {@link Node} interface and provides logic for checking and managing words
 * or single characters made up of lowercase letters. Each instance of this class represents a single word value.
 */

public class WordNode implements Node {
    private final String value;
    
    /**
     * Constructs a new word node with the specified value..
     * 
     * The value must be a word composed only of lowercase letters. If the value provided does not meet this criteria,
     * an exception will be thrown. {@link IllegalArgumentException}.
     * 
     * @param value The word value for the node. Must be a string made up of lowercase letters only.
     * @throws IllegalArgumentException if the value is not a valid word, consisting only of lowercase letters.
     */

    public WordNode(String value) {
        if (!isWordNode(value)) {
            throw new IllegalArgumentException("Invalid word node: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean isValidDependency() {
        return value.length() == 1 && value.matches("[a-z]");
    }

    public static WordNode fromString(String str) {
        return new WordNode(str);
    }

    public static boolean isWordNode(String str) {
        return str.matches("[a-z]+");
    }
    
    /**
     * Gets the node's dependencies.
     * 
     * For words, dependencies are the unique characters present in the word.
     * This is useful for checking whether all multi-character dependencies are present on other nodes.
     * 
     * @return A set of characters that are the dependencies of the node.
     */
    
    public Set<Character> getDependencies() {
        Set<Character> dependencies = new HashSet<>();
        for (char c : value.toCharArray()) {
            dependencies.add(c);
        }
        return dependencies;
    }
}
