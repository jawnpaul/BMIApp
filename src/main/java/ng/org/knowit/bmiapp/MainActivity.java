package ng.org.knowit.bmiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declared the three variables we need for our calculation
    double height, weight, bmiResult;

    //Declared all the views in the activity
    TextView heightTextView, weightTextView, bmiResultTextView;
    SeekBar heightSeekBar, weightSeekBar;
    Button nextButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiated our views
        nextButon = findViewById(R.id.buttonNext);
       heightSeekBar = findViewById(R.id.heightSeekBar);
       weightSeekBar = findViewById(R.id.weightSeekBar);
       bmiResultTextView = findViewById(R.id.bmiTextView);
       heightTextView = findViewById(R.id.heightTextView);
       weightTextView = findViewById(R.id.weightTextView);

       heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               height = seekBar.getProgress();
               heightTextView.setText(String.valueOf(height) + "m");
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               height = seekBar.getProgress();
               heightTextView.setText(String.valueOf(height) + "m");
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               height = seekBar.getProgress();
               heightTextView.setText(String.valueOf(height) + "m");
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }
       });

       weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight + "kg"));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight + "kg"));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight + "kg"));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }
       });

       nextButon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, DetailActivity.class);
               //Here we pass our BMI result to the intent
               intent.putExtra("bmiResult", bmiResult);
               startActivity(intent);
           }
       });

    }

    //This is the method that calulaytes BMI using weight and height
    private double calculateBmi(double weight, double height) {
        bmiResult = weight / Math.pow(height, 2);
        return bmiResult;
    }

}
