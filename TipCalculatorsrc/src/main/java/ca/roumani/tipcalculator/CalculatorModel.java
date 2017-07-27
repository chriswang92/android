package ca.roumani.tipcalculator;

/**
 * Created by user on 7/6/17.
 */
public class CalculatorModel
{
    private double amount;
    private int percentage;
    private int number;
    public CalculatorModel(double amount,
                           int percentage,
                           int number){
        this.amount = amount;
        this.percentage = percentage;
        this.number = number;
    }
    public double getTotal(){
        return this.amount*(1 + this.percentage/100.0);
    }
    public double getPerPerson(){
        return this.getTotal() / number;
    }

}