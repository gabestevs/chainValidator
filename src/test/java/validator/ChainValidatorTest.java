package validator;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link ChainValidator} class.
 * 
 * The {@code ChainValidatorTest} class contains tests that verify the functionality of validating chains of nodes, including
 * both digit nodes and word nodes. Uses the JUnit framework to ensure that the class behavior
 * {@code ChainValidator} is correct and that the validation logic is implemented as expected.
 */

public class ChainValidatorTest {
	@Test
    public void testValidDigitChain() {
        assertTrue(ChainValidator.validate(Arrays.asList(
            DigitNode.fromString("36"), DigitNode.fromString("6"), DigitNode.fromString("24"),
            DigitNode.fromString("4"), DigitNode.fromString("47"), DigitNode.fromString("7"),
            DigitNode.fromString("2"), DigitNode.fromString("3"), DigitNode.fromString("27")
        )));
    }

    @Test
    public void testInvalidDigitChain() {
        // 2 is missing, so the chain is invalid
        assertFalse(ChainValidator.validate(Arrays.asList(
            DigitNode.fromString("35"), DigitNode.fromString("5"), DigitNode.fromString("65"),
            DigitNode.fromString("6"), DigitNode.fromString("24"), DigitNode.fromString("4")
        )));
    }

    @Test
    public void testValidWordChain() {
        assertTrue(ChainValidator.validate(Arrays.asList(
            WordNode.fromString("p"), WordNode.fromString("aba"), WordNode.fromString("a"),
            WordNode.fromString("b"), WordNode.fromString("perso"), WordNode.fromString("o"),
            WordNode.fromString("r"), WordNode.fromString("e"), WordNode.fromString("s")
        )));
    }

    @Test
    public void testInvalidWordChain() {
        // "a" is missing, so the chain is invalid
        assertFalse(ChainValidator.validate(Arrays.asList(
            WordNode.fromString("p"), WordNode.fromString("aba"), WordNode.fromString("b"),
            WordNode.fromString("perso"), WordNode.fromString("o"), WordNode.fromString("r"),
            WordNode.fromString("e"), WordNode.fromString("s")
        )));
    }

    @Test
    public void testMixedInvalidChain() {
        // Mixed types of nodes should result in an invalid chain
        assertFalse(ChainValidator.validate(Arrays.asList(
            DigitNode.fromString("5"), WordNode.fromString("a"), WordNode.fromString("asd")
        )));
    }
    
    /**
     * Tests a string of word nodes containing uppercase letters, which should throw an exception.
     * 
     * Checks whether creating a {@code WordNode} with an uppercase letter results in an {@link IllegalArgumentException} exception.
     * Additionally, checks whether a string containing uppercase letters is correctly identified as invalid.
     */
    
    @Test
    public void testWordChainWithUppercaseLetters() {
        // Should throw IllegalArgumentException due to invalid uppercase letter
        assertThrows(IllegalArgumentException.class, () -> {
            WordNode.fromString("A");
        });
        
        // Should be invalid due to uppercase letter in the chain
        assertFalse(ChainValidator.validate(Arrays.asList(
            WordNode.fromString("a"), WordNode.fromString("B"), WordNode.fromString("c")
        )));
    }
}