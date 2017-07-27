package ca.roumani.countingroomsapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private CountingRoomsModel model = new CountingRoomsModel();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.updateButtonColor();
    }

    public void northButtonClicked(View view){
        this.model.increNorth();
        this.updateText();
        this.updateButtonColor();
    }

    public void southButtonClicked(View view){
        this.model.increSouth();
        this.updateText();
        this.updateButtonColor();
    }

    public void westButtonClicked(View view){
        this.model.increWest();
        this.updateText();
        this.updateButtonColor();
    }

    public void eastButtonClicked(View view){
        this.model.increEast();
        this.updateText();
        this.updateButtonColor();
    }

    private void updateText(){
        String index = this.model.getButtonPressedCounter();
        View answerView = findViewById(R.id.counter);
        TextView answerText = (TextView) answerView;
        answerText.setText(index);
    }
    private void updateButtonColor(){
        View northButtonView = findViewById(R.id.North);
       if(this.model.canGoNorth()){
           northButtonView.setBackgroundColor(Color.GREEN);
       }else
       {
           northButtonView.setBackgroundColor(Color.RED);
       }
        View southButtonView = findViewById(R.id.South);
        if(this.model.canGoSouth()){
            southButtonView.setBackgroundColor(Color.GREEN);
        }else
        {
            southButtonView.setBackgroundColor(Color.RED);
        }
        View eastButtonView = findViewById(R.id.East);
        if(this.model.canGoEast()){
            eastButtonView.setBackgroundColor(Color.GREEN);
        }else
        {
            eastButtonView.setBackgroundColor(Color.RED);
        }
        View westButtonView = findViewById(R.id.West);
        if(this.model.canGoWest()){
            westButtonView.setBackgroundColor(Color.GREEN);
        }else
        {
            westButtonView.setBackgroundColor(Color.RED);
        }

    }
}
