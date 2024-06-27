import dataModel.Polynomial;
import logic.Operations;

import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertEquals;


public class OpTest {
    @Test
    public void addTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(3, 2.0);
        p1.addMonomial(2, 1.0);
        p1.addMonomial(0, 4.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomial(1, 2.0);
        p2.addMonomial(0, 3.0);

        Polynomial res = new Polynomial();
        res = Operations.add(p1, p2);
        assertEquals("7.0+2.0x^1+x^2+2.0x^3", res.toString());
    }

    @Test
    public void subtractTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(3, 2.0);
        p1.addMonomial(2, 1.0);
        p1.addMonomial(0, 4.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomial(1, 2.0);
        p2.addMonomial(0, 3.0);

        Polynomial res = new Polynomial();
        res = Operations.subtract(p1, p2);
        assertEquals("1.0-2.0x^1+x^2+2.0x^3", res.toString());
    }
    @Test
    public void multiplyTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(3, 2.0);
        p1.addMonomial(2, 1.0);
        p1.addMonomial(0, 4.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomial(1, 2.0);
        p2.addMonomial(0, 3.0);

        Polynomial res = new Polynomial();
        res = Operations.multiply(p1, p2);
        assertEquals("12.0+8.0x^1+3.0x^2+8.0x^3+4.0x^4", res.toString());
    }
    @Test
    public void derivateTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(3, 2.0);
        p1.addMonomial(2, 1.0);
        p1.addMonomial(0, 4.0);

        Polynomial res = new Polynomial();
        res = Operations.derivate(p1);
        assertEquals("2.0x^1+6.0x^2", res.toString());
    }
    @Test
    public void integralTest() {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(3, 2.0);
        p1.addMonomial(2, 1.0);
        p1.addMonomial(0, 4.0);

        Polynomial res = new Polynomial();
        res = Operations.integral(p1);
        assertEquals("4.0x^1+0.3333333333333333x^3+0.5x^4", res.toString());
    }
}
