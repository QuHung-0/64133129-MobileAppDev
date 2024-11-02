package ntu.nlqh.midtermtestrun;
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

    public void IntentBMI(View v)
    {
        Intent iBMI = new Intent(MainActivity.this, BMICalculatorActivity.class);
        startActivity(iBMI);
    }

    public void IntentProfile(View v)
    {
        Intent iP = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(iP);
    }

    public void IntentListView(View v)
    {
        Intent iLV = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(iLV);
    }

    public void IntentRecyclerView(View v)
    {
        Intent iRV = new Intent(MainActivity.this, RecyclerViewActivity.class);
        startActivity(iRV);
    }

}
