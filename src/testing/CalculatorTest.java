package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    int multiply(int a, int b) {
        return a * b;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testMultiplication(int a, int b, int expected) {
        assertEquals(expected, multiply(a, b));
    }
    
    int add(int a, int b) {
        return a + b;
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "4, 5, 9",
        "10, 20, 30"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, add(a, b));
    }
}

