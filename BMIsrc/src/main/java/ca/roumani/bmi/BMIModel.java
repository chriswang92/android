package ca.roumani.bmi;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Model for the BMI app.
 *
 * @author Hamzeh Roumani
 */
public class BMIModel
{
    private double weight;
    private double height;
    public static final double poundsPerKg = 2.20462262;

    /**
     * Initializes this model with the given weight and height.
     *
     * @param weightText weight as text.
     * @param heightText height as text.
     */
    public BMIModel(String weightText, String heightText)
    {
        this.weight = Double.parseDouble(weightText);
        this.height = Double.parseDouble(heightText);
    }

    /**
     * Returns the index of this model, with one digit precision.
     *
     * @return the index of this model.
     */
    public String getBMI()
    {
        double index = this.weight / (this.height * this.height);
        String indexText = String.format("%.1f", index);
        return indexText;
    }

    public String getWeightInPound()
    {
        double index = this.weight * poundsPerKg;
        int i = (int) Math.round(index);
        String indexText = String.format("%d", i);
        return indexText;
    }
}
