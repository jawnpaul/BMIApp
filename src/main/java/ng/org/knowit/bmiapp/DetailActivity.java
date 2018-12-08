package ng.org.knowit.bmiapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    double bmiResult;
    TextView detailsTextView;
    ImageView illustrationImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        detailsTextView = findViewById(R.id.detailsTextView);
        illustrationImageView = findViewById(R.id.resultIllustrationImageView);

        //We retrieve the intent coming from the MainActivity
        Intent intent = getIntent();

        //We get the bmiResult passed in the intent
        bmiResult = intent.getDoubleExtra("bmiResult", 0);

        //We use the bmiResult to determine what would be displayed
        showStatus(bmiResult);
    }

    //This method determines what would appear on our interface based on the BMI result
    private void showStatus(double bmiResult) {
        this.bmiResult = bmiResult;

        //If bmiResult is less than 18.5 then the user is underweight
        if (bmiResult < 18.5) {
            illustrationImageView.setImageResource(R.drawable.eating_illustration);
            detailsTextView.setText(R.string.underWeightDetails);

        //If bmiResult is greater than 18.5 and less than 25 then the user has a normal BMI
        } else if (bmiResult >= 18.5 && bmiResult < 25) {
            illustrationImageView.setImageResource(R.drawable.high_five_illustration);
            detailsTextView.setText(R.string.normalWeightDetails);

        //If bmiResult is greater than or equal 25 and greater than or equal 30 the user is overweight
        } else if (bmiResult >= 25 && bmiResult >= 30) {
            illustrationImageView.setImageResource(R.drawable.workout_illustration);
            detailsTextView.setText(R.string.overWeightDetails);
        }
    }
}
