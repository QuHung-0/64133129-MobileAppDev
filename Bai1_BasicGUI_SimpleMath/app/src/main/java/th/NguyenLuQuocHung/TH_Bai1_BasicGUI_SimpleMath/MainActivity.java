package th.NguyenLuQuocHung.TH_Bai1_BasicGUI_SimpleMath;

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
        EditText inputA = findViewById(R.id.inputA);
        EditText inputB = findViewById(R.id.inputB);
        RadioGroup operatorGroup = findViewById(R.id.operatorGroup);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView resultText = findViewById(R.id.resultText);

        // Xử lý sự kiện khi nhấn nút "Thực hiện"
        btnCalculate.setOnClickListener(v ->
        {
            // Kiểm tra ô nhập rỗng
            if (inputA.getText().toString().isEmpty() || inputB.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Vui lòng nhập cả hai số!", Toast.LENGTH_SHORT).show();
                return;
            }

            try
            {
                // Lấy giá trị từ EditText
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());

                // Lấy toán tử được chọn từ RadioGroup
                int selectedOperatorId = operatorGroup.getCheckedRadioButtonId();
                if (selectedOperatorId == -1)
                {
                    Toast.makeText(this, "Vui lòng chọn phép toán!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String operator = "";
                if (selectedOperatorId == R.id.radioAdd)
                {
                    operator = "+";
                }
                else if (selectedOperatorId == R.id.radioSubtract)
                {
                    operator = "-";
                }
                else if (selectedOperatorId == R.id.radioMultiply)
                {
                    operator = "*";
                }
                else if (selectedOperatorId == R.id.radioDivide)
                {
                    operator = "/";
                }


                // Thực hiện tính toán
                double result = 0;
                switch (operator)
                {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b != 0)
                        {
                            result = a / b;
                        }
                        else
                        {
                            Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }

                // Hiển thị kết quả
                resultText.setText("Kết quả: " + result);

            }
            catch (NumberFormatException e)
            {
                Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

