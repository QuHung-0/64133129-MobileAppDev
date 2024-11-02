package ntu.nlqh.midtermtestrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity
{

    private ArrayList<String> items;  // List to hold items
    private ArrayAdapter<String> adapter;  // Adapter to manage items in ListView
    private EditText editTextNewItem;  // Input field for new items

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        // Initialize the ListView, EditText, and Add Button
        ListView listView = findViewById(R.id.listView);
        editTextNewItem = findViewById(R.id.editTextNewItem);
        Button buttonAddItem = findViewById(R.id.buttonAddItem);

        // Initialize the list with some predefined items
        items = new ArrayList<>();
        items.add("Sample Item 1");
        items.add("Sample Item 2");
        items.add("Sample Item 3");
        items.add("Sample Item 4");
        items.add("Sample Item 5");

        // Set up the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        // Set up the Add Item button to add new items to the list
        buttonAddItem.setOnClickListener(v ->
        {
            String newItem = editTextNewItem.getText().toString().trim();
            if (!newItem.isEmpty())
            {
                items.add(newItem);  // Add new item to the list
                adapter.notifyDataSetChanged();  // Notify adapter of data change
                editTextNewItem.setText("");  // Clear the input field
            }
            else
            {
                Toast.makeText(ListViewActivity.this, "Hãy nhập thông tin để thêm", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to return to the main screen
    public void Return(View v)
    {
        Intent iMainActivity = new Intent(ListViewActivity.this, MainActivity.class);
        startActivity(iMainActivity);
    }
}
