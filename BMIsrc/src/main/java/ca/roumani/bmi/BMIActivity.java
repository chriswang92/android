package ca.roumani.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Controller for the BMI app.
 *
 * @author Hamzeh Roumani
 */
public class BMIActivity extends AppCompatActivity
{
    /**
     * Initializes this controller.
     *
     * @param savedInstanceState information needed for re-initialization.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_bmi);
    }

    /**
     * Sets the BMI based on the entered weight and height.
     *
     * @param view not applicable.
     */
    public void buttonClicked(View view)
    {
        // get the weight as text
        View weightView = findViewById(R.id.weightBox);
        EditText weightEdit = (EditText) weightView;
        String weight = weightEdit.getText().toString();

        // get the height as text
        View heightView = findViewById(R.id.heightBox);
        EditText heightEdit = (EditText) heightView;
        String height = heightEdit.getText().toString();

        // create a model
        BMIModel model = new BMIModel(weight, height);

        // get the index from the model
        String index = "Your weight in pound is " + model.getWeightInPound() +
                " and your BMI is " + model.getBMI();
        // set the index
        View answerView = findViewById(R.id.answer);
        TextView answerText = (TextView) answerView;
        answerText.setText(index);
    }
}

