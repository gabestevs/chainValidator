# chainValidator
 
## Overview
This Java project validates lists of digits and words, ensuring that all multi-character dependencies are satisfied by the individual characters present in the list.

## Functionality

### ChainValidator
This class contains the static method `validate`, which validates a list of nodes (`Node`) ensuring that all dependencies are satisfied.

#### Methods:
- `public static boolean validate(List<Node> nodes)`: Validates a list of `Node` objects to ensure all multi-character dependencies are satisfied by the individual characters present in the list.

### Node
An interface representing a generic node. It defines the method `isValidDependency`.

#### Methods:
- `boolean isValidDependency()`: Checks if the node represents a valid dependency. For example, single-digit numbers and single-character words are considered valid dependencies.

### DigitNode
This class implements the `Node` interface to represent digit nodes.

#### Methods:
- `public DigitNode(int value)`: Constructor that initializes the digit node with a given value.
- `public int getValue()`: Returns the value of the digit node.
- `public boolean isValidDependency()`: Checks if the digit node represents a valid dependency (i.e., if it is a single-digit number).
- `public static DigitNode fromString(String str)`: Creates a `DigitNode` from a string.
- `public static boolean isDigitNode(String str)`: Checks if a string can be represented as a `DigitNode`.

### WordNode
This class implements the `Node` interface to represent word nodes.

#### Methods:
- `public WordNode(String value)`: Constructor that initializes the word node with a given value.
- `public String getValue()`: Returns the value of the word node.
- `public boolean isValidDependency()`: Checks if the word node represents a valid dependency (i.e., if it is a single-character word).
- `public static WordNode fromString(String str)`: Creates a `WordNode` from a string.
- `public static boolean isWordNode(String str)`: Checks if a string can be represented as a `WordNode`.
- `public Set<Character> getDependencies()`: Returns a set of characters that the word node depends on.

### ChainValidatorTest
This class contains unit tests to verify the functionality of the `ChainValidator` class.

#### Test Methods:
- `public void testValidDigitChain()`: Tests a valid chain of digit nodes.
- `public void testInvalidDigitChain()`: Tests an invalid chain of digit nodes.
- `public void testValidWordChain()`: Tests a valid chain of word nodes.
- `public void testInvalidWordChain()`: Tests an invalid chain of word nodes.
- `public void testMixedInvalidChain()`: Tests a mixed chain of digit and word nodes, which should be invalid.
- `public void testWordChainWithUppercaseLetters()`: Tests a chain with uppercase letters, which should be invalid and throw an exception.

## How to Run
Compile and run the tests with Maven:
```sh
mvn clean compile test
