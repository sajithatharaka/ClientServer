package task;

import java.io.Serializable;
import java.math.BigInteger;

public class CalculateGCD implements Task, Serializable {

    private long firstInteger;
    private long secondInteger;
    private long gcd;

    public CalculateGCD(int firstInteger, int secondInteger) {
        this.firstInteger = firstInteger;
        this.secondInteger = secondInteger;
    }

    @Override
    public void executeTask() {
        System.out.println("Performing a client task of CalculateGCD");
        // Computing the GCD
        gcd = CalculateGCD(firstInteger, secondInteger);
    }

    public long CalculateGCD(long a, long b) {
        if (a == 0) {
            return b;
        } else {
            while (b != 0) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            return a;
        }
    }

    @Override
    public Object getResult() {
        return "The Greatest Common Divisor of " + firstInteger + " and " + secondInteger + " is " + gcd;
    }

}
