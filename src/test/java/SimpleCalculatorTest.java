import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void TwoPlusTwoShouldFour(){
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4,calculator.addNumbers(2,2));
        assertTrue(calculator.addNumbers(2,2)==4);
    }

}