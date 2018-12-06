package ng.org.knowit.bmiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double height, weight, bmiResult;

    TextView heightTextView, weightTextView, bmiResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar heightSeekBar = findViewById(R.id.heightSeekBar);

        bmiResultTextView = findViewById(R.id.bmiTextView);


    }

    private void calculateBmi(double weight, double height) {

        bmiResult = weight / Math.pow(height, 2);
        bmiResultTextView.setText(String.valueOf(bmiResult));
    }
}
