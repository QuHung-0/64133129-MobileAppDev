package ntu.nlqh.chuyenmanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    //onclick="chuyen ve man hinh chinh"
    public void ChuyenVeManHinhChinh (View v)
    {
        //1. Lay intent ve
        Intent iNhanDuoc = getIntent();


        //2.Boc du lieu
        String data =  iNhanDuoc.getStringExtra("ten");

        //3. hien len
        Toast.makeText(getBaseContext(), data, Toast.LENGTH_LONG).show();

        //4.chuyen ve man hinh chinh
        Intent iManHinhChinh = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(iManHinhChinh);
    }
}