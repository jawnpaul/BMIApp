package ng.org.knowit.bmiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    double bmiResult;
    TextView detailsTextView;
    ImageView illistrationImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        bmiResult = intent.getDoubleExtra("bmiResult", 0);
        detailsTextView = findViewById(R.id.detailsTextView);
        illistrationImageView = findViewById(R.id.resultIllustrationImageView);
        showStatus(bmiResult);
    }

    private void showStatus(double bmiResult) {
        this.bmiResult = bmiResult;
        if (bmiResult < 18.5) {
            illistrationImageView.setImageResource(R.drawable.eating_illustration);
            detailsTextView.setText(R.string.underWeightDetails);
        } else if (bmiResult >= 18.5 && bmiResult < 25) {
            illistrationImageView.setImageResource(R.drawable.high_five_illustration);
            detailsTextView.setText(R.string.normalWeightDetails);
        } else if (bmiResult >= 25 && bmiResult >= 30) {
            illistrationImageView.setImageResource(R.drawable.workout_illustration);
            detailsTextView.setText(R.string.overWeightDetails);
        }
    }
}
