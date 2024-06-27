package logic;

import dataModel.Polynomial;
import java.util.Map;

public class Operations{
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> monomial : p1.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            result.addMonomial(deg, coef);
        }
        for (Map.Entry<Integer, Double> monomial : p2.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            result.addMonomial(deg, coef);
        }
        return result;
    }
    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> monomial : p1.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            result.addMonomial(deg, coef);
        }
        for (Map.Entry<Integer, Double> monomial : p2.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            result.subtractMonomial(deg, coef);
        }
        return result;
    }
    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> monomial1 : p1.getPolynomial().entrySet()) {
            int deg1 = monomial1.getKey();
            double coef1 = monomial1.getValue();
            for (Map.Entry<Integer, Double> monomial2 : p2.getPolynomial().entrySet()) {
                int deg2 = monomial2.getKey();
                double coef2 = monomial2.getValue();
                int newDeg = deg1 + deg2;
                double newCoef = coef1 * coef2;
                result.addMonomial(newDeg, newCoef);
            }
        }
        return result;
    }
    public static Polynomial derivate(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> monomial : p.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            if(deg > 0) {
                coef *= deg;
                result.addMonomial(deg-1, coef);
            }
        }
        return result;
    }
    public static Polynomial integral(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> monomial : p.getPolynomial().entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            double integralCoef = coef / (deg + 1);
            result.addMonomial(deg + 1, integralCoef);
        }
        return result;
    }
}
