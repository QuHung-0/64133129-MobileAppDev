package com.example.tuan5_b2_baithohay;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Nguon du lieu
    ArrayList<String> dsBaiTho;

    ListView lvBaiTho;
    Button btnThem;
    EditText edttenBT;

    ArrayAdapter<String> adapterBaiTho;


    //ListView lvBaiTho
    void getControl()
    {
        lvBaiTho = findViewById(R.id.lvBT);
        btnThem = findViewById(R.id.btnThem);
        edttenBT = findViewById(R.id.edttenBT);
    }


    //Ham doc du lieu tu nguon bat ky
    ArrayList<String> getData()
    {
        ArrayList<String> lstTenBaiTho = new ArrayList<String>();
        lstTenBaiTho.add("Banh troi nuoc");
        lstTenBaiTho.add("Song");
        lstTenBaiTho.add("Dat nuoc");
        lstTenBaiTho.add("Tay tien");

        return lstTenBaiTho;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getControl();
        dsBaiTho = getData();

        adapterBaiTho = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsBaiTho);

        lvBaiTho.setAdapter(adapterBaiTho);

        adapterBaiTho.notifyDataSetChanged();

        lvBaiTho.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                XuLyKhiNhanVaoViTriThu(position);
            }

            //ta dua code xy ly ra ngoai cho gon
        });

        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //lay ten bai
                String tenBai = edttenBT.getText().toString();

                //them vao nguon
                dsBaiTho.add(tenBai);

                //bao adapter cap nhat lai Listview
                adapterBaiTho.notifyDataSetChanged();
            }
        });
    } // end create

    void XuLyKhiNhanVaoViTriThu(int pos)
    {
        //lay phan tu
        String item = dsBaiTho.get(pos);
        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    }


}