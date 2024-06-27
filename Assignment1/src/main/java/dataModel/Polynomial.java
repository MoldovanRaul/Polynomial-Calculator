package dataModel;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    protected Map<Integer, Double> monomials;
    public Polynomial(){
        monomials = new TreeMap<>();
    }
    public Map<Integer, Double> getPolynomial() {
        return this.monomials;
    }
    public void addMonomial(int deg, double coef) {
        if (monomials.containsKey(deg)) {
            coef += monomials.get(deg);
        }
        monomials.put(deg, coef);
    }
    public void subtractMonomial(int deg, double coef) {
        if (monomials.containsKey(deg)) {
            coef = monomials.get(deg) - coef;
        } else {
            coef = -coef;
        }
        monomials.put(deg, coef);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Double> monomial : monomials.entrySet()) {
            int deg = monomial.getKey();
            double coef = monomial.getValue();
            if (coef == 0.0) {
                continue;
            }
            if (coef > 0.0 && sb.length() > 0) {
                sb.append("+");
            }
            if (coef == -1.0 && sb.length() > 0) {
                sb.append("-");
            }
            if (coef != 1.0 && coef != -1.0 || deg == 0) {
                sb.append(coef);
            }
            if (deg > 0) {
                sb.append("x");
            }
            if (deg > 0) {
                sb.append("^" + deg);
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
    public void fromString(String p) {
        String[] monomialStr = p.split("(?=[+-])");
        for (String term : monomialStr) {
            double coef = 1.0;
            int deg = 0;
            String[] monomial = term.split("x\\^?");
            if (monomial.length > 0) {
                if (monomial[0].equals("-")) {
                    coef = -1;
                } else if (monomial[0].isEmpty()) {
                    coef = 1;
                } else {
                    try {
                        coef = Double.parseDouble(monomial[0]);
                    } catch (NumberFormatException e) {
                        coef = 1;
                    }
                }
            }
            if (monomial.length > 1)  {
                if (monomial[1].isEmpty()) {
                    deg = 1;
                } else {
                    try {
                        deg = Integer.parseInt(monomial[1]);
                    } catch (NumberFormatException e) {
                        deg = 1;
                    }
                }
            } else if (term.contains("x")) {
                deg = 1;
            }
            addMonomial(deg,coef);
        }
    }

    /*public void fromString(String p) {
        String pattern = "([-+]?\\d+[.]?\\d+?)?([xX]?\\^?)?(\\d+)?";   //"([+-])?\\s*(\\d*\\.?\\d*)(x(\\^\\d+))?"
        Pattern coeffPattern = Pattern.compile(pattern);
        Matcher matcher = coeffPattern.matcher(p);

        while (matcher.find()) {
            String signStr = matcher.group(1);
            double sign = signStr != null && signStr.equals("-") ? -1.0 : 1.0;
            String coefStr = matcher.group(2).replaceAll("\\s+", "");
            double coef = coefStr.isEmpty() ? sign : sign * Double.parseDouble(coefStr);
            String degStr = matcher.group(4);
            int deg = degStr == null ? 1 : Integer.parseInt(degStr.substring(1));
            monomials.put(deg, coef);
        }
    }*/
}
