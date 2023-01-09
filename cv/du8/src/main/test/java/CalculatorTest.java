package du8.src.main.test.java;

import du8.src.main.java.Calculator1;
import du8.src.main.java.Calculator2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void TestSum(){
        Calculator1 calculator1 = new Calculator1();
        Assertions.assertEquals(calculator1.sum(1,2), 3);
        Assertions.assertEquals(calculator1.substract(2,1), 1);
    }
}
