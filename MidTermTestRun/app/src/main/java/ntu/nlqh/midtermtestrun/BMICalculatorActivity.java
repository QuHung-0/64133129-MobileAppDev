package ntu.nlqh.midtermtestrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity
{
    private EditText heightInput;
    private EditText weightInput;
    private TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);

        // Initialize the UI components
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        bmiResult = findViewById(R.id.bmiResult);
    }

    // Method to calculate BMI
    public void calculateBMI(View v)
    {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Hãy nhập chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            if (height <= 0 || weight <= 0) {
                Toast.makeText(this, "Hãy nhập chiều cao và cân nặng hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate BMI
            float bmi = weight / (height * height);
            bmiResult.setText(String.format("BMI: %.2f", bmi));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "thông tin không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to return to main screen
    public void Return(View v)
    {
        Intent iMainActivity = new Intent(BMICalculatorActivity.this, MainActivity.class);
        startActivity(iMainActivity);
    }
}
