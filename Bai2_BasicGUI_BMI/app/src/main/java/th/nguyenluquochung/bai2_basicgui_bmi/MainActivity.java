package th.nguyenluquochung.bai2_basicgui_bmi;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tham chiếu các thành phần giao diện
        EditText inputHeight = findViewById(R.id.inputHeight);
        EditText inputWeight = findViewById(R.id.inputWeight);
        CheckBox isAsianCheckbox = findViewById(R.id.isAsianCheckbox);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView resultText = findViewById(R.id.resultText);

        // Xử lý sự kiện khi nhấn nút "Tính BMI"
        btnCalculate.setOnClickListener(v ->
        {
            // Kiểm tra nhập liệu
            if (inputHeight.getText().toString().isEmpty() || inputWeight.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Vui lòng nhập chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
                return;
            }

            try
            {
                // Lấy chiều cao và cân nặng
                double height = Double.parseDouble(inputHeight.getText().toString());
                double weight = Double.parseDouble(inputWeight.getText().toString());

                // Tính BMI
                double bmi = weight / (height * height);

                // Xác định nhóm chỉ số BMI
                String evaluation;
                if (isAsianCheckbox.isChecked())
                {
                    // Tiêu chuẩn Châu Á
                    if (bmi < 17.5)
                    {
                        evaluation = "Under weight";
                    }
                    else if (17.5 < bmi && bmi < 22.99)
                    {
                        evaluation = "Normal weight";
                    }
                    else if (23 < bmi && bmi <27.99)
                    {
                        evaluation = "Over Weight";
                    }
                    else
                    {
                        evaluation = "Obese";
                    }
                }
                else
                {
                    // Tiêu chuẩn quốc tế
                    if (bmi < 18.5)
                    {
                        evaluation = "Under weight";
                    }
                    else if (18.5 < bmi && bmi < 24.99)
                    {
                        evaluation = "Normal weight";
                    }
                    else if (25 < bmi && bmi < 29.99)
                    {
                        evaluation = "Over Weight";
                    }
                    else
                    {
                        evaluation = "Obese";
                    }
                }

                // Hiển thị kết quả
                resultText.setText(String.format("BMI: %.2f\nĐánh giá: %s", bmi, evaluation));

            }
            catch (NumberFormatException e)
            {
                Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
