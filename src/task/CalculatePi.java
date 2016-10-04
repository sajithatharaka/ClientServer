package task;

import java.io.Serializable;

public class CalculatePi implements Task, Serializable {

    private int decimalPlaces;
    private double valueOfPI;

    public CalculatePi(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public void executeTask() {
        System.out.println("Performing a client task of CalculatePi");
        // Computing the PI
        valueOfPI = new Pi(decimalPlaces).execute().doubleValue();
    }

    @Override
    public Object getResult() {
        System.out.println("Calculating PI");
        return valueOfPI;
    }

}
