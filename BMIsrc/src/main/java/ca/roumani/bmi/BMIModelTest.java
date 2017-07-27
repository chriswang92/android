package ca.roumani.bmi;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * App that tests the BMIModel.
 *
 * @author Hamzeh Roumani
 */
public class BMIModelTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        BMIModel model = new BMIModel("100", "1.8");
        output.println(model.getBMI());

        model = new BMIModel("45", "1.35");
        output.println(model.getBMI());

        model = new BMIModel("80", "1.2");
        output.println(model.getBMI());

        model = new BMIModel("65", "1.6");
        output.println(model.getBMI());

        String s = model.getWeightInPound();
        output.print(s);
    }
}
