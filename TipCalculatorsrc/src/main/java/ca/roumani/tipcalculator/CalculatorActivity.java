package ca.roumani.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity
{
    private CalculatorModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view){
        View amountView = findViewById(R.id.amountText);
        double amount = Double.parseDouble(((EditText) amountView).getText().toString());
        View peopleNumberView = findViewById(R.id.peopleNumberText);
        int peopleNumber = Integer.parseInt(((EditText) peopleNumberView).getText().toString());
        int percentage = 0;

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButtonChecked = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String text = radioButtonChecked.getText().toString();

        if(text.equals("10%")){
            percentage = 10;
        }
        if(text.equals("15%")){
            percentage = 15;
        }
        if(text.equals("20%")){
            percentage = 20;
        }

        model = new CalculatorModel(amount, percentage, peopleNumber);
        String total = String.format("Total = %.2f" ,this.model.getTotal());
        View totalView = findViewById(R.id.total);
        TextView totalText = (TextView) totalView;
        totalText.setText(total);

        String perperson = String.format("Per Person = %.2f"  ,this.model.getPerPerson());
        View perpersonView = findViewById(R.id.perperson);
        TextView perpersonText = (TextView) perpersonView;
        perpersonText.setText(perperson);
    }
}
