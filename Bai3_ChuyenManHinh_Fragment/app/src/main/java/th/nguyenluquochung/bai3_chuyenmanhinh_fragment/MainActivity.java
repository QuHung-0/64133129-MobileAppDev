package th.nguyenluquochung.bai3_chuyenmanhinh_fragment;

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


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, TiengAnhActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, ToanActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, LapTrinhActivity.class);
                startActivity(intent);
            }
        });

    }
}