package ntu.hung.bai5_quizappgui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cardView1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, cppActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.cardView2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, javaActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.cardView3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, pythonActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.quiz).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Navigate to ToanActivity
                Intent intent = new Intent(MainActivity.this, quizActivity.class);
                startActivity(intent);
            }
        });
    }
}