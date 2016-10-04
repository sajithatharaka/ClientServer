package task;

import java.io.Serializable;

public class CalculatePrimes implements Task, Serializable {

    private int number;
    private String primeNumbers = "";

    public CalculatePrimes(int number) {
        this.number = number;
    }

    @Override
    public void executeTask() {
        System.out.println("Performing a client task of CalculatePrimes");
        // Loopign from 1 until the given number
        for (int i = 1; i <= number; i++) {
            if (isPrime(i)) {
                primeNumbers = primeNumbers + i + ", ";
            }
        }
    }

    // Computing the Prime Numbers
    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getResult() {
        return "The number of primes is : " + primeNumbers;
    }

}
