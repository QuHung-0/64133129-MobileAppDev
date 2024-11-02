package ntu.nlqh.chuyenmanhinh;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }
    // Chuyen sang man hinh 2
    public void ChuyenSangManHinh2(View v)
    {
        //1. Tao intent
        Intent iMH2 = new Intent(MainActivity.this, MainActivity2.class);

        //2. Goi du lieu
        iMH2.putExtra("ten", "Mai Cuong Tho");

        //3. Chuyen man hinh
        startActivity(iMH2);
    }

}
