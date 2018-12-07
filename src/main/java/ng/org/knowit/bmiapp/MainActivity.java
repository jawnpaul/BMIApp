package ng.org.knowit.bmiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double height, weight, bmiResult;

    TextView heightTextView, weightTextView, bmiResultTextView;
    SeekBar heightSeekBar, weightSeekBar;

    Button nextButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
               heightTextView.setText(String.valueOf(height));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               height = seekBar.getProgress();
               heightTextView.setText(String.valueOf(height));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               height = seekBar.getProgress();
               heightTextView.setText(String.valueOf(height));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }
       });

       weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               weight = seekBar.getProgress();
               weightTextView.setText(String.valueOf(weight));
               bmiResultTextView.setText(String.valueOf(calculateBmi(weight, height)));
           }
       });

       nextButon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, DetailActivity.class);
               intent.putExtra("bmiResult", bmiResult);
               startActivity(intent);
           }
       });

    }

    private double calculateBmi(double weight, double height) {
        bmiResult = weight / Math.pow(height, 2);
        return bmiResult;
    }

}
