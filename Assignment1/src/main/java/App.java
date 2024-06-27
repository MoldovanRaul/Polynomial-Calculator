import dataModel.Polynomial;
import gui.GUI;
import logic.Operations;

public class App extends Operations {
    public static void main( String[] args ) {
        Polynomial p1 = new Polynomial();
        p1.addMonomial(5,4);
        p1.addMonomial(4,-3);
        p1.addMonomial(2,1);
        p1.addMonomial(1,-8);
        p1.addMonomial(0,1);

        System.out.println(p1);

        Polynomial p2 = new Polynomial();
        p2.addMonomial(4,3);
        p2.addMonomial(3,-1);
        p2.addMonomial(2,1);
        p2.addMonomial(1,2);
        p2.addMonomial(0,-1);

        System.out.println(p2);

        Polynomial res = new Polynomial();

        System.out.println("ADD");
        res = add(p1, p2);
        System.out.println(res);

        System.out.println("SUB");
        res = subtract(p1, p2);
        System.out.println(res);

        Polynomial p3 = new Polynomial();
        p3.addMonomial(2,3);
        p3.addMonomial(1,-1);
        p3.addMonomial(0,1);

        Polynomial p4 = new Polynomial();
        p4.addMonomial(1,1);
        p4.addMonomial(0,-2);

        System.out.println("MUL");
        res = multiply(p3, p4);
        System.out.println(res);

        Polynomial p5 = new Polynomial();
        p5.addMonomial(3,1);
        p5.addMonomial(2,-2);
        p5.addMonomial(1,6);
        p5.addMonomial(0,-5);

        System.out.println("DER");
        res = derivate(p5);
        System.out.println(res);

        Polynomial p6 = new Polynomial();
        p6.addMonomial(3,1);
        p6.addMonomial(2,4);
        p6.addMonomial(0,5);

        System.out.println("INT");
        res = integral(p6);
        System.out.println(res);

        System.out.println("REGEX");
        Polynomial p = new Polynomial();
        Polynomial pp = new Polynomial();
        p.fromString("4x^5-3x^4+x^2-8x+1");
        System.out.println(p);
        pp.fromString("3x^4-x^3+x^2+2x-1");
        System.out.println(pp);
        res = subtract(p,pp);
        System.out.println();
        System.out.println(res);

        GUI display = new GUI();
    }
}
